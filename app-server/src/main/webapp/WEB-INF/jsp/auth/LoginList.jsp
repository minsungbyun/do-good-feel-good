<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- //menu -->
    
    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="inforSerch">검색</label>
          <input type="text" class="" id="inforSerch">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <div class="table01">
          <table class="table">
            <thead>
              <tr>
               <th scope="col">
                 <input type="checkbox">
               </th>
                <th scope="col">번호</th>
                <th scope="col">아이디</th>
                <th scope="col">이름</th>
                <th scope="col">전화</th>
                <th scope="col">이메일</th>
                <th scope="col">우편번호</th>
                <th scope="col">기본주소</th>
                <th scope="col">상세주소</th>
                <th scope="col">승인상태</th>
                <th scope="col">회원유형</th>
                <th scope="col">등록일</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${joinUserList}" var="joinDTO">
<tr>
<td><input type="checkbox" class="select-box"></td>
    <td>${joinDTO.no}</td> 
    <td>${joinDTO.id}</td> 
    <td>${joinDTO.name}</td> 
    <td>${joinDTO.tel}</td> 
    <td>${joinDTO.email}</td> 
    <td>${joinDTO.postNo}</td> 
    <td>${joinDTO.basicAddress}</td> 
    <td>${joinDTO.detailAddress}</td> 
    <td>${joinDTO.status}</td> 
    <td>${joinDTO.type}</td> 
    <td>${joinDTO.registerDate}</td>
</tr>
</c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href="#" class="btnSubmit">추방</a>
            <a href="#" class="btnSubmit">반려하기</a>
            <a href="#" class="btnSubmit">승인하기</a>
            <!--  <a href="#" class="btnSubmit">수정</a>-->
            
          </div>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
      
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
    <!-- //ad-main -->












    