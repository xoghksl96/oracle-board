<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body style="background-color : #505050">

	<c:if test="${loginMember == null}">
		<jsp:include page="/inc/menu.jsp"></jsp:include>
	</c:if>
		
	<c:if test="${loginMember != null}">
		<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	</c:if>
	
	<br><br>
	<div class="container">
		<div class="card bg-secondary" style="width: 100%; height: 500px;">
	  		<div class="card-header" style="text-align : center">
	  			<h1 class="card-title">오라클을 이용한 게시판 구축</h1>
	  		</div>
	  		<div class="card-body" style="text-align : center">
	  			<a href="https://www.oracle.com/kr/"><img src="img/oracle.png" style="width : 50% ; height : 100%"></a>
	  		</div>
		</div>
	</div>
</body>
</html>