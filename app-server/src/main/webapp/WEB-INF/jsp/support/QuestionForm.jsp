<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div class="page-section padding-board">
	<div class="container">
		<h4 class="mb-5">문의사항 등록</h4>
		<form action='questionAdd' method="post" enctype="multipart/form-data">

			<%--<c:forEach items="${questionCategory}"  var="questionCategory" >
        <label for='f-qnaType'>${qnaType.title}</label> 
        <input id='f-qnaType' type='radio' name='qnaType' value="${qnaType.no}" >
      </c:forEach>--%>
      
      <div>
        <label for='f-qnaType'>문의분야</label>
        <select id='f-qnaType' name='qnaTypeNo'>
	        <option value='1'>함께해요 문의</option>
	        <option value='2'>나눔이야기 문의</option>
	        <option value='3'>모금함 문의</option>
	        <option value='4'>챌린지 문의</option>
	        <option value='5'>사이트이용 문의</option>
	        <option value='6'>기타 문의</option>
        </select>
      </div>
      <div>
        <label for='f-title'>제목</label>
        <input id='f-title' type='text' name='title'>
      </div>
      <div>
        <label for='f-content'>내용</label>
        <input id='f-content' type='text' name='content'>
      </div>
      <div>
        <label for='f-password'>패스워드</label>
        <input id='f-password' type='password' name='qnaPassword' maxlength='4'>
      </div>
			<%--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>--%>
			<button>등록</button>
			<br> <a href='questionList'>[목록]</a>
		</form>
	</div>
</div>









