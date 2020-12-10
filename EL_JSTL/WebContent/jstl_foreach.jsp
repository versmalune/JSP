<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>1부터 100까지 홀수의 합</h4>
	<%-- <c:set> 태그는 jstl에서 사용할 변수를 선언하는 태그 --%>
	<c:set var="sum" value="0" /> <%-- int sum = 0; --%>
	
	<%-- 
	for (int i = 1; i <= 100; i += 2) {
		sum += i;
	}
	out.println("결과: " + sum + "<br>");
	 --%>
	
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum + i}"/>
	</c:forEach>
	결과: ${sum} <br><br>
	
	
	
	<%-- 구구단 4단 --%>
	<%--
	for (int i = 1; i <= 9; i++) {
		System.out.println("4 x " + i + "=" + 4*i);
	 --%>
	 
	<c:forEach var="i" begin="1" end="9" step="1">
		4 x ${i} = ${4*i} <br>
	</c:forEach>
	
	<hr>
	
	
	<%--
		int[] iArr = {1,2,3,4,5};
		for (int i : iArr) {
			out.println(i + "&nbsp;");
		} --%>
	<h4>int 배열</h4> 
	<c:set var="iArr" value="<%= new int[] {1,2,3,4,5} %>"/>
	<c:forEach var="i" items="${iArr}">
		${i}&nbsp;
	</c:forEach>

</body>
</html>