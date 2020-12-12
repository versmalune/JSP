package com.decadance.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.decadance.board.service.BoardContentService;
import com.decadance.board.service.BoardListService;
import com.decadance.board.service.BoardWriteService;
import com.decadance.board.service.IBoardService;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	private void doRequest(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		IBoardService service = null;
		String view = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		
		if(com.equals("/board/list.board")) {
			service = new BoardListService();
			service.executeService(request, response);
			view = "/board/board_list.jsp";
		} else if(com.equals("/board/write_view.board")) {
			view = "/board/write_view.jsp";
		} else if(com.equals("/board/write.board")) {
			service = new BoardWriteService();
			service.executeService(request, response);
			view = "/board/list.board";
		} else if(com.equals("/board/content_view.board")) {
			service = new BoardContentService();
			service.executeService(request, response);
			view = "/board/content_view.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(view);
		dp.forward(request, response);
		
	}
}
