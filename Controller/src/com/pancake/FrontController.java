package com.pancake;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") //url이 *.do로 둘어왔을 때 이 서블릿이 처리한다
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
		doRequest(request, response);
	}

	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);
		
		if(com.equals("/insert.do")) {
			System.out.println("insert 요청이 들어왔습니다");
			System.out.println("---------------------");
		} else if(com.equals("/update.do")) {
			System.out.println("update 요청이 들어왔습니다");
			System.out.println("---------------------");
		} else if(com.equals("/delete.do")) {
			System.out.println("delete 요청이 들어왔습니다");
			System.out.println("---------------------");
		} else if (com.equals("/select.do")) {
			System.out.println("select 요청이 들어왔습니다");
			System.out.println("---------------------");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출!");
		doRequest(request, response);
	}

}
