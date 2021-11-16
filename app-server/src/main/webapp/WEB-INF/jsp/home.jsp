<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
  <body>
    
    <section>
      <div class="page-banner home-banner mb-5">
        <div class="slider-wrapper">
          <div class="owl-carousel hero-carousel">
            <div class="hero-carousel-item">
              <img src="${contextPath}/images/home/main.jpg" alt="">
              <div class="img-caption">
           <!-- <div class="subhead">We're design studio believe in ideas</div> -->
            <!--<h1 class="mb-4">Creative Design</h1> -->
             <!-- <a href="#services" class="btn btn-outline-light">Get Started</a> -->
              </div>
            </div>
            <div class="hero-carousel-item">
              <img src="${contextPath}/images/home/main1.jpg" alt="">
              <div class="img-caption">
               <!-- <h1 class="mb-4">We combine Design, Thinking, and Technical</h1> -->
               <!-- <a href="#services" class="btn btn-outline-light">Get Started</a> -->
               <!-- <a href="#services" class="btn btn-primary">See Pricing</a> -->
              </div>
            </div>
            <div class="hero-carousel-item">
              <img src="${contextPath}/images/home/volunteer.jpg" alt="">
              <div class="img-caption">
                <!--<div class="subhead">Easy way to build perfect website</div> -->
               <!-- <h1 class="mb-4">Beautify handcrafted templates for your website</h1> -->
               <!-- <a href="#services" class="btn btn-primary">Read More</a> -->
              </div>
            </div>
          </div>
        </div> <!-- .slider-wrapper -->
      </div> <!-- .page-banner -->
    </section>
  
    <main>
      <div class="page-section">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6 py-3">
              <div class="subhead">HappyShare</div>
              <h2 class="title-section">환영합니다 <span class="fg-primary">HappyShare</span>입니다.</h2>
  
              <p>HappyShare는 개인과 소규모 단체 중심의 봉사 및 모금활동 공간입니다. 봉사에 대한 진입장벽을 낮추고 참여율을 진작시키고자하는 목표를 품고 봉사활동 뿐만 아니라 기부, 챌린지 등 다양한 서비스를 지원하고 있습니다.
특히, 챌린지 기능은 많은 회원이 함께 참여하고 인증하는 과정을 통해 재미는 물론 봉사자들의 성취감을 고취시키고, 커뮤니티를 통해 회원 간 소통할 수 있는 공간을 마련하였습니다.</p>
  
              <a href="about.html" class="btn btn-primary mt-4">더보기</a>
            </div>
            <div class="col-lg-6 py-3">
              <div class="about-img">
                <img src="${contextPath}/images/volunteer1.jpg" alt="">
              </div>
            </div>
          </div>
        </div>
      </div> <!-- .page-section -->
  
     
  
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">ㅇㅇㅇ</div>
            <h2 class="title-section">진행중인 봉사목록</h2>
          </div>
  
          <div class="owl-carousel team-carousel mt-5">
           <c:forEach items="${volunteerList}" var="volunteerDTO">
            <div class="team-wrap">
              <div class="team-profile">
                <img src="${contextPath}/images/home/main.jpg" alt="봉사사진">
              </div>
              <div class="team-content">
                <h5>${volunteerDTO.title}</h5>
                <div class="text-sm fg-grey">주최자 : ${volunteerDTO.owner.id}</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
            </c:forEach>
  
  <!-- 
            <div class="team-wrap">
              <div class="team-profile">
                <img src="${contextPath}/assets/img/teams/team_2.jpg" alt="">
              </div>
              <div class="team-content">
                <h5>${volunteerList.get(1).title}</h5>
                <div class="text-sm fg-grey">주최자 : ${volunteerList.get(1).owner.id}</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
  
            <div class="team-wrap">
              <div class="team-profile">
                <img src="${contextPath}/assets/img/teams/team_3.jpg" alt="">
              </div>
              <div class="team-content">
                <h5>${volunteerList.get(2).title}</h5>
                <div class="text-sm fg-grey">주최자 : ${volunteerList.get(2).owner.id}</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
   -->
          </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
      
        <!-- Testimonials -->
      <div class="page-section">
        <div class="container">
        <div class="text-center">
            <div class="subhead">ㅇㅇㅇ</div>
            <h2 class="title-section">봉사 참여후기를 확인해보세요:D</h2>
          </div>
          <div class="owl-carousel testimonial-carousel">
          
          <c:forEach items="${volunteerShortReviewList}" var="volunteerShortReviewDTO">
            <div class="card-testimonial">
              <div class="content">
                ${volunteerShortReviewDTO.content}
              </div>
              <div class="author">
                <div class="avatar">
                  <img src="${contextPath}/assets/img/person/person_1.jpg" alt="">
                </div>
                <div class="d-inline-block ml-2">
                  <div class="author-name">${volunteerShortReviewDTO.owner.id}</div>
                  <div class="author-info">${volunteerShortReviewDTO.registeredDate}</div>
                </div>
              </div>
            </div>
                </c:forEach>
 
  
          </div> <!-- .row -->
     
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
  
  
  
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">ㅇㅇㅇ</div>
            <h2 class="title-section">진행중인 모금함목록</h2>
          </div>
  
          <div class="owl-carousel team-carousel mt-5">
           <c:forEach items="${donationBoardList}" var="donationBoardDTO">
            <div class="team-wrap">
              <div class="team-profile">
                <img src="${contextPath}/images/donation_main.jpg" alt="모금함사진">
              </div>
              <div class="team-content">
                <h5>${donationBoardDTO.title}</h5>
                <div class="text-sm fg-grey">주최자 : ${donationBoardDTO.leader.id}</div>
  
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
              </div>
            </div>
            </c:forEach>
             </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
  
  <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">ㅇㅇㅇ</div>
            <h2 class="title-section">진행중인 챌린지목록</h2>
          </div>
  
          <div class="owl-carousel team-carousel mt-5">
           <c:forEach items="${challengeList}" var="challengeDTO">
            <div class="team-wrap">
              <div class="team-profile">
                <img src="${contextPath}/images/challenge_main.jpg" alt="챌린지사진">
              </div>
              <div class="team-content">
                <h5>${challengeDTO.title}</h5>
                <div class="text-sm fg-grey">${challengeDTO.content}</div>
                <!-- 
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
                 -->
              </div>
            </div>
            </c:forEach>
             </div>
        </div> <!-- .container -->
      </div> <!-- .page-section -->
  
  
  
  
  
            <!--  
      <div class="page-section">
        <div class="container">
        <div class="text-center">
            <div class="subhead">ㅇㅇㅇ</div>
            <h2 class="title-section">챌린지 목록</h2>
          </div>
          <div class="row align-items-center">
            <div class="col-md-6 py-3">
           
            </div>
            <div class="col-md-6 py-3 text-md-right">
              <a href="portfolio.html" class="btn btn-outline-primary">Browse Projects <span class="mai-arrow-forward ml-2"></span></a>
            </div>
    
          </div>
  
          <div class="row mt-3">
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/images/challenge_main.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/images/challenge_main.jpg" alt="">
                </a>
              </div>
              
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/images/challenge_main.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/images/challenge_main.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/assets/img/portfolio/work-3.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/images/challenge_main.jpg" alt="">
                </a>
              </div>
            </div>
            
     
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/assets/img/portfolio/work-4.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/assets/img/portfolio/work-4.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/assets/img/portfolio/work-5.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/assets/img/portfolio/work-5.jpg" alt="">
                </a>
              </div>
            </div>
            <div class="col-lg-4 py-3">
              <div class="portfolio">
                <a href="${contextPath}/assets/img/portfolio/work-6.jpg" data-fancybox="portfolio">
                  <img src="${contextPath}/assets/img/portfolio/work-6.jpg" alt="">
                </a>
              </div>
            </div>
          </div>
      
        </div> <!-- .container -->
        <!--   </div>--> <!-- .page-section -->
          
    
   <!-- 
      <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">News</div>
            <h2 class="title-section">Read Our Latest News</h2>
          </div>
  
          <div class="row my-5 card-blog-row">
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="${contextPath}/assets/img/person/person_1.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="${contextPath}/assets/img/person/person_2.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
            <div class="col-lg-3 py-3">
              <div class="card-blog">
                <div class="header">
                  <div class="avatar">
                    <img src="${contextPath}/assets/img/person/person_3.jpg" alt="">
                  </div>
                  <div class="entry-footer">
                    <div class="post-author">Sam Newman</div>
                    <a href="#" class="post-date">23 Apr 2020</a>
                  </div>
                </div>
                <div class="body">
                  <div class="post-title"><a href="blog-single.html">What is Business Management?</a></div>
                  <div class="post-excerpt">Lorem, ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
                <div class="footer">
                  <a href="blog-single.html">Read More <span class="mai-chevron-forward text-sm"></span></a>
                </div>
              </div>
            </div>
          </div>
  
          <div class="text-center">
            <a href="blog.html" class="btn btn-primary">View More</a>
          </div>
  
        </div> <!-- .container -->
      <!-- </div> --> <!-- .page-section -->
       
       
       <!-- 
       <div class="page-section">
        <div class="container">
          <div class="text-center">
            <div class="subhead">Our Services</div>
            <h2 class="title-section">See what can we do for your Projects</h2>
          </div>
  
          <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/web_development.svg" alt="">
                </div>
                <h5>Web Development</h5>
              </div>
            </div>
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/graphics_design.svg" alt="">
                </div>
                <h5>Graphics Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/seo_and_marketing.svg" alt="">
                </div>
                <h5>SEO & Marketing</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/customer_services.svg" alt="">
                </div>
                <h5>Customer Services</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/app_development.svg" alt="">
                </div>
                <h5>App Development</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/ui_ux_design.svg" alt="">
                </div>
                <h5>UI/UX Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/product_design.svg" alt="">
                </div>
                <h5>Product Design</h5>
              </div>
            </div>
  
            <div class="col-md-6 col-lg-4 col-xl-3 py-3 mb-3">
              <div class="text-center">
                <div class="img-fluid mb-4">
                  <img src="${contextPath}/assets/img/icons/data_analyst.svg" alt="">
                </div>
                <h5>Data Analyst</h5>
              </div>
            </div>
  
          </div>
        </div> <!-- .container -->
     <!--  </div> --> <!-- .page-section -->
       
    </main>
    </body>
    </html>

  
