package com.decadance.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.model.BoardDAO;

public class BoardModifyService implements IBoardService {

	@Override
	public void executeService(HttpServletRequest request, HttpServletResponse response) {
		
		//�� �±׿��� �� ��ȣ �� �Ѿ�Ա� ������ �ѱ�
		//input type = "hidden"���� �ѱ�!!
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(bId, bTitle, bContent);
	}
}
