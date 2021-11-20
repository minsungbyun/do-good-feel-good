<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html" style="font-size:20px;">함께해요</a></li>
                <li class="breadcrumb-item active" aria-current="page" style="font-size:22px;">봉사목록</li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
    
  <main>
    <div class="page-section">
      <div class="container">
        <h3 class="widget-title">${volunteer.title}</h3>
        <div class="divider"></div>
        <div class="vol-detail">
          <div class="vol-de-img">
           <img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
          </div>
          
          <!-- //vol-de-img -->
          <div class="vol-infor-wrap">

            
             <!-- vol-joiner -->
             <div class="vol-joiner">
               <div style="padding:10px;">
              <span class="vol-cur">
                
                <span class="sr-only">참여인원</span>
                <b class="vol-count">${volunteer.currentNum}명</b>
                /
                <span class="sr-only">총 모집인원</span>
                ${volunteer.limitNum}명
              </span>
              <div class="progress">
                <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <input type="hidden" id="volunteerNo" value="${volunteer.no}"/>
              <button type="button" class="btn btn-primary open" id="btn-modal">봉사 참여자 목록</button>
            </div>
             </div>  <!-- //vol-joiner -->
             <div class="vol-owner">  <!-- vol-owner -->
              <div class="social-mini-button">
                <span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
                <span class="owner-right">${volunteer.tel}</span>
                <span class="owner-right">${volunteer.email}</span>
              </div>
             </div> <!-- //vol-owner -->
           
             <div class="vol-detail-infor">
               <ul>
                 <li>
                   <span>봉사기간</span> :
                   <span>${volunteer.startDate} ~ ${volunteer.endDate}</span><span>총 ${volunteerDate.totalDate}일</span>
                 </li>
                 <li>
                   <span>봉사시간</span> :
                   <span>${volunteer.startTime} ~ ${volunteer.endTime}</span>
                 </li>
                 <li>
                    D-day ${volunteerDate.remainDate}일
                 </li>
               </ul>
             </div>  <!-- //vol-detail-infor -->
          </div>  <!-- //vol-infor-wrap -->
       </div>   <!-- //vol-detail -->
       
      <!-- 모달창 띄우기 -->
    <div id="vol-modal" class="vol-modal-overlay">
        <div class="vol-modal-window ">
            <div class="close-area">X</div>
            <div class="vol-title">
                <h1>[ 참여자 목록 ]</h1>
            </div>
            <div class="vol-content">
					    <table>
					      <thead>
					        <tr>
					          <th>번호</th>
					          <th>아이디</th>
					          <th>이름</th>
					          <th>시작시간</th>
					          <th>신청일</th>
					        </tr>
					      </thead>
					      <tbody>
					        <c:forEach items="${volunteerList}" var="volunteerJoinDTO" >
					          <tr>
					              <td>${volunteerJoinDTO.volunteer.no}</td> 
					              <td>${volunteerJoinDTO.joinUser.id}</td> 
					              <td>${volunteerJoinDTO.joinUser.name}</td> 
					              <td>${volunteerJoinDTO.startTime}</td> 
					              <td>${volunteerJoinDTO.registeredDate}</td> 
					          </tr>
					        </c:forEach>
					      </tbody>
					    </table>
            <%-- <button type="button" class="btn btn-primary" data-toggle="modal" onclick="location.href='join/list?no=${volunteer.no}'" >참여자목록</button>--%>
            </div>
        </div>
    </div> <!-- 모달 끝 -->
    
     <div style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
      <div class="vol-con-wrap">
       <p>
        <button class="btn btn-primary" type="button"  onclick="location.href='detail?no=${volunteer.no}#section1'" >
          <a class="widget-title" id="section1">상세보기 (Detail)</a>
        </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section2'">
           <a class="widget-title" id="section2">참여인증 & 댓글 (Review)</a>
         </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section3'">
           <a class="widget-title" id="section3">위치 (Location)</a>
         </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section4'">
           <a class="widget-title" id="section4">문의하기 (Q & A)</a>
         </button>
      </p>
    </div>
  </div> <!-- style -->
    
    
        <div class="vol-con-wrap">
            <h3 class="widget-title" id="scroll-section1" style="padding-top:30px;" >상세정보</h3>
            <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                    <form action="#" class="form-contact" method="post" enctype="multipart/form-data" name="form" >
                      <div class="row">
                        <div class="col-sm-12 py-2">
                          <label for="title" class="fg-grey">제목</label>
                          <input type="text" class="form-control" id="title" name="title" value="${volunteer.title}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">전화번호</label>
                          <input type="text" class="form-control" id="tel" name="tel" value="${volunteer.tel}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">이메일</label>
                          <input type="email" class="form-control" id="email" value="${volunteer.email}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작일</label>
                          <input type="text" class="form-control" id="startDate" value="${volunteer.startDate}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료일</label>
                          <input type="text" class="form-control" id="endDate" value="${volunteer.endDate}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작시간</label>
                          <input type="text" class="form-control" id="startTime" value="${volunteer.startTime}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료시간</label>
                          <input type="text" class="form-control" id="endTime" value="${volunteer.startTime}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">총모집인원</label>
                          <input type="text" class="form-control" id="limitNum" value="${volunteer.limitNum}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="content" class="fg-grey">내용</label>
                          <textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea >
                        </div>
                      </div>
                    </form>
                  </div>
		           </div>
		        </div>
	        </div> <!-- vol-con-wrap -->
	        
	          <div class="vol-con-wrap"> <!--  #scroll-' + page_id-->
               <h3 class="widget-title" id="scroll-section2" style="padding-top:30px;" >참여인증 & 댓글</h3>
              <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                     <div class="cont-short-list">
								        <c:forEach items="${volunteerShortReviewList}" var="volunteerShortReviewDTO">
								        <div class="s-review-list">
								          <div class="review-view">
								            <ul>
								              <li>
								                <div class="review-section">
								                  <div class="profile-thumb">
								                    <img src="${contextPath}/assets/img/level.png" alt="프로필사진">
								                  </div>
								                  <div class="review-infor">
								                    <div class="review-post">
								                      <div class="profile-infor">
								                        <span>${volunteerShortReviewDTO.owner.id}</span>
								                        <span class="txt_date">${volunteerShortReviewDTO.registeredDate}</span>
								                   <%-- <span class="ico_bbs ico_new">새글</span>--%>          
								                      </div>
								                         <div class="review-post">
								                        <p><span>${volunteerShortReviewDTO.content}</span></p>
								                      </div>
								                      <div class="review-btn">
								                        <a href='reviewUpdate?no=${volunteerShortReviewDTO.no}' class="link_menu">[수정]</a>
								                        <a href='reviewDelete?no=${volunteerShortReviewDTO.no}' class="link_menu">[삭제]</a>
								                      </div>
								                    </div>
								                  </div>
								                 </div>
							                 </li>             
								              </ul>
								            </div>
								          </div>
								          </c:forEach>
								          <!-- //s-review-list -->
								        </div>
								        
								               <button class="btn btn-primary" type="button" onclick="location.href='reviewList?no=${volunteer.no}'">상세정보</button>
								        
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
		            </div>
		          </div> <!-- vol-con-wrap -->
	                          

         <div>
            <h3 class="widget-title" style="padding-top:30px;" id="scroll-section3">위치</h3>
            <div class="divider"></div>
            <div class="content-map">
            구글맵
            
            </div>
         </div>
         
         
         <div class="vol-con-wrap">
            <h3 class="widget-title" style="padding-top:30px;" id="scroll-section4"><a>문의하기</a></h3>
		           <div class="divider"></div>
		           <div class="col-lg-12">
                 <div class="widget">
                    <div class="widget-box">
                       <div class="content-box chall-box" style="background: #81BEF7">
                        <c:forEach items="${volunteerQuestion}" var="volunteerQuestionDTO" varStatus="vs">
                          <div> <!-- 말풍선 전체 포함 -->
				                     <div style="margin-left: 19%; ">
				                       <em>${volunteerQuestionDTO.joinUser.id}</em><br>
				                     </div>
						                <div class="ch-balloon left" style="margin-top: 1%; margin-bottom: 1%; margin-left:18%; float:center">
						                <span>
					                   <div class="class" id="id" style="display: none">${volunteerQuestionDTO.no}</div>
						                    ${volunteerQuestionDTO.content}<br>
						                  <small>${volunteerQuestionDTO.registeredDate}</small>
		                      </span>
		                      </div>
		                     
                    <!-- 모달 창 -->
                    <c:if test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
                    <!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는 모달 창 전체를 
                     감싸는 div의 id 이름을 지정하면 된다. -->
                  &nbsp;&nbsp;<a data-toggle="modal" href="#myModalQuestionU${vs.index}">[변경]</a>
                    </c:if>
                    <!-- 부트스트랩의 모달 창을 사용할려면 아래의 class 이름들을 그대로 사용해야 한다. 변경하면 모양이 달라진다.-->
                    <div class="modal fade" id="myModalQuestionU${vs.index}" role="dialog"> <!-- 사용자 지정 부분① : id명 -->
                      <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                          <div class="modal-header">
                            <h4 class="modal-title">문의 수정</h4> <!-- 사용자 지정 부분② : 타이틀 -->
                            <button type="button" class="close" data-dismiss="modal">×</button>
                          </div>
                            <form action='question/update' method="post">
                              <div class="modal-body">
                            <!-- 
                              <div class= "class" id="id" style="display:none">
                                <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='no' value='${challengeDTO.no}' readonly>
                              <br></div>
                               -->
	                              <div class= "class" id="id" style="display:none">
	                                <label for='f-questionNo'>문의번호</label> <input id='f-questionNo' type='text' name='no' value='${volunteerQuestionDTO.no}' readonly>
	                             </div>
	                             
                                  <textarea id='f-content' name='content' cols="55" rows="1" class="modal-body">${volunteerQuestionDTO.content}</textarea>
                                  
                                <label for='f-owner'>작성자</label> 
                                <span id='f-owner'>${volunteerQuestionDTO.joinUser.id}</span><br>
                            
                                <label for='f-registeredDate'>등록일</label> 
                                <span id='f-registeredDate'>${volunteerQuestionDTO.registeredDate}</span><br>
                                
                                <div class= "class" id="id" style="display:none">
                                <label for='f-volunteerNo'>봉사번호</label> <input id='f-volunteerNo' type='text' name='volNo' value='${volunteer.no}' readonly>
                                </div>
                            </div>
                              <button>수정완료</button><br>
                          </form>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 모달 창 -->
                    <c:if test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
                    <a href='question/delete?no=${volunteerQuestionDTO.no}&volunteerNo=${volunteer.no}'>[삭제]</a>
                    </c:if>
                </div><br>
                
                  <c:if  test="${volunteerQuestionDTO.reply != null}" >
                     <div class="ch-balloon right" style="margin-bottom: 1%; margin-left: 70%; float:center">
			                <span>
			                    -관리자 답글-<br>
			                    ${volunteerQuestionDTO.reply}
			                </span></div><br>
                 </c:if>
              </c:forEach>
              
              <form action='question/add' method="post">
               
                  <div class= "class" id="id" style="display:none">
                    <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='volNo' value='${volunteer.no}' readonly>
                  </div><br>
                  
                     <textarea id='f-content' name='content' cols=100% rows="1" class="modal-body" style="margin-left:5%; float: left;"></textarea>
            
                    <button style="margin-left:1.5%; margin-top:1.7%;" onsubmit="checkValue()">문의등록</button>
              </form>
            </div>
         </div>
       </div>
                  
                  
                  </div>
               </div>
             </div>
            </div>
       </div>
        <div class="btn-regi">
          <button type="button" class="btn btn-primary nBtn" onclick="location.href='join/detail?no=${volunteer.no}'")>참여하기</button>
          <button type="button" class="btn btn-primary nBtn" onclick="history.go(-1)">이전</button>
        </div> <!-- //btn-regi -->       
      </div>  <!-- //container -->
    </div>  <!-- //page-section -->
  </main>


<script>
    $(document).ready(function() { 
      var page_url = window.location.href; 
      var page_id = page_url.substring(page_url.lastIndexOf("#") + 1); 
       alert(page_id); 
      if (page_id == 'section1') { 
        $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 5000); 
        } else if (page_id == 'section2') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 200); 
        } else if (page_id == 'section3') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        }  else if (page_id == 'section4') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        }
      });
    
    
   function checkValue() {
	  var content = document.querySelector("#f-content");
	   
	   if (content.value == "") {
		   alert("내용을 입력해주세요");
		   return false;
	   }
		   
	   
   }
    </script>
    
   











