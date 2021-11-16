<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
      <div class="page-section">
        <div class="container">
          <div class="short-main">
            <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" alt="기부자참여내역 메인이미지">
          </div>
          <!-- //short-main -->
          
          
          <!-- //text-wirte -->
          <div class="cont-short-list">
          <c:forEach items="${donationRegisterList}" var="donationRegisterDTO">
            <div class="num-text bo">
              기부자참여
              <span class="sr-only">참여인원</span>
              <b class="num-count">2</b>
              
            </div>
            <div class="s-review-list">
              <div class="review-view">
                <ul>
                  <li>
                    <div class="review-section">
                      <div class="profile-thumb">
                        <img src="${contextPath}/assets/img/base_profile.png" alt="프로필사진">
                      </div>
                      <div class="review-infor">
                        <div class="review-post">
                          <div class="profile-infor">
                            <span>${donationRegisterDTO.donator.id}</span>
                            <span class="txt_date">${donationRegisterDTO.registeredDate}</span>
                            <span class="ico_bbs ico_new">기부참여내역</span>
                          </div>
                          <div class="review-post">
                            <p><span>${donationRegisterDTO.donationMoney}원</span></p>
                          </div>
                        </div>
                      </div>
                     </div>
                     <!-- //review-section -->
                  </li>
              </ul>
              </div>
            </div>
                     </c:forEach>
            <!-- //s-review-list -->
          </div>
          
          <div class="col-12 my-5">
            <nav aria-label="Page Navigation">
              <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item active" aria-current="page">
                  <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">2</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">Next</a>
                </li>
              </ul>
            </nav>
          </div>
          
        </div>
        <!-- //container -->
      </div>
    </main>  






    