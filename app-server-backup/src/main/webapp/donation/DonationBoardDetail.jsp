<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <title>HappyShare : 모금함 상세보기</title>
    
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
                <a href="portfolio.html" class="nav-link active">모금함</a>
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
        
        <a href="" class="theme" style="text-decoration:none">${donationBoardDTO.category.title}</a>
        
        <ul class="nav nav-tabs">
                    <li class="nav-item">
                      <a class="nav-link active" href="#">모금함 소개</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="registerList?no=${donationBoardDTO.no}">기부 내역</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="#">모금 소식</a>
                    </li>
                  </ul>
                  
           <img src="https://happybean-phinf.pstatic.net/20211103_47/16359178050095kGYu_JPEG/KakaoTalk_20210517_174428137.jpg?type=w720" class="d-block w-80" alt="...">
          <dl>
          <dt id="paragraphTitle">${donationBoardDTO.title}</dt>
          <dd id="paragraphContent">${donationBoardDTO.content}</dd>
          </dl>
          <hr>
          
          <strong>기부금 계획</strong> <span>여러분들의 소중한 기부금 이렇게 사용됩니다.</span>
          
          
          <table class="table table-hover">
            <colgroup><col style="width:160px">
            <col>
            <col style="width:160px">
            </colgroup>
            <thead>
            <tr>
                <th scope="col" colspan="2">사용계획내용</th>
                <th scope="col">사용금액</th>
            </tr>
            </thead>
            <tbody>
            <tr class="total">
                <td class="use"><strong>총 집행금액</strong></td>
                <td colspan="2"><em>${remainMoney}</em> 원 (목표금액 ${donationBoardDTO.moneyTarget}원)</td>
            </tr>
            
                <tr>
                    <td class="use">사업비</td>
                    <td>의료비(검사,약제비등) 50만원*6명 </td>
                    <td class="amount"><em>3,000,000</em>원</td>
                </tr>
            
                <tr>
                    <td class="use">사업비</td>
                    <td>양육물품(내복,젖병등)약40만*14명 </td>
                    <td class="amount"><em>5,415,000</em>원</td>
                </tr>
            
                <tr>
                    <td class="use">경상운영비</td>
                    <td>사업진행비 </td>
                    <td class="amount"><em>1,485,000</em>원</td>
                </tr>
            
            </tbody>
        </table>
              
      </div>  <!-- //container -->
      </div> <!-- //page-section -->
    </main>  
  </body>
</html>
    
    