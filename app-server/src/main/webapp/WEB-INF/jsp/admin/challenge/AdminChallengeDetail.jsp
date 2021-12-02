<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<div class="ad-main">
<div class="ad-main-infor">
          <div class="write-wrap">
            <h4 class="mb-5">챌린지 상세</h4>
            <form action="update" method="post" id="notice-form" enctype="multipart/form-data">
              <div class="form-group">
                <label for="f-no">번호</label>
                <input type="text" class="form-control col-sm-1" id="f-no" name="no" value='${challengeDTO.no}' readonly>
              </div>
              <!-- //번호 -->
              <div class="form-group">
                <label for="f-title">제목</label>
                <input type="text" class="form-control" id="f-title" name="title" value='${challengeDTO.title}'>
              </div>
              <!-- //제목 -->
              <div class="form-group">
                <label for="f-content">내용</label>
                <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${challengeDTO.content}</textarea>
              </div>
              <!-- //내용 -->
              <div class="form-group">
                <label for="f-startDate">시작일</label>
                <span id='f-startDate' name='startDate'>${challengeDTO.startDate}</span>
              </div>
              <!-- //시작일 -->
              <div class="form-group">
                <label for="f-endDate">종료일</label>
                <span id='f-endDate' name='endDate'>${challengeDTO.endDate}</span>
              </div>
              <!-- //종료일 -->
              <div class="form-group">
                <label for="f-registeredDate">등록일</label>
                <span id='f-registeredDate'>${challengeDTO.registeredDate}</span>
              </div>
              <!-- //등록일 -->
              <div class="form-group">
                <label for="f-photo">첨부파일</label>
                <a href="${contextPath}/upload/challenge/${challenge.photo}" >
	                <img id="f-challenge-image" src="${contextPath}/upload/challenge/${challenge.photo}_100x100.jpg">
	             </a>
                <input id='f-photo' type='file' name='photoFile'>
              </div>
              <!-- //첨부파일 -->
              <%-- <div class="form-group row">
                <label for="f-file" class="col-sm-1 col-form-label">첨부파일</label>
                <div class="col-sm-11">
                <img  id ="f-file-image" src="../upload/notice/${notice.fileUpload}">
                  <input type="file" class="form-control-file" id="f-file" name="fileUpload">
                </div>
              </div>
              <!-- //파일첨부 -->--%>
              <div class="form-group">
                <button>변경</button>
						     <a href='delete?no=${challengeDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
						     <a href='questionList?no=${challengeDTO.no}'>[문의목록]</a>
              </div>
              <!-- //ad-btn -->
            </form>
          </div>
          <!-- //write-wrap -->
        </div>
        <!-- //form -->
      </div>
      <!-- //ad-main -->
</body>
</html>