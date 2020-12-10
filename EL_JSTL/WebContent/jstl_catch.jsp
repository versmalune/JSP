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
	<c:catch var="ex">
		name 파라미터의 값" ${param.name}"<br>
		<% if (request.getParameter("name").equals("test")) { %>
			${param.name}은 test입니다.
		<% } %>
	</c:catch>
	<c:if test="${ex != null }">
		예외가 발생했습니다.<br>
		${ex}
	</c:if>
</body>
</html>