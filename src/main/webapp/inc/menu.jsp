<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand active" href="#">Board System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarColor01">
	    	<c:if test="${nowPage eq 'home'}">
	    		<ul class="navbar-nav me-auto">
	       			<li class="nav-item">
	          			<a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
	       			</li>
	        		<li class="nav-item">
	          			<a class="nav-link" id="addMemberMenu" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
	       		 	</li>
	       		 	<li class="nav-item">
	       		  		<a class="nav-link" id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
	       		 	</li>
	      		</ul>
	    	</c:if>   
		    <c:if test="${nowPage eq 'addMember'}">
		   		<ul class="navbar-nav me-auto">
		      		<li class="nav-item">
		         		<a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
		      		</li>
			       	<li class="nav-item">
			         	<a class="nav-link active" id="addMemberMenu" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
			      	</li>
		      		 <li class="nav-item">
		      		  	<a class="nav-link" id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
		      		 </li>
		   		</ul>
		   	</c:if> 
		    <c:if test="${nowPage eq 'login'}">
				<ul class="navbar-nav me-auto">
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="addMemberMenu" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
					</li>
				</ul>
		    </c:if>
    	</div>
    </div>
</nav>