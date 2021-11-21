<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

  <div class="ad-main">
      <div class="ad-main-infor">
        <div class="write-wrap">
          <h4 class="mb-5">문의사항</h4>
          <form action='questionAdd' method="post">
            <div class="form-group">
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
            <!-- //제목 -->
            <div class="form-group">
              <label for="f-content">내용</label>
              <textarea name="content" id="f-content" cols="30" rows="8" class="form-control"></textarea>
            </div>
            <!-- //내용 -->
          <%-- <div class="form-group row">
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
            </div>
            <!-- //파일첨부 -->--%>
            <div class="form-group">
              <label for="f-content" class="sr-only">등록</label>
              <input type="submit" value="등록" class="btn btn-primary">
              <label for="f-content" class="sr-only">삭제</label>
              <input type="submit" value="이전" class="btn btn-secondary">
            </div>
            <!-- //등록 -->
          </form>
        </div>
        <!-- //write-wrap -->
      </div>
      <!-- //form -->
    </div>
    <!-- //ad-main -->





	<body>
		<h1>문의사항 등록</h1>
		<form action='questionAdd' method="post">
		
			<%--<c:forEach items="${questionCategory}"  var="questionCategory" >
		    <label for='f-qnaType'>${qnaType.title}</label> 
		    <input id='f-qnaType' type='radio' name='qnaType' value="${qnaType.no}" >
	    </c:forEach>--%>
		
			<label for='f-qnaType'>문의분야</label>
			<select id='f-qnaType' name='qnaTypeNo'>
			 <option value='1'>함께해요 문의</option>
			 <option value='2'>나눔이야기 문의</option>
			 <option value='3'>모금함 문의</option>
			 <option value='4'>챌린지 문의</option>
			 <option value='5'>사이트이용 문의</option>
			 <option value='6'>기타 문의</option>
			</select>
			<label for='f-title'>제목</label> <input id='f-title' type='text' name='title'><br>
			<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
			<label for='f-password'>패스워드</label> <input id='f-password' type='password' name='qnaPassword' maxlength='4'><br>
			<%--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>--%>
			<button>등록</button><br>
			<a href='questionList'>[목록]</a>
		</form>
	</body>










