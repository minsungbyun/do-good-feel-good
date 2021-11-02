<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>공지사항 등록</title>
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
<h1>공지사항 등록</h1>
<form action='noticeAdd'>
<label for='f-title'>제목</label> <input id='f-title' type='text' name='title'><br>
<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
<!--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>-->
<button>등록</button><br>
</form>
</body>
</html>









