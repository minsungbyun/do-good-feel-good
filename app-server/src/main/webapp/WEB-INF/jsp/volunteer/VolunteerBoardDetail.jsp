<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="ad-main">
     <div class="ad-main-infor">
       <div class="board-wrap padding-board">
         <h4 class="mb-3">봉사 게시판 상세보기</h4>
         
          <form action='boardUpdate' method="post"> 
				  <div class="form-group" >
				   <label for='f-no'></label>
				    <input id='f-no' type='hidden' name='no' class="form-control col-sm-1" value='${volunteerBoardDTO.no}' readonly>
				  </div>
				
				  <div class="form-group">
				    <label for='f-name' class="col-sm-2 col-form-label">작성자</label>
				      <input id='f-name' type='text' name='name' class="form-control" value="${volunteerBoardDTO.owner.id}">
				  </div>
				  
				  <div class="form-group">
				    <label for='f-title' class="col-sm-2 col-form-label">제목</label>
				      <input id='f-title' type='text' name='title' class="form-control" value="${volunteerBoardDTO.title}">
				  </div>
				  
				  <div class="form-group">
				    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
             <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${volunteerBoardDTO.content}</textarea>
           </div>
           
              <!-- //파일첨부 -->

				  
           <%--         <div class="mb-3 row">
            <label for='f-photo' class="col-sm-2 col-form-label">사진</label> 
            <div class="col-sm-10">
              <a href="../upload/volunteer/${volunteerBoardDTO.fileUpload}" >
                  <img id="f-photo-image" src="../upload/volunteer/${volunteerBoardDTO.fileUpload}_100x100.jpg">
              </a>
              <input id='f-photo' type='file' name='photo' class="form-control">
            </div>
          </div> --%>
				  
				  <div class="form-group">
				    <label for='f-registeredDate' class="col-sm-2 col-form-label">등록일</label> 
				      <input id='f-registeredDate' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.registeredDate}">
				  </div>
				    
				  <div class="form-group">
				   <label for='f-viewCount' class="col-sm-2 col-form-label">조회수</label> 
				     <input id='f-viewCount' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.viewCount}">
				  </div>  
       
          <div class="button-box">
					 <button class="btn btn-primary">변경</button>
					 <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
					 <a href='boardList' class="btn btn-primary">목록</a>
					 <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a><br>
         </div>       
	       </form> 
	     </div>
	    </div>
	   </div>
        


