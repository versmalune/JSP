<%@page import="com.pancake.users.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import = "com.pancake.users.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDAO dao = new UserDAO();
	ArrayList<UserVO> list = dao.userSelectAll();
	
	for (int i = 0; i < list.size(); i++){
		UserVO vo = list.get(i);
		
		String name = vo.getName();
		String id = vo.getId();
		String pw = vo.getPw();
		String phone = vo.getPhone1() + vo.getPhone2() + vo.getPhone3();
		String gender = vo.getGender();
		
		out.println("NAME: " + name + " ID: " + id + " PHONE: " + phone + " GENDER: " + gender + "<br>");
	}
%>    
