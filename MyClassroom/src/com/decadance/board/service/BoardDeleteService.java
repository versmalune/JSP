package com.decadance.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.model.BoardDAO;

public class BoardDeleteService implements IBoardService {

	@Override
	public void executeService(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(bId);

	}

}
