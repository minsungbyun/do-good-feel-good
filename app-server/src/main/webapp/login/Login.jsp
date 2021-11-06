<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
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
=======
	<head>
	  <title>로그인</title>
=======
  <head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
	  <title>HappyShare : 로그인</title>
>>>>>>> 33b733d04a2f53e15fdf96e3c8250dfcdc7d9d5a
	  <!--  link -->
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/maicons.css">
    <link rel="stylesheet" href="../assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="../assets/css/theme.css">
	</head>
	
  <body>
    <header>
      <div class="top-bar">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-8">
              <div class="d-inline-block">
                <span class="mai-mail fg-primary"></span> <a href="mailto:contact@mail.com">contact@mail.com</a>
              </div>
              <div class="d-inline-block ml-2">
                <span class="mai-call fg-primary"></span> <a href="tel:+0011223495">+0011223495</a>
              </div>
            </div>
            <div class="col-md-4 text-right d-none d-md-block">
              <div class="social-mini-button">
                <a href="#"><span>로그인</span></a>
                <a href="#"><span>회원가입</span></a>
                <a href="#"><span>관리자</span></a>
              </div>
            </div>
          </div>
          <!-- //row -->
        </div>
      </div>
      <!-- //top-bar -->
      
  
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
          <a href="index.html" class="navbar-brand">Reve<span class="text-primary">Tive.</span></a>
  
          <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
          <div class="navbar-collapse collapse" id="navbarContent">
            <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
              <li class="nav-item active">
                <a href="index.html" class="nav-link">함께해요</a>
              </li>
              <li class="nav-item">
                <a href="about.html" class="nav-link">소통해요</a>
              </li>
              <li class="nav-item">
                <a href="services.html" class="nav-link">챌린지</a>
              </li>
              <li class="nav-item">
                <a href="portfolio.html" class="nav-link">모금함</a>
              </li>
              <li class="nav-item">
                <a href="blog.html" class="nav-link">고객센터</a>
              </li>
            </ul>
          </div>
        </div> <!-- .container -->
      </nav> <!-- .navbar -->
    </header>
    	
	
    <main>
      <div class="page-section">
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
			</div>
		</main>  
	</body>
>>>>>>> 63b25ab60473262f12b408f1e3c616fd587c5166
</html>
    