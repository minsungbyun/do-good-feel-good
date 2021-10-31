<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>공지사항 상세</title>
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
<h1>공지사항 상세</h1>

<form action='update'>
    <label for='f-no'>번호</label> 
    <input id='f-no' type='text' name='no' value='${notice.no}' readonly><br>
    
    <label for='f-title'>제목</label>
    <input id='f-title' type='text' name=title value='${notice.title}'><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content' value='${notice.content}'><br>
    
    <label for='f-registeredDate'>등록일</label> 
    <span id='f-registeredDate'>${notice.registeredDate}</span><br>
    
    <label for='f-viewCount'>조회수</label> 
    <span id='f-viewCount'>${notice.viewCount}</span><br>
    
    <!--  <label for='f-file'>첨부파일</label> 
    <input id='f-file' type='file' name='fileUpload' value='${notice.fileUpload}'><br>-->
    
<button>변경</button>
 <a href='noticeDelete?no=${notice.no}'>[삭제]</a> <a href='noticeList'>[목록]</a><br>
</form>

</body>
</html>
