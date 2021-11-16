<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <main>    
    <div class="page-section">
      <div class="container">
        <div class="challgne-item">
          <p class="challgne-type bu">비대면</p>
          <h3>${challengeDTO.title}</h3>
        </div>
        <div class="chall-detail">
          <div class="chall-de-img">
           <img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
          </div>
          <!-- //vol-de-img -->
          <div class="chall-infor-wrap">
             <!-- vol-joiner -->
             <div class="chall-joiner">
              <span class="chall-cur">
                <span class="sr-only">참여인원</span>
                <b class="chall-count">0명</b>
                /
                <span class="sr-only">총 모집인원</span>
                5명
              </span>
              <div class="progress">
                <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <button type="button" class="btn btn-secondary">참여자보기</button>
              
             </div>
             <!-- //vol-joiner -->
             <!-- vol-owner -->
             <div class="chall-detail-infor">
               <ul>
                 <li>
                   <span>모집기간</span>
                   <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span><span>총 00일</span>
                 </li>
                 <li>
                   <span>참여기간</span>
                   <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span>
                 </li>
                 <li>
                   D-day 00일
                 </li>
                 <li>
                  <p>획득 포인트:100포인트</p>
                 </li>
               </ul>
               <button type="button" class="btn btn-secondary">참여하기</button>
             </div>
          </div>
          <!-- //vol-infor-wrap -->
       </div>
       <!-- //vol-detail -->
       
       <div class="vol-con-wrap">
         <div>
            <h1 class="widget-title" style="padding-top:30px;">상세정보</h1>
            <div class="content-box">
              ${challengeDTO.content}
            </div>
         </div>
         <div>
            <a href='reviewList?no=${challengeDTO.no}'>
            <h4 class="widget-title" style="padding-top:30px;">참여인증&댓글</h4>
            </a>
         </div>
         <div>
            <a href='questionList?no=${challengeDTO.no}'>
            <h4 class="widget-title" style="padding-top:30px;">문의하기
            </h4>
            </a>
         </div>
         </div>
       </div>
        <div class="btn-regi">
          <button type="submit" class="btn btn-primary nBtn">참여하기</button>
            <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
        </div>
      </div>
      <!-- //container -->
    <!-- //page-section -->
  </main>
</body>
</html>
