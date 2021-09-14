package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.admin.AdminChallengeAddHandler;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeSearchHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.admin.AdminQuestionDeleteHandler;
import com.share.ftp.handler.admin.AdminQuestionDetailHandler;
import com.share.ftp.handler.admin.AdminQuestionListHandler;
import com.share.ftp.handler.admin.AdminQuestionUpdateHandler;
import com.share.ftp.handler.join.AuthChangeUserInfoHandler;
import com.share.ftp.handler.join.AuthDisplayUserInfoHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.MyPageDelete;
import com.share.ftp.handler.join.MyPageInfoHandler;
import com.share.ftp.handler.org.MyVolApplyListHandler;
import com.share.ftp.handler.org.MyVolApproveListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.MyRankingHandler;
import com.share.ftp.handler.personal.challenge.RankingHandler;
import com.share.ftp.handler.personal.community.CommBestDetailHandler;
import com.share.ftp.handler.personal.community.CommBestListHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardSearchHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDeleteHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDetailHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolDetailHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyRejectedVolHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAcceptHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyCompleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestBookmarkHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralTotalApprovedListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {

  // 회원가입 도메인(값)
  List<JoinDTO> joinDTOList = new ArrayList<>();
  //  List<JoinDTO> members = new ArrayList<>();
  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // 개인, 기관 공통 도메인
  //  List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> personalRequestApplyDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> personalRequestRejectDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> orgRequestDTOApplyList = new ArrayList<>();
  //  List<GeneralRequestDTO> orgRequestDTORejectList = new ArrayList<>();

  // 개인 봉사신청 관련 도메인
  List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestApplyDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestRejectDTOList = new ArrayList<>();

  // 기관 봉사신청 관련 도메인
  //  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();
  //  List<OrgRequestDTO> orgRequestApplyDTOList = new ArrayList<>();
  //  List<OrgRequestDTO> orgRequestRejectDTOList = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();

  // 챌린지 도메인(값)
  List<ChallengeJoinDTO> myChallengeJoinDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> myChallengeQuestionDTOList = new ArrayList<>();
  List<ChallengeReviewDTO> myChallengeReviewDTOList = new ArrayList<>();

  // 모금함 개설 신청 관련 도메인(값)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardApplyDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardRejectDTOList = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationMyRegisterDTOList;

  // 마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();

  // 관리자 도메인(값)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();
  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  // 메뉴 객체 컨트롤(Map)
  HashMap<String,Command> commands = new HashMap<>();

  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      command.execute();
    }
  }

  // 전체 봉사보기 Handler 

  VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler = 
      new VolGeneralRequestAppliedListHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //  VolRequestOrgAppliedListHandler volRequestOrgAppliedListHandler = 
  //      new VolRequestOrgAppliedListHandler
  //      (orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);

  GeneralRequestDTO personalRequestDTO = new GeneralRequestDTO();

  VolGeneralDoJoinHandler volRequestPersonalAppliedListDetailHandler =
      new VolGeneralDoJoinHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //  VolRequestOrgAppliedListDetailHandler volRequestOrgAppliedListDetailHandler =
  //      new VolRequestOrgAppliedListDetailHandler
  //      (orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);



  // 함께해요 봉사 세부사항 Handler

  VolGeneralTotalApprovedListHandler volRequestTotalApprovedListHandler =
      new VolGeneralTotalApprovedListHandler
      (volGeneralRequestAppliedListHandler);

  //봉사참여자목록
  VolGeneralDoJoinListHandler volDoJoinHandler = 
      new VolGeneralDoJoinListHandler
      (generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler);



  // 모금함 개설 승인된 목록 Handler
  DonationBoardAppliedListHandler donationBoardAppliedListHandler =
      new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);

  DonationPrompt donationPrompt = new DonationPrompt(donationBoardDTOList, donationRegisterDTOList);


  //  DonationRegisterParticipationListHandler donationRegisterParticipationListHandler = new DonationRegisterParticipationListHandler(donationRegisterDTOList, donationBoardDTOList);

  public static void main(String[] args) {

    App app = new App(); 
    app.service();
  }

  public App() {
    //로그인, 로그아웃
    commands.put("/auth/login", new AuthLoginHandler(joinDTOList)); // 로그인
    commands.put("/auth/logout", new AuthLogoutHandler()); // 로그아웃
    commands.put("/auth/changeUserInfo", new AuthChangeUserInfoHandler()); // 마이페이지 나의정보
    commands.put("/auth/displayUserInfo", new AuthDisplayUserInfoHandler()); // 마이페이지 나의정보수정

    //회원가입
    commands.put("/join/add", new JoinAddHandler(joinDTOList)); // 회원가입
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(joinDTOList)); // 폰번호로 아이디 찾기
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(joinDTOList)); // 이메일로 아이디 찾기
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(joinDTOList)); // 비밀번호 찾기

    //함께해요 (개인) + 마이페이지
    commands.put("/volRequestPersonal/apply", new VolGeneralRequestApplyHandler(generalRequestDTOList,joinDTOList));
    commands.put("/volRequestPersonal/applyList", new VolGeneralRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volRequestPersonal/applyCompleteList", new VolGeneralRequestApplyCompleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/acceptApply", new VolGeneralRequestAcceptHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectApply", new VolGeneralRequestRejectHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/appliedList", new VolGeneralRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectedList", new VolGeneralRequestRejectedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/delete", new VolGeneralRequestDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequestPersonal/bookmark", new VolGeneralRequestBookmarkHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volGeneralRequestAppliedListHandler));
    commands.put("/volDoJoinPersonal/add", new VolGeneralDoJoinHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volDoJoin/list", new VolGeneralDoJoinListHandler(generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler));
    commands.put("/volRequest/delete", new VolGeneralDoJoinDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    //함께해요 (기관) + 마이페이지
    //    commands.put("/volRequestOrg/apply", new VolRequestOrgApplyHandler(orgRequestDTOList,joinDTOList));
    //    commands.put("/volRequestOrg/applyList", new VolRequestOrgApplyListHandler(orgRequestDTOList));
    //    commands.put("/volRequestOrg/applyCompleteList", new VolRequestOrgApplyCompleteListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/acceptApply", new VolRequestOrgAcceptApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectApply", new VolRequestOrgRejectApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/appliedList", new VolRequestOrgAppliedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectedList", new VolRequestOrgRejectedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));

    // 소통해요 나눔이야기
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList));
    commands.put("/commBoard/search", new CommBoardSearchHandler(commBoardDTOList));

    // 소통해요 나눔이야기 BEST
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    // 소통해요 한줄후기
    commands.put("/commReview/add", new CommReviewAddHandler(commReviewDTOList));
    commands.put("/commReview/list", new CommReviewListHandler(commReviewDTOList));
    commands.put("/commReview/update", new CommReviewUpdateHandler(commReviewDTOList));
    commands.put("/commReview/delete", new CommReviewDeleteHandler(commReviewDTOList));

    // 챌린지
    commands.put("adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));  // 챌린지 상세정보
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(myChallengeJoinDTOList));  // 참여하기(구현중..)
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(myChallengeJoinDTOList));  // 참여자목록(구현중..)

    // 챌린지 참여인증&댓글
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(myChallengeReviewDTOList));

    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(myChallengeQuestionDTOList));

    // 챌린지 랭킹
    commands.put("/ranking/list", new RankingHandler());  //전체랭킹(구현예정)
    commands.put("/myRanking/list", new MyRankingHandler()); //나의랭킹(구현예정)

    // 모금함 (개설신청하기, 개설목록, 승인, 반려)
    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardAppliedListHandler));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDTOList, joinDTOList));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDTOList));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDTOList, donationRegisterDTOList, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDTOList, donationRegisterDTOList, donationPrompt));

    // 모금함 (기부하기)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDTOList, joinDTOList, donationBoardDTOList));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDTOList));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDTOList));

    //    // 고객센터 공지사항 (개인+ 관리자)
    //    commands.put("/notice/add", new NoticeAddHandler(noticeDTOList));
    //    commands.put("/notice/list", new NoitceListHandler(noticeDTOList));
    //    commands.put("/notice/detail", new NoticeDetailHandler(noticeDTOList));
    //    commands.put("/notice/update", new NoticeUpdateHandler(noticeDTOList));
    //    commands.put("/notice/delete", new NoticeDeleteHandler(noticeDTOList));
    //    commands.put("/notice/search", new NoticeSearchHandler(noticeDTOList));

    // 고객센터 문의사항
    commands.put("/question/add", new QuestionAddHandler(myQuestionListDTOList));
    commands.put("/question/list", new QuestionListHandler(myQuestionListDTOList));
    commands.put("/question/detail", new QuestionDetailHandler(myQuestionListDTOList));
    commands.put("/question/update", new QuestionUpdateHandler(myQuestionListDTOList));
    commands.put("/question/delete", new QuestionDeleteHandler(myQuestionListDTOList));
    commands.put("/question/search", new QuestionDeleteHandler(myQuestionListDTOList));

    // 마이페이지
    commands.put("/myPage/info", new MyPageInfoHandler(joinDTOList)); // 내정보 수정
    commands.put("/myPage/delete", new MyPageDelete(joinDTOList)); // 회원탈퇴

    commands.put("/myPersonal/applied", new MyAppliedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myPersonal/appliedDetail", new MyAppliedVolDetailHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myPersonal/rejected", new MyRejectedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));


    commands.put("/myBoard/list", new MyBoardListHandler()); // 나의게시글 목록
    commands.put("/myBoard/detail", new MyBoardDetailHandler()); // 나의게시글 목록
    commands.put("/myBoard/update", new MyBoardUpdateHandler()); // 나의게시글 목록
    commands.put("/myBoard/delete", new MyBoardDeleteHandler()); // 나의게시글 목록

    commands.put("myPoint/list", new MyPointHandler()); // 나의포인트 

    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // 기관 마이페이지 승인신청 
    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // 기관 마이페이지 승인조회
    commands.put("/myDonation/list", new MyDonationHandler()); // 모금함
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDTOList, donationMyRegisterDTOList)); // 모금함
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));

    // 관리자

    // 관리자 회원정보 조회
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // 관리자가 회원 목록을 조회
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // 가입회원 상세보기 (관리자연결)
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // 관리자 공지사항 관리
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDTOList));

    // 관리자 문의사항
    commands.put("/adminAsk/add", new AdminQuestionAddHandler(questionDTOList));
    commands.put("/adminAsk/list", new AdminQuestionListHandler(questionDTOList));
    commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(questionDTOList));
    commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(questionDTOList));
    commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(questionDTOList));

    // 관리자 챌린지
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(challengeDTOList));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDTOList));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDTOList));


    // 관리자 기관승인


  }


  public void service() {

    loadJoins();
    //
    //    loadPersonalRequest();
    //    loadPersonalRequestApply();
    //    loadPersonalRequestReject();
    //
    //    loadOrgRequest();
    //    loadOrgRequestApply();
    //    loadOrgRequestReject();
    //
    //    loadCommBoard();
    //    loadCommReview();
    //
    //    loadAdminChellengeAdd();
    //
    //    loadChallengeReviews();
    //    loadChallengeQuestions();
    //
    //    loadDonationBoards();
    //    loadDonationRegisters();
    //
    //    loadQuestion();

    createMenu().execute();
    Prompt.close();

    saveJoins();

    savePersonalRequest();
    savePersonalRequestApply();
    savePersonalRequestReject();

    //    saveOrgRequest();
    //    saveOrgRequestApply();
    //    saveOrgRequestReject();

    saveCommBoard();
    saveCommReview();


    saveAdminChellengeAdd();

    saveDonationBoards();
    saveDonationRegisters();
    saveDonationBoards();
    saveDonationRegisters();

    saveQuestion();

    saveChallengeReviews();
    saveChallengeQuestions();

    saveDonationBoards();
    saveDonationRegisters();

  }

  @SuppressWarnings("unchecked")
  private void loadPersonalRequest() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("personalRequest.data"))) {

      generalRequestDTOList.addAll((List<GeneralRequestDTO>) in.readObject());

      System.out.println("봉사 신청서 로딩 완료!");

    } catch (Exception e) {
      System.out.println("봉사 신청서를 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }


  private void savePersonalRequest() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("personalRequest.data"))) {



      out.writeObject(generalRequestDTOList);

      System.out.println("봉사 신청서 저장 완료!");

    } catch (Exception e) {
      System.out.println("봉사 신청서 저장 중 오류 발생!");
      e.printStackTrace();
    }

  }

  @SuppressWarnings("unchecked")
  private void loadPersonalRequestApply() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("personalRequestApply.data"))) {

      generalRequestApplyDTOList.addAll((List<GeneralRequestDTO>) in.readObject());

      System.out.println("봉사 승인 로딩 완료!");

    } catch (Exception e) {
      System.out.println("봉사 승인 신청서를 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }


  }

  private void savePersonalRequestApply() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("personalRequestApply.data"))) {

      out.writeObject(generalRequestApplyDTOList);

      System.out.println("봉사 승인 저장 완료!");

    } catch (Exception e) {
      System.out.println("봉사 승인 신청서 저장 중 오류 발생!");
      e.printStackTrace();
    }

  }

  @SuppressWarnings("unchecked")
  private void loadPersonalRequestReject() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("personalRequestReject.data"))) {

      generalRequestRejectDTOList.addAll((List<GeneralRequestDTO>) in.readObject());

      System.out.println("봉사 반려 신청서 로딩 완료!");

    } catch (Exception e) {
      System.out.println("봉사 반려 신청서를 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }

  }

  private void savePersonalRequestReject() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("personalRequestReject.data"))) {

      out.writeObject(generalRequestRejectDTOList);

      System.out.println("봉사 반려 신청서 저장 완료!");

    } catch (Exception e) {
      System.out.println("봉사 반려 신청서 저장 중 오류 발생!");
      e.printStackTrace();
    }

  }

  @SuppressWarnings("unchecked")

  private void loadCommBoard() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("commBoard"))) {

      commBoardDTOList.addAll((List<CommBoardDTO>) in.readObject());

      System.out.println("나눔이야기 로딩 완료!");

    } catch (Exception e) {
      System.out.println("나눔이야기 읽어 오는 중 오류 발생!");
    }
  }

  private void saveCommBoard() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("commBoard"))) {

      out.writeObject(commBoardDTOList);

      System.out.println("나눔이야기 저장 완료!");

    } catch (Exception e) {
      System.out.println("나눔이야기 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")

  private void loadCommReview() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("commReview"))) {

      commReviewDTOList.addAll((List<CommReviewDTO>) in.readObject());

      System.out.println("게시글 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 게시글을 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }


  private void saveCommReview() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("commReview"))) {

      out.writeObject(commReviewDTOList);

      System.out.println("한줄후기 저장 완료!");

    } catch (Exception e) {
      System.out.println("한줄후기 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }


  @SuppressWarnings({"unchecked"})

  private void loadAdminChellengeAdd() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("monthlychallenge.data"))) {

      challengeDTOList.addAll((List<ChallengeDTO>) in.readObject());

      System.out.println("이달의 챌린지 로딩 완료!");

    } catch (Exception e) {
      System.out.println("이달의 챌린지 읽어 오는 중 오류 발생!");
    }
  }

  private void saveAdminChellengeAdd() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("monthlychallenge.data"))) {

      out.writeObject(challengeDTOList);

      System.out.println("이달의 챌린지 저장 완료!");

    } catch (Exception e) {
      System.out.println("이달의 챌린지 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }


  @SuppressWarnings("unchecked")
  private void loadChallengeReviews() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("myChallengeReview.data"))) {

      myChallengeReviewDTOList.addAll((List<ChallengeReviewDTO>) in.readObject());

      System.out.println("참여인증&댓글 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 참여인증&댓글을 읽어오는 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void saveChallengeReviews() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("myChallengeReview.data"))) {

      out.writeObject(myChallengeReviewDTOList);

      System.out.println("참여인증&댓글 저장 완료!");

    } catch (Exception e) {
      System.out.println("참여인증&댓글을 파일에 저장 중 오류 발생!");
    }
  }

  @SuppressWarnings("unchecked")
  private void loadChallengeQuestions() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("myChallengeQuestion.data"))) {

      myChallengeQuestionDTOList.addAll((List<ChallengeQuestionDTO>) in.readObject());

      System.out.println("챌린지 문의글 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 챌린지 문의글을 읽어오는 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void saveChallengeQuestions() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("myChallengeQuestion.data"))) {

      out.writeObject(myChallengeQuestionDTOList);

      System.out.println("챌린지 문의글 저장 완료!");

    } catch (Exception e) {
      System.out.println("챌린지 문의글을 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }


  @SuppressWarnings("unchecked")
  private void loadDonationBoards() {
    try (
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("donationBoard.data"))) {

      donationBoardDTOList.addAll((List<DonationBoardDTO>) in.readObject());

      System.out.println("모금함 개설 등록 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 모금함 개설 등록 파일을 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }



  private void saveDonationBoards() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("donationBoard.data"))) {

      out.writeObject(donationBoardDTOList);

      System.out.println("모금함 개설등록 저장 완료!");

    } catch (Exception e) {
      System.out.println("모금함 개설 등록을 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }


  @SuppressWarnings("unchecked")
  private void loadDonationRegisters() {
    try (
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("donationRegister.data"))) {

      donationRegisterDTOList.addAll((List<DonationRegisterDTO>) in.readObject());

      System.out.println("모금함 기부하기 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 모금함 기부하기 파일을 읽어 오는 중 오류 발생!");

      e.printStackTrace();
    }
  }

  private void saveDonationRegisters() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("donationRegister.data"))) {

      out.writeObject(donationRegisterDTOList);

      System.out.println("모금함 기부하기 저장 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 모금함 기부하기 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadJoins() {
    try (
        ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("join.data"))) {

      joinDTOList.addAll((List<JoinDTO>) in.readObject());

      System.out.println("----------------------------------");

      System.out.println("확인용!");
      for (int i = 0; i < joinDTOList.size(); i++) {

        System.out.println("인덱스 i  = " + i);
        System.out.println("각 사용자의 no = "+ joinDTOList.get(i).getNo());

      }
      System.out.println("joinDTOList.size()  = " + joinDTOList.size());

      System.out.println("----------------------------------");

      System.out.println("회원가입 로딩 완료!");

    } catch (Exception e) {
      System.out.println("회원가입 파일을 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void saveJoins() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("join.data"))) {
      System.out.println(joinDTOList);
      out.writeObject(joinDTOList);

      System.out.println("회원정보 저장 완료!");

    } catch (Exception e) {
      System.out.println("회원정보 파일에 저장 중 오류 발생!");

      e.printStackTrace();
    }
  }

  //  @SuppressWarnings("unchecked")
  //  private void loadOrgRequest() {
  //    try (ObjectInputStream in = new ObjectInputStream(
  //        new FileInputStream("orgRequest.data"))) {
  //
  //      orgRequestDTOList.addAll((List<OrgRequestDTO>) in.readObject());
  //
  //      System.out.println("기관봉사 신청서 로딩 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("봉사신청서를 읽어 오는 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }
  //
  //
  //  private void saveOrgRequest() {
  //    try (ObjectOutputStream out = new ObjectOutputStream(
  //        new FileOutputStream("orgRequest.data"))) {
  //
  //      out.writeObject(orgRequestDTOList);
  //
  //      System.out.println("기관 신청서 저장 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("봉사 신청서 저장 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }
  //
  //  @SuppressWarnings("unchecked")
  //  private void loadOrgRequestApply() {
  //    try (ObjectInputStream in = new ObjectInputStream(
  //        new FileInputStream("orgRequestApply.data"))) {
  //
  //      orgRequestApplyDTOList.addAll((List<OrgRequestDTO>) in.readObject());
  //
  //      System.out.println("기관봉사 승인 신청서 로딩 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("기관봉사 승인 신청서를 읽어 오는 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }
  //
  //  private void saveOrgRequestApply() {
  //    try (ObjectOutputStream out = new ObjectOutputStream(
  //        new FileOutputStream("orgRequestApply.data"))) {
  //
  //      out.writeObject(orgRequestApplyDTOList);
  //
  //      System.out.println("기관봉사 승인 신청서 저장 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("기관봉사 승인 신청서 저장 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }
  //
  //  @SuppressWarnings("unchecked")
  //  private void loadOrgRequestReject() {
  //    try (ObjectInputStream in = new ObjectInputStream(
  //        new FileInputStream("orgRequestReject.data"))) {
  //
  //      orgRequestRejectDTOList.addAll((List<OrgRequestDTO>) in.readObject());
  //
  //      System.out.println("기관봉사 반려 신청서 로딩 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("봉사 반려 신청서를 읽어 오는 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }
  //
  //  private void saveOrgRequestReject() {
  //    try (ObjectOutputStream out = new ObjectOutputStream(
  //        new FileOutputStream("orgRequestReject.data"))) {
  //
  //      out.writeObject(orgRequestRejectDTOList);
  //
  //      System.out.println("기관봉사 반려 신청서 저장 완료!");
  //
  //    } catch (Exception e) {
  //      System.out.println("기관봉사 반려 신청서 저장 중 오류 발생!");
  //      e.printStackTrace();
  //    }
  //
  //  }



  @SuppressWarnings("unchecked")
  private void loadQuestion() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("question.data"))) {

      myQuestionListDTOList.addAll((List<QuestionListDTO>) in.readObject());

      System.out.println("게시글 데이터 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 게시글 데이터를 읽어 오는 중 오류 발생!");

    }
  }


  private void saveQuestion() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("question.data"))) {

      out.writeObject(myQuestionListDTOList);

      System.out.println("게시글 데이터 저장 완료!");

    } catch (Exception e) {
      System.out.println("게시글 데이터를 파일에 저장 중 오류 발생!");
    }
  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*행복하Share*");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("아이디찾기", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);
    searchId.add(new MenuItem("휴대폰번호로아이디찾기", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("이메일로아이디찾기", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("비밀번호찾기", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_MEMBER_ADMIN, "/auth/logout"));


    // 함께해요
    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);


    doVolMenu.add(new MenuItem("개인봉사신청양식(개인주최자)", ACCESS_PERSONAL, "/volRequestPersonal/apply"));
    doVolMenu.add(new MenuItem("기관봉사신청양식", ACCESS_ORG, "/volRequestOrg/apply")); 
    doVolMenu.add(new MenuItem("전체인증봉사리스트","/volRequest/totalApprovedList")); 
    doVolMenu.add(createVolJoinMenu()); // 봉사 참여하기
    doVolMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

    // 소통해요
    MenuGroup CommunityMenu = new MenuGroup("소통해요");
    mainMenuGroup.add(CommunityMenu);

    CommunityMenu.add(createReviewMenu());      // 나눔이야기
    CommunityMenu.add(createBestReviewMenu());  // 나눔이야기BEST
    CommunityMenu.add(createShortReviewMenu()); // 한줄후기

    // 챌린지
    MenuGroup challengeMenu = new MenuGroup("챌린지");
    mainMenuGroup.add(challengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    challengeMenu.add(monthlyChallengeMenu);

    //    MenuGroup challengeListMenu = new MenuGroup("챌린지 목록");
    //    monthlyChallengeMenu.add(challengeListMenu);

    MenuGroup challengeDetailMenu = new MenuGroup("챌린지 상세보기");
    monthlyChallengeMenu.add(challengeDetailMenu); 

    //    MenuGroup showChallengeDetailHandler = new MenuGroup("상세정보");  // 구현예정
    //    challengeDetailMenu.add(showChallengeDetailHandler);

    challengeDetailMenu.add(new MenuItem("상세정보", "adminChallenge/detail"));

    challengeDetailMenu.add(new MenuItem("참여하기", ACCESS_MEMBER, "/challengeJoin/join"));

    challengeDetailMenu.add(new MenuItem("참여자 목록", ACCESS_MEMBER, "/challengeJoin/list"));

    challengeDetailMenu.add(createChallengeReviewMenu()); // 참여인증&댓글
    challengeDetailMenu.add(createChallengeQuestionMenu()); // 문의하기

    challengeMenu.add(createMonthlyRankingMenu()); // 이달의 랭킹


    // 모금함
    MenuGroup DonationMenu = new MenuGroup("모금함");
    mainMenuGroup.add(DonationMenu);

    DonationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
    DonationMenu.add(new MenuItem("모금함 개설신청", ACCESS_ORG, "/donationBoard/apply"));

    MenuGroup doDonationListMenu = new MenuGroup("모금함목록");
    DonationMenu.add(new MenuItem("모금함목록","/donationBoard/list"));

    doDonationListMenu.add(new MenuItem("모금함 상세보기", "/donationBoard/applyDetail"));
    doDonationListMenu.add(new MenuItem("기부하기", ACCESS_MEMBER, "/donationRegister/add"));
    doDonationListMenu.add(new MenuItem("참여내역", "/donationRegister/participation"));

    DonationMenu.add(createDonationDetailMenu()); // 모금함 상세보기

    // 고객센터
    MenuGroup supportMenu = new MenuGroup("고객센터");
    mainMenuGroup.add(supportMenu);

    supportMenu.add(createAdminNoticeMenu());      // 공지사항
    supportMenu.add(createAskMenu());         // 문의하기

    // 마이페이지
    MenuGroup MyPageMenu = new MenuGroup("마이페이지", ACCESS_MEMBER);
    mainMenuGroup.add(MyPageMenu);
    MyPageMenu.add(createMyProfileMenu());    // 회원정보
    MyPageMenu.add(createMyVolunteerMenu());  // 나의봉사
    MyPageMenu.add(createMyBoardMenu());      // 나의게시글
    MyPageMenu.add(createMyPointMenu());      // 나의포인트
    MyPageMenu.add(createMyDonationMenu());   // 나의모금함
    MyPageMenu.add(createOrgApprovewMenu());  // 기관승인신청
    MyPageMenu.add(new MenuItem("탈퇴", ACCESS_MEMBER, "/myPage/delete")); 

    // 관리자
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    mainMenuGroup.add(adminMenu);

    adminMenu.add(createAdminMemberMenu());      // 회원관리
    adminMenu.add(createAdminDonationMenu());    // 기부관리
    adminMenu.add(createAdminVolMenu());         // 봉사관리
    adminMenu.add(createAdminNoticeMenu());      // 공지사항관리
    // 관리자 공지사항 관리 => 회원 createNoticeMenu 부분과 기능 겹침. 삭제 고려
    adminMenu.add(createAdminAskMenu());         // 문의사항관리
    adminMenu.add(createAdminChallengeMenu());   // 챌린지관리
    adminMenu.add(createAdminApproveInfoMenu()); // 기관승인관리

    return mainMenuGroup;
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////



  private Menu createVolJoinMenu() {
    MenuGroup volJoinMenu = new MenuGroup("봉사참여하기");

    volJoinMenu.add(new MenuItem("개인봉사참여","/volDoJoinPersonal/add")); 
    volJoinMenu.add(new MenuItem("기관봉사참여","/volRequest/totalApprovedList")); 
    volJoinMenu.add(new MenuItem("참여자정보보기","/volDoJoin/list")); 
    volJoinMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정
    volJoinMenu.add(createVolReviewMenu());
    volJoinMenu.add(createVolQuestionMenu()); 

    return volJoinMenu;
  }


  private Menu createVolReviewMenu() {
    MenuGroup volReview = new MenuGroup("참여인증&댓글");
    volReview.add(new MenuItem("봉사 참여인증 등록", ACCESS_MEMBER, "/volJoinReview/add"));
    volReview.add(new MenuItem("봉사 참여인증 목록", "/volJoinReview/list"));
    volReview.add(new MenuItem("봉사 참여인증 수정", ACCESS_MEMBER,"/volJoinReview/update"));
    volReview.add(new MenuItem("봉사 참여인증 삭제", ACCESS_MEMBER,"/volJoinReview/delete"));
    volReview.add(new MenuItem("봉사 참여인증 검색", "/volJoinReview/search"));

    return volReview;
  }


  private Menu createVolQuestionMenu() {
    MenuGroup VolQuestion = new MenuGroup("문의하기");

    VolQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/volQuestion/add"));
    VolQuestion.add(new MenuItem("문의 목록",  "/volQuestion/list"));
    VolQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/volQuestion/detail"));
    VolQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/volQuestion/update"));
    VolQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/volQuestion/delete"));
    VolQuestion.add(new MenuItem("문의 검색",  "/volQuestion/search"));

    return VolQuestion;
  }





  private Menu createReviewMenu() {
    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");

    reviewMenu.add(new MenuItem("등록", ACCESS_MEMBER, "/commBoard/add"));
    reviewMenu.add(new MenuItem("목록","/commBoard/list"));
    reviewMenu.add(new MenuItem("상세보기","/commBoard/detail"));
    reviewMenu.add(new MenuItem("변경", ACCESS_MEMBER,"/commBoard/update"));
    reviewMenu.add(new MenuItem("삭제",ACCESS_MEMBER,"/commBoard/delete"));
    reviewMenu.add(new MenuItem("검색",ACCESS_MEMBER,"/commBoard/search"));

    return reviewMenu;
  }

  private Menu createBestReviewMenu() {
    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");

    bestReviewMenu.add(new MenuItem("목록","/commBest/list"));
    bestReviewMenu.add(new MenuItem("상세보기","/commBest/detail"));

    return bestReviewMenu;
  }

  private Menu createShortReviewMenu() {
    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");

    shortReviewMenu.add(new MenuItem("등록", ACCESS_MEMBER, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("목록", "/commReview/list")); 
    shortReviewMenu.add(new MenuItem("수정", ACCESS_MEMBER, "/commReview/update")); 
    shortReviewMenu.add(new MenuItem("삭제", ACCESS_MEMBER, "/commReview/delete")); 
    shortReviewMenu.add(new MenuItem("검색",ACCESS_MEMBER,"/commReview/search"));


    return shortReviewMenu;
  }


  private Menu createChallengeReviewMenu() {
    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", ACCESS_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", "/challengeReview/list"));
    //    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", ACCESS_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", ACCESS_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", ACCESS_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", "/challengeReview/search"));

    return ChallengeReview;
  }



  private Menu createChallengeQuestionMenu() {
    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
    ChallengeQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));

    return ChallengeQuestion;
  }



  private Menu createMonthlyRankingMenu() {
    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)

    return monthlyRankingMenu;
  }


  private Menu createDonationDetailMenu() {
    MenuGroup doDonationMenu = new MenuGroup("모금함 상세보기");
    doDonationMenu.add(new MenuItem("모금함 상세보기", "/donationBoard/applyDetail"));
    doDonationMenu.add(new MenuItem("기부하기", ACCESS_MEMBER, "/donationRegister/add"));
    doDonationMenu.add(new MenuItem("참여내역", "/donationRegister/participation"));

    return doDonationMenu;
  }




  //  private Menu createNoticeMenu() {
  //    MenuGroup notice = new MenuGroup("공지사항");
  //    //    notice.add(new MenuItem("등록",ACCESS_ADMIN,"/notice/add"));
  //    notice.add(new MenuItem("목록", "/adminNotice/list"));
  //    notice.add(new MenuItem("상세보기", "/adminNotice/detail"));
  //    notice.add(new MenuItem("목록", "/notice/list"));
  //    notice.add(new MenuItem("상세보기", "/notice/detail"));
  //    //    notice.add(new MenuItem("변경",ACCESS_ADMIN,"/notice/update"));
  //    //    notice.add(new MenuItem("삭제",ACCESS_ADMIN, "/notice/delete"));
  //    notice.add(new MenuItem("검색", "/notice/search"));
  //
  //    return notice;
  //  }

  private Menu createAskMenu() {
    MenuGroup ask = new MenuGroup("문의하기");
    ask.add(new MenuItem("등록", ACCESS_MEMBER,"/question/add"));
    ask.add(new MenuItem("목록", "/question/list"));
    ask.add(new MenuItem("상세보기", "/question/detail"));
    ask.add(new MenuItem("변경",ACCESS_MEMBER,"/question/update"));
    ask.add(new MenuItem("삭제",Menu.ACCESS_MEMBER, "/question/delete"));
    ask.add(new MenuItem("검색", "question/search"));

    return ask;
  }

  // 마이페이지

  private Menu createMyProfileMenu() {
    MenuGroup myProfile = new MenuGroup("회원정보", ACCESS_MEMBER);
    myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("내 정보 수정", "/auth/changeUserInfo"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("나의 봉사");

    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_PERSONAL,"/myPersonal/appliedDetail")); 
    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_ORG,"/volRequestOrg/applyCompleteList")); // 보완필요
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_PERSONAL,"/myPersonal/applied"));    
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_ORG,"/volRequestOrg/appliedList"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_PERSONAL,"/myPersonal/rejected"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_ORG,"/volRequestOrg/rejectedList"));    
    myVolunteer.add(new MenuItem("개인봉사 삭제",ACCESS_PERSONAL,"/volRequestPersonal/delete"));    
    myVolunteer.add(new MenuItem("참여한봉사 취소하기",ACCESS_MEMBER,"/volRequest/delete"));    
    myVolunteer.add(new MenuItem("찜한봉사",ACCESS_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

    return myVolunteer;
  }

  private Menu createMyBoardMenu() {

    MenuGroup myBoard = new MenuGroup("나의 게시글"); // 구현예정
    myBoard.add(new MenuItem("나의게시글 목록","/myBoard/list"));
    myBoard.add(new MenuItem("나의게시글 상세보기","/myBoard/detail"));
    myBoard.add(new MenuItem("나의게시글 수정","/myBoard/update"));
    myBoard.add(new MenuItem("나의게시글 삭제","/myBoard/delete"));

    return myBoard;
  }


  private Menu createMyDonationMenu() {
    MenuGroup myDonation = new MenuGroup("나의 모금함"); 
    myDonation.add(new MenuItem("나의 모금함 개설신청서 확인", ACCESS_ORG, "/myDonation//applyCompleteList")); 
    myDonation.add(new MenuItem("나의 기부내역", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("승인된 모금함 개설내역",ACCESS_ORG,"/donationBoard/appliedList")); 
    myDonation.add(new MenuItem("반려된 모금함 개설내역", ACCESS_ORG,"/donationBoard/rejectedList"));  

    return myDonation;
  }

  private Menu createMyPointMenu() {
    MenuGroup myPoint = new MenuGroup("나의 포인트"); // 구현예정
    myPoint.add(new MenuItem("나의포인트확인","myPoint/list"));

    return myPoint;
  }


  private Menu createOrgApprovewMenu() {
    MenuGroup orgpprove = new MenuGroup("기관 승인 신청");

    orgpprove.add(new MenuItem("승인 요청하기","/orgMyVol/apply"));
    orgpprove.add(new MenuItem("승인 현황보기","/orgMyVol/approve"));

    return orgpprove;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  // 관리자

  private Menu createAdminMemberMenu() {
    MenuGroup adminMemberMenu = new MenuGroup("회원정보 관리", ACCESS_ADMIN);

    adminMemberMenu.add(new MenuItem("회원목록", "/join/list"));
    adminMemberMenu.add(new MenuItem("가입회원 상세보기", "/join/detail"));
    adminMemberMenu.add(new MenuItem("회원추방","/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminDonationMenu() {
    MenuGroup adminDonationMenu = new MenuGroup("모금함 관리" ,ACCESS_ADMIN);

    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 목록", "/donationBoard/applyList"));
    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 상세보기", "/adminDonationBoard/applyDetail"));
    adminDonationMenu.add(new MenuItem("모금함 개설 승인하기", "/donationBoard/acceptApply"));
    adminDonationMenu.add(new MenuItem("모금함 개설 반려하기", "/donationBoard/rejectApply"));

    return adminDonationMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("봉사활동 관리", ACCESS_ADMIN);

    adminVolMenu.add(new MenuItem("개인봉사신청내역","/volRequestPersonal/applyList"));
    adminVolMenu.add(new MenuItem("기관봉사신청내역","/volRequestPersonal/bookmark")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사승인하기","/volRequestPersonal/acceptApply"));
    adminVolMenu.add(new MenuItem("기관봉사승인하기","/volRequestOrg/acceptApply")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사반려하기","/volRequestPersonal/rejectApply"));
    adminVolMenu.add(new MenuItem("기관봉사반려하기","/volRequestPersonal/bookmark")); // 구현예정
    adminVolMenu.add(new MenuItem("개인봉사삭제하기","/volRequestPersonal/delete"));

    return adminVolMenu;
  }

  private Menu createAdminNoticeMenu() {
    MenuGroup adminNoticeMenu = new MenuGroup("공지사항");

    adminNoticeMenu.add(new MenuItem("공지사항 등록",ACCESS_ADMIN,"/adminNotice/add"));
    adminNoticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
    adminNoticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
    adminNoticeMenu.add(new MenuItem("공지사항 변경",ACCESS_ADMIN,"/adminNotice/update"));
    adminNoticeMenu.add(new MenuItem("공지사항 삭제",ACCESS_ADMIN,"/adminNotice/delete"));
    adminNoticeMenu.add(new MenuItem("공지사항 검색","/adminNotice/search"));

    return adminNoticeMenu;
  }

  private Menu createAdminAskMenu() {
    MenuGroup adminAskInfo = new MenuGroup("문의사항 관리", ACCESS_ADMIN);

    adminAskInfo.add(new MenuItem("문의사항 등록","/adminAsk/add"));
    adminAskInfo.add(new MenuItem("문의사항 목록","/adminAsk/list"));
    adminAskInfo.add(new MenuItem("문의사항 상세보기","/adminAsk/detail"));
    adminAskInfo.add(new MenuItem("문의사항 변경","/adminAsk/update"));
    adminAskInfo.add(new MenuItem("문의사항 삭제","/adminAsk/delete"));

    return adminAskInfo;
  }

  private Menu createAdminChallengeMenu() {
    MenuGroup adminChallengeInfo = new MenuGroup("챌린지 관리");

    adminChallengeInfo.add(new MenuItem("챌린지 등록","/adminChallenge/add"));
    adminChallengeInfo.add(new MenuItem("챌린지 목록","/adminChallenge/list"));
    adminChallengeInfo.add(new MenuItem("챌린지 상세보기","/adminChallenge/detail"));
    adminChallengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/update"));
    adminChallengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/delete"));

    return adminChallengeInfo;
  }

  private Menu createAdminApproveInfoMenu() {
    MenuGroup adminApproveInfo = new MenuGroup("기관 승인", ACCESS_ADMIN);

    adminApproveInfo.add(new MenuItem("기관승인신청 목록","/adminChallenge/list"));
    adminApproveInfo.add(new MenuItem("기관승인신청 내용","/adminChallenge/detail"));
    adminApproveInfo.add(new MenuItem("기관승인신청 변경","/adminChallenge/update"));
    adminApproveInfo.add(new MenuItem("기관승인신청 삭제","/adminChallenge/delete"));

    return adminApproveInfo;
  }

}

