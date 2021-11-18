<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <main>
    <div class="page-section">
      <div class="container">
        <div class="do-detail">
          <!-- do-left -->
          <div class="do-left">
           <h5><a href="#">${donationBoardDTO.category.title}</a></h5>
           <h2>${donationBoardDTO.title}</h2>
           <ul class="do-tap">
              <li id="do-tap-de" class="on"><a href="${contextPath}/app/donation/list?no=${donationBoardDTO.no}" class="do-on">모금함 소개</a></li>
              <li id="do-tap-de"><a href="${contextPath}/app/register/list?no=${donationBoardDTO.no}">참여내역</a></li>
            </ul>
            <div class="tab-cont">
              <p class="tab-cont-sub">${donationBoardDTO.content}</p>
              <div class="owl-img">파일첨부넣기</div>
            </div>
          </div>
          <!-- //do-left -->
          <!-- do-right -->
          <div class="do-right">
             <div class="graph-status">
               <span class="per"><strong>50</strong>%</span>
             </div>
             <div class="progress">
              <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
             </div>
             <div class="num-area">
              <p class="do-num">
                <span><strong><fmt:formatNumber type="number" value="${donationBoardDTO.moneyTarget}" maxFractionDigits="3"/></strong>원</span>
              </p>
              <p class="num-status">
                <span>현재금액<strong>현재기부금액넣기</strong>원</span>
              </p>
             </div>
             <!-- //num-area -->
             <div class="do-date">
              <p>
                <strong>${donationBoardDTO.startDate}~${donationBoardDTO.endDate}</strong>까지
              </p>
              <div class="do-d-day">
                D-${donationBoardDTO.remainDate}
              </div>
             </div>
             <!-- //do-date -->
             <div class="do-infor">
              <p>${donationBoardDTO.tel}</p>
              <p>${donationBoardDTO.email}</p>
             </div>
            <div class="do-btn">
             <a href="#" class="do-btn-a">모금함 기부하기</a>
            </div>
          </div>
          <!-- //do-right -->
        </div>
       <!-- //do-detail -->     
      </div>
      <!-- //container -->
    </div>
  </main>
    
    