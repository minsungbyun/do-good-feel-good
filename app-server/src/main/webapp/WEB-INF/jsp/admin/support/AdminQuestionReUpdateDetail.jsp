<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>문의사항 답변 등록/수정</title>
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
		<h1>문의사항 관리자 등록/수정</h1>
		<form action='replyUpdate' method="post">
		  <div style="display:none;">
		    <label for='f-no'>번호</label> 
        <input id='f-no' type='text' name='no' value='${questionListDTO.no}' readonly><br>
		  </div>
			<label for='f-reply'>답글</label>
			<input id='f-reply' type='text' name='reply' value='${questionListDTO.reply}'><br>
			<!-- <label for='f-password'>패스워드</label> <input id='f-password' type='password' name='qnaPassword' maxlength='4'><br> -->
			<%--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>--%>
			<button>등록</button><br>
			<a href='questionList?quesitonNo=${questionListDTO.no}'>[목록]</a>
		</form>
	</body>
</html>








