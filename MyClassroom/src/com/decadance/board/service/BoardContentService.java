package com.decadance.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.model.BoardDAO;
import com.decadance.board.model.BoardVO;

public class BoardContentService implements IBoardService {

	@Override
	public void executeService(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo  = dao.contentView(bId);
		
		request.setAttribute("content", vo);

	}
}