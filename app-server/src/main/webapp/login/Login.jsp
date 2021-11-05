<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>로그인</title>
	  <!--  link -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.css">
	</head>
	<body>
		<div class="container">
		  <div class="login_form">
				<h1>로그인</h1>
				<form action='lgoin'>
					<div class="form-group">
						<label for='f-id'>아이디</label> 
						<input id='f-id' class="form-control" type='text' name='id'><br>					    
					</div>
					<!-- //form-group -->
					<div class="form-group">
            <label for='f-password'>암호</label> 
            <input id='f-password' class="form-control" type='password' name='password'><br>           
          </div>		    				
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input form-group" id="idRemem">
						<label class="form-check-label" for="idRemem">아이디 저장하기</label>
					</div>
				</form>
				<button type="submit" class="btn btn-primary">로그인</button>
				<a href='delete?no=${groupDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
			</div>
		</div>
		<!-- //container -->
	</body>
</html>
    