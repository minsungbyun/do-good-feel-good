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
	    width: 60px;
	  }
	  </style>
	</head>
	<body>
  <div id="wrap">
    <div class="loginBox" action=''>  
      <div class="loginInput">
        <label for="id" title="아이디 입력"> 아이디</label>
        <input type="text" class="loginInput" name="id" maxlength="10" style="width:180px;">
        
        <label for="pwd" title="비밀번호 입력"></label>
        <input type="password" class="loginInput" name="pwd" maxlength="25" style="width:180px;">
        
        <button type="button" class="loginBtn">로그인</button>
        <span>- 아이디·비밀번호 찾기 및 변경, 신규 등록이 필요한 경우 맥스카드 담당자에게 연락하시기 바랍니다.</span>
      </div>
      <!-- //loginInput -->     
    </div>
  </div>
  <!-- //wrap -->
</body>
</html>









