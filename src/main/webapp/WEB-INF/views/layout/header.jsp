<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>그린컴퓨터아카데미</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<style>
header {
	position: fixed;
	top: 0;
	/* width: 100% */
	left: 0;
	right: 0;
	z-index: 8;
}
</style>
</head>
<body>
	<header>
	
		<!-- 네브바 시작 -->
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark ">
		
			<a class="navbar-brand" href="/">그린컴퓨터아카데미</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
				<c:choose>
				<c:when test="${empty sessionScope.principal}">
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/joinForm">회원가입</a></li>				
				</ul>
			</div>
				</c:when>
						<c:otherwise>
						<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/user/${sessionScope.principal.id}">회원정보수정</a></li>				
					<li class="nav-item"><a class="nav-link" href="/user/${sessionScope.principal.id}">로그아웃</a></li>				
						</ul>
						</div>
				</c:otherwise>
				</c:choose>
		</nav>
		
	</header>
</body>
</html>

<!-- 네브바 끝 -->