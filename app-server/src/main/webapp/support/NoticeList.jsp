<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ko">
    <!-- main -->
  <main>
    <div class="page-section">
      <div class="container">
        <div class="table-wrap">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">등록일</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody>
              <c:if test='${empty noticeList}'>
	             <p>작성된 게시글이 없습니다.</p>
	            </c:if>
	            
	            <c:forEach items="${noticeList}" var="noticeDTO" >
	              <tr>
	                <td>${noticeDTO.no}</td>
	                <td><a href='noticeDetail?noticeNo=${noticeDTO.no}'>${noticeDTO.title}</a></td>
	                <td>${noticeDTO.registeredDate}</td>
	                <td>${noticeDTO.viewCount}</td>
	              </tr>
	            </c:forEach>
            </tbody>
          </table>
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
      <!-- //container -->
      
    </div>
    <!-- //page-section -->

    </main>
  </body>
</html>








