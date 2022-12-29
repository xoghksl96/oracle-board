<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#rowPerPage').change(function() {
			$('#form').submit();
		});
		
		$('#searchBtn').click(function() {
			$('#form').submit();
		})
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	
	<br><br>
	
	<div class="container">
		<div style="text-align : center">
			<h1>BOARD LIST</h1>
		</div>
	
		<div style="text-align : right">
			<a href="${pageContext.request.contextPath}/board/addBoard" class="btn btn-primary" style="text-align : right">게시글 등록</a>
		</div>
		
		<br>
		
		<table class="table table-hover">
			<thead>
				<tr class="table-success">
					<th style="width : 5%; text-align : center;">NO</th>
					<th style="width : 45%; text-align : center;">TITLE</th>
					<th style="width : 10%; text-align : center;">MEMBERID</th>
					<th style="width : 20%; text-align : center;">CREATEDATE</th>
					<th style="width : 20%; text-align : center;">UPDATEDATE</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td style="width : 5%; text-align : center;">${board.boardNo}</td>
						<td style="width : 45%; text-align : center;"><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
						<td style="width : 10%; text-align : center;">${board.memberId}</td>
						<td style="width : 20%; text-align : center;">${board.createdate}</td>
						<td style="width : 20%; text-align : center;">${board.updatedate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
		<form method="get" action="${pageContext.request.contextPath}/board/boardList" id="form">
			<div style="text-align : right">
				<div>
					<ul class="pagination">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">&laquo;</a>
		    			</li>
						
						<c:if test="${currentPage - 2 > 0}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage-2}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">${currentPage-2}</a>
			    			</li>
						</c:if>
						
						<c:if test="${currentPage - 1 > 0}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">${currentPage-1}</a>
			    			</li>
						</c:if>
					
						<li class="page-item active">
		      				<a class="page-link" href="#">${currentPage}</a>
		    			</li>
		    			
		    			<c:if test="${currentPage + 1 <= endPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">${currentPage+1}</a>
			    			</li>
						</c:if>
						
						<c:if test="${currentPage + 2 <= endPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${currentPage+2}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">${currentPage+2}</a>
			    			</li>
						</c:if>
						
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/board/boardList?currentPage=${endPage}&rowPerPage=${rowPerPage}&searchWord=${searchWord}">&raquo;</a>
		    			</li>
					</ul>
				</div>
			</div>
		
			<div style="text-align : center;">
				<div>
					<select id="rowPerPage" name="rowPerPage" class="select select" style="width : 50px; height : 35px; font-size : 15pt;">
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
					
					&nbsp;&nbsp;&nbsp;&nbsp;
					</select>
				
					<input class="form-control" type="search" name="searchWord" placeholder="Search" value="${searchWord}" style="width : 200px;">
		     		<button class="btn btn-secondary" type="submit" id="searchBtn">Search</button>
				</div>
			</div>
		</form>
	</div>	
</body>
</html>