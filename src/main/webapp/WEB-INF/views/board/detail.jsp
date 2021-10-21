<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

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
	#step1{
		width: 30%;
		text-align: center;
	}
	#step3{
		width: 30%;
		text-align: center;
		vertical-align: middle;
	}
	#step5{
		vertical-align: middle;
	}
	.header {
		background-image:  url("/image/background.jpg");
		height: 350px;
	}
	.search_box{
		width: 480px;
		height: 320px;
		background-color:  rgba(255, 255, 255, .95);
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

</style>
<br>
<br>
<br>
<!-- 윗부분 시작-->
<div class="container">
		<form action="#" method="post">
			<!-- 강의소개 -->
			<div class="header">
				<section>
					<div class="search_box">
						<div class="search_title"><h3>데이터 융합 자바(JAVA),코틀린(Kotlin) 웹&앱 개발자 양성과정</h3></div>
						<div class="search_sub_title"><p>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을 이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</p></div>
						<table>
							<tr>
								<td id="step1" >교육분야</td>
								<td>교육분야</td>
							</tr>
							<tr>
								<td id="step1" >취업분야</td>
								<td>취업분야</td>
							</tr>
							<tr>
								<td id="step1" >사용프로그램</td>
								<td>사용프로그램</td>
							</tr>
							<tr>
								<td id="step1" >시간</td>
								<td>시간</td>
							</tr>
						</table>	
					</div>
				</section>
			</div>
			</br>
			</br>
			<!-- 윗부분 종료 -->
			<!-- 커리큘럼 -->
			  <h3>CURRICULUM <span>커리큘럼</span></h3>
			  </br>
			  <table class="table table-dark">
			  	<tr>
			  		<div id="last">
			  		<td rowspan=2 id="step" ><h5>STEP <span>01</span></h5></td>
			  		</div>
			  		<td>프로그래밍 언어활용 <span>｜</span> 응용SW 기초기술 활용</td>
			  	</tr>
			  	<tr>
			  		<td>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을
							이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</td>
			  	</tr>
			  </table>
				</br>
			  <table class="table table-dark">
			  	<tr>
			  		<td rowspan=2 id="step" ><h5>STEP <span>02</span></h5></td>
			  		<td>프로그래밍 언어활용 <span>｜</span> 응용SW 기초기술 활용</td>
			  	</tr>
			  	<tr>
			  		<td>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을
							이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</td>
			  	</tr>
			  </table>
				</br>
			  <table class="table table-dark">
			  	<tr>
			  		<td rowspan=2 id="step" ><h5>STEP <span>03</span></h5></td>
			  		<td>프로그래밍 언어활용 <span>｜</span> 응용SW 기초기술 활용</td>
			  	</tr>
			  	<tr>
			  		<td>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을
							이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</td>
			  	</tr>
			  </table>	
				</br>
			  <table class="table table-dark">
			  	<tr>
			  		<td rowspan=2 id="step" ><h5>STEP <span>04</span></h5></td>
			  		<td>프로그래밍 언어활용 <span>｜</span> 응용SW 기초기술 활용</td>
			  	</tr>
			  	<tr>
			  		<td>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을
							이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</td>
			  	</tr>
			  </table>	
				</br>
			  <table class="table table-dark">
			  	<tr>
			  		<td rowspan=2 id="step" ><h5>STEP <span>05</span></h5></td>
			  		<td>프로그래밍 언어활용 <span>｜</span> 응용SW 기초기술 활용</td>
			  	</tr>
			  	<tr>
			  		<td>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을
							이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</td>
			  	</tr>
			  </table>	
			  </br>
			  <!--  아래부분 시작-->
			  <!-- 라인  -->
			<h3 id="step5"><img src="/image/logo.png" alt="John Doe" class="mr-3 mt-3 rounded-circle" style="width: 60px;"> 그린 컴퓨터 아카데미 평점 및 리뷰</h3>
			  </br>
			  <table class="table">
			  	<tr>
			  		<td id="step4"><h4>평균평점 : 4</h4></td>
			  		<td>
					<div class="star-rating space-x-4 mx-auto">
						<input type="radio" id="5-stars" name="rating" value="5"
							v-model="ratings" /> <label for="5-stars" class="star pr-4">★</label>
						<input type="radio" id="4-stars" name="rating" value="4"
							v-model="ratings" /> <label for="4-stars" class="star">★</label>
						<input type="radio" id="3-stars" name="rating" value="3"
							v-model="ratings" /> <label for="3-stars" class="star">★</label>
						<input type="radio" id="2-stars" name="rating" value="2"
							v-model="ratings" /> <label for="2-stars" class="star">★</label>
						<input type="radio" id="1-star" name="rating" value="1"
							v-model="ratings" /> <label for="1-star" class="star">★</label>
					</div>
					</td>	
				</tr>
			  </table>
				<div class="mt-3">
					<div class="media border p-3">
						<img src="/image/logo.png" alt="John Doe"
							class="mr-3 mt-3 rounded-circle" style="width: 60px;">
						<div class="media-body">
							<h4>
								제목 <small><i>작성자</i></small>
							</h4>
							<p>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을 이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</p>
								<a href=" /test/board/reviewupdateForm" class="btn btn-primary">리뷰 수정</a>
						</div>
					</div>
				</div>
				</br>
				<div class="mt-3">
					<div class="media border p-3">
						<img src="/image/logo.png" alt="John Doe"
							class="mr-3 mt-3 rounded-circle" style="width: 60px;">
						<div class="media-body">
							<h4>
								제목 <small><i>작성자</i></small>
							</h4>
							<p>응용 SW 개발에 필요한 환경을 구축하고 프로그래밍 언어의 기초문법을 적용하고 , 자바 언어의 특징을 이해하고 기본 응용SW를 구현하며 프로그래밍의 기본기를 익히는 단계</p>
						</div>
					</div>
				</div>
				</br>
			  	<nav>
			  	<ul>
			  	<button type="submit" class="btn btn-primary" id="button">강의 삭제</button>
			  	<a href=" /test/board/reviewsaveForm" class="btn btn-primary">리뷰 등록</a>
			  	</ul>
			  	</nav>
			  <!--  아래부분 종료-->
		</form>
	</div>


<%@ include file="../layout/footer.jsp" %>        