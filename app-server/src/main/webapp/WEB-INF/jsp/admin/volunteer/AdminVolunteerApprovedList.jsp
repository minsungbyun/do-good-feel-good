
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
  .pagination {
    display: flex;
    padding-left: 0;
    list-style: none;
    border-radius: 0.25rem;
    margin-bottom: 110px;
  }
</style>
    
    <div class="ad-main">
      <div class="ad-main-infor">
        <div class="table01">
        <!-- search -->
        <div>
           <form action="search" method="GET" class="form-inline" style="float: right; margin-bottom: 25px">
              <label for="search"></label>
              <input class="form-control mr-sm-2 search-box" type="search"
                id="f-search" name="keyword" placeholder="검색어를 입력해주세요..">
              <button class="btn btn-secondary my-2 my-sm-0 search-btn" style="background: #666;">검색</button>
          </form>
        </div>
        <!-- //serch -->
          <table class="table">
            <thead>
              <tr>
                <th scope="col">
                 <input type="checkbox">
                </th>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">주최자</th>
                <th scope="col">카테고리</th>
                <th scope="col">전화번호</th>
                <th scope="col">총모집인원</th>
                <th scope="col">총날짜</th>                
                <th scope="col">남은기간</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${adminVolunteerApprovedList}" var="volunteerRequestDTO" varStatus="vs" >
              <tr data-no="${volunteerRequestDTO.no}">
                <td><input type="checkbox" class="select-box"></td>
                <td>${volunteerRequestDTO.no}</td>
                <td><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></td> 
                <td>${volunteerRequestDTO.owner.id}</td> 
                <td>${volunteerRequestDTO.category.title}</td> 
                <td>${volunteerRequestDTO.tel}</td> 
                <td>${volunteerRequestDTO.limitNum}<span>명</span></td>
                <td>${volunteerRequestDTO.totalDate}<span>일</span></td>
                <td>${volunteerRequestDTO.remainDate}<span>일</span></td>
                <td><a href="#volunteerList${vs.index}" class="btn btn-primary"
                data-toggle="modal">상세보기</a>
                </td>
              </tr>
              
              <!-- 모달창 -->
            <div class="modal fade modal-p" id="volunteerList${vs.index}" role="dialog">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- modal-header -->
                  <div class="modal-header">
                    <h4 class="modal-title">${volunteerRequestDTO.no}번 봉사 상세보기</h4>
                    <button type="button" class="close" data-dismiss="modal">×</button>
                  </div>
                  <!-- //modal-header -->
                  <!-- modal-body -->
                  <div class="modal-body">
                    <div class="mb-3 row">
                      <label for='f-no' class="col-sm-2 col-form-label">번호</label>
                      <input id='f-no' class="col-sm-2 form-control" type='text'
                           name='no' value='${volunteerRequestDTO.no}' readonly>
                    </div>
                    <!-- 번호 -->
                    <div class="mb-3 row">
                      <label for='f-title' class="col-sm-2 col-form-label">제목</label>
                      <input id='f-title' class="col-sm-9 form-control" type="text"
                              name="title" value="${volunteerRequestDTO.title}" readonly>
                    </div>
                    <!-- //제목 -->
                    <div class="mb-3 row">
                      <label for='f-content' class="col-sm-2 col-form-label">내용</label>
                      <textarea id='f-content' class="col-sm-9 form-control"
                           name="content"  cols="15" rows="5" readonly>${volunteerRequestDTO.content}</textarea>
                    </div>
                    <!-- //내용 -->
                  </div>
                  <!-- //modal-body -->
                  <div class="modal-footer">
                    <a href="doApprove?no=${volunteerRequestDTO.no}"
                      class="btn btn-primary">승인</a>
                    <a href="doReject?no=${volunteerRequestDTO.no}"
                      class="btn btn-primary">반려</a>
                     <button type="button" class="btn btn-default"
                    data-dismiss="modal">닫기</button>
                  </div>
                </div>
              </div>
              <!-- //modal-dialog -->
            </div>
            <!-- //모달창 -->
              </c:forEach>
            </tbody>
          </table>
          
          <c:if test="${empty adminVolunteerApprovedList}"> 승인 목록이 없습니다!</c:if>
          
          <div class="ad-btn">
            <a href='list' class="btnSubmit">전체목록</a>
            <a href='approve' class="btnSubmit">승인목록</a>
            <a href='reject' class="btnSubmit">반려목록</a>
            <a href='wait' class="btnSubmit">대기목록</a>
          </div>
        </div>
        <!-- //table01 -->
      </div>

      
     <div class="col-12 my-5">
    <nav aria-label="Page Navigation">
      <ul class="pagination justify-content-center">
        <li class="page-item disabled"><a class="page-link" href="#"
          tabindex="-1" aria-disabled="true">이전</a></li>
        <li class="page-item active" aria-current="page"><a
          class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
        </li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">다음</a></li>
      </ul>
    </nav>
  </div>
      
    </div>
    <!-- //ad-main -->
    













