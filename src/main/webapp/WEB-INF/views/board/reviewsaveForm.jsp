<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet"
   href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
   integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
   crossorigin="anonymous" />
<style>
.starRev  {
   flex-direction: column;
   text-align: center;
}

.title_star {
	 text-align: center;
}

nav {
	display: grid;
	grid-template-columns: auto auto;
	justify-content: flex-end;
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

.starR input {
   display: none;
}

.starR.on {
   background-position: 0 0;
}

[type=radio] {
   position: absolute;
   opacity: 0;
   width: 0;
   height: 0;
}
</style>

<div class="container">
	<form action="/board/${boardEntity.id}/review"  method="post">
		<br> <br> <br>

		<!-- 별점주기 -->
		<h3 class="title_star ">그린 컴퓨터 아카데미 평점 및 리뷰 작성</h3>
		<hr>
         <div class="starRev">
            <input type="radio"  value="1" /><label for="1-stars" class="starR on">1</label> 
            <input type="radio"  value="2" /><label for="2-stars" class="starR">2</label> 
            <input type="radio"  value="3" /><label for="3-stars" class="starR">3</label> 
            <input type="radio"  value="4" /><label for="4-stars" class="starR">4</label> 
            <input type="radio"  value="5" /><label for="5-stars" class="starR">5</label>
            <input type="hidden"  id="check_radio" name="rating" />
         </div>
		<br />
		<!-- 별점주기 끝 -->

		<div class="form-group">
			<input type="text" name="title" class="form-control"
				placeholder="Enter title">
		</div>
		<div class="form-group">
			<textarea id="summernote" class="form-control" rows="5"
				name="content"></textarea>
		</div>
		<nav><button type="submit" class="btn btn-primary">등록 완료</button></nav>
	</form>
</div>

<script>
	$('#summernote').summernote({
		height : 350
	});
	

   $('.starRev label').click(function(e) {
      $(this).parent().children('label').removeClass('on');
      $(this).addClass('on').prevAll('label').addClass('on');
      $("#check_radio").val($(this).text());
      return false;
   });
</script>

<%@ include file="../layout/footer.jsp"%>