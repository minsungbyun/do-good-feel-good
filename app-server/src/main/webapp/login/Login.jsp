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
<h1>로그인</h1>
<form action="check" name="userInfo" onsubmit="return checkValue()" >
    
    <label for='f-id'>아이디</label> 
    <input id='f-id' type='text' name="id" maxlength="50"><br>
    
    <label for='f-password'>암호</label> 
    <input id='f-password' type='password' name="password" maxlength="50"><br>
    
    
 <button>[로그인]</button>
 <a href='delete?no=${groupDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>

<input type="submit" value="개인회원가입" onclick="goPersonalLoginForm()">
<input type="submit" value="단체회원가입" onclick="goGroupLoginForm()">
<input type="submit" value="기관회원가입" onclick="goOrgLoginForm()">

 <script type="text/javascript">
    
        function checkValue() {
            if(!document.userInfo.id.value) {
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.password.value) {
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value) {
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
        
    
        function goLoginForm() {
            location.href="../volunteer/list";
        }
        
        function goPersonalLoginForm() {
            location.href="../join/personal/form";
        }
        
        function goGroupLoginForm() {
            location.href="../join/group/form";
        }
        
        function goOrgLoginForm() {
            location.href="../join/org/form";
        }
        
       
    </script>
</body>
</html>
    