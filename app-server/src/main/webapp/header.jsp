<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <header>
      <div class="top-bar">
        <div class="container">
          <div class="row align-items-center">          
            <div class="col-md-12 text-right d-none d-md-block">
              <div class="social-mini-button">
               <c:if test="${empty sessionScope.loginUser}">
                  <a href="${contextPath}/auth/loginForm"><span>로그인</span></a>
                <a href="${contextPath}/join/userType"><span>회원가입</span></a>
                </c:if>
                <c:if test="${not empty sessionScope.loginUser}">
                    ${sessionScope.loginUser.name}<br>
                     <a href="${contextPath}/auth/logout"><span>로그아웃</span></a>
                </c:if>
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
           <a href="${contextPath}/home" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
          <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
          <div class="navbar-collapse collapse" id="navbarContent">
            <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
              <li class="nav-item">
                <a href="index.html" class="nav-link">함께해요</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">소통해요</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="#">나눔이야기</a>
                  <a class="dropdown-item" href="#">한줄후기</a>
                </div>
              </li>
              <li class="nav-item">
                <a href="services.html" class="nav-link">챌린지</a>
              </li>
              <li class="nav-item">
                <a href="${contextPath}/donation/boardList" class="nav-link">모금함</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">고객센터</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="${contextPath}/support/noticeList">공지사항</a>
                  <a class="dropdown-item" href="${contextPath}/support/questionList">문의사항</a>
                </div>
              </li>
            </ul>
          </div>
        </div> <!-- .container -->
      </nav> <!-- .navbar -->
    </header>