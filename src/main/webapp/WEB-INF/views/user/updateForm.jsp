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
} 
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
	background-color: #39459b; /*#39459b */
	cursor: pointer;
	text-transform: uppercase;
	transition: background-color 0.2s linear;
}


button[type="submit"]:hover {
	background-color: #299cd1;
}

h {
	position: relative;
	width: 100px;
	height: 100px;
	bottom: -90px;
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
		<h3>회원 정보 수정</h3>
		<p>양식에 맞추어 수정할 내용을 입력해주세요.</p>
	<form onsubmit="userUpdate(event, ${sessionScope.principal.id})">
		<div class="form-group">
			<input type="text" class="form-control" required placeholder="아이디" readonly="readonly" value="${sessionScope.principal.username}">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="password" required placeholder="비밀번호"  >
		</div>
		<div class="form-group">
			<input type="text" class="form-control" required placeholder="이름" readonly="readonly" value="${sessionScope.principal.name}">
		</div>
		<div class="form-group">
			<input type="email" id="email" class="form-control" required placeholder="이메일" value="${sessionScope.principal.email}" >
		</div>
		<div class="form-group">
			<input type="text"  id="phone"  class="form-control" required placeholder="전화번호" value="${sessionScope.principal.phone}" >
		</div>
		<nav>
			<button id="btn1" type="submit">수정하기</button>
			<h>더이상 이용하지 않는다면 <a
				href="/test/user/deleteForm">회원탈퇴</a> 바로가기</h>
		</nav>
	</form>
</div>

<script>
async function userUpdate(event, id){ 
	   event.preventDefault();

	   let userUpdateDto = {
			   email: document.querySelector("#email").value,
			   phone: document.querySelector("#phone").value,
			   password: document.querySelector("#password").value
	   };
		
		let response = await fetch("http://localhost:8080/user/"+id, {
			method: "put",
			body: JSON.stringify(userUpdateDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json();

		if(parseResponse.code == 1){
			alert("업데이트 성공");
			location.href = "/";
		}else{
			alert("업데이트 실패 : "+parseResponse.msg);
		}
}
</script>

<%@ include file="../layout/footer.jsp"%>

