<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand active" href="${pageContext.request.contextPath}/home">Board System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarColor01">
	    	<c:if test="${nowPage == 'home'}">
	    		<ul class="navbar-nav me-auto">
	       			<li class="nav-item">
	          			<a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
	       			</li>
	        		<li class="nav-item">
	          			<a class="nav-link" id="memberOneMenu" href="${pageContext.request.contextPath}/member/memberOne">회원정보</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link" id="boardListMenu" href="${pageContext.request.contextPath}/board/boardList">게시판</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link" id="logoutMenu" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	       		 	</li>
	       		 	<li class="nav-item" style="font-weight:500;">
	       		  		<button class="nav-link btn btn-secondary" disabled>${loginMember.memberName}님 환영합니다!</button>
	       		 	</li>
	      		</ul>
	    	</c:if>   
		    <c:if test="${nowPage == 'member'}">
	    		<ul class="navbar-nav me-auto">
	       			<li class="nav-item">
	          			<a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
	       			</li>
	        		<li class="nav-item">
	          			<a class="nav-link active" id="memberOneMenu" href="${pageContext.request.contextPath}/member/memberOne">회원정보</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link" id="boardListMenu" href="${pageContext.request.contextPath}/board/boardList">게시판</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link" id="logoutMenu" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	       		 	</li>
	       		 	<li class="nav-item" style="font-weight:500;">
	       		  		<button class="nav-link btn btn-secondary" disabled>${loginMember.memberName}님 환영합니다!</button>
	       		 	</li>
	      		</ul>
	    	</c:if>  
		    <c:if test="${nowPage == 'board'}">
	    		<ul class="navbar-nav me-auto">
	       			<li class="nav-item">
	          			<a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
	       			</li>
	        		<li class="nav-item">
	          			<a class="nav-link" id="memberOneMenu" href="${pageContext.request.contextPath}/member/memberOne">회원정보</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link active" id="boardListMenu" href="${pageContext.request.contextPath}/board/boardList">게시판</a>
	       		 	</li>
	       		 	<li class="nav-item" style="justify-content: flex-end">
	       		  		<a class="nav-link" id="logoutMenu" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	       		 	</li>
	       		 	<li class="nav-item" style="font-weight:500;">
	       		  		<button class="nav-link btn btn-secondary" disabled>${loginMember.memberName}님 환영합니다!</button>
	       		 	</li>
	      		</ul>
	    	</c:if> 
    	</div>
    </div>
</nav>