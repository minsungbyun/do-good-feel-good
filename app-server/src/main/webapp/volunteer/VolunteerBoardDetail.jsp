<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ko"></html>
	    <!-- //menu -->
	    
	    <div class="ad-main">
	      <div class="ad-main-infor">
	        <div class="write-wrap">
	          <h4 class="mb-5">나눔이야기 상세보기</h4>

            <form action='boardUpdate'  method='post' enctype="multipart/form-data">

              <div class="form-group">
	              <label for="f-no">번호</label>
	              <input type="text" class="form-control col-sm-1" id="f-no" name="no" value="${volunteerBoardDTO.no}" readonly>
	            </div>
	            <!-- //번호 -->

              <div class="form-group">
                <label for='f-name'>작성자</label>
                <input type='text' class="form-control" id='f-name' name='name'  value="${volunteerBoardDTO.owner.id}">
                </div>
              </div>
	            <!-- //작성자 -->

	            <div class="form-group">
	              <label for="f-title">제목</label>
	              <input type="text" class="form-control" id="f-title" name="title" value="${volunteerBoardDTO.title}">
	            </div>
	            <!-- //제목 -->

	            <div class="form-group">
	              <label for="f-content">내용</label>
	              <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${volunteerBoardDTO.content}</textarea>
	            </div>
	            <!-- //내용 -->

	            <div class="form-group">
	              <label for="f-registeredDate">등록일</label>
	              <span id='f-registeredDate'>${volunteerBoardDTO.registeredDate}</span>
	            </div>
	            <!-- //등록일 -->

	            <div class="form-group">
	              <label for="f-viewCount">조회수</label>
	              <span id='f-viewCount'>${volunteerBoardDTO.viewCount}</span>
	            </div>
	            <!-- //조회수 -->

	            <div class="form-group row">
	              <label for="f-file" class="col-sm-1 col-form-label">첨부파일</label>
	              <div class="col-sm-11">
	              <img  id ="f-file-image" src="../upload/volunteer/${volunteerBoardDTO.fileUpload}">
	                <input type="file" class="form-control-file" id="f-file" name="fileUpload">
	              </div>
	            </div>
	            <!-- //파일첨부 -->

	            <div class="form-group">
	              <a href="volunteerBoardDTO" class="btn btn-primary">목록</a>
	            </div>

              <button id="volunteer-button" class="btn btn-primary">변경</button>
              <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
              <a href='boardList' class="btn btn-primary">목록</a>
              
                <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a><br>
            </form>

	            <!-- //ad-btn -->

	        </div>
	        <!-- //write-wrap -->
	      </div>
	      <!-- //form -->
	    </div>
	    <!-- //ad-main -->
	    
	  </div>
	  <!-- //wrap -->
	  

<script>
document.querySelector("#volunteer-button").onclick = () => {
  if (document.querySelector("#f-title").value == "" ||
      document.querySelector("#f-content").value == "") {
    //window.alert("필수 입력 항목이 비어 있습니다.")
    Swal.fire("필수 입력 항목이 비어 있습니다.")
    return false;
  }
};
</script>
	  <!-- sript -->

	</body>
</html>

 
</body>
</html>


