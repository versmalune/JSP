package com.decadance.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.model.BoardDAO;

public class BoardWriteService implements IBoardService {

	@Override
	public void executeService(HttpServletRequest request, HttpServletResponse response) {
/*		controller���� ���ӹ��� ��û ó�� ����
		�� �����Ϳ� �Ѿ�� ���� ó�� �� DAO ����*/
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.write(bName, bTitle, bContent);
	}
}