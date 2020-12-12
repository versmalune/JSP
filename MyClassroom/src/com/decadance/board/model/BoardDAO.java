package com.decadance.board.model;

import java.sql.*;
import java.util.*;

import com.decadance.util.ConnProvider;
import com.decadance.util.JdbcUtil;

public class BoardDAO { //singleton
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO( ) {}
	
	public static BoardDAO getInstance() {
		if(instance != null) {
			return instance;
		}
		return instance;
	}
	
	/*게시판 글들의 정보를 DB로부터 불러올 메소드*/
	public ArrayList<BoardVO> getList(){
		ArrayList<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board order by board_id desc";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("board_id");
				String bName = rs.getString("board_name");
				String bTitle = rs.getString("board_title");
				String bContent = rs.getString("board_content");
				Timestamp bDate = rs.getTimestamp("board_date");
				int bHit = rs.getInt("board_hit");
				
				BoardVO vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}	
		return list;
	}	
	
	/*글쓰기 요청에 대한 내용을 DB에 저장하는 메소드*/
	public void write(String bName, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into board (board_name, board_title, board_content) values (?,?,?)";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*게시글 내용 확인 메소드*/
	public BoardVO contentView(String strId) {
		
		upHit(strId); //글 내용 보여 주는 동시에 upHit() 호출 -> 조회수 올림
		
		BoardVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where board_id = ?";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int bId = rs.getInt("board_id");
				String bName = rs.getString("board_name");
				String bTitle = rs.getString("board_title");
				String bContent = rs.getString("board_content");
				bContent = bContent.replaceAll("\r\n", "<br>");
				bContent = bContent.replaceAll("\u0020", "&nbsp;");
				Timestamp bDate = rs.getTimestamp("board_date");
				int bHit = rs.getInt("board_hit");
				
				vo = new BoardVO(bId, bName, bTitle, bContent, bDate, bHit);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}	
		
		return vo;
	}
	
	/*글 제목 클릭할 때마다 조회수 1 상승시키는 메소드*/
	private void upHit(String strId) { //이 안에서만 쓰니까 private
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set board_hit = board_hit + 1 where board_id=?";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
		
	}



	public void update(String bId, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set board_title = ?, board_content = ? where board_id = ?";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setInt(3, Integer.parseInt(bId));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}

	public void delete(String bId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where board_id = ?";
		
		try {
			conn = ConnProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);	
		}	
	}	
}


