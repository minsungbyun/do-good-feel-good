<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <!-- meta -->
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	     
	  <title>HappyShare : 개인 회원가입</title>
	       
	  <!--  link -->
	  <link rel="stylesheet" href="../../assets/css/bootstrap.css">
	  <link rel="stylesheet" href="../../assets/css/maicons.css">
	  <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
	  <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
	  <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
	  <link rel="stylesheet" href="../../assets/css/theme.css">
	  <link rel="stylesheet" href="../../assets/css/style.css">
  </head>
	<body>
	<!-- header -->
  <header>
    <div class="top-bar">
      <div class="container">
        <div class="row align-items-center">          
          <div class="col-md-12 text-right d-none d-md-block">
            <div class="social-mini-button">
              <a href="#"><span>로그인</span></a>
              <a href="#" class="active"><span>회원가입</span></a>
               <a href="#"><span>관리자</span></a>
            </div>
          </div>
        </div>
        <!-- //row -->
      </div>
    </div>
    <!-- //top-bar -->
    
    <!-- nav -->
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- navbarContent -->
        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item">
              <a href="index.html" class="nav-link">함께해요</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">소통해요</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">나눔이야기</a>
                <a class="dropdown-item" href="#">한줄후기</a>
              </div>
            </li>
            <li class="nav-item">
              <a href="services.html" class="nav-link">챌린지</a>
            </li>
            <li class="nav-item">
              <a href="portfolio.html" class="nav-link">모금함</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">고객센터</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">공지사항</a>
                <a class="dropdown-item" href="#">문의사항</a>
              </div>
            </li>
          </ul>
        </div>
        <!-- //navbarContent -->
      </div>
      <!-- //container -->
    </nav>
    <!-- //nav -->
  </header>
  
  <main>
      <div class="page-section">
        <div class="container">
          <form action="#" name="form" method="post" onsubmit="validLoginForm(); return false;" enctype="multipart/form-data">
          <h1 class="title-h">회원가입 - 개인</h1>
          <div class="join-wrap">
            <h5>기본정보<span class="required_title"><em class="icon_required">·</em>표시는 반드시 입력하셔야 합니다.</span></h5>
              <div class="base-table">
                <table class="join-table">
                  <caption>개인회원 기본정보</caption>
                  <tbody>
                    <tr>
                      <th><em class="icon_required">·</em><span>아이디</span></th>
                      <td>
                        <label for='f-id' class="sr-only sr-cont">아이디</label> 
                        <input id='f-id' class="form-control form-sub-control box-input" type='text' name='id' placeholder="아이디">
                        <button type="button" class="btnj btn btn-primary" data-toggle="modal" id="id-check">중복확인</button>
                      </td>
                    </tr>
                    <!-- //아이디 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>비밀번호</span></th>
                      <td>
                        <label for='f-password' class="sr-only">비밀번호</label> 
                        <input id='f-password' class="form-control box-input" type='password' name='password' placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
                      </td>
                    </tr>
                    <!-- //비밀번호 -->
                    <tr>
				              <th><em class="icon_required">·</em><span>비밀번호확인</span></th>
				              <td>
				                <label for='f-passwordConfirm' class="sr-only">비밀번호확인</label> 
				                <input id='f-passwordConfirm' class="form-control box-input" type='password' name='passwordConfirm' placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
				              </td>
			              </tr>
			              <!-- //비밀번호 확인 -->
			              <tr>
			               <th><span>사진</span></th>
			               <td>
			               <label for='f-photo' class="sr-only">사진</label> 
			               <input id='f-photo' class="form-control box-input" type='file' name='photo'>
			               </td>
			             </tr>
                    <tr>
                      <th><em class="icon_required">·</em><span>이름</span></th>
                      <td>
                        <label for='f-name' class="sr-only">이름</label> 
                        <input id='f-name' class="form-control box-input" type='text' name='name'>
                      </td>
                    </tr>
                    <!-- //이름 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>휴대폰번호</span></th>
                      <td>
                        <label for='f-tel' class="sr-only">휴대폰번호</label> 
                        <input id='f-tel' class="form-control box-input" type='tel' name='tel'>
                      </td>
                    </tr>
                    <!-- //휴대폰번호 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>이메일</span></th>
                      <td>
                        <label for='f-email' class="sr-only">이메일</label> 
                        <input id='f-email' class="form-control box-input" type='email' name='email'>
                      </td>
                    </tr>
                    <!-- //이메일 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>주소</span></th>
                      <td>
                        <div>
                          <label for='f-postNo' class="sr-only">우편번호</label> 
                          <input id='f-postNo' class="form-control form-sub-control box-input" type='text' name='postNo' placeholder="우편번호" readonly>
                          <input type="button" onclick="findByPostNo()" value="우편번호 찾기" class="btnj btn btn-primary" ></input>
                        </div>
                        <div>
                          <label for='f-basicAddress' class="sr-only sr-cont">기본주소</label> 
                          <input id='f-basicAddress' class="form-control form-sub-control postfo box-input" type='text' name='basicAddress' placeholder="기본주소" readonly>          
                        </div>
                        <div>
                          <label for='f-detailAddress' class="sr-only sr-cont">상세주소</label> 
                          <input id='f-detailAddress' class="form-control form-sub-control postfo box-input" type='text' name='detailAddress' placeholder="상세주소">
                        </div>
                      </td>
                    </tr>
                    <!-- //주소 -->
                    <tr>
                      <th><span>생년월일</span></th>
                      <td>
                        <label for=f-birthdate class="sr-only">생년월일</label> 
                        <input id='f-birthdate' class="form-control box-input" type='date' name='birthdate'><br>
                      </td>
                    </tr>
                    <!-- //생년월일 -->
                  </tbody>
                </table>
              </div>
              <div class="btn-regi">
                <button type="submit" class="btn btn-primary nBtn">회원가입</button>
                <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
              </div>
            </div>
            <!-- //join-wrap -->
            </form>
        </div>
        <!-- //container -->
      </div>
    </main>
    
    <!-- script -->
    <script>
    document.querySelector("#id-check").onclick = () => {
        var name = document.querySelector("#f-id");
        if (name.value == "") {
          alert("이미 존재하는 아이디입니다!");
          name.focus();
          return; 

         } else {
           alert("사용 가능한 아이디입니다!");
         }
       }
    
        //유효성 검사 메서드
		    function validLoginForm() {
		    // onsubmit="validLoginForm(this); return false;"도 가능
		    var form = document.form; // name으로 form tag 찾기
		    //var form = document.querySelector("form"); // form태그 바로 찾기
		    //var form = document.querySelector("#id-tag"); // id로 찾기 
		    //var form = document.querySelector(".ccc"); // class로 찾기
		
		    var loadForm = false;
		    if (loadForm) {
		      alert("처리중입니다. 잠시만 기다려주세요");
		      return;
		    }
		    
		    form.id.value = form.id.value.trim(); // 공백제거
	          
	       if(form.id.value.length == 0) {
	        alert("로그인 아이디를 입력해주세요!");
	           form.id.focus();
	           return;
	         }
		    
	       form.password.value = form.password.value.trim();
	          
	          if(form.password.value.length == 0) {
	            alert("로그인 비밀번호를 입력해주세요!");
	            form.password.focus();
	            return;
	          }

	          form.passwordConfirm.value = form.passwordConfirm.value.trim();

	          if (form.password.value != form.passwordConfirm.value ) {
	            alert("비밀번호가 일치하지 않습니다! 다시 입력해주세요");
	            form.passwordConfirm.focus();
	            return;
	          }

	          form.name.value = form.name.value.trim();
	          
	          if(form.name.value.length == 0) {
	            alert("이름을 입력해주세요!");
	            form.name.focus();
	            return;
	          }

	          form.tel.value = form.tel.value.trim();
	          
	          if(form.tel.value.length == 0) {
	            alert("휴대폰번호를 입력해주세요!");
	            form.tel.focus();
	            return;
	          } else if (form.tel.value.indexOf("-") == -1) {
	            alert("-를 포함해서 입력해주세요! ex) 010-xxxx-xxxx");
	            form.tel.focus();
	            return;
	          }

	          form.email.value = form.email.value.trim();
	          
	          if(form.email.value.length == 0) {
	            alert("이메일을 입력해주세요!");
	            form.email.focus();
	            return;

	          } else if (form.email.value.indexOf("@") == -1) {
	            alert("@를 포함해서 입력해주세요! ex) sample@naver.com");
	            form.email.focus();
	            return;
	          }
	          
	          form.postNo.value = form.postNo.value.trim();
	          
	          if(form.postNo.value.length == 0) {
	            alert("주소를 입력해주세요!");
	            form.postNo.focus();
	            return;
	          }
	          
	          form.submit();
	          loadForm = true;
	        }
    </script>
    
    <!-- //script -->
    
    <!-- 우편번호API -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		function findByPostNo() {
		    new daum.Postcode({
		        oncomplete: function(data) {           
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("f-detailAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("f-detailAddress").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('f-postNo').value = data.zonecode;
	                document.getElementById("f-basicAddress").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("f-detailAddress").focus()
		        }
		    }).open();
		  }
		</script>
		<!-- //우편번호API -->
  </body>
</html>
