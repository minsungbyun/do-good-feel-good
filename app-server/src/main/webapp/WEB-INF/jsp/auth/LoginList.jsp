<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- //menu -->
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.pagination {
  display: flex;
  padding-left: 0;
  list-style: none;
  border-radius: 0.25rem;
  margin-bottom:110px;
}
</style>

    <div class="ad-main">
      <div class="ad-main-infor">
        <h2 style="display:flex; justify-content:center; align-items:cetner; padding-top:50px;"><b>회원정보 조회</b></h2>  
        <div class="table01" >
       <!-- search -->
        <div>
           <form action="search" method="GET" class="form-inline" style="float: right; margin-bottom: 25px" >
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
               <!-- <th scope="col">
                 <input type="checkbox">
               </th> -->
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
              <c:forEach items="${joinUserList}" var="joinDTO" varStatus="vs">
								<tr data-no="${joinDTO.no}">
								<!-- <td><input type="checkbox" class="select-box"></td> -->
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
								    <td><a href="#myModalLoginL${vs.index}" class="btn btn-primary" data-toggle="modal" >상세보기</a></td>
								</tr>
<!-- 모달 창 -->
              <div class="modal fade" id="myModalLoginL${vs.index}"
                role="dialog">
                <!-- 사용자 지정 부분① : id명 -->
                <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <h3 class="modal-title">회원 관리</h3>
                      <!-- 사용자 지정 부분② : 타이틀 -->
                      <button type="button" class="close" data-dismiss="modal">×</button>
                    </div>
                      <div class="modal-body">
                        <div class="mb-3 row">
		                      <label for='f-no' class="col-sm-3 col-form-label">번호</label>
		                      <input id='f-no' class="col-sm-8 form-control" type='text'
		                           name='no' value='${joinDTO.no}' readonly>
                       </div>
                       
                        <div class="mb-3 row">
                          <label for='f-no' class="col-sm-3 col-form-label">아이디</label>
                          <input id='f-no' class="col-sm-8 form-control" type='text'
                               name='id' value='${joinDTO.id}' readonly>
                       </div>
                       
                        <div class="mb-3 row">
                          <label for='f-name' class="col-sm-3 col-form-label">이름</label>
                          <input id='f-name' class="col-sm-8 form-control" type='text'
                               name='name' value='${joinDTO.name}' readonly>
                       </div>
                       
                        <div class="mb-3 row">
                          <label for='f-tel' class="col-sm-3 col-form-label">전화번호</label>
                          <input id='f-tel' class="col-sm-8 form-control" type='text'
                               name='tel' value='${joinDTO.tel}' readonly>
                       </div>
                       
                        <div class="mb-3 row">
                          <label for='f-email' class="col-sm-3 col-form-label">이메일</label>
                          <input id='f-email' class="col-sm-8 form-control" type='text'
                               name='email' value='${joinDTO.email}' readonly>
                       </div>
                       
                       <div class="mb-3 row">
                          <label for='f-postNo' class="col-sm-3 col-form-label">우편번호</label>
                          <input id='f-postNo' class="col-sm-8 form-control" type='text'
                               name='postNo' value='${joinDTO.postNo}' readonly>
                       </div>
                       
                       <div class="mb-3 row">
                          <label for='f-basicAddress' class="col-sm-3 col-form-label">기본주소</label>
                          <input id='f-basicAddress' class="col-sm-8 form-control" type='text'
                               name='basicAddress' value='${joinDTO.basicAddress}' readonly>
                       </div>
                       <div class="mb-3 row">
                          <label for='f-email' class="col-sm-3 col-form-label">상세주소</label>
                          <input id='f-email' class="col-sm-8 form-control" type='text'
                               name='detailAddress' value='${joinDTO.detailAddress}' readonly>
                       </div>
                       <div class="mb-3 row">
                          <label for='f-status' class="col-sm-3 col-form-label">승인상태</label>
                          <input id='f-status' class="col-sm-8 form-control" type='text'
                               name='status' value='${joinDTO.status}' readonly>
                       </div>
                       <div class="mb-3 row">
                          <label for='f-type' class="col-sm-3 col-form-label">회원유형</label>
                          <input id='f-type' class="col-sm-8 form-control" type='text'
                               name='type' value='${joinDTO.type}' readonly>
                       </div>
                       
                       <div class="mb-3 row">
                          <label for='f-registerDate' class="col-sm-3 col-form-label">등록일</label>
                          <input id='f-registerDate' class="col-sm-8 form-control" type='text'
                               name='registerdDate' value='${joinDTO.registerDate}' readonly>
                       </div>
                        
							          <div class="ad-btn">
							            <!--  <a href="#" class="btnSubmit">수정</a>-->
							          </div>
                      <br>
                    <div class="modal-footer">
							            <a href="#" class="btn btn-primary">승인하기</a>
							            <a href="#" class="btn btn-primary">반려하기</a>
							            <a href="#" class="btn btn-primary">추방하기</a>
							            <button type="button" class="btn btn-default"
                           data-dismiss="modal">닫기</button>
                      
                    </div>
                  </div>
                </div>
              </div>
              </div>
              <!-- 모달 창 -->
              </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
      
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












    