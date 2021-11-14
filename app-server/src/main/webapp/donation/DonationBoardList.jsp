<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- main -->
  <main>
      <div class="container">
    <div class="page-section" >
        <div class="table-wrap">
        
        <div class="filterable-btn">
          <button class="btn active" data-filter="*">전체</button>
          <button class="btn" data-filter=".web">비대면</button>
          <button class="btn" data-filter=".mobile">아동</button>
          <button class="btn" data-filter=".desktop">청소년</button>
          <button class="btn" data-filter=".desktop">노인</button>
          <button class="btn" data-filter=".desktop">장애인</button>
          <button class="btn" data-filter=".desktop">동물</button>
          <button class="btn" data-filter=".desktop">환경</button>
          <button class="btn" data-filter=".desktop">기타</button>
      </div>
        <div class="card_body" style="overflow: hidden; box-sizing: border-box; width:100%;" >
        <c:forEach items="${donationBoardList}" var="donationBoardDTO">

        <div class="card" style="width: 33.33%; float: left; padding:0 5%;  border: none;">
          <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" class="card-img-top" alt="..."> 
          <div class="card-body">
            <h5 class="card-title">${donationBoardDTO.title}</h5>
            <p>${donationBoardDTO.leader.name}</p>
            <a href="detail?no=${donationBoardDTO.no}" class="btn btn-secondary">상세보기</a>
          </div>
        </div>
        </c:forEach>
          </div>
        
          <div class="form-btn">
            <a href="form" class="btnSubmit">개설신청</a>
        </div>
        <!-- //table-wrap -->
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
      </div>
      <!-- //container -->
      
    </div>
    <!-- //page-section -->

  </main>








