<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
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
<h1>로그인(MVC + EL)</h1>
<form action='lgoin'>
    
    <label for='f-id'>아이디</label> 
    <input id='f-id' type='text' name='id'><br>
    
    <label for='f-password'>암호</label> 
    <input id='f-password' type='password' name='password'><br>
    
 <button>[로그인]</button>
 <a href='delete?no=${groupDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>
</body>
</html>
    