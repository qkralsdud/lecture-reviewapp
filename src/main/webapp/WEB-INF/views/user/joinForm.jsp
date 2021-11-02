<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​
<%@ include file="../layout/header.jsp"%>

<link href="/assets/dist/css/signin.css" rel="stylesheet">
<style>
* {
	box-sizing: border-box;
}

include {
	padding-bottom: 5%
}

body {
	margin-top: 5%;
	margin-bottom: 8%;
	color: #000000;
	font-size: 15px;
}

input, button {
	color: #ffffff;
	font-size: 15px;
}

input:focus, button:focus {
	outline: none;
}

h3 {
	margin: 0 0 12px 0;
	font-size: 45px;
	text-align: center;
	text-transform: uppercase;
}

p {
	padding: 0 10px;
	margin: 0 0 55px 0;
	text-align: center;
	line-height: 1.8;
	color: ""
}

.wrapper {
	min-height: 100vh;
	align-items: center;
	padding-top: 5%;
	padding-bottom: 5%;
} /*  padding-top: 30%; padding-bottom: 30%; */
.form-container {
	max-width: 767px;
	margin: auto;
	padding: 70px 100px 80px;
	border: 10px solid #95c6db;
	background: #f5f5f5;
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.2);
}

.form-group {
	position: relative;
	display: block;
	margin-bottom: 48px;
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

button[type="submit"] {
	width: 162px;
	height: 51px;
	display: grid;
	align-items: center;
	justify-content: center;
	margin: 60px auto 0;
	padding: 0;
	color: #ffffff;
	border: 2px solid #ffffff;
	border-radius: 4px;
	background-color: #007bff;
	cursor: pointer;
	text-transform: uppercase;
	transition: background-color 0.2s linear;
}

button[type="submit"]:hover {
	background-color: #299cd1;
}
/*  div{
   z-index:-1;
}   */
nav {
	z-index: 2;
	position: relative;
}
/* #btn1{
   z-index: 2;

} */
</style>

<div class="form-container">
	<form action="/join" method="post">
		<h3>회원 가입</h3>
		<p>양식에 맞추어 회원 정보를 입력해주세요.</p>
		<div class="form-group">
			<input type="text"  name="username" class="form-control" required placeholder="아이디">
		</div>
		<div class="form-group">
			<input type="password"  name="password" class="form-control" required placeholder="비밀번호">
		</div>
		<div class="form-group">
			<input type="text"  name="name" class="form-control" required placeholder="이름">
		</div>
		<div class="form-group">
			<input type="text"  name="email" class="form-control" required placeholder="이메일">
		</div>
		<div class="form-group">
			<input type="text"  name="phone" class="form-control" required placeholder="전화번호">
		</div>
		<nav>
			<button id="btn1" type="submit">신청하기</button>
		</nav>
	</form>
</div>


<%@ include file="../layout/footer.jsp"%>

