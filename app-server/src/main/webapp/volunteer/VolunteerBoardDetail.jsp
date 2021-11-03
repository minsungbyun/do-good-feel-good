<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사게시글상세보기</title>
  <style>
  label {
    margin-right: 5px;
    text-align: right;
    display: inline-block;
    width: 60px;
  }
  </style>
</head>
<body>
<h1>봉사 게시판 상세보기</h1>
<form action='boardUpdate'>
    <label for='f-no'>게시글 번호</label> 
    <input id='f-no' type='text' name='no' value='${volunteerBoardDTO.no}' readonly><br>
    
    <label for='f-name'>작성자</label>
    <input id='f-name' type='text' name='owner' value='${volunteerBoardDTO.owner.id}'><br>
    
    <label for='f-title'>제목</label> 
    <input id='f-title' type='text' name='title' value='${volunteerBoardDTO.title}'><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content' value='${volunteerBoardDTO.content}'><br>
    <%-- 
    <label for='f-file'>첨부파일</label> 
    <input id='f-file' type='file' name='fileUpload' value='${volunteerBoardDTO.fileUpload.title}'><br>
    --%>
    <label for='f-registeredDate'>등록일</label> 
    <span id='f-registeredDate'>${volunteerBoardDTO.registeredDate}</span><br>
    
    <label for='f-viewCount'>조회수</label> 
    <input id='f-viewCount' type='number' name='viewCount' value='${volunteerBoardDTO.viewCount}' readonly><br>
 <button>변경</button>
 <a href='boardDelete?no=${volunteerBoardDTO.no}'>[삭제]</a> <a href='boardList'>[목록]</a><br>
</form>

</body>
</html>
