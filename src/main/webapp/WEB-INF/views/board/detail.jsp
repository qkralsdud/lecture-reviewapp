<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<style>
ul {
	margin: 1px;
}

nav {
	display: grid;
	grid-template-columns: auto auto;
	justify-content: flex-end;
}

#content {
	width: auto;
	margin: 0 auto;
	max-width: 740px;
}

table {
	width: 100%;
	table-layout: fixed;
	border: 0 none;
	border-spacing: 0;
	border-collapse: collapse;
}

#step {
	width: 20%;
	text-align: center;
}

#step1 {
	width: 30%;
}

#step3 {
	width: 30%;
	text-align: center;
	vertical-align: middle;
}

#step5 {
	vertical-align: middle;
}

.header {
	background-image: url("/image/background.jpg");
	height: 350px;
}

.search_box {
	width: 480px;
	height: 320px;
	background-color: rgba(255, 255, 255, .95);
	display: inline-block;
	padding: 20px 30px;
	float: right;
	border-radius: 10px;
	position: relative;
	top: 10px;
	right: 10px;
}

.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 2.25rem;
	line-height: 2.5rem;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
}

.star-rating input {
	display: none;
}

.star-rating label {
	-webkit-text-fill-color: transparent;
	/* Will override color (regardless of order) */
	-webkit-text-stroke-width: 2.3px;
	-webkit-text-stroke-color: #2b2a29;
	cursor: pointer;
}

.star-rating :checked ~ label {
	-webkit-text-fill-color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	-webkit-text-fill-color: #fff58c;
}

label {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 60px;
	height: 60px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;
}

[type=radio] {
	position: absolute;
	opacity: 0;
	width: 0;
	height: 0;
}
</style>
<br>
<br>
<br>
<!-- 윗부분 시작-->
<div class="container">
	<form action="/board/{id}/detail" method="post">
		<!-- 강의소개 -->
		<div class="header">
			<section>
				<div class="search_box">
					<div class="search_title">
						<h3>${boardEntity.title }</h3>
					</div>
					<div class="search_sub_title">
						<p>${boardEntity.intro }</p>
					</div>
					<table>
						<tr>
							<td id="step1">취업분야</td>
							<td>${boardEntity.employment }</td>
						</tr>
						<tr>
							<td id="step1">사용프로그램</td>
							<td>${boardEntity.program }</td>
						</tr>
						<tr>
							<td id="step1">강사명</td>
							<td>${boardEntity.teacher }</td>
						</tr>
					</table>
				</div>
			</section>
		</div>
		</br> </br>
		<!-- 윗부분 종료 -->
		<!-- 커리큘럼 -->
		<h3>CURRICULUM <span>커리큘럼</span></h3>
		</br>
			<table class="table table-dark">
				<tr>
					<div id="last">
						<td id="step"><h5>STEP <span>01</span></h5></td>
						<td><c:out value="${boardEntity.curriculum1}"/></td>
					</div>
				</tr>
			</table>
			<table class="table table-dark">
				<tr>
					<div id="last">
						<td id="step"><h5>STEP <span>02</span></h5></td>
						<td><c:out value="${boardEntity.curriculum2}"/></td>
					</div>
				</tr>
			</table>
			<table class="table table-dark">
				<tr>
					<div id="last">
						<td id="step"><h5>STEP <span>03</span></h5></td>
						<td><c:out value="${boardEntity.curriculum3}"/></td>
					</div>
				</tr>
			</table>
			<table class="table table-dark">
				<tr>
					<div id="last">
						<td id="step"><h5>STEP <span>04</span></h5></td>
						<td><c:out value="${boardEntity.curriculum4}"/></td>
					</div>
				</tr>
			</table>
			<table class="table table-dark">
				<tr>
					<div id="last">
						<td id="step"><h5>STEP <span>05</span></h5></td>
						<td><c:out value="${boardEntity.curriculum5}"/></td>
					</div>
				</tr>
			</table>
			</br>
			</br>
		<!--  아래부분 시작-->
		<!-- 라인  -->
		<h3 id="step5">
			<img src="/image/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width: 60px;"> 그린 컴퓨터 아카데미 평점 및 리뷰
		</h3>
		</br>
		<table class="table">
			<tr>
				<td id="step4"><h4>평균평점 : ${boardEntity.ratingmin }</h4></td>
				<td>
		         <div class="starRev">
		            <input type="radio"  value="1" /><label for="1-stars" class="starR on">1</label> 
		            <input type="radio"  value="2" /><label for="2-stars" class="starR">2</label> 
		            <input type="radio"  value="3" /><label for="3-stars" class="starR">3</label> 
		            <input type="radio"  value="4" /><label for="4-stars" class="starR">4</label> 
		            <input type="radio"  value="5" /><label for="5-stars" class="starR">5</label>
		            <input type="hidden"  id="check_radio" name="rating" />
		         </div>
				</td>
			</tr>
		</table>
		<div class="mt-3">
			<c:forEach var="review" items="${boardEntity.reviews}">
				<div class="media border p-3">
					<img src="/image/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width: 60px;">
					<div class="media-body">
						<h4>${review.title } <small><i>${review.rating}</i></small></h4>
						<p>${review.content }</p>
							<nav>
								<div class="d-flex justify-content-end">작성자 : ${review.user.username} &nbsp;</div>
								<c:if test="${sessionScope.principal.id == boardEntity.user.id}">
									<a href=" /board/${review.id }/reviewupdateForm" class="btn btn-primary">리뷰 수정</a>
								</c:if>
							</nav>
					</div>
				</div>
			</c:forEach>
		</div>
		</br>
		</br>
	</form>
			<nav>
			<ul>
				<c:choose>
					<c:when test="${sessionScope.principal.username eq 'master'}">
						<button class="btn btn-primary" id="button" onclick="deleteById(${boardEntity.id })">강의 삭제</button>
					</c:when>	
				</c:choose>
				<a href=" /board/${boardEntity.id }/reviewsaveForm" class="btn btn-primary">리뷰 등록</a>
			</ul>
		</nav>
		<!--  아래부분 종료-->
		<script>
			async function deleteById(id){
				// 1. 비동기 함수 호출 -> 비동기를 잘처리하는 방법??????
				let response = await fetch("http://localhost:8080/board/"+id, {
					method: "delete"
				}); // 약속 - 어음 (10초)
				
				// 2.코드
				// json() 함수는 json처럼 생긴 문자열을 자바스크립트 오브젝트로 변환해준다.
				let parseResponse = await response.json();
				console.log(parseResponse); 
				
				if(parseResponse.code == 1){
					alert("삭제 성공");
					location.href="/";
				}else{
					alert(parseResponse.msg);
					location.href="/";
				}
			}
		</script>
</div>


<%@ include file="../layout/footer.jsp"%>
