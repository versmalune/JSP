<%@page import="com.pancake.Thermometer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Thermometer tm = new Thermometer();
	//객체 저장 기능이 있는 jsp 내장 객체에 자바 객체를 저장해 두면, EL에서 해당 객체를 사용할 수 있음
	request.setAttribute("t", tm);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${t.setMap('서울', 39.4)}
	서을 온도: 섭씨 ${t.getMap('서울')}도 / 화씨 ${t.getFahrenheit('서울')}도 <br>
	정보: ${t.info}

</body>
</html>