<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 태그 사용 위해서는 디렉티브 사용하여 사용 구문 입력해야 함 --%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="true">
	무조건 출력되는 문장입니다. <br>
	</c:if>
	
	<c:if test="${param.name == 'hello'}">
		name 파라미터의 값의 ${param.name}입니다 <br>
	</c:if>
	
	
	<!-- age라는 파라미터의 값의 19 이상이면 브라우저에 '성인입니다' 출력, 19 미만이면 '미성년자' 출력 -->
	<c:if test="${param.age >= 19}">
		성인입니다.
	</c:if>
	<c:if test="${param.age < 19}">
		미성년자입니다.
	</c:if>	
</body>
</html>