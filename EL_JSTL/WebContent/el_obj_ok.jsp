<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 원래는 이렇게 해야 했음! 하지만 EL 쓰면 이렇게 안 해도 됨
<%
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
%>
--%>    
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- initParam은 서블릿 컨텍스트 초기화 파라미터를 직접 참조 가능한 EL의 내장 객체이며, param은 요청 파라미터 값을 참조 가능한 내장 객체 -->

	NAME: ${initParam.name}<br>
	ID: ${initParam.id}<br>
	PW: ${initParam.pw}<br>
	ADDRESS: ${param.addr}<br>
	EMAIL: ${param.email}<br>

</body>
</html>