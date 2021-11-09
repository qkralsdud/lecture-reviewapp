<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet"
   href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
   integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
   crossorigin="anonymous" />

<style>
.star {
   flex-direction: column;
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
	<form onsubmit="update(event, ${reviewEntity.id})">
		<br> <br> <br>
		<!-- 별점주기 -->
		<h3 class="title_star ">리뷰 수정</h3>
		<hr>
         <div class="starRev">
            <input type="radio" id="rating" value="1" /><label for="1-stars" class="starR on">1</label> 
            <input type="radio" id="rating" value="2" /><label for="2-stars" class="starR">2</label> 
            <input type="radio" id="rating" value="3" /><label for="3-stars" class="starR">3</label> 
            <input type="radio" id="rating" value="4" /><label for="4-stars" class="starR">4</label> 
            <input type="radio" id="rating" value="5" /><label for="5-stars" class="starR">5</label>
            <input type="hidden"  id="check_radio" name="rating" />
         </div>
		<br />
		<!-- 별점주기 끝 -->

		<div class="form-group">
			<input type="text" id="title" class="form-control"   value="${reviewEntity.title}" 
				placeholder="Enter title">
		</div>
		<div class="form-group">
			<textarea id="content" class="form-control"   rows="5">${reviewEntity.content}</textarea>
		</div>
		<nav>
			<button type="submit" class="btn btn-primary">수정완료</button>
		</nav>
	</form>
</div>

<script>
	async function update(event, id){ 
	    
	    event.preventDefault();
	   
	    let reviewUpdateDto = {
	          title: document.querySelector("#title").value,
	          content: document.querySelector("#content").value,
	          rating:  document.querySelector("#rating").value
	    };
	   
	       let response = await fetch("http://localhost:8080/board/"+id+"/reviewupdate", {
	          method: "put",
	          body: JSON.stringify(reviewUpdateDto),
	          headers: {
	             "Content-Type": "application/json; charset=utf-8"
	          }
	       });
	       
	       let parseResponse = await response.json(); 
	       
	       if(parseResponse.code == 1){
	          alert("리뷰 업데이트 성공");
	          location.href="/";
	       }else{
	          alert("리뷰 업데이트 실패: " + parseResponse.msg);
	       }
	 }
	
   $('.starRev label').click(function(e) {
	      $(this).parent().children('label').removeClass('on');
	      $(this).addClass('on').prevAll('label').addClass('on');
	      $("#check_radio").val($(this).text());
	      return false;
	   });
   
	$('#content').summernote({
		height : 350
	});
</script>

<%@ include file="../layout/footer.jsp"%>