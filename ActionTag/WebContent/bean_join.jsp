<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
<%--
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
%>
--%>

<jsp:useBean id = "user" class = "com.pancake.User" scope = "page"/>

<%-- 방법 1: 
<jsp:setProperty name = "user" property = "name" value = "<%= name %>">
<jsp:setProperty name = "user" property = "id" value = "<%= id %>">
<jsp:setProperty name = "user" property = "pw" value = "<%= pw %>">
<jsp:setProperty name = "user" property = "email" value = "<%= email %>">
 --%>
 
<jsp:setProperty name = "user" property = "*"/>

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "2" cellspacing = "0" cellpadding = "0">
		<tr>
			<td>아이디</td>
			<td>
				<jsp:getProperty property="id" name="user"/>
			</td>
			<td>비밀번호</td>
			<td>
				<jsp:getProperty property="pw" name="pw"/>
			</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td>
				<jsp:getProperty property="name" name="name"/>
			</td>
			<td>이메일</td>
			<td>
				<jsp:getProperty property="email" name="email"/>
			</td>
		</tr>
	</table>
</body>
</html>