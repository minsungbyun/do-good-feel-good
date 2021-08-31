package com.share.ftp;


import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestApplyDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestRejectDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.org.OrgVolRequestHandler;
import com.share.ftp.handler.org.PersonalVolRequestHandler;
import com.share.ftp.handler.personal.CommBestHandler;
import com.share.ftp.handler.personal.CommBoardHandler;
import com.share.ftp.handler.personal.CommHandler;
import com.share.ftp.handler.personal.CommReviewHandler;
import com.share.ftp.handler.personal.VolApprovedHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {

  // 함께해요 도메인(값)
  List<VolListDTO> volListDTO = new ArrayList<>();
  List<PersonalRequestApplyDTO> personalRequestApplyDTO = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestDTO = new ArrayList<>();
  List<PersonalRequestRejectDTO> personalRequestRejectDTO = new ArrayList<>();


  List<ApproveOrgDTO> approveOrgDTO = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTO = new ArrayList<>();
  List<CommReviewDTO> commReviewDTO = new ArrayList<>();

  // 챌린지 도메인(값)
  List<MyChallengeQuestionDTO> myChallengeQuestionDTO = new ArrayList<>();
  List<MyChallengeReviewDTO> myChallengeReviewDTO = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationBoardDTO> donationBoardDTO = new ArrayList<>();
  List<DonationRegisterDTO> donationRegisterDTO = new ArrayList<>();

  //마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTO = new ArrayList<>();
  List<MyQuestionListDTO> myQuestionListDTO = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTO = new ArrayList<>();

  //관리자 도메인(값)
  List<ChallengeDTO> challengeDTO = new ArrayList<>();
  List<NoticeDTO> noticeDTO = new ArrayList<>();
  List<QuestionDTO> questionDTO = new ArrayList<>();


  // 함께해요 핸들러(기능)

  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler();
  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();
  VolApprovedHandler volApprovedHandler = new VolApprovedHandler();
  //  static VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);


  // 소통해요 핸들러(기능)
  CommBoardHandler commBoardHandler = new CommBoardHandler(commBoardDTO);
  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  CommReviewHandler commReviewHandler = new CommReviewHandler(commReviewDTO);
  CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler,commReviewHandler);


  //챌린지 핸들러(기능)
  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler();


  // 모금함 관련 핸들러(기능)
  //  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler();
  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  //  QuestionListHandler questionListHandler = new QuestionListHandler(myQuestionListDTO);
  //  NoticeListHandler noticeListHandler = new NoticeListHandler();
  //  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationDetailHandler, donationRegisterHandler);


  // 마이 페이지
  //  MyPageHandler myVolHandler = new MyPageHandler();
  //  QuestionListHandler questionListHandler = new QuestionListHandler();
  //  NoticeListHandler noticeListHandler = new NoticeListHandler();
  //  MyBoardListHandler myBoardListHandler = new MyBoardListHandler();
  //  MyPointHandler myPointHandler = new MyPointHandler();
  //  MyDonationHandler myDonationHandler = new MyDonationHandler();
  //  ApproveOrgHandler approveOrgHandler = new ApproveOrgHandler();
  //  WithdrawMemberHandler withdrawMemberHandler = new WithdrawMemberHandler();

  // 고객센터 핸들러(기능)
  //  ShowNoticeHandler showNoticeHandler = new ShowNoticeHandler();
  //  ShowQuestionHandler showQuestionHandler = new ShowQuestionHandler(questionDTOList);
  //  SupportHandler supportHandler = new SupportHandler(questionListHandler, noticeListHandler);


  // 관리자 페이지
  //  ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler,orgVolRequestHandler);
  //  ShowDonationHandler showDonationHandler = new ShowDonationHandler(donationBoardHandler);
  //  ShowMemberHandler showMemberHandler = new ShowMemberHandler();
  //  ShowOrgApproveHandler showOrgApproveHandler = new ShowOrgApproveHandler();
  //  AdminPageHandler adminPageHandler = new AdminPageHandler(personalVolRequestHandler,showVolHandler, donationBoardHandler, showDonationHandler); 



  // 마이 페이지

  //<<<<<<< HEAD
  //=======
  //    donation.add(new Menu("기부하기") {
  //      @Override
  //      public void execute() {
  //        donationRegisterHandler.add(); 
  //      }});
  //    donation.add(new Menu("기부내역") {
  //      @Override
  //      public void execute() {
  //        boardHandler.donationList(); 
  //      }});
  //>>>>>>> 416a1777ac3b9ac218dd56cc3aed17e787feb5a3





  public static void main(String[] args) {

    App app = new App(); 
    app.service();

  }
  void service() {
    createMenu().execute();
    Prompt.close();
  }


  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("로그인");
    mainMenuGroup.setPrevMenuTitle("종료");


    MenuGroup personalMenu = new MenuGroup("개인");
    mainMenuGroup.add(personalMenu);

    MenuGroup doVolMenu = new MenuGroup("함께해요");
    personalMenu.add(doVolMenu);

    doVolMenu.add(new Menu("1. 개인봉사신청양식") {
      @Override
      public void execute() {
        personalVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("2. 기관봉사신청양식") {
      @Override
      public void execute() {
        orgVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("3. 승인봉사목록") {
      @Override
      public void execute() {
        volApprovedHandler.approvedList(); 
      }});
    doVolMenu.add(new Menu("4. 봉사참여하기") {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});


    //
    //    MenuGroup personalCommunityMenu = new MenuGroup("소통해요");
    //    personalMenu.add(personalCommunityMenu);
    //
    //    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");
    //    personalCommunityMenu.add(reviewMenu);
    //
    //    reviewMenu.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.write(); 
    //      }});
    //    reviewMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewList(); 
    //      }});
    //    reviewMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDetail(); 
    //      }});
    //    reviewMenu.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewChange(); 
    //      }});
    //    reviewMenu.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDelete(); 
    //      }});
    //
    //    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    //    personalCommunityMenu.add(bestReviewMenu);
    //
    //    bestReviewMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.bestReview(); 
    //      }});
    //
    //    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    //    personalCommunityMenu.add(shortReviewMenu);
    //
    //    shortReviewMenu.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewAdd(); 
    //      }});
    //
    //    shortReviewMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewList(); 
    //      }});
    //
    //    shortReviewMenu.add(new Menu("수정") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewUpdate(); 
    //      }});
    //    shortReviewMenu.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewDelete(); 
    //      }});
    //
    //    MenuGroup personalChallengeMenu = new MenuGroup("챌린지");
    //    personalMenu.add(personalChallengeMenu);
    //
    //    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    //    personalChallengeMenu.add(monthlyChallengeMenu);
    //
    //
    //    monthlyChallengeMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeList(); 
    //      }});
    //    monthlyChallengeMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeDetail(); 
    //      }});
    //
    //
    //    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    //    personalChallengeMenu.add(monthlyRankingMenu);
    //
    //
    //    monthlyRankingMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyRankingList(); 
    //      }});
    //    monthlyRankingMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyRankingDetail(); 
    //      }});
    //
    //    monthlyRankingMenu.add(new Menu("나의 랭킹보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.rankingList(); 
    //      }});
    //
    //
    //    MenuGroup personalDonationMenu = new MenuGroup("모금함");
    //    personalMenu.add(personalDonationMenu);
    //
    //    MenuGroup donationList = new MenuGroup("모금함 목록");
    //    personalDonationMenu.add(donationList);
    //
    //    MenuGroup donation = new MenuGroup("모금함 기부하기");
    //    donationList.add(donation);
    //
    //    donation.add(new Menu("기부하기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.okMessage(); 
    //      }});
    //    donation.add(new Menu("기부내역") {
    //      @Override
    //      public void execute() {
    //        boardHandler.donationList(); 
    //      }});
    //
    //    MenuGroup donationTotal = new MenuGroup("전체 모금액");
    //    personalDonationMenu.add(donationTotal);
    //
    //
    //    MenuGroup support = new MenuGroup("고객센터");
    //    personalMenu.add(support);
    //
    //    MenuGroup notice = new MenuGroup("공지사항");
    //    support.add(notice);
    //
    //    notice.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.list(); 
    //      }});
    //    notice.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});
    //
    //    MenuGroup faQ = new MenuGroup("FAQ");
    //    support.add(faQ);
    //
    //    faQ.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.list(); 
    //      }});
    //    faQ.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});
    //
    //    MenuGroup ask = new MenuGroup("문의하기");
    //    support.add(ask);
    //
    //    ask.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.askMesasge(); 
    //      }});
    //    ask.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.list(); 
    //      }});
    //    ask.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});
    //    ask.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.finish(); 
    //      }});
    //    ask.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.ask(); 
    //      }});
    //
    MenuGroup personalMyPage = new MenuGroup("마이페이지");
    personalMenu.add(personalMyPage);

    MenuGroup myProfile = new MenuGroup("회원정보수정");
    personalMyPage.add(myProfile);
    //
    //    myProfile.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkchange(); 
    //      }});
    //    myProfile.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkDelete(); 
    //      }});
    //
    //    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    //    personalMyPage.add(myVolunteer);
    //    //
    //    myVolunteer.add(new Menu("1. 나의 봉사신청서 확인") {
    //      @Override
    //      public void execute() {
    //        myVolHandler.showVolApplyList(); 
    //      }});
    //    myVolunteer.add(new Menu("2. 승인된 봉사내역") {
    //      @Override
    //      public void execute() {
    //        myVolHandler.showApproveList(); 
    //      }});    
    //    myVolunteer.add(new Menu("3. 찜한봉사") {
    //      @Override
    //      public void execute() {
    //        myVolHandler.showVolBookmark(); 
    //      }});    

    MenuGroup myBoard = new MenuGroup("나의 게시글");
    personalMyPage.add(myBoard);
    //
    //    MenuGroup myBoardList = new MenuGroup("목록");
    //    myBoard.add(myBoardList);
    //
    //    MenuGroup myBoardDetail = new MenuGroup("상세보기");
    //    myBoard.add(myBoardDetail);
    //
    //    myBoardDetail.add(new Menu("수정") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkUpdate(); 
    //      }});
    //    myBoardDetail.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkDelete(); 
    //      }});    
    //
    //    MenuGroup myPoint = new MenuGroup("나의 포인트");
    //    personalMyPage.add(myPoint);
    //    //
    //    myPoint.add(new Menu("1. 나의포인트확인") {
    //      @Override
    //      public void execute() {
    //        myPointHandler.showMyPointList(); 
    //      }});    
    //    //
    //    MenuGroup myDonation = new MenuGroup("나의 모금함");
    //    personalMyPage.add(myDonation);
    //    //
    //    myDonation.add(new Menu("1. 나의기부내역") {
    //      @Override
    //      public void execute() {
    //        myDonationHandler.showMyTotalDonation(); 
    //      }});    
    //    //
    //    MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
    //    personalMyPage.add(organizationApprove);

    //    organizationApprove.add(new Menu("승인 요청하기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.okSubmit(); 
    //      }});  
    //
    //    organizationApprove.add(new Menu("승인 현황보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});   
    //
    //    MenuGroup cancelMember = new MenuGroup("회원 탈퇴");
    //    personalMyPage.add(cancelMember);
    //
    //    cancelMember.add(new Menu("탈퇴") {
    //      @Override
    //      public void execute() {
    //        boardHandler.getOutHere(); 
    //      }});
    //
    //
    //    //////////////////////////////////////////////////////////////////////////////////////////////////////    
    //
    //    MenuGroup organizationMenu = new MenuGroup("기관");
    //    mainMenuGroup.add(organizationMenu);
    //
    //    MenuGroup organizationBoardMenu = new MenuGroup("함께해요");
    //    organizationMenu.add(organizationBoardMenu);
    //
    //    organizationBoardMenu.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.registerFinish(); 
    //      }});
    //    organizationBoardMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewList(); 
    //      }});
    //    organizationBoardMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDetail(); 
    //      }});
    //    organizationBoardMenu.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.volunteerupdate(); 
    //      }});
    //    organizationBoardMenu.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.volunteerdelete(); 
    //      }});
    //
    //    MenuGroup organizationMemberMenu = new MenuGroup("소통해요");
    //    organizationMenu.add(organizationMemberMenu);
    //
    //    organizationMemberMenu.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.write(); 
    //      }});
    //    organizationMemberMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewList(); 
    //      }});
    //    organizationMemberMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDetail(); 
    //      }});
    //    organizationMemberMenu.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewChange(); 
    //      }});
    //    organizationMemberMenu.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDelete(); 
    //      }});
    //
    //    MenuGroup organizationProjectMenu = new MenuGroup("챌린지");
    //    organizationMenu.add(organizationProjectMenu);
    //
    //    organizationProjectMenu.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewAdd(); 
    //      }});
    //    organizationProjectMenu.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewList(); 
    //      }});
    //    organizationProjectMenu.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.reviewDetail(); 
    //      }});
    //    organizationProjectMenu.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewUpdate(); 
    //      }});
    //    organizationProjectMenu.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewDelete(); 
    //      }});
    //
    //    MenuGroup organizationtaskMenu = new MenuGroup("모금함");
    //    organizationMenu.add(organizationtaskMenu);
    //
    //    MenuGroup organizationDonationApply = new MenuGroup("모금함 신청");
    //    organizationtaskMenu.add(organizationDonationApply);
    //
    //    organizationDonationApply.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.okMessage(); 
    //      }});
    //    organizationDonationApply.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.donationList(); 
    //      }});
    //
    //    organizationDonationApply.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.totalList(); 
    //      }});
    //    organizationDonationApply.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkUpdate(); 
    //      }});
    //    organizationDonationApply.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkDelete(); 
    //      }});
    //    MenuGroup organizationServiceCenter = new MenuGroup("고객센터");
    //    organizationMenu.add(organizationServiceCenter);
    //
    //    MenuGroup organizationNotice = new MenuGroup("공지사항");
    //    organizationServiceCenter.add(organizationNotice);
    //
    //    organizationNotice.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeList(); 
    //      }});
    //    organizationNotice.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeDetail(); 
    //      }});
    //
    //    MenuGroup organizationFaQ = new MenuGroup("FAQ");
    //    organizationServiceCenter.add(organizationFaQ);
    //
    //    organizationFaQ.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewList(); 
    //      }});
    //    organizationFaQ.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeDetail(); 
    //      }});
    //
    //    MenuGroup organizationAsk = new MenuGroup("문의하기");
    //    organizationServiceCenter.add(organizationAsk);
    //
    //    organizationAsk.add(new Menu("등록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.shortReviewAdd(); 
    //      }});
    //    organizationAsk.add(new Menu("목록") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyRankingList(); 
    //      }});
    //    organizationAsk.add(new Menu("상세보기") {
    //      @Override
    //      public void execute() {
    //        boardHandler.monthlyChallengeDetail(); 
    //      }});
    //    organizationAsk.add(new Menu("변경") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkUpdate(); 
    //      }});
    //    organizationAsk.add(new Menu("삭제") {
    //      @Override
    //      public void execute() {
    //        boardHandler.checkDelete(); 
    //      }});
    //
    //    //////////////////////////////////////////////////////////////////////////////////////////////
    //    MenuGroup adminMenu = new MenuGroup("관리자");
    //    mainMenuGroup.add(adminMenu);
    //    //
    //    //
    //    MenuGroup memberMenu = new MenuGroup("1. 회원정보 조회");
    //    adminMenu.add(memberMenu);
    //    //
    //    memberMenu.add(new Menu("1. 회원목록") {
    //      @Override
    //      public void execute() {
    //        showMemberHandler.list(); 
    //      }});
    //    memberMenu.add(new Menu("2. 회원추방") {
    //      @Override
    //      public void execute() {
    //        showMemberHandler.getOutMember(); 
    //      }});
    //
    //    //
    //    MenuGroup donationMenu = new MenuGroup("2. 모금 관리");
    //    adminMenu.add(donationMenu);
    //    //
    //    donationMenu.add(new Menu("1. 모금활동관리") {
    //      @Override
    //      public void execute() {
    //        showDonationHandler.list(); 
    //      }});
    //
    //    //
    //    MenuGroup volunteerMenu = new MenuGroup("3. 봉사활동 관리");
    //    adminMenu.add(volunteerMenu);
    //    //
    //    volunteerMenu.add(new Menu("1. 개인봉사신청내역") {
    //      @Override
    //      public void execute() {
    //        showVolHandler.personalApprove(); 
    //      }});
    //    volunteerMenu.add(new Menu("2. 기관봉사신청내역") {
    //      @Override
    //      public void execute() {
    //        showVolHandler.orgApprove(); 
    //      }});
    //    volunteerMenu.add(new Menu("3. 승인하기") {
    //      @Override
    //      public void execute() {
    //        showVolHandler.accept(); 
    //      }});
    //    volunteerMenu.add(new Menu("4. 반려하기") {
    //      @Override
    //      public void execute() {
    //        showVolHandler.reject(); 
    //      }});
    //    //
    //    //
    //    MenuGroup noticeMenu = new MenuGroup("4. 공지사항 관리");
    //    adminMenu.add(noticeMenu);
    //    //
    //    noticeMenu.add(new Menu("1. 공지사항 등록") {
    //      @Override
    //      public void execute() {
    //        showNoticeHandler.add(); 
    //      }});
    //    noticeMenu.add(new Menu("2. 공지사항 목록") {
    //      @Override
    //      public void execute() {
    //        showNoticeHandler.list(); 
    //      }});
    //    noticeMenu.add(new Menu("3. 공지사항 상세보기") {
    //      @Override
    //      public void execute() {
    //        showNoticeHandler.detail(); 
    //      }});
    //    noticeMenu.add(new Menu("4. 공지사항 변경") {
    //      @Override
    //      public void execute() {
    //        showNoticeHandler.update(); 
    //      }});
    //    noticeMenu.add(new Menu("5. 공지사항 삭제") {
    //      @Override
    //      public void execute() {
    //        showNoticeHandler.delete(); 
    //      }});
    //    //
    //    //
    //    MenuGroup askInfo = new MenuGroup("5. 문의사항 관리");
    //    adminMenu.add(askInfo);
    //    //
    //    askInfo.add(new Menu("1. 문의사항 등록") {
    //      @Override
    //      public void execute() {
    //        showQuestionHandler.addreply(); 
    //      }});
    //    askInfo.add(new Menu("2. 문의사항 목록") {
    //      @Override
    //      public void execute() {
    //        showQuestionHandler.list(); 
    //      }});
    //    askInfo.add(new Menu("3. 문의사항 상세보기") {
    //      @Override
    //      public void execute() {
    //        showQuestionHandler.detail(); 
    //      }});
    //    askInfo.add(new Menu("4. 문의사항 변경") {
    //      @Override
    //      public void execute() {
    //        showQuestionHandler.update(); 
    //      }});
    //    askInfo.add(new Menu("5. 문의사항 삭제") {
    //      @Override
    //      public void execute() {
    //        showQuestionHandler.delete(); 
    //      }});
    //    //
    //    MenuGroup challengeInfo = new MenuGroup("6. 챌린지 관리");
    //    adminMenu.add(challengeInfo);
    //
    //    challengeInfo.add(new Menu("1. 챌린지 등록") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.add(); 
    //      }});
    //    challengeInfo.add(new Menu("2. 챌린지 목록") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.list(); 
    //      }});
    //    challengeInfo.add(new Menu("3. 챌린지 상세보기") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.detail(); 
    //      }});
    //    challengeInfo.add(new Menu("4. 챌린지 변경") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.update(); 
    //      }});
    //    challengeInfo.add(new Menu("5. 챌린지 삭제") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.delete(); 
    //      }});
    //    //
    //    MenuGroup approveInfo = new MenuGroup("7. 기관 승인");
    //    adminMenu.add(approveInfo);
    //    //
    //    approveInfo.add(new Menu("1. 기관승인신청 목록") {
    //      @Override
    //      public void execute() {
    //        showOrgApproveHandler.list(); 
    //      }});
    //    approveInfo.add(new Menu("2. 기관승인신청 내용") {
    //      @Override
    //      public void execute() {
    //        showOrgApproveHandler.detail(); 
    //      }});
    //    approveInfo.add(new Menu("3. 기관승인신청 변경") {
    //      @Override
    //      public void execute() {
    //        showOrgApproveHandler.update(); 
    //      }});
    //    approveInfo.add(new Menu("4. 기관승인신청 삭제") {
    //      @Override
    //      public void execute() {
    //        showOrgApproveHandler.delete(); 
    //      }});



    return mainMenuGroup;
  }



}





