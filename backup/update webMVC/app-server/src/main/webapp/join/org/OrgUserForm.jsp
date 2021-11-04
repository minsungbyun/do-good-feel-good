<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>기관회원</title>
	<style>
	label {
		margin-right: 5px;
		text-align: right;
		display: inline-block;
		 width: 100px;
	 }
	</style>
</head>
<body>
<h1>기관회원(MVC)</h1>
<form action='add'>
<label for='f-id'>아이디</label> <input id='f-id' type='text' name='id'><br>
<label for='f-password'>암호</label> <input id='f-password' type='password' name='password'><br>
<label for='f-name'>이름</label> <input id='f-name' type='text' name='name'><br>
<label for='f-tel'>전화</label> <input id='f-tel' type='tel' name='tel'><br>
<label for='f-email'>이메일</label> <input id='f-email' type='email' name='email'><br>
<label for='f-postNo'>우편번호</label> <input id='f-postNo' type='number' name='postNo'><br>
<label for='f-basicAddress'>기본주소</label> <input id='f-basicAddress' type='text' name='basicAddress'><br>
<label for='f-detailAddress'>상세주소</label> <input id='f-detailAddress' type='text' name='detailAddress'><br>
<label for='f-corpNo'>사업자번호</label> <input id='f-corpNo' type='text' name='corpNo'><br>
<label for='f-fax'>팩스</label> <input id='f-fax' type='text' name='fax'><br>
<label for='f-homepage'>홈페이지</label> <input id='f-homepage' type='url' name='homepage'><br>
<button>등록</button><br>
</form>
</body>
</html>
     