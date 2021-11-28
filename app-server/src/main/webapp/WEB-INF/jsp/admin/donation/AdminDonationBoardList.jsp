<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>모금함전체리스트</title>
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
             <th scope="col" style="text-align : center;">번호</th>
             <th scope="col" style="text-align : center;">제목</th>
             <th scope="col" style="text-align : center;">주최자</th>
             <th scope="col" style="text-align : center;">카테고리</th>
             <th scope="col" style="text-align : center;">내용</th>
             <th scope="col" style="text-align : center;">개설시작일</th>
             <th scope="col" style="text-align : center;">개설종료일</th>
             <th scope="col" style="text-align : center;">총기간</th>               
             <th scope="col" style="text-align : center;">남은기간</th>
             <th scope="col" style="text-align : center;">목표금액</th>
             <!-- <th scope="col">첨부파일</th> -->
             <th scope="col" style="text-align : center;">승인여부</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${adminDonationBoardList}" var="donationBoardDTO" varStatus="vs">
            
              <tr data-no='${donationBoardDTO.no}'>
                  <td>${donationBoardDTO.no}</td> 
                  <td>${donationBoardDTO.title}</td> 
                  <td>${donationBoardDTO.leader.name}</td> 
                  <td>${donationBoardDTO.category.title}</td> 
                  <td>${donationBoardDTO.content}</td>
                  <td>${donationBoardDTO.startDate}</td>
                  <td>${donationBoardDTO.endDate}</td>
                  <td>${donationBoardDTO.totalDate}</td>
                  <td>${donationBoardDTO.remainDate}</td>
                  <td><fmt:formatNumber type="number" value="${donationBoardDTO.moneyTarget}" maxFractionDigits="3"/>원</td>
                  <%-- <td>${donationBoardDTO.fileNames}</td> --%>
                  <td>${donationBoardDTO.status}</td>
                  <td><a data-toggle="modal" href="#myModalDonationList${vs.index}">[관리]</a></td>
              </tr>
              <!-- 모달 창 -->
              <div class="modal fade" id="myModalDonationList${vs.index}"
                role="dialog">
                <!-- 사용자 지정 부분① : id명 -->
                <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <h4 class="modal-title">모금함 관리</h4>
                      <!-- 사용자 지정 부분② : 타이틀 -->
                      <button type="button" class="close" data-dismiss="modal">×</button>
                    </div>
                      <div class="modal-body">
                        <div class="class" id="id" style="display: none">
                          <label for='f-no'>모금함 번호</label> <input id='f-no'
                            type='text' name='no' value='${donationBoardDTO.no}' readonly>
                          <br>
                        </div>
                        <label for='f-content'>내용</label> <span id='f-content'>${donationBoardDTO.content}</span><br>
                        
                        <label for='f-leader'>신청자</label> <span id='f-leader'>${donationBoardDTO.leader.name}</span><br>

                        <label for='f-status'>승인상태</label> <span
                          id='f-status'>${donationBoardDTO.status}</span><br>
                      </div>
							          <div class="ad-btn">
							            <a href='approve?no=${donationBoardDTO.no}'>승인</a>
							            <a href='reject?no=${donationBoardDTO.no}'>반려</a>
							          </div>
                      <br>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default"
                        data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 모달 창 -->
              </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href="${contextPath}/app/admin/donation/approvedList" class="btnSubmit">[승인목록]</a>
            <a href="${contextPath}/app/admin/donation/rejectedList" class="btnSubmit">[반려목록]</a>
            <a href="${contextPath}/app/admin/donation/waitList" class="btnSubmit">[대기목록]</a>
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
    















    