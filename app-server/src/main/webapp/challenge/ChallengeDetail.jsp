<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <meta name="copyright" content="MACode ID, https://macodeid.com/">

  <title>챌린지 : 챌린지 목록</title>

  <link rel="stylesheet" href="../assets/css/bootstrap.css">
  
  <link rel="stylesheet" href="../assets/css/maicons.css">

  <link rel="stylesheet" href="../assets/vendor/animate/animate.css">

  <link rel="stylesheet" href="../assets/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="../assets/vendor/fancybox/css/jquery.fancybox.css">

  <link rel="stylesheet" href="../assets/css/theme.css">

</head>
<body>

  <!-- Back to top button -->
  <div class="back-to-top"></div>

  <header>
    <div class="top-bar">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-8">
            <div class="d-inline-block">
              <span class="mai-mail fg-primary"></span> <a href="mailto:contact@mail.com">contact@mail.com</a>
            </div>
            <div class="d-inline-block ml-2">
              <span class="mai-call fg-primary"></span> <a href="tel:+0011223495">+0011223495</a>
            </div>
          </div>
          <div class="col-md-4 text-right d-none d-md-block">
            <div class="social-mini-button">
              <a href="#"><span class="mai-logo-facebook-f"></span></a>
              <a href="#"><span class="mai-logo-twitter"></span></a>
              <a href="#"><span class="mai-logo-youtube"></span></a>
              <a href="#"><span class="mai-logo-linkedin"></span></a>
            </div>
          </div>
        </div>
      </div> <!-- .container -->
    </div> <!-- .top-bar -->

    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="index.html" class="navbar-brand">Reve<span class="text-primary">Tive.</span></a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="navbarContent">
          <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item">
              <a href="index.html" class="nav-link">함께해요</a>
            </li>
            <li class="nav-item">
              <a href="about.html" class="nav-link">소통해요</a>
            </li>
            <li class="nav-item active">
              <a href="services.html" class="nav-link">챌린지</a>
            </li>
            <li class="nav-item">
              <a href="portfolio.html" class="nav-link">모금함</a>
            </li>
            <li class="nav-item">
              <a href="blog.html" class="nav-link">고객센터</a>
          </ul>
        </div>
      </div> <!-- .container -->
    </nav> <!-- .navbar -->

    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/challengebackground.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
        <c:forEach items="${challengeList}" var="challengeDTO">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html">메인메뉴</a></li>
                <li class="breadcrumb-item active" aria-current="page">챌린지</li>
              </ol>
            </nav>
            <h1 class="fg-white text-center">이달의 챌린지</h1>
            <h1 class="fg-dark text-center">${challengeDTO.title}</h1>
        </c:forEach>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
  </header>

            <!-- 내용이 들어갑니다. -->
            <div class="viewtop_tb_z">
                <div class="viewtop_tb_w">
                    <div class="viewtop_tb">
                        <div class="viewtop_td vtopimg">
                            <div class="vtopimg_w">
                                <a id="fb-img" href="/upload/bbs/2021/8/26/70c50f49-0dd9-410f-ba36-37d0489b5da4.jpg" title="아동학대예방캠페인 '깜빡 챌린지'">
                                    <img src="/upload/bbs/2021/8/26/70c50f49-0dd9-410f-ba36-37d0489b5da4.jpg" alt="아동학대예방캠페인 '깜빡 챌린지'">
                                </a>
                            </div>
                            <h2 class="vtopsmp">
                                아동학대예방캠페인 '깜빡 챌린지'
                            </h2>
                        </div>
                        <div class="viewtop_td vtopspec vtype2">
                            <div class="vtsym type3">
                                <div class="vtsym_in">
                                    <div class="vt_proc_w">
                                        <p class="vt_proc_01">총 <span id="relativeCnt">355</span> / 300분이 참여하였습니다.</p>
                                        <div class="sproc_bar_w"><span class="sproc_bar" style="width: 100.0%"></span></div>
                                        <p class="vt_proc_03"><button type="button" class="btn_wrin" id="btn_relativeList" data-type="modal" data-target="#lyTarget">참여자 보기</button></p>
                                    </div>
                                </div>
                            </div>
                            <div class="vtsym type2 outtype2">
                                <div class="vtsym_in">
                                    <div class="vtsp_tb_w">
                                        <ul class="vtsp_tb">
                                            <li>
                                                <div class="vtcell vtth">등록정보</div>
                                                <div class="vtcell vttd">swsilver7</div>
                                                <div class="vtlaydate">2021-08-26</div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="vtnor">
                                <div class="vtsp_tb_w mb10">
                                    <ul class="vtsp_tb type2">
                                    
                                        <li>
                                            <div class="vtcell vtth">모집기간</div>
                                            <div class="vtcell vttd">2021.09.02 ~ 2021.09.30</div>
                                        </li>
                                        <li>
                                            <div class="vtcell vtth">캠페인기간</div>
                                            <div class="vtcell vttd">2021.09.01 ~ 2021.09.30</div>
                                        </li>
                                        <li>
                                            <div class="vtcell vtth">모집인원</div>
                                            <div class="vtcell vttd">300명 이하 </div>
                                        </li>
                                        <li>
                                            <div class="vtcell vtth">봉사장소</div>
                                            <div class="vtcell vttd">경기 수원시 장안구 영화로71번길 2 (정자동, 수원시종합자원봉사센터) 2 수원시자원봉사센터</div>
                                        </li>
                                    
                                    </ul>
                                </div>
                                <a href="javascript:void(0)" class="btn_vtysym" id="btn_relativeRegister" title="참여하기">참여하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="midcont_w has_laymdc" id="container">
                <div class="mctab_list_w laymdc_item">
                    <ul class="mctab_list">
                        <li class="active"><a href="javascript:void(0)" class="mctab_item dtab tabs" data-menu="detail" title="상세정보"><span>상세정보</span></a></li>
                        <li><a href="javascript:void(0)" class="mctab_item dtab tabs" data-menu="review" title="참여댓글"><span>참여댓글</span></a></li>
                        <li><a href="javascript:void(0)" class="mctab_item dtab tabs" data-menu="comment" title="문의하기"><span>문의하기</span></a></li>
                        <li><a href="javascript:void(0)" class="mctab_item dtab tabs" data-menu="result" title="캠페인결과"><span>캠페인결과</span></a></li>
                    </ul>
                </div>
                <div class="mct_cont" id="detail_content">
                    <h3 class="hdtext">상세정보</h3>
                    <div><div style="text-align: center;"><span style="color:rgb(0, 195, 204)"><span style="font-size:36px"><strong>아동학대예방캠페인 &#39;깜빡 챌린지&#39;</strong></span></span><br />
<br />
<span style="font-size:26px"><span style="color:rgb(105, 105, 105)"><span style="font-family:gamja flower,cursive">아이들이 피해 사실을 외부에 알려 도움을 청할 수 있도록,<br />
우리가 도움을 줄 수 있기를 바라는 마음으로 준비한 캠페인 입니다.</span><br />
<br />
<span style="font-family:gamja flower,cursive">아동학대(가정폭력) 피해자가 외부에 도움을 요청하는 손동작을<br />
더 널리 알리기 위해 &#39;깜빡 챌린지&#39;에 많은 참여 부탁드립니다.</span></span></span><br />
<br />
<br />
<span style="color:rgb(0, 195, 204)"><span style="font-size:28px"><strong><img alt="" src="/common/file/XR_image.do?id=fc489f67-794b-4f8f-b6cb-48effa17b090" style="height:700px; width:700px" /><br />
<br />
<img alt="" src="/common/file/XR_image.do?id=5ae530a7-f6d9-4c92-a115-56aded1af8ec" style="height:700px; width:700px" /><br />
<img alt="" src="/common/file/XR_image.do?id=043179c5-1f50-4bfa-970a-27ded164b868" style="height:700px; width:700px" /><br />
<br />
<img alt="" src="/common/file/XR_image.do?id=ceca7c2d-59fe-4265-a6b0-c6fbeff6df62" style="height:700px; width:700px" /><br />
<br />
<img alt="" src="/common/file/XR_image.do?id=0d134ff1-e3d0-4cac-91ec-50d65b4770c0" style="height:700px; width:700px" /><br />
<img alt="" src="/common/file/XR_image.do?id=5f1567d6-1e04-4398-aa5e-b17145bf54b4" style="height:700px; width:700px" /><br />
<img alt="" src="/common/file/XR_image.do?id=11218459-cb72-4a32-a281-e55d6a6211c3" style="height:700px; width:700px" /><br />
<br />
<img alt="" src="/common/file/XR_image.do?id=b60b0cc7-c650-4228-9b3e-658a6a20adfc" style="height:700px; width:700px" /><br />
<img alt="" src="/common/file/XR_image.do?id=7f21aca1-555c-4a11-9863-6c501de8a147" style="height:700px; width:700px" /></strong></span></span><br />
<br />
&nbsp;</div>
</div>
                    <div id="map" style="width:100%;height:350px;"></div>
                </div>
                <div class="mct_cont" style="display:none" id="comment_content">
                    <h3 class="hdtext">문의하기</h3>
                    <div class="repwr_low">
                        
                            
                            
                                <label for="cmtContents" class="hdtext">문의하기</label>
                                <textarea cols="20" rows="20" class="ta_rep" id="cmtContents" name="cmtContents">로그인 후에 작성이 가능합니다.</textarea>
                            
                        
                        <button type="button" class="btn_repwr" id="btn_commentRegister"><span>문의하기등록</span></button>
                    </div>
                    <div class="repcount_low" id="total_comment"></div>
                    <div class="rep_viewer tsel" id="comment_area"></div>
                </div>
                <div class="mct_cont type2" style="display:none" id="review_content">
                    <h3 class="hdtext">참여댓글</h3>
                    <ul class="cthnail_list" id="review_area">
                    </ul>
                    <button id="review_area_more" class="btn_cthn" style="margin:20px auto;display:block;padding:0 50px;" onclick="js_reviewListShowPerPage()">참여댓글 더 보기</button>
                </div>
                <div class="mct_cont" style="display:none" id="result_content">
                    <h3 class="hdtext">캠페인 결과</h3>
                    <div><center>등록된 캠페인 결과가 없습니다.</center></div>
                </div>
                
                
                <div class="btn_sbtn_w" style="margin-top:40px;">
                    <a href="/fe2/bbs/NR_index.do?bbsCd=17" class="btn_sbtn sbtn_02 stype2" title="목록">목록</a>
                </div>
                
            </div>
            
            <!-- // 하단 참여자수 공유해요 참여댓글등록 S -->
            <div class="braboth_list_z">
                <div class="braboth_list_w">
                    <div class="braboth_list">
                        <div class="brad_td brad_left tsel">
                            <span class="brab_item type7" id="btn_good" title="참여댓글건수">
                                <a href="#container" class="tabs" data-menu="review" title="참여댓글">
                                    <span class="brab_in">참여댓글건수<span class="brab_count" id="reviewCnt">331</span></span>
                                </a>
                            </span>
                            <span class="brab_item hasnot" id="btn_snsLink">
                                <a href="javascript:void(0)" onclick="sendLinkKakao()" class="brad_smico bsmico01" title="카카오톡 공유하기 - 새 창"><span class="hdtext">카카오톡 공유하기</span></a>
                                <a href="javascript:void(0)" onclick="SNS.faceBookShare()" class="brad_smico bsmico02" title="페이스북 공유하기 - 새 창"><span class="hdtext">페이스북 공유하기</span></a>
                                <span class="brab_in" title="공유해요">공유해요<span class="brab_count" id="snsLinkCnt">0</span></span>
                            </span>
                        </div>
                        <div class="brad_td brad_right">
                            <a href="javascript:void(0)" class="brab_item type3" id="btn_review" title="참여댓글등록"><span class="brab_in">참여댓글등록</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- // 하단 참여자수 공유해요 참여댓글등록 E -->
        </div>
        <script language="javascript">Suwon.subMenuRock("#smli01");</script>
    </div>
    
    <!-- 참여자보기 프레임 -->
    <div class="ly_z" id="lyTarget">
        <div class="ly_w"><div class="ly_in">
            <!-- 레이어박스 -->
            <div class="ly_box_w stype3">
                <div class="ly_box">
                    <h2 class="ly_tit">참여자보기</h2>
                    <div class="list_skin_w type2">
                        <table class="list_skin">
                            <caption>시민제안 참여자 리스트 - 번호, 아이디, 신청일로 구성</caption>
                            <colgroup>
                                <col style="width:15%" />
                                <col />
                                <col style="width:25%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th scope="col">번호</th>
                                    <th scope="col">아이디</th>
                                    <th scope="col">신청일</th>
                                </tr>
                            </thead>
                            <tbody class="tbody_list">
                            </tbody>
                        </table>
                    </div>
                    <!-- paging_w -->
                    <div id="PAGE_NAVI" class="paging_w"></div>
                    <input type="hidden" id="rowPerPage" name="rowPerPage" value="6" />
                    <!-- // paging_w -->
                </div>
                <button type="button" class="ly_close" data-focusTarget="#btn_relativeList"><span class="hdtext">닫기</span></button>
            </div>
            <!-- // 레이어박스 -->
        </div></div>
    </div>
    <!-- 참여자보기 프레임 -->
    
    <!-- 레이어 프레임 - 시민제안톡 참여댓글등록 -->
    <div class="ly_z" id="reviewLayer">
        <div class="ly_w">
            <div class="ly_in">
            
                <!-- 레이어박스 -->
                <div class="ly_box_w">
                    <div class="ly_box">
                        <h2 class="ly_tit">참여댓글 등록하기</h2>
                        <div class="bdot_list_box">
                            <ul class="bdot_list">
                                <li>시민공터 제안에 참여하신 분들만 참여댓글 등록 해주십시오.</li>
                                <li>게시물 작성 시 주민번호, 이메일, 전화번호  등의 개인정보가 입력되지 않도록 주의하시길 바랍니다.</li>
                                <li>목적에 맞지 않는 내용이나, 타인을 비방 또는 욕설이 포함되는 게시물은 삭제 될 수 있습니다.</li>
                                <li>첨부이미지은 5MB 미만의 이미지 파일(JPG, PNG, GIF) 만 등록 가능합니다. </li>
                            </ul>
                        </div>
                        <div class="wrskin_w dtype2">
                            <ul class="wrskin">
                                <li>
                                    <ul class="wrtr">
                                        <li class="wrth"><span class="fsp">아이디</span></li>
                                        <li class="wrtd dcloud"></li>
                                    </ul>
                                </li>
                                <li>
                                    <ul class="wrtr">
                                        <li class="wrth"><span class="fsp">제안제목</span></li>
                                        <li class="wrtd dcloud">
                                            <div id="reTitle">[시민후기] 아동학대예방캠페인 '깜빡 챌린지'</div>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <ul class="wrtr">
                                        <li class="wrth"><label for="reQuestion">내용</label></li>
                                        <li class="wrtd">
                                            <ul class="hwf_list">
                                                <li>
                                                    <textarea rows="5" cols="10" class="wrta" placeholder="내용입력 (2000byte 이내)" id="reQuestion" style="width:700px;height:200px;"></textarea>
                                                    <input type="hidden" id="reBbsSeq" name="reBbsSeq"/>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <form name="fileForm" method="post" enctype="multipart/form-data">
                                        <ul class="wrtr">
                                            <li class="wrth"><label for="our-test">첨부이미지</label></li>
                                            <li class="wrtd" id="devAdd">
                                                <ul class="hwf_list type2" id="existFileList">
                                                    <!-- 이미 업로드 되어있는 파일 목록 -->
                                                </ul>
                                                <ul class="hwf_list type2">
                                                    <li>
                                                        <div class="multiple_attach">
                                                            <input id="fileReceipt" type="file" name="files[]" data-label="첨부파일" multiple="multiple" class="multifile" />
                                                            <div class="selected-file" id="selected-file"></div>
                                                            <p class="file_notice" style="margin-top:8px;">
                                                                - 파일 최대 갯수 5개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                - 총 용량제한 20.0 MB&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                - 첨부가능 확장자 : gif, jpg, jpeg, png
                                                            </p>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </form>
                                </li>
                            </ul>
                        </div>
                        <div class="btn_sbtn_w mt15">
                            <a href="javascript:void(0)" class="btn_sbtn sbtn_05 stype2" id="btn_reviewRegisterUpdate" title="참여댓글등록">참여댓글등록</a>
                            <a href="javascript:void(0)" class="btn_sbtn sbtn_02 stype2" id="btnCancel" data-focusTarget="#btn_review" title="취소">취소</a>
                        </div>
                    </div>
                    <button type="button" class="ly_close" data-focusTarget="#btn_review"><span class="hdtext">닫기</span></button>
                </div>
                <!-- // 레이어박스 -->
            </div>
        </div>
    </div>
    <!-- // 레이어 프레임 - 시민제안톡 참여댓글등록 -->
    
    <!-- 레이어 프레임 - 문의하기 수정 -->
    <div class="ly_z" id="commentLayer">
        <div class="ly_w">
            <div class="ly_in">
                <!-- 레이어박스 -->
                <div class="ly_box_w">
                    <div class="ly_box">
                        <h2 class="ly_tit"><span class="sym">문의하기 </span>수정하기</h2>
                        <div class="wrskin_w dtype2">
                            <ul class="wrskin">
                                <li>
                                    <ul class="wrtr">
                                        <li class="wrth"><label for="reCmtContents">문의하기</label></li>
                                        <li class="wrtd">
                                            <ul class="hwf_list">
                                                <li>
                                                    <textarea rows="2" cols="5" class="wrta" placeholder="내용입력 (1000byte 이내)" id="reCmtContents" style="width:700px;"></textarea>
                                                    <input type="hidden" id="reCmtSeq" name="reCmtSeq"/>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="btn_sbtn_w mt15">
                            <a href="javascript:void(0)" class="btn_sbtn sbtn_05 stype2" id="btn_commentUpdate" title="수정">수정</a><!-- 문의하기수정 -->
                            <a href="javascript:void(0)" class="btn_sbtn sbtn_02 stype2 closetrigger" data-focusTarget="#btn_review" title="취소">취소</a>
                        </div>
                    </div>
                    <button type="button" class="ly_close" data-focusTarget="#btn_review"><span class="hdtext">닫기</span></button>
                </div>
                <!-- // 레이어박스 -->
            </div>
        </div>
    </div>
    <!-- // 레이어 프레임 - 문의하기 수정 -->
        

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src='/resources/front/FE2/js/sns.js'></script>
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=88f5f451b576b6e63f52a09ac87db82a&libraries=services,clusterer,drawing"></script>

<script type="text/javascript">

$().ready(function(){
    js_map();
    
    // 접근성 관련 다음 맵 API 호출 시 area 태그의 alt 속성값 삽입
    setTimeout(function() {
        $("area").attr("alt", "다음지도");
    },1000);
    
    $(".multifile").MultiFile({
        max: 5, 
        maxsize: 20480, 
        accept: "gif, jpg, jpeg, png"
     });
     
});



/////////////////////////////////////////// 탭메뉴 처리  //////////////////////////////////////
$(".tabs").click(function() { // 상세정보 탭
    var clickedMenu = $(this).data('menu');
    js_tabs(clickedMenu);
});
var js_tabs = function(clickedMenu) { 
    $('.tabs').each(function(index, item) { 
        $(this).parent().removeClass('active');
        $('#' + $(this).data('menu') + '_content').hide();
    });
    $('.tabs').each(function(index, item) { 
        if(clickedMenu == $(this).data('menu')){
            $(this).parent().addClass('active');
            
            $('#cmtContents').focus();
            
        }
    });
    $('#' + clickedMenu + '_content').show();
    // 하드코딩 퍼블리싱 그지 같아
    if(clickedMenu == 'detail'){
        $('#container div.btn_sbtn_w').show();
    } else if(clickedMenu == 'comment'){
       $('#container div.btn_sbtn_w').hide();
       js_commentList();
    }else if(clickedMenu == 'review'){
        $('#container div.btn_sbtn_w').hide();
        js_reviewList();
    }else if(clickedMenu == 'result'){
        $('#container div.btn_sbtn_w').hide();
    }
};

/////////////////////////////////////////// 시민제안  //////////////////////////////////////
$("#btn_bbsUpdate").click(function() { // 시민제안 수정 
    self.location.href = '/fe2/bbs/NR_form.do?bbsCd=15&bbsSeq=6683';
});

$("#btn_bbs_delete").click(function() { // 시민제안 삭제
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : '/fe2/bbs/TR_deleteAction.do',
        data:{
            bbsCd : '17',
            bbsSeq: '6683'
        },error :function(request,status,error){
            console("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(response){
            var messages = SM.parseMsg(response);
            alert("[처리결과] " + messages.text);
            if (messages.code == 200) {
                self.location.href = '/fe2/bbs/NR_index.do?bbsCd=15';
            }
        },complete :function(response){
            uncover_loading_layer();
        }
    });
});

/////////////////////////////////////////// 참여댓글  //////////////////////////////////////
$('#btnCancel').click(function(e) {
    
    e.preventDefault();
    $("#reviewLayer").hide();
    
    if ($('#popParam').val() == "replyBtn") {
        $("#btn_review").focus();               // 참여댓글등록 포커싱
    } else {
        $('#reviewUpdate').focus();             // 수정버튼 포커싱
    }

    $("#reBbsSeq").val('');
    $("#reQuestion").val('');
});

$("#btn_review").click(function() { // 참여댓글등록 레이어 팝업 오픈
    
   if(!false){
        alert('로그인 후 이용하세요.');
        self.location.href = '/fe2/login/NR_login.do';
        return;
    }
    
    js_tabs('review');

    $("#reBbsSeq").val('');
    $("#reQuestion").val('');
    $("#existFileList").html('');
    $(".multifile").MultiFile('reset');

    $('#popParam').val("replyBtn");
    $("#reviewLayer").trigger("showPopup");
});

var js_reviewView = function(selectedBbsSeq) { // 참여참여댓글 정보
    coverup_loading_layer();
    $.ajax({
           type     : 'GET',
           url      : '/fe2/bbs/JR_reviewView.do',
           dataType :'json',
           data:{
               bbsCd : '17',
               bbsSeq : '6683',
               regId : '',
               selectedReviewBbsSeq : selectedBbsSeq
           },error :function(request,status,error){
               console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           },success :function(data){

               if(data.bbsSeq != undefined){
                   // 참여댓글정보 셋팅
                   $("#reBbsSeq").val(data.bbsSeq);
                   $( "#reTitle" ).empty();
                   $( "#reTitle" ).append(data.title);  // 수정화면일 때는 기존 타이틀 그대로 사용
                   $("#reQuestion").val(data.question);
                   $(".multifile").MultiFile('reset');
                   
                   var fileListHtml = '<li style="display:block;">삭제하고 싶은 파일을 선택하신 후 참여댓글등록 버튼을 누르시면 파일이 삭제됩니다.</li>';
                   for(idx in data.fileList){
                       fileListHtml += '<li style="display:block;">';
                       fileListHtml += '    <input type="checkbox" class="MultiFile-remove" name="fileIds" id="'+data.fileList[idx].fileId+'" value="'+data.fileList[idx].fileId+'"/>';
                       fileListHtml += '    <label class="MultiFile-remove" for="'+data.fileList[idx].fileId+'">'+data.fileList[idx].orgFileNm+'</label>';
                       fileListHtml += '</li>';
                   }
                   $("#existFileList").html(fileListHtml);
                   
               }
           },complete :function(data){
               uncover_loading_layer();
           }
       });
};
    
$("#btn_reviewRegisterUpdate").click(function() { // 참여댓글등록
    if($("#reQuestion").val() == ''){
        alert("내용을 입력해주세요.");
        return ;
    } 
    if ( !jsCheckInputBytes($( "#reQuestion").val(), 2000 ) ) {
        alert("[내용] 2000byte를 넘을 수 없습니다. (한글 3byte)");
        return ;
    }
    
    var url = '';
    var bbsSeq = '';
    var title = '';
    
    var form = document.fileForm;
    var formData = new FormData(form);

    if($("#reBbsSeq").val() == ''){
        url = '/fe2/bbs/TR_insertAction.do';
        bbsSeq = '6683';
        title = $("#reTitle").text();
    }else{
        url = '/fe2/bbs/TR_updateAction.do';
        bbsSeq = $("#reBbsSeq").val();
        title = $("#reTitle").text();
    }
    
    formData.append('bbsCd', '17');
    formData.append('bbsSeq', bbsSeq);
    formData.append('title', title);
    formData.append('question', $("#reQuestion").val());
    
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : url,
        cache: false,
        contentType: false,
        processData: false,
        data: formData
        ,error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            console.log(data.length);
        },complete :function(data){
            
            var messages = SM.parseMsg(data.responseText);
            alert(messages.text);
            if (messages.code == 200) {
                $("#reviewLayer").hide();
                if ($('#popParam').val() == "replyBtn") {
                    js_reviewList();
                    $("#btn_review").focus();
                    
                } else if ($('#popParam').val() == "updateBtn" ) {
                    js_reviewList('param');
                }
                // 저장 후 레이어 데이터 클리어
                $("#reBbsSeq").val('');
                $("#reQuestion").val('');
                document.fileForm.reset();
            }
            uncover_loading_layer();
        }
    });
});

var js_getImgList = function(fileList){
    if (!fileList || fileList.length<1) {
        return ;
    }
    
    var result = [];
    for(j=0; j<fileList.length; j++ ){
        if (fileList[j].fileType.indexOf("image")==0) {
            result.push('<img src="'+fileList[j].fileUrl+'"/>');
        }
    }
    return result;
};

var listCount = 20;
var reviewJsonList;
var js_reviewListShowPerPage = function(){
    var strHtml = '';
    for(i=0;0<reviewJsonList.length && i<listCount;i++ ){
        var jsonItem = reviewJsonList.shift();
        var imageList = js_getImgList(jsonItem.fileList);
        strHtml = strHtml + '<li>';
        strHtml = strHtml + '<div class="cthnail_item">';
        
        if( imageList && imageList.length > 1) {
            strHtml = strHtml + '    <div class="cthnail_thum"><div class="imageSlider">';
            for(j=0; j<imageList.length; j++ ){
                strHtml = strHtml + '        <div class="">'+imageList[j]+'</div>';
            }
            strHtml = strHtml + '    </div></div>';
            strHtml = strHtml + '    <div class="cthnail_spec">';
        } else if( imageList && imageList.length == 1) {
            strHtml = strHtml + '    <div class="cthnail_thum">'+imageList[0]+'</div>';
            strHtml = strHtml + '    <div class="cthnail_spec">';
        } else {
            strHtml = strHtml + '    <div class="">';
        }
        strHtml = strHtml + '        <p class="cthn_sp01 psk psk02">' + jsonItem.regId +' ' + jsonItem.regDt.substring(0, 10) +'</p>';
        strHtml = strHtml + '        <p class="cthn_sp02">';
        var htmlContents = jsonItem.question;
        if (htmlContents) htmlContents = jsonItem.question.replace(/(\n|\r\n)/g, '<br>');
        strHtml = strHtml + htmlContents;
        strHtml = strHtml + '        </p>';
        if(jsonItem.regId == ''){
            strHtml = strHtml + '        <div class="btn_cthn_w">';
            strHtml = strHtml + '            <a href="javascript:void(0)" class="btn_cthn btn_reviewUpdate" data-seq="' + jsonItem.bbsSeq + '" title="' + jsonItem.bbsSeq + ' 수정" id="reviewUpdate" >수정</a>';
            strHtml = strHtml + '            <a href="javascript:void(0)" class="btn_cthn type2 btn_reviewDelete" data-seq="' + jsonItem.bbsSeq + '" title="' + jsonItem.bbsSeq + ' 삭제">삭제</a>';
            strHtml = strHtml + '        </div>';
        }
        strHtml = strHtml + '    </div>';
        strHtml = strHtml + '</div>';
        strHtml = strHtml + '</li>';
    }
    $("#review_area").append(strHtml);
    
    $('.btn_reviewUpdate').on('click', callback_review_update);
    $('.btn_reviewDelete').on('click', callback_review_delete); // 참여댓글 삭제\
    // 참여댓글 이미지를 슬라이드 처리
    $('.imageSlider').bxSlider({ 
        mode: 'horizontal', 
        slideWidth: 300 
    });

    if (0 < reviewJsonList.length) {
        $("#review_area_more").show();
    } else {
        $("#review_area_more").hide();
    }
};
var js_reviewList = function(param) { // 참여댓글목록(온시민은 한건만 존재)
    coverup_loading_layer();
    $.ajax({
        type     : 'GET',
        url      : '/fe2/bbs/JR_relativeListRelativeNull.do',
        data:{
           bbsCd : '17',
           bbsSeq : '6683',
           refSeq : '-52',
           orderNo : '0'
        },error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            reviewJsonList = data;
            
            $("#reviewCnt").empty();
            $("#reviewCnt").append(reviewJsonList.length);
            $("#review_area" ).empty();
            
            js_reviewListShowPerPage();

            if(param == "param") {
                $("#reviewUpdate").focus();
            }
            
        },complete :function(data){
            uncover_loading_layer();
        }
    });
};

var callback_review_update = function() {
    
    // 수정버튼 클릭 후 레이어팝업 진입
    $('#popParam').val("updateBtn"); 
     
    $("#reBbsSeq").val($(this).data('seq'));
    js_reviewView($(this).data('seq'));
    $("#reviewLayer").trigger("showPopup");
}

var callback_review_delete = function() {
    js_reviewUpdateDelete(false, $(this).data('seq'));
}

var js_reviewUpdateDelete = function(isUpdate, varBbsSeq) {
    var url = '';
    if(isUpdate){
        url = '/fe2/bbs/TR_updateAction.do';
    }else{
        if( !confirm("삭제 하시겠습니까?") ) {
            return;
        }
        url = '/fe2/bbs/TR_deleteAction.do';
    }
    coverup_loading_layer();
    $.ajax({
       type     : 'POST',
       url      : url,
       data:{
           bbsCd : '17',
           bbsSeq : varBbsSeq,
           targetTypeCd : 100
       },error :function(request,status,error){
           console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       },success :function(data){
            console.log(data.length);
       },complete :function(data){
           js_reviewList();
           
           $("#reBbsSeq").val('');
           $("#reQuestion").val('');
           $(".mctab_item.dtab.tabs").focus();
           uncover_loading_layer();
       }
   });
};

/////////////////////////////////////////// 문의하기관련 //////////////////////////////////////
$("#btn_commentRegister").click(function() { // 문의하기등록

   if(!false){
        alert('로그인 후 이용하세요.');
        self.location.href = '/fe2/login/NR_login.do';
        return;
    }
    if($("#cmtContents").val() == ''){
        alert("문의하실 내용을 입력하세요.");
        return;
    } 
    if ( !jsCheckInputBytes($( "#cmtContents").val(), 1000 ) ) {
        alert("[문의하기] 1000byte를 넘을 수 없습니다. (한글 3byte)");
        return ;
    }
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : '/fe2/bbs/comment/TR_insertAction.do',
        data:{
            bbsCd : '17',
            bbsSeq : '6683',
            cmtContents : $("#cmtContents").val()
        },error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            console.log(data.length);
        },complete :function(data){
            
            var messages = SM.parseMsg(data.responseText);
            alert(messages.text);
            if (messages.code == 200) {
                $("#cmtContents").val('');
                js_commentList();
            }
            uncover_loading_layer();
        }
    });
});

var js_commentList = function() { // 문의하기목록
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : '/fe2/bbs/comment/JR_list.do',
        data:{
           bbsCd : '17',
           bbsSeq : '6683'
        },error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            $( "#comment_area" ).empty();
            for(i=0;i<data.length;i++ ){
                var strHtml = '';
                    if(data[i].regId == 'swsilver7'){
                    strHtml = strHtml + '<div class="repbul_item repright_w">'  
                    }else{
                    strHtml = strHtml + '<div class="repbul_item repleft_w">'
                    }
                    strHtml = strHtml + '    <div class="rep_who">' + data[i].regId +'</div>';
                    strHtml = strHtml + '        <div class="rep_cbox">';
                    strHtml = strHtml + '        <div class="rep_bulp01">' + data[i].regDt.substring(0, 10) +'</div>';
                    var htmlContents = data[i].cmtContents;
                    if (htmlContents) htmlContents = data[i].cmtContents.replace(/(\n|\r\n)/g, '<br>');
                    strHtml = strHtml + '        <div class="rep_bulp02">' + htmlContents +'</div>';
                if(data[i].regId == ''){
                    strHtml = strHtml + '        <div class="repctr_list_w">';  
                    strHtml = strHtml + '            <ul class="repctr_list">';
                    strHtml = strHtml + '                <li><button type="button" class="btn_repctr btn_commentUpdate" data-seq="' + data[i].cmtSeq +'" data-cmt-contents="' + data[i].cmtContents + '">수정</button></li>';
                    strHtml = strHtml + '                <li><button type="button" class="btn_repctr btn_commentDelete" data-seq="' + data[i].cmtSeq +'">삭제</button></li>';
                    strHtml = strHtml + '            </ul>';
                    strHtml = strHtml + '        </div>';
                }
                strHtml = strHtml + '    </div>';
                strHtml = strHtml + '</div>';
                $( "#comment_area" ).append(strHtml);
            }
            $('.btn_commentUpdate').on('click', callback_comment_update); // 반드시 클래스로 선언할것
            $('.btn_commentDelete').on('click', callback_comment_delete); // 반드시 클래스로 선언할것
            $( "#total_comment" ).text('문의하기 ' + data.length + '건');
       },complete :function(data){
            uncover_loading_layer();
       }
   });
   var callback_comment_update = function() {// 문의하기수정 콜백
       
       $("#reCmtContents").val($(this).data('cmt-contents'));
       $("#reCmtSeq").val($(this).data('seq'));
       $("#commentLayer").trigger("showPopup");
   }
   var callback_comment_delete = function() {// 문의하기삭제 콜백
       js_commentUpdateDelete(false, $(this).data('seq'));
   }
};

$("#btn_commentUpdate").click(function() { // 문의하기수정
    if($("#reCmtContents").val() == ''){
        alert("문의하기을 입력하세요.");
        return;
    } 
    if ( !jsCheckInputBytes($( "#reCmtContents").val(), 1000 ) ) {
        alert("[문의하기] 1000byte를 넘을 수 없습니다. (한글 3byte)");
        return ;
    }
    js_commentUpdateDelete(true, $("#reCmtSeq").val());
});
 
var js_commentUpdateDelete = function(isUpdate, varCmtSeq) { // 문의하기수정, 삭제
    var url = '';
    if(isUpdate){
        url = '/fe2/bbs/comment/TR_updateAction.do';
    } else {
        if( !confirm("삭제 하시겠습니까?") ) {
            return;
        }
        url = '/fe2/bbs/comment/TR_deleteAction.do';
    }
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : url,
        data:{
           bbsCd : '17',
           bbsSeq : '6683',
           cmtContents : $("#reCmtContents").val(),
           cmtSeq : varCmtSeq
        },error :function(request,status,error){
           console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
               console.log(data.length);
        },complete :function(data){
            
            var messages = SM.parseMsg(data.responseText);
            alert(messages.text);
            if (messages.code == 200) {
                $("#commentLayer").hide();
                js_commentList();
            }
            uncover_loading_layer();
        }
    });
};

$(".brad_smico").click(function() { // 공유해요    
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : '/fe2/bbs/TR_updateSnsLinkCnt.do',
        data:{
            bbsCd : '17',
            bbsSeq: '6683'
        },error :function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            $("#snsLinkCnt").text(parseInt($("#snsLinkCnt").text()) + 1);
        },complete :function(data){
            uncover_loading_layer();
        }
    });
});

/////////////////////////////////////////// 참여자 보기 팝업 //////////////////////////////////////
$("#btn_relativeRegister").click(function() { // 참여하기

   if(!false){
        alert('로그인 후 이용하세요.');
        self.location.href = '/fe2/login/NR_login.do';
        return;
    }
    
    // 등록자는 참여 불가
    if (false) {
        alert("등록자는 참여 할 수 없습니다.");
        return;
    }
    
    // 중복참여 체크
    if(js_duplicateReviewCnt() > 0){
        alert('이미 참여했습니다.');
        return false;
    }
    coverup_loading_layer();
    $.ajax({
        type     : 'POST',
        url      : '/fe2/bbs/TR_insertAction.do',
        data:{
            bbsCd : '17',
            bbsSeq : '6683',
            title : '[참여하기]',
            question : ' ',
            relativeYn : 'Y'
        },error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
          console.log(data.length);
        },complete :function(data){
            js_relativeListForPage(1); //참여자 목록 갱신
            alert("참여하기가 완료되었습니다.");
            uncover_loading_layer();
        }
    });
});

var js_duplicateReviewCnt = function(){
    
    var retDuplicateReviewCnt;
    coverup_loading_layer();
    $.ajax({
        type     : 'GET',
        url      : '/fe2/bbs/JR_duplicateReviewCntRelativeY.do',
        async    : false,
        data:{
            bbsCd : '17',
            bbsSeq : '6683',
            regId : ''
        },error :function(request,status,error){
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            console.log(data.length);
        },complete :function(data){
            retDuplicateReviewCnt = data.responseJSON.value;
            uncover_loading_layer();
        }
    });
    
    return retDuplicateReviewCnt;
}

$("#btn_relativeList").click(function() { // 참여자보기
    js_relativeListForPage(1);
});

var js_relativeListForPage = function(currPage) {
    coverup_loading_layer();
    $.ajax({
        type     : 'GET',
        url      : '/fe2/bbs/JR_relativeListForPage.do',
        dataType :'json',
        data:{
            bbsCd : '17',
            refSeq : '-52',
            orderNo : '0',
            relativeYn : 'Y',
            rowPerPage : $("#rowPerPage").val(),
            currentPage : currPage
        },error :function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        },success :function(data){
            if(data.list.length == 0){
                return false;
            }
            $( ".tbody_list" ).empty();
            for(i=0;i<data.list.length;i++ ){
                var strHtml = 
                      '<tr>'
                    + '<td>' + (data.indexNo - i) + '</td>'
                    + '<td>' + data.list[i].regId +'</td>'
                    + '<td>' + data.list[i].regDt.substring(0, 10) +'</td>'
                    + '</tr>'
                $( ".tbody_list" ).append(strHtml);
            }
            $( "#relativeCnt" ).text(data.totalNum);
            js_pager('PAGE_NAVI', data, 'js_relativeListForPage', $("#rowPerPage").val());
        },complete :function(data){
            uncover_loading_layer();
        }
    });
};

var js_pager = function(divId, data, fnName, rowPerPage) {
    
    $("#"+divId).empty();
    var preStr = "";
    var postStr = "";
    var str = "";
    if(data.totalPage > 10){ //전체 인덱스가 10이 넘을 경우, 맨앞, 앞 태그 작성
        preStr += "<a href='javascript:void(0)' class='btn_pag pn_prev2' onclick='" + fnName + "(1)' title='이전 10 페이지'>[<<]</a>" +
                "<a href='javascript:void(0)' class='btn_pag pn_prev' onclick='" + fnName + "("+data.previousPartLastPage+")' title='이전 페이지'>[<]</a>";
    }
    else if( (data.totalPage <=10) && (data.totalPage > 1) ){ //전체 인덱스가 10보다 작을경우, 맨앞 태그 작성
        preStr += "<a href='javascript:void(0)' class='btn_pag pn_prev2' onclick='" + fnName + "(1)' title='이전 10 페이지'>[<]</a>";
    }
    if(data.totalPage > 10){ //전체 인덱스가 10이 넘을 경우, 맨뒤, 뒤 태그 작성
        postStr += "<a href='javascript:void(0)' class='btn_pag pn_next' onclick='" + fnName + "("+data.nextPartFirstPage+")' title='다음 페이지'>[>]</a>" +
                    "<a href='javascript:void(0)' class='btn_pag pn_next2' onclick='" + fnName + "("+data.totalPage+")' title='다음 10 페이지'>[>>]</a>";
    }
    else if( (data.totalPage <= 10) && (data.totalPage > 1) ){ //전체 인덱스가 10보다 작을경우, 맨뒤 태그 작성
        postStr += "<a href='javascript:void(0)' class='btn_pag pn_next2' onclick='" + fnName + "("+data.totalPage+")' title='다음 페이지'>[>]</a>";
    }
    for(var i= 0; i< data.pages.length; i++){
        if(data.pages[i] != data.currPage){
            str += "<li><a href='javascript:void(0)' class='pnum' onclick='" + fnName + "("+ data.pages[i] +")' title=" + data.pages[i] + " 페이지'>"+ data.pages[i] +"</a></li>";
        }
        else{
            str += "<li class='active'><a href='javascript:void(0)' class='pnum' onclick='" + fnName + "("+data.pages[i]+")' title=" + data.pages[i] + " 페이지>"+data.pages[i]+"</a></li>";
        }
    }
    $("#"+divId).append(preStr + '<ul class="pnum_list">' + str + '</ul>' + postStr);
};

var js_map = function(){
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  
    
    // 지도를 생성합니다    
    var map = new daum.maps.Map(mapContainer, mapOption); 
    
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new daum.maps.services.Geocoder();
    
    // 주소로 좌표를 검색합니다
    geocoder.addressSearch('경기 수원시 장안구 영화로71번길 2 (정자동, 수원시종합자원봉사센터)', function(result, status) {
    
        // 정상적으로 검색이 완료됐으면 
         if (status === daum.maps.services.Status.OK) {
    
            var coords = new daum.maps.LatLng(result[0].y, result[0].x);
    
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new daum.maps.Marker({
                map: map,
                position: coords
            });
    
            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new daum.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">수원시자원봉사센터</div>'
            });
            infowindow.open(map, marker);
    
            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    });
};

</script>

      
      
        <div class="section fp-auto-height" id="section4">
  <footer class="page-footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 py-3">
          <h3>Reve<span class="fg-primary">Tive.</span></h3>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Contact Information</h5>
          <p>301 The Greenhouse, Custard Factory, London, E2 8DY.</p>
          <p>Email: example@mail.com</p>
          <p>Phone: +00 112323980</p>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Company</h5>
          <ul class="footer-menu">
            <li><a href="#">Career</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#">News & Feed</a></li>
          </ul>
        </div>
        <div class="col-lg-3 py-3">
          <h5>Newsletter</h5>
          <form action="#">
            <input type="text" class="form-control" placeholder="Enter your email">
            <button type="submit" class="btn btn-primary btn-sm mt-2">Submit</button>
          </form>
        </div>
      </div>

      <hr>

      <div class="row mt-4">
        <div class="col-md-6">
          <p>Copyright 2020. This template designed by <a href="https://macodeid.com">MACode ID</a></p>
        </div>
        <div class="col-md-6 text-right">
          <div class="sosmed-button">
            <a href="#"><span class="mai-logo-facebook-f"></span></a>
            <a href="#"><span class="mai-logo-twitter"></span></a>
            <a href="#"><span class="mai-logo-youtube"></span></a>
            <a href="#"><span class="mai-logo-linkedin"></span></a>
          </div>
        </div>
      </div>
    </div>
  </footer>
<script src="../assets/js/jquery-3.5.1.min.js"></script>

<script src="../assets/js/bootstrap.bundle.min.js"></script>

<script src="../assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>

<script src="../assets/vendor/wow/wow.min.js"></script>

<script src="../assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>

<script src="../assets/vendor/isotope/isotope.pkgd.min.js"></script>

<script src="../assets/js/google-maps.js"></script>

<script src="../assets/js/theme.js"></script>

</body>
</html>
