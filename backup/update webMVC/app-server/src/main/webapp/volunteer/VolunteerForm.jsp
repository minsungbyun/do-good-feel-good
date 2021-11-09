<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사신청양식</title>
  <style>
  
  
  label {
    margin-right: 10px;
    text-align: right;
    display: inline-block;
    width: 100px;
  }
  
  #header {
     background-color: rgb(163, 176, 250);
     color: beige;
  }
  
  </style>
</head>
<body>
  <div id="header">
        <h1>Happy-share 봉사신청 양식</h1>
    </div>
    <div id="aside">
      <ul>
          <li><a href="#">Menu - 1</a></li>
          <li><a href="#">Menu - 2</a></li>
          <li><a href="#">Menu - 3</a></li>
      </ul>
  </div>

<form action='add'>
<label for='f-name'>제목</label> 
<input id='f-name' type='text' name='title'><br>

<label for='f-category'>카테고리</label> 
    <select>
        <option selected>선택하세요</option>
        <option>비대면</option>
        <option>아동</option>
        <option>청소년</option>
        <option>노인</option>
        <option>장애인</option>
        <option>동물</option>
        <option>환경</option>
        <option>기타</option>
    </select>
    
<label for='f-content'>내용</label> 
<input id='f-content' type='text' name='content'><br>

<label for='f-tel'>전화번호</label> 
<input id='f-tel' type='tel' name='tel'><br>

<label for='f-email'>이메일</label> 
<input id='f-email' type='email' name='email'><br>

<label for='f-startDate'>시작일</label> 
<input id='f-startDate' type='date' name='startDate'>

<label for='f-endDate'>종료일</label> 
<input id='f-endDate' type='date' name='endDate'><br>

<label for='f-startTime'>시작시간</label> 
<input id='f-startTime' type='time' name='startTime'>

<label for='f-endTime'>종료시간</label> 
<input id='f-endTime' type='time' name='endTime'><br>

<label for='f-limitNum'>총모집인원</label> 
<input id='f-limitNum' type='number' name='limitNum'><br>

<label for='f-fileUpload'>첨부파일</label> 
<input id='f-fileUpload' type='file' name='fileUpload'><br>

<input type='hidden' value='2' name='status'><br>
<button>봉사신청</button><br>
</form>
</body>
</html>









