<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <main>
    <div class="page-section padding-board">
      <div class="container">
        <h4 class="mb-3">문의사항</h4>
        <!-- serch -->
        <div>
          <form class="form-inline" style="float:right; margin-bottom:25px">
            <input class="form-control mr-sm-2 search-box" type="search" placeholder="검색" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0 search-btn" type="submit">검색</button>
          </form>
        </div>
        <!-- //serch -->
        
        <!-- table-wrap -->
        <div class="table-wrap">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">문의분야</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">등록일</th>
                <th scope="col">조회수</th>
                <th scope="col">답글여부</th>
              </tr>
            </thead>
            
            <tbody>
              <c:if test='${empty questionList}'>
               <p>작성된 게시글이 없습니다.</p>
              </c:if>
              
              <c:forEach items="${questionList}" var="QuestionListDTO" >
                <tr>
                  <td>${QuestionListDTO.no}</td>
                  <td>${QuestionListDTO.qnaType.title}</td>
                  <td id="btnOpen"><a href='questionDetail?questionNo=${QuestionListDTO.no}'>${QuestionListDTO.title}</a></td> 
                  <td>${QuestionListDTO.owner.id}</td>
                  <td>${QuestionListDTO.registeredDate}</td>
                  <td>${QuestionListDTO.viewCount}</td> 
                  <td>${QuestionListDTO.status}</td>
                </tr>
              </c:forEach>
              
              <!-- modal -->
                <div id='pw-modal' style="display: none">
								  <div id='pw-content'>
								    <input type='button' value='X' class="close" id='btnClose'/>
								    <label>비밀번호를 입력하세요</label><br/>
								    <input type='password' id='pwd' value='1234' />
								    <input type='button' value='check' id='btnCheck' />
								  </div>
								</div>
              <!-- //modal -->
            </tbody>
          </table>
          <div class="form-group btn-right">
            <a class="btn btn-primary search-box" href='questionForm'>글쓰기</a><br>
          </div>
        </div>
        <!-- table-wrap -->

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
    
    <script>
      document.querySelectorAll("tbody a").forEach((aTag) => {
        aTag.onclick = () => false;
      });
      
      var trList = document.querySelectorAll("tbody tr");
      trList.forEach(function(trTag) {
        trTag.onclick = (e) => {
          //console.log(e.currentTarget.querySelector("a").href);
          //e.currentTarget.querySelector("a").click();
          window.location.href = e.currentTarget.querySelector("a").href;
          //window.location.href = "detail?no=" + e.currentTarget.getAttribute("data-no");
        };
      });
      
      var btnOpen  = document.getElementById('#btnOpen');
      var btnCheck = document.getElementById('btnCheck');
      var btnClose = document.getElementById('btnClose');

      // modal 창을 감춤
      /* var closeRtn = function(){
        var modal = document.getElementById('pw-modal');
        modal.style.display = 'none';
      } */

      // modal 창을 보여줌
      btnOpen.onclick = function(){
        var modal = document.getElementById('pw-modal');
        modal.style.display = 'block';
      }

      btnCheck.onclick = closeRtn;
      btnClose.onclick = closeRtn;
      
    </script>
