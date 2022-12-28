<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>BOARD LIST</h1>
	
	<form method="get" action="">
		<select name="rowPerPage">
			<c:if test="${rowPerPage == 10}">
				<option value="10" selected="selected">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
			</c:if>
			
			<c:if test="${rowPerPage == 20}">
				<option value="10">10</option>
				<option value="20" selected="selected">20</option>
				<option value="30">30</option>
			</c:if>
			
			<c:if test="${rowPerPage == 30}">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30" selected="selected">30</option>
			</c:if>
		</select>
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>NO</th>
				<th>TITLE</th>
				<th>MEMBERID</th>
				<th>CREATEDATE</th>
				<th>UPDATEDATE</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.boardNo}</td>
					<td><a href="${pageContext.request.contextPath}/BoardOneController?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
					<td>${board.memberId}</td>
					<td>${board.createdate}</td>
					<td>${board.updatedate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/InsertBoardFormController">게시글 등록</a>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/BoardListController?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
		<span>${currentPage}</span>
		<a href="${pageContext.request.contextPath}/BoardListController?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</div>
</body>
</html>