<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() { // 이벤트 : <body>~</body>태그가 로드되고 나면 
		
		$('#modifyBoardBtn').click(function() {
			
			$('#boardTitle').focus();
			
			// boardTitle 유효성 체크
			if ($('#boardTitle').val().length < 1) {
				alert('제목 입력해주세요');
				$('#boardTitle').focus();
				return;
			}
			
			// boardContent 유효성 체크
			if ($('#boardContent').val().length < 1) {
				alert('내용 입력해주세요');
				$('#boardContent').focus();
				return;
			}
			
			$('#modifyBoardForm').submit();
		});
	});
</script>
<title>게시글 수정</title>
</head>
<body>
	<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	
	<br><br>
	
	<div class="container">
		<div style="text-align : center">
			<h1>게시글 수정</h1>
		</div>
		<form action="${pageContext.request.contextPath}/board/modifyBoard" method="post" id="modifyBoardForm">
			<input type="number" id="boardNo" name="boardNo" value="${board.boardNo}" hidden="hidden">
			<table class="table" style="font-size : 15pt;">
				<tr>
					<th class="table-info" style="width : 20%; text-align : center;">NO</th>
					<td style="width : 80%; text-align : center;">${board.boardNo}</td>
				</tr>
				
				<tr>
					<th class="table-info" style="width : 20%; text-align : center;">TITLE</th>
					<td style="width : 80%; text-align : center;"><input type="text" style="width:80%" id="boardTitle" name="boardTitle" value="${board.boardTitle}"></td>
				</tr>
				
				<tr>
					<th class="table-info" style="width : 20%; text-align : center; vertical-align : middle;">CONTENT</th>
					<td style="width : 80%; text-align : center;"><textarea style="width:80%" rows="10" id="boardContent" name="boardContent">${board.boardContent}</textarea></td>
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
				<button type="button" id="modifyBoardBtn" class="btn btn-warning" style="width : 200px; height : 60px; font-size : 20pt">수정</button>
			</div>
		
		</form>
	</div>
</body>
</html>