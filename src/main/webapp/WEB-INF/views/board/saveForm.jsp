<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<style>
nav {
	display: grid;
	grid-template-columns: auto auto;
	justify-content: flex-end;
}

#content {
	width: auto;
	margin: 0 auto;
	max-width: 600px;
}

table {
	width: 100%;
	table-layout: fixed;
	border: 0 none;
	border-spacing: 0;
	border-collapse: collapse;
}

#curry {
	height: 100px;
}

th {
	width: 110px;
}
</style>
<br>
<br>
<br>
<br>
<div class="container">
	<div id="content">
		<form action="/board" method="post">
			<div class="mTitle">
				<h4>그린컴퓨터 아카데미 강의등록</h4>
				<table class="table">
					<tr>
						<th>
							<h5>강의 소개 사진 등록</h5>
						</th>
						<td>
							<div class="custom-file mb-3">
								<input type="file" class="custom-file-input" id="customFile"
									name="filename"> <label class="custom-file-label"
									for="customFile">사진선택</label>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">
							<h5>강의명</h5>
						</th>
						<td><input type="text" name="title" class="form-control"
							placeholder="강의명을 입력하세요"></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>강사명</h5>
						</th>
						<td><input type="text" name="teacher" class="form-control"
							placeholder="강사님 성함을 입력하세요"></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>취업분야</h5>
						</th>
						<td><input type="text" name="employment" class="form-control"
							placeholder="수강 후 취업가능 분야를 소개해주세요"></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>프로그램</h5>
						</th>
						<td><input type="text" name="program" class="form-control"
							placeholder="사용프로그램을 입력하세요"></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>강의소개</h5>
						</th>
						<td><textarea name="intro" class="form-control"
								placeholder="강의를 소개해주세요"></textarea></td>
					</tr>
				</table>
				<br> <br>
				<h4>커리큘럼등록</h4>
				<table class="table">
					<tr>
						<th scope="row">
							<h5>커리큘럼 Step1</h5>
						</th>
						<td><textarea id="curry" name="curriculum1"
								class="form-control" placeholder="커리큘럼을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>커리큘럼 Step2</h5>
						</th>
						<td><textarea id="curry" name="curriculum2"
								class="form-control" placeholder="커리큘럼을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>커리큘럼 Step3</h5>
						</th>
						<td><textarea id="curry" name="curriculum3"
								class="form-control" placeholder="커리큘럼을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>커리큘럼 Step4</h5>
						</th>
						<td><textarea id="curry" name="curriculum4"
								class="form-control" placeholder="커리큘럼을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<th scope="row">
							<h5>커리큘럼 Step5</h5>
						</th>
						<td><textarea id="curry" name="curriculum5"
								class="form-control" placeholder="커리큘럼을 입력해주세요"></textarea></td>
					</tr>
				</table>
				<hr>
				<nav><button type="submit" class="btn btn-primary">등록하기</button></nav>
			</div>
		</form>
	</div>
</div>
<!-- 사진 넣었을때 이름 넣기 -->
<script>
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

<%@ include file="../layout/footer.jsp"%>
