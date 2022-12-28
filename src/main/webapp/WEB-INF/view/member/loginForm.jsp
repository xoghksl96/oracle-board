<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<h1>로그인 페이지</h1>
	<form action="${pageContext.request.contextPath}/LoginActionController" method="post" id="loginForm">
	
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" id="memberId" name="memberId"></td>
			</tr>
			
			<tr>
				<th>PW</th>
				<td><input type="password" id="memberPw" name="memberPw"></td>
			</tr>
		</table>
		
		<div>
			<button type="button" id="loginBtn">로그인</button>
		</div>
	</form>
</body>
</html>