<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>새챌린지</title>
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
<!-- <h1>새챌린지(MVC)</h1>
<form action='add' method='post' enctype="multipart/form-data">
<label for='f-title'>제목</label> <input id='f-title' type='text' name='title'><br>
<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
<label for='f-startDate'>시작일</label> <input id='f-startDate' type='date' name='startDate'><br>
<label for='f-endDate'>종료일</label> <input id='f-endDate' type='date' name='endDate'><br>
<label for='f-photo'>사진첨부</label> <input id='f-photo' type='file' name='photoFile'><br>
<button>등록</button><br>
</form> -->


<div class="container">
<br><h4>챌린지 등록</h4><br>
<form action='add' method="post" enctype="multipart/form-data">

  <div class="mb-3 row">
    <label for='f-title' class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-8">
      <input id='f-title' type='text' name='title' class="form-control">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
        <div class="col-sm-8">
      <textarea id='f-content' name='content' class="form-control" rows="5">
    </textarea>
  </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-startDate' class="col-sm-2 col-form-label">시작일</label> 
        <div class="col-sm-8">
      <input id='f-startDate' name='startDate' class="form-control" type='date'>
  </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-endDate' class="col-sm-2 col-form-label">종료일</label> 
        <div class="col-sm-8">
      <input id='f-endDate' name='endDate' class="form-control" type='date'>
  </div>
  </div>
  
  <div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">파일첨부</label> 
  <div class="col-sm-8">
    <input id='f-photo' type='file' name='photoFile' class="form-control">
  </div>
</div>
  
<!-- 
  <div class="mb-3 row">
   <label for='f-viewCount' class="col-sm-2 col-form-label">첨부파일</label> 
   <div class="col-sm-10">
     <input id='f-viewCount' type="file" class="form-control-plaintext" name='photoFile'>
   </div>
  </div>  
    -->

  <div class="btn-regi" style="float: right;">
    <button type="submit" class="btn btn-primary nBtn">등록</button>
    <input type="button" class="btn btn-outline-primary nBtn" value="이전"
        onClick="history.go(-1)" role="button">
  </div>
  
</form>
</div><!-- .container -->
</body>
</html>









