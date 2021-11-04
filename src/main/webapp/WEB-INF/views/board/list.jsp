<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
 
    <style>
        .m_box {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr;
            grid-gap: 20px;
        }

        .m_tm_20 {
            margin-top: 20px;
        }
        .box {
  display: block;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
#content {
    max-width: 460px;
    width: auto;
    margin: 0 auto;
}
    </style>
<br>
<br>
<br>
<br>
<h2 style="text-align: center">그린 컴퓨터 아카데미 IT 강의 리스트</h2>
<div class="container mt-3" >
<div id="content">
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  </div>
  <br>
  <br>
</div>
    <div class="container m_box "  id="list">
        <!-- 영화카드시작 -->
        <div class="card "  >
            <img class="card-img-top" src="/image/background.jpg" alt="Card image">
            <div class="card-body text-center" >
                <h4 class="card-title">${boardEntity.title }</h4>
                <p class="card-text box" >${boardEntity.intro }</p>
                <a href=" board/{id}" class="btn btn-primary">상세보기</a>
            </div>
            <br>
        </div> 
        <!-- 영화카드 끝 -->

    </div>
    <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#list div").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<%@ include file="../layout/footer.jsp" %>








