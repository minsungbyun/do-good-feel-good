<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>문의사항 상세</title>
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
		<h1>문의사항 상세</h1>
		<form action='questionUpdate'>
	    <label for='f-no'>번호</label> 
	    <input id='f-no' type='text' name='questionNo' value='${questionListDTO.no}' readonly><br>
			<label for='f-qnaType'>문의분야</label>
			<span id='f-qnaType'>${questionListDTO.qnaType.title}</span><br>
			<label for='f-title'>제목</label> 
			<input id='f-title' type='text' name='title' value='${questionListDTO.title}'><br>
			<label for='f-content'>내용</label> 
			<input id='f-content' type='text' name='content' value='${questionListDTO.content}'><br>
			<label for='f-password'>패스워드</label>
			<input id='f-password' type='password' name='qnaPassword' maxlength='4'><br>
			<label for='f-owner'>작성자</label> 
			<span id='f-owner'>${questionListDTO.owner.id}</span><br>
			<label for='f-registeredDate'>등록일</label> 
			<span id='f-registeredDate'>${questionListDTO.registeredDate}</span><br>
			<label for='f-viewCount'>조회수</label> 
      <span id='f-viewCount'>${questionListDTO.viewCount}</span><br>
      <%--<label for='f-file'>첨부파일</label> 
      <input id='f-file' type='file' name='fileUpload' value='${questionListDTO.fileUpload}'>  --%>
			<button>수정</button>
			<a href='questionDelete?questionNo=${questionListDTO.no}'>[삭제]</a>
			<a href='questionList'>[목록]</a><br>
	  </form>
	</body>
</html>
