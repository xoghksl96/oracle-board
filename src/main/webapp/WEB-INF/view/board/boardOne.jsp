<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>게시글</title>
</head>
<body>
	<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	
	<br><br>
	<div class="container">
		<div style="text-align : center;">
			<h1>게시글</h1>
		</div>
	
		<table class="table" style="font-size : 15pt;">
			<tr>
				<th class="table-info" style="width : 20%; text-align : center;">NO</th>
				<td style="width : 80%; text-align : center;">${board.boardNo}</td>
			</tr>
			
			<tr>
				<th class="table-info" style="width : 20%; text-align : center;">TITLE</th>
				<td style="width : 80%; text-align : center;">${board.boardTitle}</td>
			</tr>
			
			<tr>
				<th class="table-info" style="width : 20%; text-align : center; vertical-align : middle;">CONTENT</th>
				<td style="width : 80%; text-align : center;"><textarea style="width: 90%; height:300px;"readonly="readonly">${board.boardContent}</textarea></td>
			</tr>
			
			<tr>
				<th class="table-info" style="width : 20%; text-align : center;">ID</th>
				<td style="width : 80%; text-align : center;">${board.memberId}</td>
			</tr>
			
			<tr>
				<th class="table-info" style="width : 20%; text-align : center;">UPDATEDATE</th>
				<td style="width : 80%; text-align : center;">${board.updatedate}</td>
			</tr>
			
			<tr>
				<th class="table-info" style="width : 20%; text-align : center;">CREATEDATE</th>
				<td style="width : 80%; text-align : center;">${board.createdate}</td>
			</tr>
		</table>
		
		<div style="text-align : right">
			<a type="button" class="btn btn-warning" style="width : 200px; height : 60px; font-size : 20pt" href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${board.boardNo}">수정</a>
			&nbsp;
			<a type="button" class="btn btn-danger" style="width : 200px; height : 60px; font-size : 20pt" href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${board.boardNo}">삭제</a>			
		</div>
	</div>
</body>
</html>