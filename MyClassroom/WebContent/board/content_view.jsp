<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
.div_center {
    margin-bottom: 20px;
    padding: 30px 15px;
    background: #fff;
    background: rgba(255,255,255,0.9);
}      
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>DECADANCE</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	 <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    
    <script src = "../js/member.js"></script>

</head>

<body>

    <!-- Navigation -->
	<jsp:include page="../include/header.jsp"/>
	<div class="div_center" align="center">

	<h3>ARTICLES</h3>
	<hr>
	<input type="hidden" name="bId" value="${content.bId}">
	<table width="500" border="1">
		<tr>
			<td width="20%">number</td>
			<td width="30%">${content.bId}</td>
			<td width="20%">hit</td>
			<td width="30%">${content.bHit}</td>
		</tr>
		<tr>
			<td width="20%">by</td>
			<td width="30%">${content.bName}</td>
			<td width="20%">date</td>
			<td width="30%">${content.bDate}</td>
		</tr>
		<tr>
			<td width="20%">title</td>
			<td width="30%" colspan="3">${content.bTitle}</td>
		</tr>
		<tr>
			<td width="20%">article</td>
			<td width="30%" height="100px" colspan="3">${content.bContent}</td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<a href="/decadance/board/list.board">[list]</a>&nbsp;&nbsp;
				<a href="/decadance/board/modify_view.board?bId=${content.bId}">[edit]</a>&nbsp;&nbsp;
				<a href="/decadance/board/delete.board?bId=${content.bId}">[delete]</a>&nbsp;&nbsp;
				<a href="#">[reply]</a>&nbsp;&nbsp;
			</td>
		</tr>
	
	
	
	
	</table>
	
	</div>
	
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>



















