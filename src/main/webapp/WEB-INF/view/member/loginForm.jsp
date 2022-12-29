<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() { // 이벤트 : <body>~</body>태그가 로드되고 나면 
		
		// loginBtn click
		$('#loginBtn').click(function() {
			
			$('#memberId').focus();
			
			// memberId 유효성 체크
			if ($('#memberId').val().length < 1) {
				alert('아이디를 입력해주세요');
				$('#memberId').focus();
				return;
			}
			
			// memberPw 유효성 체크
			if ($('#memberPw').val().length < 1) {
				alert('비밀번호를 입력해주세요');
				$('#memberPw').focus();
				return;
			}
			
			$('#loginForm').submit();
		});
	});
</script>
<title>로그인 페이지</title>
</head>
<body>
	<jsp:include page="/inc/menu.jsp"></jsp:include>
	
	<br><br><br><br>
	
	<div class="container" style="width : 50%">
		<form action="${pageContext.request.contextPath}/member/login" method="post" id="loginForm">
			<div class="card bg-secondary mb-3" style="margin : auto; text-algin : center;">
	  			<div class="card-header" style="margin-top : 10pt">
	  				<h1>로그인</h1>
	  			</div>
	 			<div class="card-body">
	 				<div class="form-group">
	      				<label for="exampleInputID" class="form-label mt-4">&nbsp; ID</label>
	      				<input type="text" class="form-control" id="memberId" name="memberId" placeholder="ID">
	   				 </div>
	   				 
	    			<div class="form-group">
	      				<label for="exampleInputPassword" class="form-label mt-4">&nbsp; PASSWORD</label>
	      				<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="Password">
	   				 </div>
	  			</div>
	  			
	  			<div style="text-align : right; margin-right : 23px; margin-bottom : 20px;">
					<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>