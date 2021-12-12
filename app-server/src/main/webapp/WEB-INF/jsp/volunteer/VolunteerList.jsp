
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(${contextPath}/images/volunteer1.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">list</li>
              </ol>
            </nav>
            <h1 class="fg-white text-center">Volunteer</h1>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->

  <main>
    <div class="page-section">
      <div class="container">
        <div class="filterable-btn filter-v">
          <button class="btn active" data-filter="*">전체</button>
          <button class="btn" data-filter=".untact">비대면</button>
          <button class="btn" data-filter=".children">아동</button>
          <button class="btn" data-filter=".teen">청소년</button>
          <button class="btn" data-filter=".elder">노인</button>
          <button class="btn" data-filter=".handicapped">장애인</button>
          <button class="btn" data-filter=".animal">동물</button>
          <button class="btn" data-filter=".environment">환경</button>
          <button class="btn" data-filter=".other">기타</button>
        </div>

        <div class="grid mt-3">
        
        
        <c:if test="${empty volunteerList}">
          <div style="display: flex; justify-content: center; align-items: center;">
            <p>${info}</p>
          </div>
        </c:if>
        
      <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
       <c:set var="cropTitle" value="${volunteerRequestDTO.title}"/>
      <c:choose> 
	      <c:when test="${volunteerRequestDTO.category.title eq '비대면'}">
		       <div class="grid-item untact">
	            <div class="portfolio">
	              <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
	              <a href="${contextPath}/images/volunteer1.jpg" data-fancybox="portfolio">
	                <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
	              </a>
	              <div class="card">
	                <div class="card-body">
				              <h5 class="card-title vol-title">
				                <a href='detail?no=${volunteerRequestDTO.no}'>
				                   <c:if test="${fn:length(cropTitle) > 45}">
				                    <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
				                   </c:if>
				                   <c:if test="${fn:length(cropTitle) <= 45}">
				                    <h5>${volunteerRequestDTO.title}</h5>
				                    </c:if>
				                 </a>
			                </h5>
				              
				              
				              <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
					          <ul class="list-group list-group-flush">
					            <li class="list-group-item" style="font-weight:bold;">
	<%-- 				              <span class="vol-cur">
					                  <span class="sr-only">참여인원</span>
					                  <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
					                  /
					                  <span class="sr-only">총 모집인원</span>
					                  ${volunteerRequestDTO.limitNum}명
					                </span> --%>
					              <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
				             </li>
					            <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
				          </ul>
					            <div class="card-footer">
					               <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
					           </div> <!-- // card-footer -->
                </div> <!-- // card -->
	            </div>  <!-- // portfolio -->
	          </div> <!-- // grid-item -->
	      </c:when>
	       
			  <c:when test="${volunteerRequestDTO.category.title eq '아동'}">
		       <div class="grid-item children">
	            <div class="portfolio">
                <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
	              <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
	                <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
	              </a>
	              <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                      <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                      </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                        <%-- <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
	            </div>
	          </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '청소년'}">
		       <div class="grid-item teen">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
	            <div class="portfolio">
	              <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
	                <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
	              </a>
		              <div class="card">
	                  <div class="card-body">
	                      <h5 class="card-title vol-title">
	                       <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
	                       </h5>
	                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
	                  </div> <!-- // card-body -->
	                    <ul class="list-group list-group-flush">
	                      <li class="list-group-item" style="font-weight:bold;">
	                        <%-- <span class="vol-cur">
	                            <span class="sr-only">참여인원</span>
	                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
	                            /
	                            <span class="sr-only">총 모집인원</span>
	                            ${volunteerRequestDTO.limitNum}명
	                          </span> --%>
	                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
	                     </li>
	                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
	                  </ul>
	                      <div class="card-footer">
	                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
	                     </div> <!-- // card-footer -->
	                </div> <!-- // card -->
	            </div>
	          </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '노인'}">
		       <div class="grid-item elder">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
             <div class="portfolio">
               <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
                 <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
               </a>
               <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                      <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                      </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                       <%--  <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
             </div>
           </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '장애인'}">
		       <div class="grid-item handicapped">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
             <div class="portfolio">
               <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
                 <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
               </a>
               <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                      <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                     </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                        <%-- <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
             </div>
           </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '동물'}">
		       <div class="grid-item animal">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
             <div class="portfolio">
               <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
                 <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
               </a>
               <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                      <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                      </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                        <%-- <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
             </div>
           </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '환경'}">
		       <div class="grid-item environment">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
             <div class="portfolio">
               <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
                 <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
               </a>
               <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                     <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                      </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                       <%--  <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
             </div>
           </div>
			  </c:when> 
			  
			  <c:when test="${volunteerRequestDTO.category.title eq '기타'}">
		       <div class="grid-item other">
	           <span class="vol-type bu">${volunteerRequestDTO.category.title}</span>
             <div class="portfolio">
               <a href="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" data-fancybox="portfolio">
                 <img src="${contextPath}/upload/volunteer/${volunteerRequestDTO.photo}" alt="봉사이미지" style="padding:10px;">
               </a>
               <div class="card">
                  <div class="card-body">
                      <h5 class="card-title vol-title">
                     <a href='detail?no=${volunteerRequestDTO.no}'>
                           <c:if test="${fn:length(cropTitle) > 45}">
                            <h5>${fn:substring(cropTitle,0,45)}<span>${fn:replace(cropTitle,cropTitle,'....')}</span></h5>
                           </c:if>
                           <c:if test="${fn:length(cropTitle) <= 45}">
                            <h5>${volunteerRequestDTO.title}</h5>
                            </c:if>
                         </a>
                      </h5>
                      <p class="card-text"><span class="text-muted">${volunteerRequestDTO.startDate} ~ ${volunteerRequestDTO.endDate}</span></p>
                  </div> <!-- // card-body -->
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item" style="font-weight:bold;">
                        <%-- <span class="vol-cur">
                            <span class="sr-only">참여인원</span>
                            <b class="vol-count">${volunteerRequestDTO.currentNum}명</b>
                            /
                            <span class="sr-only">총 모집인원</span>
                            ${volunteerRequestDTO.limitNum}명
                          </span> --%>
                        <span style="padding-left:13px; font-weight:normal; font-size:14px; color:#777;">${volunteerRequestDTO.tel}</span>
                     </li>
                      <li class="list-group-item">${volunteerRequestDTO.remainDate}일 남음</li>
                  </ul>
                      <div class="card-footer">
                         <small class="text-muted">주최자 : ${volunteerRequestDTO.owner.id}</small>
                     </div> <!-- // card-footer -->
                </div> <!-- // card -->
             </div>
           </div>
			  </c:when> 
       </c:choose> 
      </c:forEach>
       
        </div> <!-- .grid -->
        
        <c:if test="${empty volunteerList}">
          <div class="mt-5 text-center">
            <button class="btn btn-primary" onClick="location.href='../home'">이전</button>
          </div>
        </c:if>
        
        <c:if test="${not empty volunteerList}">
          <div class="mt-5 text-center">
            <button class="btn btn-primary">더보기</button>
          </div>
        </c:if>
        
        </div> <!-- .container -->
    </div> <!-- .page-section -->
  </main>

<














