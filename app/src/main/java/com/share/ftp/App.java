package com.share.ftp;


import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.guest.JoinDTO;
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
import com.share.ftp.handler.admin.ShowChallengeHandler;
import com.share.ftp.handler.admin.ShowDonationHandler;
import com.share.ftp.handler.admin.ShowMemberHandler;
import com.share.ftp.handler.admin.ShowNoticeHandler;
import com.share.ftp.handler.admin.ShowOrgApproveHandler;
import com.share.ftp.handler.admin.ShowQuestionHandler;
import com.share.ftp.handler.admin.ShowVolHandler;
import com.share.ftp.handler.join.AuthHandler;
import com.share.ftp.handler.join.JoinHandler;
import com.share.ftp.handler.personal.ApproveOrgHandler;
import com.share.ftp.handler.personal.ChallengeBoardHandler;
import com.share.ftp.handler.personal.ChallengeListHandler;
import com.share.ftp.handler.personal.ChallengeQuestionHandler;
import com.share.ftp.handler.personal.ChallengeReviewHandler;
import com.share.ftp.handler.personal.CommBestHandler;
import com.share.ftp.handler.personal.CommBoardHandler;
import com.share.ftp.handler.personal.CommReviewHandler;
import com.share.ftp.handler.personal.DonationBoardHandler;
import com.share.ftp.handler.personal.DonationRegisterHandler;
import com.share.ftp.handler.personal.MyBoardListHandler;
import com.share.ftp.handler.personal.MyDonationHandler;
import com.share.ftp.handler.personal.MyPointHandler;
import com.share.ftp.handler.personal.MyProfileHandler;
import com.share.ftp.handler.personal.NoticeListHandler;
import com.share.ftp.handler.personal.OrgVolRequestHandler;
import com.share.ftp.handler.personal.PersonalVolRequestHandler;
import com.share.ftp.handler.personal.QuestionListHandler;
import com.share.ftp.handler.personal.RankingHandler;
import com.share.ftp.handler.personal.SupportHandler;
import com.share.ftp.handler.personal.VolApprovedHandler;
import com.share.ftp.handler.personal.VolListHandler;
import com.share.ftp.handler.personal.WithdrawMemberHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {

  // 회원가입 도메인(값)
  List<JoinDTO> joinDTOList = new ArrayList<>();

  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();
  List<PersonalRequestApplyDTO> personalRequestApplyDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestDTOList = new ArrayList<>();
  List<PersonalRequestRejectDTO> personalRequestRejectDTOList = new ArrayList<>();

  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();

  // 챌린지 도메인(값)

  List<MyChallengeQuestionDTO> myChallengeQuestionDTOList = new ArrayList<>();
  List<MyChallengeReviewDTO> myChallengeReviewDTOList = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();

  // 마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<MyQuestionListDTO> myQuestionListDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();

  // 관리자 도메인(값)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();


  // 관리자


  // 회원가입 핸들러(기능)
  JoinHandler joinHandler = new JoinHandler(joinDTOList);
  AuthHandler authHandler = new AuthHandler(joinDTOList);


  // 함께해요 핸들러(기능)
  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler(); // 아직 List 변경 안함
  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler(orgVolRequestHandler); // 아직 List 변경 안함
  VolApprovedHandler volApprovedHandler = new VolApprovedHandler();
  VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);

  // 소통해요 핸들러(기능)
  CommBoardHandler commBoardHandler = new CommBoardHandler(commBoardDTOList);
  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  CommReviewHandler commReviewHandler = new CommReviewHandler(commReviewDTOList);
  //  CommHandler commHandler = new CommHandler(commBoardHandler,commBestHandler,commReviewHandler);

  //  // 챌린지 핸들러(기능)
  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler();
  // 챌린지 핸들러(기능)
  ChallengeListHandler challengeListHandler = new ChallengeListHandler();
  ChallengeBoardHandler challengeBoardHandler = new ChallengeBoardHandler();
  RankingHandler rankingHandler = new RankingHandler();
  ChallengeQuestionHandler challengeQuestionHandler = new ChallengeQuestionHandler(myChallengeQuestionDTOList);
  ChallengeReviewHandler challengeReviewHandler = new ChallengeReviewHandler(myChallengeReviewDTOList);

  // 모금함 관련 핸들러(기능)
  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler(donationRegisterDTOList);
  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationBoardDTOList, donationRegisterHandler);

  // 마이 페이지 핸들러(기능)
  // MyPageHandler myVolHandler = new MyPageHandler();
  QuestionListHandler questionListHandler = new QuestionListHandler(myQuestionListDTOList);
  NoticeListHandler noticeListHandler = new NoticeListHandler();
  MyBoardListHandler myBoardListHandler = new MyBoardListHandler();
  MyPointHandler myPointHandler = new MyPointHandler();
  MyDonationHandler myDonationHandler = new MyDonationHandler();
  ApproveOrgHandler approveOrgHandler = new ApproveOrgHandler(approveOrgDTOList);
  WithdrawMemberHandler withdrawMemberHandler = new WithdrawMemberHandler();

  // 고객센터 핸들러(기능)
  ShowNoticeHandler showNoticeHandler = new ShowNoticeHandler(); // 아직 List 변경 안함
  ShowQuestionHandler showQuestionHandler = new ShowQuestionHandler(questionDTOList);
  SupportHandler supportHandler = new SupportHandler(questionListHandler, noticeListHandler);

  // 관리자 페이지 핸들러(기능)
  ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler,orgVolRequestHandler);
  ShowDonationHandler showDonationHandler = new ShowDonationHandler(donationBoardHandler);
  ShowMemberHandler showMemberHandler = new ShowMemberHandler();
  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler(); // 아직 List 변경 안함
  ShowOrgApproveHandler showOrgApproveHandler = new ShowOrgApproveHandler();
  MyProfileHandler myProfileHandler = new MyProfileHandler(myProfileDTOList);
  //  AdminPageHandler adminPageHandler = new AdminPageHandler(personalVolRequestHandler,showVolHandler, donationBoardHandler, showDonationHandler); 


  public static void main(String[] args) {

    App app = new App(); 
    app.service();

  }
  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*행복하Share*");
    mainMenuGroup.setPrevMenuTitle("종료");



    mainMenuGroup.add(new Menu("로그인", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        authHandler.login(); 
      }});

    mainMenuGroup.add(new Menu("아이디찾기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        joinHandler.searchId(); 
      }});

    mainMenuGroup.add(new Menu("비밀번호찾기", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        joinHandler.searchPassword(); 
      }});

    mainMenuGroup.add(new Menu("회원가입", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        joinHandler.joinSite(); 
      }});


    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        authHandler.logout(); 
      }});


    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);

    doVolMenu.add(new Menu("개인봉사신청양식", Menu.ENABLE_PERSONAL) {
      @Override
      public void execute() {
        personalVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("기관봉사신청양식", Menu.ENABLE_ORG) {
      @Override
      public void execute() {
        orgVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("인증봉사리스트(일단 개인만)") {
      @Override
      public void execute() {
        personalVolRequestHandler.appliedList(); 
      }});
    doVolMenu.add(new Menu("인증봉사세부사항") {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});
    doVolMenu.add(new Menu("찜하기") {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});

    MenuGroup personalCommunityMenu = new MenuGroup("소통해요", Menu.ENABLE_ALL);
    mainMenuGroup.add(personalCommunityMenu);

    MenuGroup reviewMenu = new MenuGroup("나눔 이야기", Menu.ENABLE_ALL);
    personalCommunityMenu.add(reviewMenu);

    reviewMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commBoardHandler.add(); 
      }});
    reviewMenu.add(new Menu("목록", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        commBoardHandler.list(); 
      }});
    reviewMenu.add(new Menu("상세보기", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        commBoardHandler.detail(); 
      }});
    reviewMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commBoardHandler.update(); 
      }});
    reviewMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commBoardHandler.delete(); 
      }});

    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST", Menu.ENABLE_ALL);
    personalCommunityMenu.add(bestReviewMenu);

    bestReviewMenu.add(new Menu("목록", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        commBestHandler.showList(); 
      }});

    bestReviewMenu.add(new Menu("상세보기", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        commBestHandler.showDetail(); 
      }});

    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기", Menu.ENABLE_ALL);
    personalCommunityMenu.add(shortReviewMenu);

    shortReviewMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commReviewHandler.add(); 
      }});

    shortReviewMenu.add(new Menu("목록", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        commReviewHandler.list(); 
      }});

    shortReviewMenu.add(new Menu("수정", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commReviewHandler.update(); 
      }});

    shortReviewMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        commReviewHandler.delete(); 
      }});

    //
        MenuGroup personalChallengeMenu = new MenuGroup("챌린지", Menu.ENABLE_ALL);
        mainMenuGroup.add(personalChallengeMenu);
    
        MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지", Menu.ENABLE_ALL);
        personalChallengeMenu.add(monthlyChallengeMenu);
    
        MenuGroup monthlyChallengeDetail = new MenuGroup("챌린지 상세보기", Menu.ENABLE_ALL);
        monthlyChallengeMenu.add(monthlyChallengeDetail);
        
        monthlyChallengeDetail.add(new Menu("상세정보", Menu.ENABLE_ALL) {
          @Override
          public void execute() {
            challengeBoardHandler.showChallengeDetail(); 
          }});
        monthlyChallengeDetail.add(new Menu("참여하기", Menu.ENABLE_PERSONAL) {
          @Override
          public void execute() {
            challengeBoardHandler.join(); 
          }});
        monthlyChallengeDetail.add(new Menu("참여자 목록", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeBoardHandler.showMemberList(); 
            }});
        MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글", Menu.ENABLE_ALL);
        monthlyChallengeDetail.add(ChallengeReview);
        
        ChallengeReview.add(new Menu("참여인증&댓글 등록", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeReviewHandler.add(); 
            }});
        ChallengeReview.add(new Menu("참여인증&댓글 목록", Menu.ENABLE_ALL) {
            @Override
            public void execute() {
              challengeReviewHandler.list(); 
            }});
        ChallengeReview.add(new Menu("참여인증&댓글 상세보기", Menu.ENABLE_ALL) {
            @Override
            public void execute() {
              challengeReviewHandler.detail(); 
            }});
        ChallengeReview.add(new Menu("참여인증&댓글 수정", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeReviewHandler.update(); 
            }});
        ChallengeReview.add(new Menu("참여인증&댓글 삭제", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeReviewHandler.delete(); 
            }});
        
        MenuGroup ChallengeQuestion = new MenuGroup("문의하기", Menu.ENABLE_ALL);
        monthlyChallengeDetail.add(ChallengeQuestion);
        ChallengeQuestion.add(new Menu("문의 등록", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeQuestionHandler.add(); 
            }});
        ChallengeQuestion.add(new Menu("문의 목록", Menu.ENABLE_ALL) {
            @Override
            public void execute() {
              challengeQuestionHandler.list(); 
            }});
        ChallengeQuestion.add(new Menu("문의 상세보기", Menu.ENABLE_ALL) {
            @Override
            public void execute() {
              challengeQuestionHandler.detail(); 
            }});
        ChallengeQuestion.add(new Menu("문의 수정", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeQuestionHandler.update(); 
            }});
        ChallengeQuestion.add(new Menu("문의 삭제", Menu.ENABLE_LOGIN) {
            @Override
            public void execute() {
              challengeQuestionHandler.delete(); 
            }});
    
    
        MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹", Menu.ENABLE_ALL);
        personalChallengeMenu.add(monthlyRankingMenu);
    
    
        monthlyRankingMenu.add(new Menu("이달의 랭킹보기", Menu.ENABLE_ALL) {
          @Override
          public void execute() {
            rankingHandler.showTotalRanking(); 
          }});
    
        monthlyRankingMenu.add(new Menu("나의 랭킹보기", Menu.ENABLE_PERSONAL) {
          @Override
          public void execute() {
            rankingHandler.showMyRanking(); 
          }});

        
        
    MenuGroup personalDonationMenu = new MenuGroup("모금함");
    mainMenuGroup.add(personalDonationMenu);

    MenuGroup donationList = new MenuGroup("모금함 목록");
    personalDonationMenu.add(donationList);

    MenuGroup donation = new MenuGroup("모금함 상세보기");
    donationList.add(donation);

    donation.add(new Menu("기부하기") {
      @Override
      public void execute() {
        donationRegisterHandler.add(); 
      }});
    donation.add(new Menu("기부내역") {
      @Override
      public void execute() {
        donationRegisterHandler.applyDonationList(); 
      }});

    MenuGroup donationTotal = new MenuGroup("전체 모금액");
    personalDonationMenu.add(donationTotal);

    donationTotal.add(new Menu("총 기부내역") {
      @Override
      public void execute() {
        donationRegisterHandler.totalDonationMoney(); 
      }});

    MenuGroup applyDonation = new MenuGroup("모금함 개설신청");
    personalDonationMenu.add(applyDonation);

    applyDonation.add(new Menu("개설신청") {
      @Override
      public void execute() {
        donationBoardHandler.applyDonation(); 
      }});

    //
    MenuGroup support = new MenuGroup("고객센터");
    mainMenuGroup.add(support);
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
    //        MenuGroup ask = new MenuGroup("문의하기");
    //        support.add(ask);
    //    
    //        ask.add(new Menu("등록") {
    //          @Override
    //          public void execute() {
    //            boardHandler.addQuestionlist(); 
    //          }});
    //        ask.add(new Menu("목록") {
    //          @Override
    //          public void execute() {
    //            boardHandler.list(); 
    //          }});
    //        ask.add(new Menu("상세보기") {
    //          @Override
    //          public void execute() {
    //            boardHandler.detail(); 
    //          }});
    //        ask.add(new Menu("변경") {
    //          @Override
    //          public void execute() {
    //            boardHandler.finish(); 
    //          }});
    //        ask.add(new Menu("삭제") {
    //          @Override
    //          public void execute() {
    //            boardHandler.ask(); 
    //          }});
    //        //
    //    MenuGroup personalMyPage = new MenuGroup("마이페이지");
    //    personalMenu.add(personalMyPage);
    //    
    //    MenuGroup myProfile = new MenuGroup("회원정보수정");
    //    personalMyPage.add(myProfile);

    MenuGroup personalMyPage = new MenuGroup("마이페이지",Menu.ENABLE_MEMBER);
    mainMenuGroup.add(personalMyPage);

    MenuGroup myProfile = new MenuGroup("회원정보");
    personalMyPage.add(myProfile);

    myProfile.add(new Menu("내 정보") {
      @Override
      public void execute() {
        authHandler.displayUserInfo(); 
      }});
    myProfile.add(new Menu("내 정보 수정") {
      @Override
      public void execute() {
        authHandler.changeUserInfo(); 
      }});
    //
    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    personalMyPage.add(myVolunteer);
    //
    myVolunteer.add(new Menu("나의 봉사신청서 확인") {
      @Override
      public void execute() {
        personalVolRequestHandler.applyList(); 
      }});
    myVolunteer.add(new Menu("승인된 봉사내역") {
      @Override
      public void execute() {
        personalVolRequestHandler.appliedList(); 
      }});    
    myVolunteer.add(new Menu("찜한봉사") {
      @Override
      public void execute() {
        //        personalVolRequestHandler.showVolBookmark(); 
      }});    
    //
    //    MenuGroup myBoard = new MenuGroup("나의 게시글");
    //    personalMyPage.add(myBoard);
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////    

    MenuGroup adminMenu = new MenuGroup("관리자",  Menu.ENABLE_ADMIN);
    mainMenuGroup.add(adminMenu);

    MenuGroup memberMenu = new MenuGroup("회원정보 조회");
    adminMenu.add(memberMenu);
    //
    memberMenu.add(new Menu("회원목록") {
      @Override
      public void execute() {
        showMemberHandler.list(); 
      }});
    memberMenu.add(new Menu("회원추방") {
      @Override
      public void execute() {
        showMemberHandler.getOutMember(); 
      }});

    MenuGroup donationMenu = new MenuGroup("모금 관리");
    adminMenu.add(donationMenu);

    donationMenu.add(new Menu("모금활동관리") {
      @Override
      public void execute() {
        showDonationHandler.list(); 
      }});

    MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new Menu("개인봉사신청내역") {
      @Override
      public void execute() {
        personalVolRequestHandler.applyList(); 
      }});
    volunteerMenu.add(new Menu("기관봉사신청내역") {
      @Override
      public void execute() {
        orgVolRequestHandler.applyList(); 
      }});
    volunteerMenu.add(new Menu("개인봉사승인하기") {
      @Override
      public void execute() {
        personalVolRequestHandler.acceptApply(); 
      }});
    volunteerMenu.add(new Menu("기관봉사승인하기") {
      @Override
      public void execute() {
        orgVolRequestHandler.acceptApply(); 
      }});
    volunteerMenu.add(new Menu("개인봉사반려하기") {
      @Override
      public void execute() {
        personalVolRequestHandler.rejectApply(); 
      }});
    volunteerMenu.add(new Menu("기관봉사반려하기") {
      @Override
      public void execute() {
        orgVolRequestHandler.rejectApply(); 
      }});

    MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new Menu("공지사항 등록") {
      @Override
      public void execute() {
        showNoticeHandler.add(); 
      }});
    noticeMenu.add(new Menu("공지사항 목록") {
      @Override
      public void execute() {
        showNoticeHandler.list(); 
      }});
    noticeMenu.add(new Menu("공지사항 상세보기") {
      @Override
      public void execute() {
        showNoticeHandler.detail(); 
      }});
    noticeMenu.add(new Menu("공지사항 변경") {
      @Override
      public void execute() {
        showNoticeHandler.update(); 
      }});
    noticeMenu.add(new Menu("공지사항 삭제") {
      @Override
      public void execute() {
        showNoticeHandler.delete(); 
      }});

    MenuGroup askInfo = new MenuGroup("문의사항 관리");
    adminMenu.add(askInfo);

    askInfo.add(new Menu("문의사항 등록") {
      @Override
      public void execute() {
        showQuestionHandler.addreply(); 
      }});
    askInfo.add(new Menu("문의사항 목록") {
      @Override
      public void execute() {
        showQuestionHandler.list(); 
      }});
    askInfo.add(new Menu("문의사항 상세보기") {
      @Override
      public void execute() {
        showQuestionHandler.detail(); 
      }});
    askInfo.add(new Menu("문의사항 변경") {
      @Override
      public void execute() {
        showQuestionHandler.update(); 
      }});
    askInfo.add(new Menu("문의사항 삭제") {
      @Override
      public void execute() {
        showQuestionHandler.delete(); 
      }});

    //    MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
    //    adminMenu.add(challengeInfo);
    //
    //    challengeInfo.add(new Menu("챌린지 등록") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.add(); 
    //      }});
    //    challengeInfo.add(new Menu("챌린지 목록") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.list(); 
    //      }});
    //    challengeInfo.add(new Menu("챌린지 상세보기") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.detail(); 
    //      }});
    //    challengeInfo.add(new Menu("챌린지 변경") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.update(); 
    //      }});
    //    challengeInfo.add(new Menu("챌린지 삭제") {
    //      @Override
    //      public void execute() {
    //        showChallengeHandler.delete(); 
    //      }});

    MenuGroup approveInfo = new MenuGroup("기관 승인");
    adminMenu.add(approveInfo);

    approveInfo.add(new Menu("기관승인신청 목록") {
      @Override
      public void execute() {
        showOrgApproveHandler.list(); 
      }});
    approveInfo.add(new Menu("기관승인신청 내용") {
      @Override
      public void execute() {
        showOrgApproveHandler.detail(); 
      }});
    approveInfo.add(new Menu("기관승인신청 변경") {
      @Override
      public void execute() {
        showOrgApproveHandler.update(); 
      }});
    approveInfo.add(new Menu("기관승인신청 삭제") {
      @Override
      public void execute() {
        showOrgApproveHandler.delete(); 
      }});

    return mainMenuGroup;
  }
}





