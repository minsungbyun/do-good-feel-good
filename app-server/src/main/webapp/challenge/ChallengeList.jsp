<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <main>
    <div class="page-section">
      <div class="container">
        <div class="filterable-btn">
          <button class="btn active" data-filter="*">최신순</button>
          <button class="btn" data-filter=".web">인기순</button>
        </div>
        <c:forEach items="${challengeList}" var="challengeDTO">
        <div class="card" style="width: 29%; height: auto; margin-right:3.33%; float: right; text-align : center;">
          <img src="https://image.flaticon.com/icons/png/512/755/755151.png" class="card-img-top" alt="..." style="width:150px; height:150px; display: block; margin: 0 auto;">
          <div class="card-body" >
            <h5 class="card-title">${challengeDTO.title}</a></h5>
            <p class="card-text">${challengeDTO.startDate} ~ ${challengeDTO.endDate}</p>
            <a href='detail?no=${challengeDTO.no}' class="btn btn-primary">자세히 보기</a>
          </div>
        </div>
        </div>
        </c:forEach>
        <div class="mt-5 text-center">
          <button class="btn btn-primary">Load More</button>
        </div>
      </div> <!-- .container -->
  </main>
</body>
</html>