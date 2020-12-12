<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>ALL MEMBERS INFO</h3>
	<hr>
	<c:forEach var="vo" items="${member_list}">
		ID: ${vo.id}, PW: ${vo.pw}, NAME: ${vo.name}, EMAIL: ${vo.email}, ADDRESS: ${vo.address}, JOINED: ${vo.rDate}<br>
		------------------------------------------------------------------------------------------------------------------------------<br>
	</c:forEach>
	<!--
	for(MemberVO vo : member_list) {
		ID: < % = vo.getId()% ...
	}
	 -->
	
	
</body>
</html>