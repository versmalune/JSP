package com.decadance.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.model.BoardDAO;

public class BoardModifyService implements IBoardService {

	@Override
	public void executeService(HttpServletRequest request, HttpServletResponse response) {
		
		//폼 태그에서 글 번호 안 넘어왔기 때문에 넘김
		//input type = "hidden"으로 넘김!!
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(bId, bTitle, bContent);
	}
}
