<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>게시글</title>
</head>
<body>
	<h1>게시글</h1>
	
	<table border="1">
		<tr>
			<th>NO</th>
			<td>${board.boardNo}</td>
		</tr>
		
		<tr>
			<th>TITLE</th>
			<td>${board.boardTitle}</td>
		</tr>
		
		<tr>
			<th>CONTENT</th>
			<td>${board.boardContent}</td>
		</tr>
		
		<tr>
			<th>ID</th>
			<td>${board.memberId}</td>
		</tr>
		
		<tr>
			<th>UPDATEDATE</th>
			<td>${board.updatedate}</td>
		</tr>
		
		<tr>
			<th>CREATEDATE</th>
			<td>${board.createdate}</td>
		</tr>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/UpdateBoardFormController?boardNo=${board.boardNo}">수정</a>
		<a href="${pageContext.request.contextPath}/DeleteBoardActionController?boardNo=${board.boardNo}">삭제</a>
	</div>
</body>
</html>