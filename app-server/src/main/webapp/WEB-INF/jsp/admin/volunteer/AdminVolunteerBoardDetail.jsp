<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="ad-main">
     <div class="ad-main-infor">
       <div class="board-wrap padding-board">
         <h4 class="mb-3">봉사 게시판 상세보기</h4>
         
          <form action='boardUpdate' method="post" enctype="multipart/form-data"> 
          <div class="form-group" >
           <label for='f-no'></label>
            <input id='f-no' type='hidden' name='no' class="form-control col-sm-1" value='${volunteerBoardDTO.no}' readonly>
          </div>
        
          <div class="form-group">
            <label for='f-name' class="col-sm-2 col-form-label"><b>작성자</b></label>
              <input id='f-name' type='text' name='name' class="form-control" value="${volunteerBoardDTO.owner.id}" readonly>
          </div>
          
          <div class="form-group">
            <label for='f-title' class="col-sm-2 col-form-label"><b>제목</b></label>
              <input id='f-title' type='text' name='title' class="form-control" value="${volunteerBoardDTO.title}">
          </div>
          
          <div class="form-group">
            <label for='f-content' class="col-sm-2 col-form-label"><b>내용</b></label> 
             <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${volunteerBoardDTO.content}</textarea>
           </div>
           
              <!-- //파일첨부 -->
          
                    <div class="mb-3 row">
            <label for='f-photo' class="col-sm-2 col-form-label">사진</label> 
            <div class="col-sm-10">
              <a href="${contextPath}/upload/volunteer/${volunteerBoardDTO.photo}" >
                  <img id="f-photo-image" src="${contextPath}/upload/volunteer/${volunteerBoardDTO.photo}_500x500.jpg">
              </a>
              <input id='f-photo' type='file' name='photoFile' class="form-control">
            </div>
          </div> 
          
          <div class="form-group">
            <label for='f-registeredDate' class="col-sm-2 col-form-label"><b>등록일</b></label> 
              <input id='f-registeredDate' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.registeredDate}">
          </div>
            
          <div class="form-group">
           <label for='f-viewCount' class="col-sm-2 col-form-label"><b>조회수</b></label> 
             <input id='f-viewCount' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.viewCount}">
          </div>  
       
       
         <div class="button-box">
            <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
           <input type="button" class="btn btn-outline-primary nBtn" value="이전" onClick="history.go(-1)" role="button">
           <%-- <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a>--%>
         </div>       
          
         </form> 
           <br>
       </div>
      </div>

     
     
     
      <!-- Reply Form {s} -->
      <div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
        <h6 class="border-bottom pb-2 mb-0">COMMENT LIST</h6>

      
		       <%--  <c:if test='${empty noticeList}'>
		            <p>작성된 게시글이 없습니다.</p>
		          </c:if>--%>

        <div class="dap_lo">
         <div class="dap_lo2">
          <c:forEach items="${volunteerBoardCommentList}" var="volunteerBoardCommentDTO" varStatus="vs">
            <div><b>${volunteerBoardCommentDTO.owner.id}</b></div>
            <div class="dap_to comt_edit">${volunteerBoardCommentDTO.commentContent}</div>
            <div class="rep_me dap_to">${volunteerBoardCommentDTO.registeredDate}</div>
            <div class="rep_me rep_menu">       

            <a href='commentDelete?no=${volunteerBoardCommentDTO.no}'>[삭제]</a>
        </div>
    </c:forEach>
        </div>
    </div>

 <form action='commentAdd?volBoardNo=${volunteerBoardDTO.no}' method="post">
      <div class="form" id="form" role="form" >

      <div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
        <div class="row">
          <div class="col-sm-10">
            <textarea type="content" name='commentContent' id="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></textarea>
          </div> <br>
        
          <div class="col-sm-2">
          <button>등록</button><br>
          </div>
             </div> 
      </div>
        </div>
        </form>
        </div>  

     </div>
