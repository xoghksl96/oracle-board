<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="${pageContext.request.contextPath}/UpdateBoardActionController" method="get">
		<input type="number" id="boardNo" name="boardNo" value="${board.boardNo}" hidden="hidden">
		<table border="1">
			<tr>
				<th>NO</th>
				<td>${board.boardNo}</td>
			</tr>
			
			<tr>
				<th>TITLE</th>
				<td><input type="text" id="boardTitle" name="boardTitle" value="${board.boardTitle}"></td>
			</tr>
			
			<tr>
				<th>CONTENT</th>
				<td><textarea cols="50" rows="5" id="boardContent" name="boardContent">${board.boardContent}</textarea></td>
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
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>