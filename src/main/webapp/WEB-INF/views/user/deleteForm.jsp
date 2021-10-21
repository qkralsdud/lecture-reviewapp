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

.containe {
	width: "900"
}

nav {
	display: grid;
	grid-template-columns: 150px 150px;
}

#btn1 {
	margin-right: 4px
}

#btn2 {
	margin-left: 4px
}
</style>


<!-- Custom styles for this template -->
<link href="/assets/dist/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<div class="container">
		<main class="form-signin">
			<form action="/test/user/deleteForm" method="post">

				<img class="mb-4" src="/assets/brand/green.svg" alt="" width="150"
					height="60">
				<h1 class="h5 mb-3 fw-normal">비밀번호를 입력해주세요</h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="floatingInput"
						value="유저네임" readonly="readonly"> <br>
					<input type="password" class="form-control" id="floatingPassword"
						placeholder="Password">

				</div>

				<nav>
					<button id="btn1" class="w-100 btn btn-lg btn-primary"
						type="submit">회원탈퇴</button>

					<button id="btn2" class="w-100 btn btn-lg btn-primary"
						type="submit">취소</button>
				</nav>
				<p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>

			</form>

		</main>
	</div>

	<%@ include file="../layout/footer.jsp"%>