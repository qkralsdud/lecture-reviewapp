<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>
body {
	padding-top: 200px;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.form-container {
	max-width: 767px;
	margin: auto;
	padding: 70px 100px 80px;
	border: 10px solid #95c6db;
	background: #f5f5f5;
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.2);
}
.form-control {
	width: 100%;
	height: 43px;
	display: block;
	font-size: 15px;
	border: none;
	border-bottom: 2px solid #04a5db;
	background: none;
}

</style>


<!-- Custom styles for this template -->
<link href="/assets/dist/css/signin.css" rel="stylesheet">

<body class="text-center">
<div class="form-container">
	<div class="container">
		<main class="form-signin">
			<form action="/test/board/list" method="">

				<img class="mb-4" src="/assets/brand/green.svg" alt="" width="150"
					height="60">
				<h1 class="h3 mb-3 fw-normal">로그인</h1>
				<div class="form-floating">
					<!--     <label for="floatingInput">Email address</label> -->
					<input type="text" class="form-control" id="floatingInput"
						placeholder="UserId"> <br>
					<!--      <label for="floatingPassword">Password</label> -->
					<input type="password" class="form-control" id="floatingPassword"
						placeholder="Password">
				</div>


				<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>

			</form>

		</main>
	</div>
</div>	
</body>

<%@ include file="../layout/footer.jsp"%>
