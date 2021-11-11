<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    
    <title>HappyShare : 로그인</title>
	
    <!--  link -->
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="stylesheet" href="../assets/css/maicons.css">
    <link rel="stylesheet" href="../assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="../assets/css/theme.css">
  </head>
  
  <!--  <script type="text/javascript">
    
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
  
  <!DOCTYPE html>
<html lang="ko">
  <head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <title>HappyShare : 로그인</title>
    
    <!--  link -->
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/maicons.css">
    <link rel="stylesheet" href="../assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="../assets/css/theme.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    
  </head>
  
  <body>
    <header>
      <div class="top-bar">
        <div class="container">
          <div class="row align-items-center">          
            <div class="col-md-12 text-right d-none d-md-block">
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
          <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
  
          <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <!-- navbarContent -->
          <div class="navbar-collapse collapse" id="navbarContent">
            <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
              <li class="nav-item">
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
          <!-- //navbarContent -->
        </div>
        <!-- container -->
      </nav>
      <!-- //navbar -->
    </header>
      
    <main>
      <div class="page-section">
        <div class="container">
          <div>
            <h1 class="title-h">로그인</h1>
            <form action="login" class="login-form" method="post" onsubmit="return checkValue()">
              <div class="form-group fo">
                <label for='f-id' class="sr-only">아이디</label> 
                <input id='f-id' class="form-control" type='text' name='id' placeholder="아이디"><br>              
              </div>
              <!-- //아이디 -->
              <div class="form-group fo">
                <label for='f-password' class="sr-only">비밀번호</label> 
                <input id='f-password' class="form-control" type='password' name='password' placeholder="비밀번호"><br>           
              </div>
              <!-- //비밀번호 --> 
              <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">아이디 저장하기</label>
              </div>              
              <!-- //아이디 저장하기 -->
              
              <button type="submit" class="btn btn-primary btn-md btn-block" style="border-radius: 40px;">로그인</button>
              <div style="margin: 15px auto;" class="social-mini-button">
                <a href="#"><span>아이디 찾기</span></a> 
                <a href="#"><span>비밀번호 찾기</span></a>
              </div>
              <div class="loginSns">
                <a href="" class="sns-login-button sns01" snstype="naver">
                  <s></s>
                  <span>네이버 계정으로 로그인</span>
                </a>
  
                <a href="" class="sns-login-button sns02" snstype="kakao">
                  <s></s>
                  <span>카카오 계정으로 로그인</span>
                </a>
  
                <a href="" class="sns-login-button sns03" snstype="google">
                  <s></s>
                  <span>구글 계정으로 로그인</span>
                </a>
              </div> <!--//loginSns -->
             </form>
            </div>
          </div>  <!-- //container -->
        </div>  <!-- //아이디 찾기 -->
    </main>  
  </body>

</html>
    
	
	
	<script type="text/javascript">
    
        function checkValue() {
            if(!document.login.id.value) {
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.login.password.value) {
                alert("비밀번호를 입력하세요.");
                return false;
            }
        }     
  </script>
</html>
    