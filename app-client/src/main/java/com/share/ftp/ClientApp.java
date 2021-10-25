package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_GROUP;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.share.context.ApplicationContextListener;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AdminChallengeAddHandler;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeQuestionListHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyAddHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyConnectlHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeReplyUpdateHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeSearchHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.join.AuthDisplayUserHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.GroupFormUpdateHandler;
import com.share.ftp.handler.join.GroupHandler;
import com.share.ftp.handler.join.GroupListHandler;
import com.share.ftp.handler.join.GroupUserDeleteHandler;
import com.share.ftp.handler.join.GroupUserUpdateHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinGroupHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinListTestHandler;
import com.share.ftp.handler.join.JoinOrgHandler;
import com.share.ftp.handler.join.JoinPersonalHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.OrgFormUpdateHandler;
import com.share.ftp.handler.join.OrgHandler;
import com.share.ftp.handler.join.OrgListHandler;
import com.share.ftp.handler.join.OrgUserDeleteHandler;
import com.share.ftp.handler.join.OrgUserUpdateHandler;
import com.share.ftp.handler.join.PersonalHandler;
import com.share.ftp.handler.join.PersonalUserDeleteHandler;
import com.share.ftp.handler.join.PersonalUserUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeRankingHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeWishHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardAddHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardDeleteHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardDetailHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardListHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardSearchHandler;
import com.share.ftp.handler.personal.community.VolunteerBoardUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationAdminPrompt;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardConnectHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDeleteHandler;
import com.share.ftp.handler.personal.donation.DonationBoardDetailRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRegisterListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardSearchHandler;
import com.share.ftp.handler.personal.donation.DonationBoardUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeDetailHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeListHandler;
import com.share.ftp.handler.personal.mypage.MyChallengeWishHandler;
import com.share.ftp.handler.personal.mypage.MyPointListHandler;
import com.share.ftp.handler.personal.mypage.MyRankingHandler;
import com.share.ftp.handler.personal.mypage.MyVolWishHandler;
import com.share.ftp.handler.personal.support.AdminQuestionConnectHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionSearchHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolDetailHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyRejectedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyVolunteerHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionAddHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionConnectHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionListHandler;
import com.share.ftp.handler.personal.volunteer.VolQuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerApproveHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerApproveListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerDetailHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerGroupJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerListHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerOtherJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolunteerWishHandler;
import com.share.ftp.listener.AppInitListener;
import com.share.menu.Menu;
import com.share.menu.MenuFilter;
import com.share.menu.MenuGroup;
import com.share.request.RequestAgent;
import com.share.util.Prompt;

public class ClientApp {

  Connection con;

  SqlSession sqlSession;

  RequestAgent requestAgent;

  // HashMap
  HashMap<String,Command> challengeReviewMap = new HashMap<>();

  // 메뉴 객체 컨트롤(Map)
  HashMap<String,Command> commands = new HashMap<>();

  // => 옵저버(리스너) 목록
  List<ApplicationContextListener> listeners = new ArrayList<>();

  // => 옵저버(리스너)를 등록하는 메서드
  public void addApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.add(listener);
  }

  // => 옵저버(리스너)를 제거하는 메서드
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.remove(listener);
  }

  private void notifyOnApplicationStarted() {

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }

  private void notifyOnApplicationEnded() {

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }

  //MenuGroup에서 사용할 필터를 정의한다.
  MenuFilter menuFilter = menu -> (menu.getAccessScope() & AuthLoginHandler.getUserAccessLevel()) > 0;


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
      try {
        command.execute(new CommandRequest(commands));
      } catch(Exception e) {
        System.out.printf("%s 명령을 실행하는 중 오류 발생!\n", menuId);
        e.printStackTrace();
      }
    }
  }

  public ClientApp() throws Exception {

    requestAgent = null;

    // DBMS와 연결
    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/happysharedb?user=happyshare&password=1111");

    sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/share/ftp/conf/mybatis-config.xml")).openSession();

    // 로그인
    JoinDao joinDao = sqlSession.getMapper(JoinDao.class);
    PersonalDao personalDao = sqlSession.getMapper(PersonalDao.class);
    GroupDao groupDao = sqlSession.getMapper(GroupDao.class);
    OrgDao orgDao = sqlSession.getMapper(OrgDao.class);

    // 공통 메서드
    GeneralDao generalDao = sqlSession.getMapper(GeneralDao.class);




    VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);
    //    CommunityDao communityDao = new NetCommunityDao(requestAgent);
    // 챌린지 관련
    ChallengeDao challengeDao = sqlSession.getMapper(ChallengeDao.class);
    ChallengeQuestionDao challengeQuestionDao = sqlSession.getMapper(ChallengeQuestionDao.class);
    ChallengeReviewDao challengeReviewDao = sqlSession.getMapper(ChallengeReviewDao.class);
    //    CommunityDao CommunityDao = new MybatisCommunityDao(sqlSession);
    QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
    NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);

    // 봉사활동 게시글
    VolunteerBoardDao volunteerBoardDao = sqlSession.getMapper(VolunteerBoardDao.class);
    //    VolunteerBoardCommentDao volunteerBoardCommentDao = sqlSession.getMapper(VolunteerBoardCommentDao.class);
    //    VolunteerShortReviewDao volunteerShortReviewDao = sqlSession.getMapper(VolunteerShortReviewDao.class);    

    //로그인, 로그아웃

    commands.put("/auth/login", new AuthLoginHandler(joinDao, personalDao, groupDao, orgDao)); // 로그인
    commands.put("/auth/logout", new AuthLogoutHandler()); // 로그아웃
    commands.put("/auth/displayUserInfo", new AuthDisplayUserHandler()); // 마이페이지 나의정보수정
    commands.put("/userInfo/personal", new PersonalHandler()); 
    commands.put("/userInfo/group", new GroupHandler()); 
    commands.put("/userInfo/org", new OrgHandler()); 

    //회원가입
    commands.put("/join/add", new JoinAddHandler()); // 회원가입
    commands.put("/join/personal", new JoinPersonalHandler(personalDao,sqlSession)); // 회원가입
    commands.put("/join/group", new JoinGroupHandler(groupDao,sqlSession)); // 회원가입
    commands.put("/join/org", new JoinOrgHandler(orgDao,sqlSession)); // 회원가입
    commands.put("/join/list", new JoinListHandler(personalDao,groupDao,orgDao)); // 회원가입
    commands.put("/join/groupForm", new GroupFormUpdateHandler(groupDao,sqlSession)); // 회원가입
    commands.put("/join/orgForm", new OrgFormUpdateHandler(orgDao,sqlSession)); // 회원가입
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(personalDao)); // 폰번호로 아이디 찾기
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(personalDao)); // 이메일로 아이디 찾기kvp
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(personalDao)); // 비밀번호 찾기

    // 봉사
    commands.put("/volRequest/apply", new VolunteerRequestApplyHandler(volunteerDao,generalDao,sqlSession));
    commands.put("/vol/list", new VolunteerListHandler(volunteerDao));  
    commands.put("/vol/detail", new VolunteerDetailHandler(volunteerDao));

    commands.put("/vol/approvelist", new VolunteerApproveListHandler(volunteerDao));
    commands.put("/vol/approve", new VolunteerApproveHandler(volunteerDao));  
    commands.put("/vol/reject", new VolunteerRejectHandler(volunteerDao)); 

    commands.put("/volJoin/add", new VolunteerJoinHandler(volunteerDao));
    commands.put("/volJoin/groupAdd", new VolunteerGroupJoinHandler(volunteerDao));
    commands.put("/volJoin/list", new VolunteerJoinListHandler(volunteerDao));
    commands.put("/volJoin/delete", new VolunteerJoinDeleteHandler(volunteerDao));
    commands.put("/volJoin/otherDelete", new VolunteerOtherJoinDeleteHandler(volunteerDao));

    commands.put("/volGeneralRequest/delete", new VolGeneralRequestDeleteHandler(volunteerDao));
    commands.put("/vol/wish", new VolunteerWishHandler(volunteerDao,sqlSession));
    commands.put("/vol/wishList", new MyVolWishHandler(volunteerDao));
    //    commands.put("/volGeneralRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volPersonalRequestAppliedListHandler,volOrgRequestAppliedListHandler));

    //함께해요 문의하기
    commands.put("/volQuestion/add", new VolQuestionAddHandler(volunteerDao));
    commands.put("/volQuestion/list", new VolQuestionListHandler(volunteerDao));
    commands.put("/volQuestion/update", new VolQuestionUpdateHandler(volunteerDao));
    commands.put("/volQuestion/delete", new VolQuestionDeleteHandler(volunteerDao));
    commands.put("/volQuestion/connect", new VolQuestionConnectHandler(volunteerDao));


    // 소통해요 나눔이야기
    commands.put("/volunteerBoard/add", new VolunteerBoardAddHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/list", new VolunteerBoardListHandler(volunteerBoardDao));
    commands.put("/volunteerBoard/detail", new VolunteerBoardDetailHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/update", new VolunteerBoardUpdateHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/delete", new VolunteerBoardDeleteHandler(volunteerBoardDao, sqlSession));
    commands.put("/volunteerBoard/search", new VolunteerBoardSearchHandler(volunteerBoardDao));
    //    commands.put("/volunteerBoard/like", new CommBoardLikeHandler(volboardDao, sqlSession)); 

    // 소통해요 댓글
    //    commands.put("/volunteerBoardComment/connect", new CommBoardReplyConnectHandler(volunteerBoardCommentDao));
    //    commands.put("/volunteerBoardComment/add", new CommBoardReplyAddHandler(volunteerBoardCommentDao, sqlSession));
    //    commands.put("/volunteerBoardComment/list", new CommBoardReplyListHandler(volunteerBoardCommentDao));
    //    commands.put("/volunteerBoardComment/update", new CommBoardReplyUpdateHandler(volunteerBoardCommentDao, sqlSession));
    //    commands.put("/volunteerBoardComment/delete", new CommBoardReplyDeleteHandler(volunteerBoardCommentDao, sqlSession));

    // 소통해요 한줄후기
    //    commands.put("/volunteerShortReview/add", new VolunteerShortReviewAddHandler(volunteerShortReviewDao, sqlSession));
    //    commands.put("/volunteerShortReview/list", new VolunteerShortReviewListHandler(volunteerShortReviewDao));
    //    commands.put("/volunteerShortReview/update", new VolunteerShortReviewUpdateHandler(volunteerShortReviewDao, sqlSession));
    //    commands.put("/volunteerShortReview/delete", new VolunteerShortReviewDeleteHandler(volunteerShortReviewDao, sqlSession));
    //    commands.put("/volunteerShortReview/search", new VolunteerShortReviewSearchHandler(volunteerShortReviewDao));



    //    // 소통해요 나눔이야기 BEST
    //    commands.put("/commBest/list", new CommBestListHandler(communityDao));
    //    commands.put("/commBest/detail", new CommBestDetailHandler(communityDao));

    // 챌린지
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDao));  // 챌린지 목록
    commands.put("/challenge/detail", new ChallengeDetailHandler(challengeDao)); // 챌린지 상세정보
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(challengeDao, sqlSession));  // 참여하기
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(challengeDao));  // 참여자목록
    //    commands.put("/challengeDetail/like", new ChallengeLikeHandler(challengeDTOList));  // 챌린지 좋아요 기능(사용안함)
    commands.put("/challengeDetail/wish", new ChallengeWishHandler(challengeDao, sqlSession));  // 관심 챌린지 등록(찜하기)

    // 챌린지 참여인증&댓글
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(challengeDao, challengeReviewDao, sqlSession));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(challengeDao, challengeReviewDao));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDao, sqlSession));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeDao, challengeReviewDao, sqlSession));
    //    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(netChallengeReviewDao, netChallengeDao));
    commands.put("/challengeReview/connect", new ChallengeReviewConnectHandler(challengeReviewDao));

    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(challengeDao ,challengeQuestionDao, sqlSession));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(challengeDao, challengeQuestionDao));
    //    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(challengeQuestionDTOList, challengeDTOList, challengeReplyList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(challengeQuestionDao, sqlSession));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(challengeDao, challengeQuestionDao, sqlSession));
    //    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(netChallengeDao, netChallengeQuestionDao));
    commands.put("/challengeQuestion/connect", new ChallengeQuestionConnectHandler(challengeQuestionDao));


    // 챌린지 랭킹
    commands.put("/ranking/list", new ChallengeRankingHandler(personalDao));  
    commands.put("/myRanking/list", new MyRankingHandler(personalDao)); 

    // 모금함 (개설신청하기, 개설목록, 승인, 반려)

    DonationBoardDao donationBoardDao = sqlSession.getMapper(DonationBoardDao.class);

    DonationPrompt donationPrompt = new DonationPrompt(donationBoardDao);
    DonationAdminPrompt donationAdminPrompt = new DonationAdminPrompt(donationBoardDao);

    DonationRegisterDao donationRegisterDao = sqlSession.getMapper(DonationRegisterDao.class);

    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardDao));
    commands.put("/donationBoard/connect", new DonationBoardConnectHandler(donationBoardDao));
    commands.put("/donationBoard/update", new DonationBoardUpdateHandler(donationBoardDao));
    commands.put("/donationBoard/delete", new DonationBoardDeleteHandler(donationBoardDao));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDao));
    commands.put("/donationBoard/search", new DonationBoardSearchHandler(donationBoardDao));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDao));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDao));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDao));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDao));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDao, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDao, donationAdminPrompt));

    // 모금함 (기부하기)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDao, donationBoardDao));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDao));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDao));

    commands.put("/donationBoardRegister/list", new DonationBoardRegisterListHandler(donationRegisterDao));
    commands.put("/donationBoardDetailRegister/add", new DonationBoardDetailRegisterAddHandler(donationBoardDao, donationRegisterDao, orgDao));

    // 고객센터 문의사항
    commands.put("/question/add", new QuestionAddHandler(questionDao));
    commands.put("/question/list", new QuestionListHandler(questionDao));
    commands.put("/question/detail", new QuestionDetailHandler(questionDao));
    commands.put("/question/update", new QuestionUpdateHandler(questionDao));
    commands.put("/question/delete", new QuestionDeleteHandler(questionDao));
    commands.put("/question/search", new QuestionSearchHandler(questionDao));

    commands.put("/adminQuestion/connect", new AdminQuestionConnectHandler());
    //    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(myQuestionListDTOList));

    // 마이페이지

    // 회원정보 변경 및 삭제
    commands.put("/myPage/personal", new PersonalUserUpdateHandler(personalDao)); // 개인회원 내정보 수정
    commands.put("/myPage/delete", new PersonalUserDeleteHandler(personalDao)); // 개인회원탈퇴
    commands.put("/myPage/group", new GroupUserUpdateHandler(groupDao)); // 단체회원 내정보 수정
    commands.put("/myPage/delete", new GroupUserDeleteHandler(groupDao)); // 단체회원탈퇴
    commands.put("/myPage/org", new OrgUserUpdateHandler(orgDao)); // 기관회원 내정보 수정
    commands.put("/myPage/delete", new OrgUserDeleteHandler(orgDao)); // 기관회원탈퇴

    commands.put("/myVol/list", new MyVolunteerHandler(volunteerDao));
    commands.put("/myVol/applied", new MyAppliedVolHandler(volunteerDao));
    commands.put("/myVol/appliedDetail", new MyAppliedVolDetailHandler(volunteerDao));
    commands.put("/myVol/rejected", new MyRejectedVolHandler(volunteerDao));

    commands.put("/myChallenge/list", new MyChallengeListHandler(challengeDao));
    commands.put("/myChallenge/detail", new MyChallengeDetailHandler(challengeDao));
    commands.put("/myChallenge/wish", new MyChallengeWishHandler(challengeDao));

    commands.put("myPoint/list", new MyPointListHandler(personalDao)); // 나의포인트 

    //    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // 기관 마이페이지 승인신청 
    //    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // 기관 마이페이지 승인조회
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDao)); // 모금함
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDao));

    // 관리자

    // 관리자 회원정보 조회
    //    commands.put("/join/list", new JoinListHandler(personalDao)); // 관리자가 회원 목록을 조회
    commands.put("/join/test", new JoinListTestHandler(personalDao)); // 관리자가 개인회원 목록을 조회
    commands.put("/join/groupList", new GroupListHandler(groupDao, sqlSession)); // 관리자가 단체회원 목록을 조회
    commands.put("/join/orgList", new OrgListHandler(orgDao, sqlSession)); // 관리자가 단체회원 목록을 조회
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // 관리자 공지사항 (개인 + 관리자)
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDao));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDao));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDao));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDao));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDao));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDao));

    // 관리자 문의사항

    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(questionDao));
    //        commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(myQuestionListDTOList));

    // 관리자 챌린지
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDao));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDao));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDao, sqlSession));
    commands.put("/adminChallenge/QuestionList", new AdminChallengeQuestionListHandler(challengeDao, challengeQuestionDao));
    commands.put("/adminChallenge/replyAdd", new AdminChallengeReplyAddHandler(challengeDao, challengeQuestionDao, sqlSession)); // 챌린지 답글 등록
    commands.put("/adminChallenge/replyUpdate", new AdminChallengeReplyUpdateHandler(challengeDao, challengeQuestionDao)); // 챌린지 답글 변경
    commands.put("/adminChallenge/replyDelete", new AdminChallengeReplyDeleteHandler(challengeDao, challengeQuestionDao)); // 챌린지 답글 삭제
    commands.put("/adminChallenge/replyConnect", new AdminChallengeReplyConnectlHandler(challengeDao, challengeQuestionDao)); // 챌린지 답글 등록, 변경, 삭제 연결

    // 관리자 기관승인

    //        challengeReviewMap.put("/challengeReview/add", new ChallengeReviewAddHandler(netChallengeDao, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    //    challengeReviewMap.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
  }


  void service() throws Exception {

    notifyOnApplicationStarted();

    createMenu().execute();
    Prompt.close();

    notifyOnApplicationEnded();

    con.close();

  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*행복하Share*");
    mainMenuGroup.setMenuFilter(menuFilter);
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("아이디찾기", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);
    searchId.add(new MenuItem("휴대폰번호로아이디찾기", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("이메일로아이디찾기", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("비밀번호찾기", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("단체양식 수정", ACCESS_LOGOUT, "/join/groupForm"));
    mainMenuGroup.add(new MenuItem("기관양식 수정", ACCESS_LOGOUT, "/join/orgForm"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_MEMBER_ADMIN, "/auth/logout"));



    // 함께해요
    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);
    doVolMenu.setMenuFilter(menuFilter);

    doVolMenu.add(new MenuItem("봉사 신청서 작성", "/volRequest/apply"));
    doVolMenu.add(new MenuItem("봉사 목록", "/vol/list"));
    //    doVolMenu.add(new MenuItem("봉사 상세보기", "/vol/detail"));

    //    doVolMenu.add(new MenuItem("개인봉사신청양식", ACCESS_PERSONAL, "/volGeneralRequest/apply"));
    //    doVolMenu.add(new MenuItem("기관봉사신청양식", ACCESS_ORG, "/volGeneralRequest/apply")); 
    //    doVolMenu.add(new MenuItem("전체인증봉사리스트","/volGeneralRequest/appliedList")); 
    //    doVolMenu.add(createVolJoinMenu()); // 봉사 참여하기
    //    doVolMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // 구현예정

    // 소통해요
    MenuGroup CommunityMenu = new MenuGroup("소통해요");
    mainMenuGroup.add(CommunityMenu);
    CommunityMenu.setMenuFilter(menuFilter);

    CommunityMenu.add(createReviewMenu());      // 나눔이야기
    CommunityMenu.add(createBestReviewMenu());  // 나눔이야기BEST
    CommunityMenu.add(createShortReviewMenu()); // 한줄후기

    // 챌린지
    MenuGroup challengeMenu = new MenuGroup("챌린지");
    mainMenuGroup.add(challengeMenu);
    challengeMenu.setMenuFilter(menuFilter);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    challengeMenu.add(monthlyChallengeMenu);
    monthlyChallengeMenu.setMenuFilter(menuFilter);

    //    MenuGroup challengeListMenu = new MenuGroup("챌린지 목록");
    //    monthlyChallengeMenu.add(challengeListMenu);

    //    MenuGroup challengeDetailMenu = new MenuGroup("챌린지 상세보기");
    //    monthlyChallengeMenu.add(challengeDetailMenu); 

    //    MenuGroup showChallengeDetailHandler = new MenuGroup("상세정보");  // 구현예정
    //    challengeDetailMenu.add(showChallengeDetailHandler);

    monthlyChallengeMenu.add(new MenuItem("챌린지 목록", "/adminChallenge/list"));

    monthlyChallengeMenu.add(new MenuItem("챌린지 상세정보", "/challenge/detail"));

    //    monthlyChallengeMenu.add(new MenuItem("참여하기", ACCESS_MEMBER, "/challengeJoin/join"));
    //
    //    monthlyChallengeMenu.add(new MenuItem("참여자 목록", ACCESS_MEMBER, "/challengeJoin/list"));
    //
    //    monthlyChallengeMenu.add(createChallengeReviewMenu()); // 참여인증&댓글
    //    monthlyChallengeMenu.add(createChallengeQuestionMenu()); // 문의하기

    challengeMenu.add(createMonthlyRankingMenu()); // 이달의 랭킹


    // 모금함
    mainMenuGroup.add(createDonationMenu());


    // 고객센터
    MenuGroup supportMenu = new MenuGroup("고객센터");
    mainMenuGroup.add(supportMenu);
    supportMenu.setMenuFilter(menuFilter);

    supportMenu.add(createNoticeMenu());      // 공지사항
    supportMenu.add(createQuestionMenu());         // 문의하기

    // 마이페이지
    MenuGroup MyPageMenu = new MenuGroup("마이페이지", ACCESS_MEMBER);
    mainMenuGroup.add(MyPageMenu);
    MyPageMenu.setMenuFilter(menuFilter);

    MyPageMenu.add(createMyProfileMenu());    // 회원정보
    MyPageMenu.add(createMyVolunteerMenu());  // 나의봉사
    MyPageMenu.add(createMyBoardMenu());      // 나의게시글
    MyPageMenu.add(createMyChallengeMenu());    // 나의챌린지
    MyPageMenu.add(createMyPointMenu());      // 나의포인트
    MyPageMenu.add(createMyDonationMenu());   // 나의모금함
    MyPageMenu.add(createOrgApprovewMenu());  // 기관승인신청
    MyPageMenu.add(new MenuItem("탈퇴", ACCESS_MEMBER, "/myPage/delete")); 

    // 관리자
    //    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    //    mainMenuGroup.add(adminMenu);

    mainMenuGroup.add(createAdminMemberMenu());      // 회원관리
    mainMenuGroup.add(createAdminDonationMenu());    // 기부관리
    mainMenuGroup.add(createAdminVolMenu());         // 봉사관리
    mainMenuGroup.add(createAdminNoticeMenu());      // 공지사항관리
    mainMenuGroup.add(createAdminAskMenu());         // 문의사항관리
    mainMenuGroup.add(createAdminChallengeMenu());   // 챌린지관리
    mainMenuGroup.add(createAdminApproveInfoMenu()); // 기관승인관리
    mainMenuGroup.add(createAdminCommMenu()); // 커뮤니티 관리

    mainMenuGroup.add(new MenuItem("탈퇴하기", ACCESS_MEMBER, "/myPage/delete"));

    return mainMenuGroup;



  }

  ////////////////////////////////////////////////////////////////////////////////////////////////



  private Menu createVolJoinMenu() {
    MenuGroup volJoinMenu = new MenuGroup("봉사참여하기");
    volJoinMenu.setMenuFilter(menuFilter);

    volJoinMenu.add(new MenuItem("개인봉사참여",ACCESS_PERSONAL,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("기관봉사참여",ACCESS_ORG,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("참여자정보보기","/volDoJoin/list")); 
    volJoinMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // 구현예정
    volJoinMenu.add(createVolReviewMenu());
    volJoinMenu.add(createVolQuestionMenu()); 

    return volJoinMenu;
  }


  private Menu createVolReviewMenu() {
    MenuGroup volReview = new MenuGroup("참여인증&댓글");
    volReview.setMenuFilter(menuFilter);
    volReview.add(new MenuItem("봉사 참여인증 등록", ACCESS_MEMBER, "/volJoinReview/add"));
    volReview.add(new MenuItem("봉사 참여인증 목록", "/volJoinReview/list"));
    volReview.add(new MenuItem("봉사 참여인증 수정", ACCESS_MEMBER,"/volJoinReview/update"));
    volReview.add(new MenuItem("봉사 참여인증 삭제", ACCESS_MEMBER,"/volJoinReview/delete"));
    volReview.add(new MenuItem("봉사 참여인증 검색", "/volJoinReview/search"));

    return volReview;
  }


  private Menu createVolQuestionMenu() {
    MenuGroup VolQuestion = new MenuGroup("문의하기");
    VolQuestion.setMenuFilter(menuFilter);

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
    reviewMenu.setMenuFilter(menuFilter);

    reviewMenu.add(new MenuItem("등록", ACCESS_MEMBER_ADMIN, "/volunteerBoard/add"));
    reviewMenu.add(new MenuItem("목록","/volunteerBoard/list"));
    reviewMenu.add(new MenuItem("상세보기","/volunteerBoard/detail"));
    //    reviewMenu.add(new MenuItem("변경", ACCESS_MEMBER_ADMIN,"/volunteerBoard/update"));
    //    reviewMenu.add(new MenuItem("삭제",ACCESS_MEMBER_ADMIN,"/volunteerBoard/delete"));
    reviewMenu.add(new MenuItem("검색",ACCESS_MEMBER_ADMIN,"/volunteerBoard/search"));

    return reviewMenu;
  }

  private Menu createBestReviewMenu() {
    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    bestReviewMenu.setMenuFilter(menuFilter);

    bestReviewMenu.add(new MenuItem("목록","/commBest/list"));
    bestReviewMenu.add(new MenuItem("상세보기","/commBest/detail"));

    return bestReviewMenu;
  }

  private Menu createShortReviewMenu() {
    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    shortReviewMenu.setMenuFilter(menuFilter);

    shortReviewMenu.add(new MenuItem("등록", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/add"));
    shortReviewMenu.add(new MenuItem("목록", "/volunteerShortReview/list")); 
    //    shortReviewMenu.add(new MenuItem("변경", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/update")); 
    //    shortReviewMenu.add(new MenuItem("삭제", ACCESS_MEMBER_ADMIN, "/volunteerShortReview/delete")); 
    shortReviewMenu.add(new MenuItem("검색",ACCESS_MEMBER_ADMIN,"/volunteerShortReview/search"));


    return shortReviewMenu;
  }


  public  Menu createChallengeReviewMenu() {
    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
    ChallengeReview.setMenuFilter(menuFilter);
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
    ChallengeQuestion.setMenuFilter(menuFilter);
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
    monthlyRankingMenu.setMenuFilter(menuFilter);
    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)

    return monthlyRankingMenu;
  }

  private Menu createDonationMenu() {
    MenuGroup donationMenu = new MenuGroup("모금함");
    donationMenu.setMenuFilter(menuFilter);

    donationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
    donationMenu.add(new MenuItem("전체 기부 참여내역", "/donationRegister/participation"));
    donationMenu.add(new MenuItem("모금함목록","/donationBoard/list"));
    donationMenu.add(new MenuItem("모금함 상세보기", "/donationBoard/applyDetail"));
    donationMenu.add(new MenuItem("모금함 검색", "/donationBoard/search"));
    donationMenu.add(new MenuItem("모금함 개설신청", ACCESS_ORG, "/donationBoard/apply"));

    return donationMenu;
  }


  private Menu createNoticeMenu() {
    MenuGroup noticeMenu = new MenuGroup("공지사항");
    noticeMenu.setMenuFilter(menuFilter);

    noticeMenu.add(new MenuItem("공지사항 등록", ACCESS_ADMIN,"/adminNotice/add"));
    noticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
    noticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
    //    noticeMenu.add(new MenuItem("공지사항 변경",ACCESS_ADMIN,"/adminNotice/update"));
    //    noticeMenu.add(new MenuItem("공지사항 삭제",ACCESS_ADMIN,"/adminNotice/delete"));
    noticeMenu.add(new MenuItem("공지사항 검색","/adminNotice/search"));

    return noticeMenu;
  }

  private Menu createQuestionMenu() {
    MenuGroup question = new MenuGroup("문의하기");
    question.setMenuFilter(menuFilter);
    question.add(new MenuItem("등록", ACCESS_MEMBER,"/question/add"));
    question.add(new MenuItem("목록", "/question/list"));
    question.add(new MenuItem("상세보기", ACCESS_MEMBER_ADMIN, "/question/detail"));
    //    ask.add(new MenuItem("변경", ACCESS_MEMBER,"/question/update"));
    //    ask.add(new MenuItem("삭제", ACCESS_MEMBER, "/question/delete"));
    question.add(new MenuItem("검색", "/question/search"));

    return question;
  }


  // 마이페이지

  private Menu createMyProfileMenu() {
    MenuGroup myProfile = new MenuGroup("회원정보", ACCESS_MEMBER);
    myProfile.setMenuFilter(menuFilter);
    myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("내 정보 수정", ACCESS_PERSONAL, "/myPage/personal"));
    myProfile.add(new MenuItem("내 정보 수정", ACCESS_GROUP, "/myPage/group"));
    myProfile.add(new MenuItem("내 정보 수정", ACCESS_ORG, "/myPage/org"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    myVolunteer.setMenuFilter(menuFilter);

    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_GROUP,"/myVol/list")); 
    myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_ORG,"/myVol/list")); 
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_GROUP,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_ORG,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_GROUP,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_ORG,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("단체봉사 삭제",ACCESS_GROUP,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("기관봉사 삭제",ACCESS_ORG,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("참여한봉사 취소하기",ACCESS_PERSONAL,"/volJoin/delete"));    
    myVolunteer.add(new MenuItem("참여한봉사 취소하기",ACCESS_GROUP,"/volJoin/otherDelete"));    
    myVolunteer.add(new MenuItem("참여한봉사 취소하기",ACCESS_ORG,"/volJoin/otherDelete"));    
    myVolunteer.add(new MenuItem("찜한봉사",ACCESS_MEMBER,"/vol/wishList")); 

    return myVolunteer;
  }

  private Menu createMyBoardMenu() {

    MenuGroup myBoard = new MenuGroup("나의 게시글"); // 구현예정
    myBoard.setMenuFilter(menuFilter);
    myBoard.add(new MenuItem("나의게시글 목록","/myBoard/list"));
    myBoard.add(new MenuItem("나의게시글 상세보기","/myBoard/detail"));
    myBoard.add(new MenuItem("나의게시글 수정","/myBoard/update"));
    myBoard.add(new MenuItem("나의게시글 삭제","/myBoard/delete"));

    return myBoard;
  }
  private Menu createMyChallengeMenu() {

    MenuGroup myChallenge = new MenuGroup("나의 챌린지"); // 구현예정
    myChallenge.setMenuFilter(menuFilter);
    myChallenge.add(new MenuItem("나의챌린지 목록","/myChallenge/list"));
    myChallenge.add(new MenuItem("나의챌린지 상세보기","/myChallenge/detail"));
    myChallenge.add(new MenuItem("나의챌린지 찜한목록","/myChallenge/wish"));

    return myChallenge;
  }


  private Menu createMyDonationMenu() {
    MenuGroup myDonation = new MenuGroup("나의 모금함"); 
    myDonation.setMenuFilter(menuFilter);
    myDonation.add(new MenuItem("나의 기부내역", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("나의 모금함 개설신청서 목록", ACCESS_ORG, "/myDonation//applyCompleteList")); 
    myDonation.add(new MenuItem("승인된 모금함 개설내역",ACCESS_ORG,"/donationBoard/appliedList")); 
    myDonation.add(new MenuItem("반려된 모금함 개설내역", ACCESS_ORG,"/donationBoard/rejectedList"));  

    return myDonation;
  }

  private Menu createMyPointMenu() {
    MenuGroup myPoint = new MenuGroup("나의 포인트"); // 구현예정
    myPoint.setMenuFilter(menuFilter);
    myPoint.add(new MenuItem("나의포인트확인","myPoint/list"));

    return myPoint;
  }


  private Menu createOrgApprovewMenu() {
    MenuGroup orgpprove = new MenuGroup("기관 승인 신청");
    orgpprove.setMenuFilter(menuFilter);

    orgpprove.add(new MenuItem("승인 요청하기","/orgMyVol/apply"));
    orgpprove.add(new MenuItem("승인 현황보기","/orgMyVol/approve"));

    return orgpprove;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  // 관리자

  private Menu createAdminMemberMenu() {
    MenuGroup adminMemberMenu = new MenuGroup("회원정보 관리", ACCESS_ADMIN);
    adminMemberMenu.setMenuFilter(menuFilter);

    //    adminMemberMenu.add(new MenuItem("회원목록",ACCESS_ADMIN, "/join/list"));
    adminMemberMenu.add(new MenuItem("가입회원 목록", ACCESS_ADMIN,"/join/list"));
    adminMemberMenu.add(new MenuItem("단체목록",ACCESS_ADMIN, "/join/groupList"));
    adminMemberMenu.add(new MenuItem("기관목록",ACCESS_ADMIN, "/join/orgList"));
    adminMemberMenu.add(new MenuItem("회원추방",ACCESS_ADMIN,"/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("봉사활동 관리", ACCESS_ADMIN);
    adminVolMenu.setMenuFilter(menuFilter);

    adminVolMenu.add(new MenuItem("봉사신청서 확인",ACCESS_ADMIN,"/vol/approveList"));

    return adminVolMenu;
  }

  private Menu createAdminDonationMenu() {
    MenuGroup adminDonationMenu = new MenuGroup("모금함 관리" ,ACCESS_ADMIN);
    adminDonationMenu.setMenuFilter(menuFilter);

    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 목록",ACCESS_ADMIN, "/donationBoard/applyList"));
    adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 상세보기",ACCESS_ADMIN, "/adminDonationBoard/applyDetail"));
    //    adminDonationMenu.add(new MenuItem("모금함 개설 승인하기", "/donationBoard/acceptApply"));
    //    adminDonationMenu.add(new MenuItem("모금함 개설 반려하기", "/donationBoard/rejectApply"));

    return adminDonationMenu;
  }


  private Menu createAdminNoticeMenu() {
    MenuGroup adminNoticeMenu = new MenuGroup("공지사항 관리", ACCESS_ADMIN);
    adminNoticeMenu.setMenuFilter(menuFilter);

    adminNoticeMenu.add(new MenuItem("공지사항 등록",ACCESS_ADMIN,"/adminNotice/add"));
    adminNoticeMenu.add(new MenuItem("공지사항 목록",ACCESS_ADMIN,"/adminNotice/list"));
    adminNoticeMenu.add(new MenuItem("공지사항 상세보기",ACCESS_ADMIN,"/adminNotice/detail"));
    //    adminNoticeMenu.add(new MenuItem("공지사항 변경",ACCESS_ADMIN,"/adminNotice/update"));
    //    adminNoticeMenu.add(new MenuItem("공지사항 삭제",ACCESS_ADMIN,"/adminNotice/delete"));
    adminNoticeMenu.add(new MenuItem("공지사항 검색",ACCESS_ADMIN,"/adminNotice/search"));

    return adminNoticeMenu;
  }

  private Menu createAdminAskMenu() {
    MenuGroup adminAskInfo = new MenuGroup("문의사항 관리", ACCESS_ADMIN);
    adminAskInfo.setMenuFilter(menuFilter);

    //    adminAskInfo.add(new MenuItem("문의사항 등록",ACCESS_ADMIN,"/question/add"));
    adminAskInfo.add(new MenuItem("문의사항 목록",ACCESS_ADMIN,"/question/list"));
    adminAskInfo.add(new MenuItem("문의사항 상세보기",ACCESS_ADMIN,"/question/detail"));
    //    adminAskInfo.add(new MenuItem("문의사항 변경",ACCESS_ADMIN,"/question/update"));
    //    adminAskInfo.add(new MenuItem("문의사항 삭제",ACCESS_ADMIN,"/question/delete"));
    adminAskInfo.add(new MenuItem("문의사항 검색",ACCESS_ADMIN,"/question/search"));

    return adminAskInfo;
  }


  private Menu createAdminChallengeMenu() {
    MenuGroup adminChallengeInfo = new MenuGroup("챌린지 관리", ACCESS_ADMIN);
    adminChallengeInfo.setMenuFilter(menuFilter);

    adminChallengeInfo.add(new MenuItem("챌린지 등록",ACCESS_ADMIN,"/adminChallenge/add"));
    adminChallengeInfo.add(new MenuItem("챌린지 목록",ACCESS_ADMIN,"/adminChallenge/list"));
    adminChallengeInfo.add(new MenuItem("챌린지 상세보기",ACCESS_ADMIN,"/adminChallenge/detail"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/update"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/delete"));
    //    adminChallengeInfo.add(new MenuItem("챌린지 문의답글 등록","/adminChallengeQuestion/add"));

    return adminChallengeInfo;
  }

  private Menu createAdminApproveInfoMenu() {
    MenuGroup adminApproveInfo = new MenuGroup("기관 승인", ACCESS_ADMIN);
    adminApproveInfo.setMenuFilter(menuFilter);

    adminApproveInfo.add(new MenuItem("기관승인신청 목록",ACCESS_ADMIN,"/adminChallenge/list"));
    adminApproveInfo.add(new MenuItem("기관승인신청 내용",ACCESS_ADMIN,"/adminChallenge/detail"));
    adminApproveInfo.add(new MenuItem("기관승인신청 변경",ACCESS_ADMIN,"/adminChallenge/update"));
    adminApproveInfo.add(new MenuItem("기관승인신청 삭제",ACCESS_ADMIN,"/adminChallenge/delete"));

    return adminApproveInfo;
  }
  private Menu createAdminCommMenu() {
    MenuGroup adminCommInfo = new MenuGroup("커뮤니티 관리", ACCESS_ADMIN);
    adminCommInfo.setMenuFilter(menuFilter);

    adminCommInfo.add(new MenuItem("나눔이야기 목록", ACCESS_MEMBER_ADMIN, "/volunteerBoard/list"));
    adminCommInfo.add(new MenuItem("나눔이야기 상세보기", ACCESS_MEMBER_ADMIN, "/volunteerBoard/detail")); 
    adminCommInfo.add(new MenuItem("한줄후기 목록",ACCESS_MEMBER_ADMIN,"/volunteerShortReview/list"));


    return adminCommInfo;
  }


  public static void main(String[] args) throws Exception {

    ClientApp app = new ClientApp(); 
    app.addApplicationContextListener(new AppInitListener());
    //    app.addApplicationContextListener(new FileListener());
    app.service();

    Prompt.close();
  }


}

