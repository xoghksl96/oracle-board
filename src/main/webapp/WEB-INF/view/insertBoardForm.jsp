<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="${pageContext.request.contextPath}/InsertBoardActionController" method="get">
		<table border="1">
			
			<tr>
				<th>TITLE</th>
				<td><input type="text" id="boardTitle" name="boardTitle"></td>
			</tr>
			
			<tr>
				<th>CONTENT</th>
				<td><textarea cols="50" rows="5" id="boardContent" name="boardContent"></textarea></td>
			</tr>
		
		</table>
		
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>