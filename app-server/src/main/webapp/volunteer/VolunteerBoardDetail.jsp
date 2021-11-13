<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

  <main>
    <div class="page-section padding-board">
      <div class="container">
        <h4 class="mb-3">봉사 게시판 상세보기</h4>
        <!-- serch -->
        <div>
          <form action='boardUpdate' class="form-inline" style="float:right; margin-bottom:25px">
            <input class="form-control mr-sm-2 search-box" type="search" placeholder="검색" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0 search-btn" type="submit">검색</button>
          </form>
        </div>
        <!-- //serch -->

  <div class="mb-3 row">
    <label for='f-no' class="col-sm-2 col-form-label">게시글 번호</label>
    <div class="col-sm-6">
      <input id='f-no' type='text' name='no' class="form-control" value='${volunteerBoardDTO.no}' readonly>
    </div>
  </div>

  <div class="mb-3 row">
    <label for='f-name' class="col-sm-2 col-form-label">작성자</label>
    <div class="col-sm-6">
      <input id='f-name' type='text' name='name' class="form-control" value="${volunteerBoardDTO.owner.id}">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-title' class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-8">
      <input id='f-title' type='text' name='title' class="form-control" value="${volunteerBoardDTO.title}">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
    <div class="col-sm-8">
      <textarea id='f-content' name='content' class="form-control" rows="5" value="${volunteerBoardDTO.content}">
    </textarea>
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-registeredDate' class="col-sm-2 col-form-label">등록일</label> 
    <div class="col-sm-8">
      <input id='f-registeredDate' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.registeredDate}">
    </div>
  </div>
    
  <div class="mb-3 row">
   <label for='f-viewCount' class="col-sm-2 col-form-label">조회수</label> 
   <div class="col-sm-8">
     <input id='f-viewCount' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.viewCount}">
   </div>
  </div>  
  
    <%-- 
  <div class="mb-3 row">
   <label for='f-viewCount' class="col-sm-2 col-form-label">첨부파일</label> 
   <div class="col-sm-10">
     <input id='f-viewCount' type="file" class="form-control-plaintext" value="${volunteerBoardDTO..fileUpload.title}">
   </div>
  </div>  
    --%>
    
 <button class="btn btn-primary">변경</button>
 <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
 <a href='boardList' class="btn btn-primary">목록</a>
 
   <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a><br>
</form>
</div><!-- .container -->
</body>
</html>

<%-- <p>&nbsp;</p>
<div style="border: 1px solid; width: 600px; padding: 5px">
    <form name="form1" action="board5ReplySave" method="post">
        <input type="hidden" name="brdno" value="<c:out value="${boardInfo.brdno}"/>작성자: 
        <input type="text" name="rewriter" size="20" maxlength="20"> <br/>
        <textarea name="rememo" rows="3" cols="60" maxlength="500" placeholder="댓글을 달아주세요."></textarea>
        <a href="#" onclick="fn_formSubmit()">저장</a>
    </form>
</div>
<br>
 --%>

