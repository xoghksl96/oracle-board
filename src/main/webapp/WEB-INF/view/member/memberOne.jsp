<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>회원정보 페이지</title>
</head>
<body>
	<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	
	<br><br>
	<div class="container">
		<div style="text-align : center">
			<h1>회원정보</h1>
		</div>
	
		<br>
		
		<table class="table table-hover" style="font-size : 20pt;">	
			<tr>
				<th class="table-dark" style="width : 20%; text-align : center;">ID</th>
				<td style="width : 80%; text-align : center;">${loginMember.memberId}</td>
			</tr>
			
			<tr>
				<th class="table-dark" style="width : 20%; text-align : center;">NAME</th>
				<td style="width : 80%; text-align : center;">${loginMember.memberName}</td>
			</tr>	
		</table>
		
		<div style="text-align : right">
			<a type="button" class="btn btn-warning" style="width : 200px; height : 60px; font-size : 20pt" href="${pageContext.request.contextPath}/member/modifyMember">회원수정</a>
			&nbsp;
			<a type="button" class="btn btn-danger" style="width : 200px; height : 60px; font-size : 20pt" href="${pageContext.request.contextPath}/member/removeMember">회원탈퇴</a>			
		</div>
	</div>
</body>
</html>