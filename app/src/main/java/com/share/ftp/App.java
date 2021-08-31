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
import com.share.ftp.handler.admin.AdminPageHandler;
import com.share.ftp.handler.admin.ShowDonationHandler;
import com.share.ftp.handler.admin.ShowVolHandler;
import com.share.ftp.handler.org.DonationRegisterHandler;
import com.share.ftp.handler.org.OrgVolRequestHandler;
import com.share.ftp.handler.org.PersonalVolRequestHandler;
import com.share.ftp.handler.personal.ChallengeHandler;
import com.share.ftp.handler.personal.CommBestHandler;
import com.share.ftp.handler.personal.CommBoardHandler;
import com.share.ftp.handler.personal.CommHandler;
import com.share.ftp.handler.personal.CommReviewHandler;
import com.share.ftp.handler.personal.DonationBoardHandler;
import com.share.ftp.handler.personal.DonationDetailHandler;
import com.share.ftp.handler.personal.MyPageHandler;
import com.share.ftp.handler.personal.MyVolHandler;
import com.share.ftp.handler.personal.QuestionListHandler;
import com.share.ftp.handler.personal.SupportHandler;
import com.share.ftp.handler.personal.VolListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {
  // 개인 도메인
  List<ApproveOrgDTO> approveOrgDTO = new ArrayList<>();
  List<CommBoardDTO> commBoardDTO = new ArrayList<>();
  List<CommReviewDTO> commReviewDTO = new ArrayList<>();
  List<DonationBoardDTO> donationBoardDTO = new ArrayList<>();
  List<DonationRegisterDTO> donationRegisterDTO = new ArrayList<>();
  List<MyChallengeQuestionDTO> myChallengeQuestionDTO = new ArrayList<>();
  List<MyChallengeReviewDTO> myChallengeReviewDTO = new ArrayList<>();
  List<MyProfileDTO> myProfileDTO = new ArrayList<>();
  List<MyQuestionListDTO> myQuestionListDTO = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTO = new ArrayList<>();
  List<PersonalRequestApplyDTO> personalRequestApplyDTO = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestDTO = new ArrayList<>();
  List<PersonalRequestRejectDTO> personalRequestRejectDTO = new ArrayList<>();
  List<VolListDTO> volListDTO = new ArrayList<>();

  //관리자 도메인
  List<ChallengeDTO> challengeDTO = new ArrayList<>();
  List<NoticeDTO> noticeDTO = new ArrayList<>();
  List<QuestionDTO> questionDTO = new ArrayList<>();

  // 개인 페이지
  static PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler();
  static OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();
  static VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);
  static DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler();
  static DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  static QuestionListHandler questionListHandler = new QuestionListHandler(myQuestionListDTO);
  static NoticeListHandler noticeListHandler = new NoticeListHandler();


  //  static CommBoardHandler commBoardHandler = new CommBoardHandler();
  //
  //  static CommReviewHandler commReviewHandler = new CommReviewHandler();
  //  static CommBoardHandler commBoardHandler = new CommBoardHandler(null);
  //>>>>>>> e4ea84d2e301647c2b888afd2a1efe0585243009
  //  static MyVolHandler myVolHandler = new MyVolHandler(personalVolRequestHandler);
  //  static DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationDetailHandler, donationRegisterHandler);
  //  static ChallengeHandler challengeHandler = new ChallengeHandler();
  //  static CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  //<<<<<<< HEAD
  //  static CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler);
  //  static SupportHandler supportHandler = new SupportHandler(questionListHandler, noticeListHandler);
  //  static MyPageHandler myPageHandler = new MyPageHandler(myVolHandler);
  //  //  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler();
  //  //  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();
  //  //  VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);
  //  //  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler();
  //  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  //  //
  //  //
  //  //  CommBoardHandler commBoardHandler = new CommBoardHandler();
  //  //  MyVolHandler myVolHandler = new MyVolHandler(personalVolRequestHandler);
  //  //  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationDetailHandler, donationRegisterHandler);
  //  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  //  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  //  //  CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler);
  //  //  SupportHandler supportHandler = new SupportHandler();
  //  //  MyPageHandler myPageHandler = new MyPageHandler(myVolHandler);
  //=======
  //  static CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler,commReviewHandler);
  //  static SupportHandler supportHandler = new SupportHandler();
  //  static MyPageHandler myPageHandler = new MyPageHandler(myVolHandler);
  //=======
  //  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler();
  //  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();
  //  VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);
  //  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler();
  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  //
  //
  //  CommBoardHandler commBoardHandler = new CommBoardHandler();
  //  MyVolHandler myVolHandler = new MyVolHandler(personalVolRequestHandler);
  //  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationDetailHandler, donationRegisterHandler);
  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  //  CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler);
  //  SupportHandler supportHandler = new SupportHandler();
  //  MyPageHandler myPageHandler = new MyPageHandler(myVolHandler);
  //>>>>>>> 5817a6d96c08be8e7c859f806417750d10136fe5
  //>>>>>>> e4ea84d2e301647c2b888afd2a1efe0585243009

  // 마이 페이지
  static MyPageHandler myVolHandler = new MyPageHandler();

  // 기관 페이지


  // 관리자 페이지
  ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler,orgVolRequestHandler);
  ShowDonationHandler showDonationHandler = new ShowDonationHandler(donationBoardHandler);
  AdminPageHandler adminPageHandler = new AdminPageHandler(personalVolRequestHandler,showVolHandler, donationBoardHandler, showDonationHandler); 

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

    MenuGroup personalvolunteerMenu = new MenuGroup("함께해요");
    personalMenu.add(personalvolunteerMenu);

    MenuGroup volunteerApply = new MenuGroup("봉사신청");
    personalvolunteerMenu.add(volunteerApply);

    MenuGroup personalApply = new MenuGroup("개인봉사등록");
    volunteerApply.add(personalApply);

    personalApply.add(new Menu("등록") {
      @Override
      public void execute() {
        volListHandler.volAuthForm(); 
      }});
    personalApply.add(new Menu("목록") {
      @Override
      public void execute() {
        volListHandler.volApprovedList(); 
      }});
    personalApply.add(new Menu("참여") {
      @Override
      public void execute() {
        volListHandler.volJoin(); 
      }});

    MenuGroup oragnizationApply = new MenuGroup("기관봉사등록");
    volunteerApply.add(oragnizationApply);

    oragnizationApply.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.registerFinish(); 
      }});
    oragnizationApply.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    oragnizationApply.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    oragnizationApply.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.volunteerupdate(); 
      }});
    oragnizationApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.volunteerdelete(); 
      }});

    MenuGroup volunteerBoard = new MenuGroup("봉사목록");
    personalvolunteerMenu.add(volunteerBoard);

    MenuGroup personalCommunityMenu = new MenuGroup("소통해요");
    personalMenu.add(personalCommunityMenu);

    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");
    personalCommunityMenu.add(reviewMenu);

    reviewMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.write(); 
      }});
    reviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.reviewList(); 
      }});
    reviewMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.reviewDetail(); 
      }});
    reviewMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.reviewChange(); 
      }});
    reviewMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.reviewDelete(); 
      }});

    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    personalCommunityMenu.add(bestReviewMenu);

    bestReviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.bestReview(); 
      }});

    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    personalCommunityMenu.add(shortReviewMenu);

    shortReviewMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.shortReviewAdd(); 
      }});

    shortReviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.shortReviewList(); 
      }});

    shortReviewMenu.add(new Menu("수정") {
      @Override
      public void execute() {
        boardHandler.shortReviewUpdate(); 
      }});
    shortReviewMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.shortReviewDelete(); 
      }});

    MenuGroup personalChallengeMenu = new MenuGroup("챌린지");
    personalMenu.add(personalChallengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    personalChallengeMenu.add(monthlyChallengeMenu);


    monthlyChallengeMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeList(); 
      }});
    monthlyChallengeMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeDetail(); 
      }});


    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    personalChallengeMenu.add(monthlyRankingMenu);


    monthlyRankingMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.monthlyRankingList(); 
      }});
    monthlyRankingMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.monthlyRankingDetail(); 
      }});

    monthlyRankingMenu.add(new Menu("나의 랭킹보기") {
      @Override
      public void execute() {
        boardHandler.rankingList(); 
      }});


    MenuGroup personalDonationMenu = new MenuGroup("모금함");
    personalMenu.add(personalDonationMenu);

    MenuGroup donationList = new MenuGroup("모금함 목록");
    personalDonationMenu.add(donationList);

    MenuGroup donation = new MenuGroup("모금함 기부하기");
    donationList.add(donation);

    donation.add(new Menu("기부하기") {
      @Override
      public void execute() {
        donationRegisterHandler.add(); 
      }});
    donation.add(new Menu("기부내역") {
      @Override
      public void execute() {
        boardHandler.donationList(); 
      }});

    MenuGroup donationTotal = new MenuGroup("전체 모금액");
    personalDonationMenu.add(donationTotal);


    MenuGroup support = new MenuGroup("고객센터");
    personalMenu.add(support);

    MenuGroup notice = new MenuGroup("공지사항");
    support.add(notice);

    notice.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    notice.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});

    MenuGroup faQ = new MenuGroup("FAQ");
    support.add(faQ);

    faQ.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    faQ.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});

    MenuGroup ask = new MenuGroup("문의하기");
    support.add(ask);

    ask.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.askMesasge(); 
      }});
    ask.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    ask.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    ask.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.finish(); 
      }});
    ask.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.ask(); 
      }});

    MenuGroup personalMyPage = new MenuGroup("마이페이지");
    personalMenu.add(personalMyPage);

    MenuGroup myProfile = new MenuGroup("회원정보수정");
    personalMyPage.add(myProfile);

    myProfile.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.checkchange(); 
      }});
    myProfile.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});

    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    personalMyPage.add(myVolunteer);

    myVolunteer.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    myVolunteer.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup myBoard = new MenuGroup("나의 게시글");
    personalMyPage.add(myBoard);

    MenuGroup myBoardList = new MenuGroup("목록");
    myBoard.add(myBoardList);

    MenuGroup myBoardDetail = new MenuGroup("상세보기");
    myBoard.add(myBoardDetail);

    myBoardDetail.add(new Menu("수정") {
      @Override
      public void execute() {
        boardHandler.checkUpdate(); 
      }});
    myBoardDetail.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});    

    MenuGroup myPoint = new MenuGroup("나의 포인트");
    personalMyPage.add(myPoint);

    myPoint.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup myDonation = new MenuGroup("나의 모금함");
    personalMyPage.add(myDonation);

    myDonation.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
    personalMyPage.add(organizationApprove);

    organizationApprove.add(new Menu("승인 요청하기") {
      @Override
      public void execute() {
        boardHandler.okSubmit(); 
      }});  

    organizationApprove.add(new Menu("승인 현황보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});   

    MenuGroup cancelMember = new MenuGroup("회원 탈퇴");
    personalMyPage.add(cancelMember);

    cancelMember.add(new Menu("탈퇴") {
      @Override
      public void execute() {
        boardHandler.getOutHere(); 
      }});


    //////////////////////////////////////////////////////////////////////////////////////////////////////    

    MenuGroup organizationMenu = new MenuGroup("기관");
    mainMenuGroup.add(organizationMenu);

    MenuGroup organizationBoardMenu = new MenuGroup("함께해요");
    organizationMenu.add(organizationBoardMenu);

    organizationBoardMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.registerFinish(); 
      }});
    organizationBoardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.reviewList(); 
      }});
    organizationBoardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.reviewDetail(); 
      }});
    organizationBoardMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.volunteerupdate(); 
      }});
    organizationBoardMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.volunteerdelete(); 
      }});

    MenuGroup organizationMemberMenu = new MenuGroup("소통해요");
    organizationMenu.add(organizationMemberMenu);

    organizationMemberMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.write(); 
      }});
    organizationMemberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.reviewList(); 
      }});
    organizationMemberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.reviewDetail(); 
      }});
    organizationMemberMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.reviewChange(); 
      }});
    organizationMemberMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.reviewDelete(); 
      }});

    MenuGroup organizationProjectMenu = new MenuGroup("챌린지");
    organizationMenu.add(organizationProjectMenu);

    organizationProjectMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.shortReviewAdd(); 
      }});
    organizationProjectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.shortReviewList(); 
      }});
    organizationProjectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.reviewDetail(); 
      }});
    organizationProjectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.shortReviewUpdate(); 
      }});
    organizationProjectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.shortReviewDelete(); 
      }});

    MenuGroup organizationtaskMenu = new MenuGroup("모금함");
    organizationMenu.add(organizationtaskMenu);

    MenuGroup organizationDonationApply = new MenuGroup("모금함 신청");
    organizationtaskMenu.add(organizationDonationApply);

    organizationDonationApply.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.okMessage(); 
      }});
    organizationDonationApply.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.donationList(); 
      }});

    organizationDonationApply.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.totalList(); 
      }});
    organizationDonationApply.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.checkUpdate(); 
      }});
    organizationDonationApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});
    MenuGroup organizationServiceCenter = new MenuGroup("고객센터");
    organizationMenu.add(organizationServiceCenter);

    MenuGroup organizationNotice = new MenuGroup("공지사항");
    organizationServiceCenter.add(organizationNotice);

    organizationNotice.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeList(); 
      }});
    organizationNotice.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeDetail(); 
      }});

    MenuGroup organizationFaQ = new MenuGroup("FAQ");
    organizationServiceCenter.add(organizationFaQ);

    organizationFaQ.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.shortReviewList(); 
      }});
    organizationFaQ.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeDetail(); 
      }});

    MenuGroup organizationAsk = new MenuGroup("문의하기");
    organizationServiceCenter.add(organizationAsk);

    organizationAsk.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.shortReviewAdd(); 
      }});
    organizationAsk.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.monthlyRankingList(); 
      }});
    organizationAsk.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.monthlyChallengeDetail(); 
      }});
    organizationAsk.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.checkUpdate(); 
      }});
    organizationAsk.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});

    //////////////////////////////////////////////////////////////////////////////////////////////
    MenuGroup adminMenu = new MenuGroup("관리자");
    mainMenuGroup.add(adminMenu);


    MenuGroup memberMenu = new MenuGroup("회원정보 조회");
    adminMenu.add(memberMenu);

    memberMenu.add(new Menu("회원목록") {
      @Override
      public void execute() {
        boardHandler.adminList(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminDetail(); 
      }});
    memberMenu.add(new Menu("추방하기") {
      @Override
      public void execute() {
        boardHandler.adminGetOut(); 
      }});

    MenuGroup donationMenu = new MenuGroup("모금 관리");
    adminMenu.add(donationMenu);

    donationMenu.add(new Menu("신청기관목록") {
      @Override
      public void execute() {
        boardHandler.adminDonationList(); 
      }});
    donationMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminDonationDetail(); 
      }});
    donationMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.adminok(); 
      }});
    donationMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.adminOut(); 
      }});

    MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.adminVolunteerList(); 
      }});
    volunteerMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminVolunteerDetail(); 
      }});
    volunteerMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.adminVolunteerok(); 
      }});
    volunteerMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.adminVolunteerOut(); 
      }});


    MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.adminNoticeAdd(); 
      }});
    noticeMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.adminNoticeList(); 
      }});
    noticeMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminNoticeDetail(); 
      }});
    noticeMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.adminNoticeOk(); 
      }});
    noticeMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.adminNoticeOut(); 
      }});


    MenuGroup askInfo = new MenuGroup("문의사항 관리");
    adminMenu.add(askInfo);

    askInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.adminaskInfoAdd(); 
      }});
    askInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.adminaskInfoList(); 
      }});
    askInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminaskInfoDetail(); 
      }});
    askInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.adminaskInfoOk(); 
      }});
    askInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.adminaskInfoOut(); 
      }});

    MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
    adminMenu.add(challengeInfo);

    challengeInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.adminChallengeInfoAdd(); 
      }});
    challengeInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.adminChallengeInfoList(); 
      }});
    challengeInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminChallengeInfoDetail(); 
      }});
    challengeInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.adminChallengeInfoOk(); 
      }});
    challengeInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.adminApproveInfoOut(); 
      }});

    MenuGroup approveInfo = new MenuGroup("기관 승인");
    adminMenu.add(approveInfo);

    approveInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.adminApproveInfoAdd(); 
      }});
    approveInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.adminApproveInfoDetail(); 
      }});
    approveInfo.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.adminApproveInfoList(); 
      }});
    approveInfo.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.adminApproveNO(); 
      }});



    return mainMenuGroup;
  }



}





