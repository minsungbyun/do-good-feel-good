<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="copyright" content="MACode ID, https://macodeid.com/">

  <title>챌린지 : 챌린지 목록</title>

  <link rel="stylesheet" href="../assets/css/bootstrap.css">
  
  <link rel="stylesheet" href="../assets/css/maicons.css">

  <link rel="stylesheet" href="../assets/vendor/animate/animate.css">

  <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">

  <link rel="stylesheet" href="../assets/css/theme.css">

</head>
<body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>

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
              <a href="#"><span class="mai-logo-facebook-f"></span></a>
              <a href="#"><span class="mai-logo-twitter"></span></a>
              <a href="#"><span class="mai-logo-youtube"></span></a>
              <a href="#"><span class="mai-logo-linkedin"></span></a>
            </div>
          </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .top-bar -->

    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="index.html" class="navbar-brand">Reve<span class="text-primary">Tive.</span></a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item">
              <a href="index.html" class="nav-link">함께해요</a>
            </li>
            <li class="nav-item">
              <a href="about.html" class="nav-link">소통해요</a>
            </li>
            <li class="nav-item active">
              <a href="services.html" class="nav-link">챌린지</a>
            </li>
            <li class="nav-item">
              <a href="portfolio.html" class="nav-link">모금함</a>
            </li>
            <li class="nav-item">
              <a href="blog.html" class="nav-link">고객센터</a>
          </ul>
        </div>
      </div> <!-- .container -->
    </nav> <!-- .navbar -->

    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/challengebackground.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
        <c:forEach items="${challengeList}" var="challengeDTO">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html">메인메뉴</a></li>
                <li class="breadcrumb-item active" aria-current="page">챌린지</li>
              </ol>
            </nav>
            <h1 class="fg-white text-center">이달의 챌린지</h1>
            <h1 class="fg-dark text-center">${challengeDTO.title}</h1>
        </c:forEach>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
  </header>

            <!-- 내용이 들어갑니다. -->
                          <div class="viewtop_td vtopimg">
                            <div class="vtopimg_w">
                                <a id="fb-img" href="https://www.suwonvol.com/upload/bbs/2021/3/16/27433d05-0e49-4192-a3b2-8cc6bd6ca210.png" title="지구를 살리는 착한 행동 '장난감의 재탄생'">
                                    <img src="https://www.suwonvol.com/upload/bbs/2021/3/16/27433d05-0e49-4192-a3b2-8cc6bd6ca210.png" alt="지구를 살리는 착한 행동 '장난감의 재탄생'">
                                </a>
                            </div>
                            <h2 class="vtopsmp">
                                지구를 살리는 착한 행동 '장난감의 재탄생'
                            </h2>
                        </div>
                         <div class="viewtop_td vtopspec vtype2">
                            <div class="vtsym type3">
                                <div class="vtsym_in">
                                    <div class="vt_proc_w">
                                        <p class="vt_proc_01">총 <span id="relativeCnt">135</span> / 200분이 참여하였습니다.</p>
                                        <div class="sproc_bar_w"><span class="sproc_bar" style="width: 67.5%"></span></div>
                                        <p class="vt_proc_03"><button type="button" class="btn_wrin" id="btn_relativeList" data-type="modal" data-target="#lyTarget">참여자 보기</button></p>
                                    </div>
                                </div>
                            </div>
                            <div class="vtsym type2 outtype2">
                                <div class="vtsym_in">
                                    <div class="vtsp_tb_w">
                                        <ul class="vtsp_tb">
                                            <li>
                                                <div class="vtcell vtth">등록정보</div>
                                                <div class="vtcell vttd">suwon777</div>
                                                <div class="vtlaydate">2021-03-16</div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
      
      
        <div class="section fp-auto-height" id="section4">
  <footer class="page-footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 py-3">
          <h3>Reve<span class="fg-primary">Tive.</span></h3>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Contact Information</h5>
          <p>301 The Greenhouse, Custard Factory, London, E2 8DY.</p>
          <p>Email: example@mail.com</p>
          <p>Phone: +00 112323980</p>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Company</h5>
          <ul class="footer-menu">
            <li><a href="#">Career</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#">News & Feed</a></li>
          </ul>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Newsletter</h5>
          <form action="#">
            <input type="text" class="form-control" placeholder="Enter your email">
            <button type="submit" class="btn btn-primary btn-sm mt-2">Submit</button>
          </form>
        </div>
      </div>

      <hr>

      <div class="row mt-4">
        <div class="col-md-6">
          <p>Copyright 2020. This template designed by <a href="https://macodeid.com">MACode ID</a></p>
        </div>
        <div class="col-md-6 text-right">
          <div class="sosmed-button">
            <a href="#"><span class="mai-logo-facebook-f"></span></a>
            <a href="#"><span class="mai-logo-twitter"></span></a>
            <a href="#"><span class="mai-logo-youtube"></span></a>
            <a href="#"><span class="mai-logo-linkedin"></span></a>
          </div>
        </div>
      </div>
    </div>
  </footer>
<script src="../assets/js/jquery-3.5.1.min.js"></script>

<script src="../assets/js/bootstrap.bundle.min.js"></script>

<script src="../assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

<script src="../assets/vendor/wow/wow.min.js"></script>

<script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>

<script src="../assets/vendor/isotope/isotope.pkgd.min.js"></script>

<script src="../assets/js/google-maps.js"></script>

<script src="../assets/js/theme.js"></script>

</body>
</html>
