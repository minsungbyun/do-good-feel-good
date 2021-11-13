<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>


    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/bg_image_3.jpg);">
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
        <div class="vol-detail">
          <div class="vol-de-img">
           <img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
          </div>
          <!-- //vol-de-img -->
          <div class="vol-infor-wrap">
             <!-- vol-joiner -->
             <div class="vol-joiner">
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
              <button type="button" class="btn btn-secondary">참여자보기</button>
              <span class="vol-type bu">비대면</span>
             </div>  <!-- //vol-joiner -->
            
             <!-- vol-owner -->
             <div class="vol-owner">
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
    
       
       <div class="vol-con-wrap">
         <div>
            <h3 class="widget-title" style="padding-top:30px;">상세정보</h3>
            
            <div class="content-box">
                
            </div>
         </div>
         <div>
            <h3 class="widget-title" style="padding-top:30px;">위치</h3>
            <div class="content-map">
              
            </div>
         </div>
       </div>
        <div class="btn-regi">
          <button type="submit" class="btn btn-primary nBtn">참여하기</button>
            <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
        </div> <!-- //btn-regi -->       
      </div>  <!-- //container -->
    </div>  <!-- //page-section -->
  </main>

 













