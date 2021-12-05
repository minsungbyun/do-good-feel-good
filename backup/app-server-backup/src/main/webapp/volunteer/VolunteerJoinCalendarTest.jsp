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

        

     
  

      <div class="main">
        <div class="content-wrap">
          <div class="content-left">
            <div class="main-wrap">
              <div id="main-day" class="main-day"></div>
              <div id="main-date" class="main-date"></div>
            </div>
            <div class="todo-wrap">
              <div class="todo-title">Todo List</div>
              <div class="input-wrap">
                <input type="text" placeholder="please write here!!" id="input-box" class="input-box">
                <button type="button" id="input-data" class="input-data">INPUT</button>
                <div id="input-list" class="input-list"></div>
              </div>
            </div>
          </div>
          <div class="content-right">
            <table id="calendar" align="center">
              <thead>
                <tr class="btn-wrap clearfix">
                  <td>
                    <label id="prev">
                        &#60;
                    </label>
                  </td>
                  <td align="center" id="current-year-month" colspan="5"></td>
                  <td>
                    <label id="next">
                        &#62;
                    </label>
                  </td>
                </tr>
                <tr>
                    <td class = "sun" align="center">Sun</td>
                    <td align="center">Mon</td>
                    <td align="center">Tue</td>
                    <td align="center">Wed</td>
                    <td align="center">Thu</td>
                    <td align="center">Fri</td>
                    <td class= "sat" align="center">Sat</td>
                  </tr>
              </thead>
              <tbody id="calendar-body" class="calendar-body"></tbody>
            </table>
          </div>
        </div>
      </div>

   

 
   






