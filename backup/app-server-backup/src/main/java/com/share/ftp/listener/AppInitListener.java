package com.share.ftp.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerShortReviewDao;

@WebListener
public class AppInitListener implements ServletContextListener {

  SqlSession sqlSession = null;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("애플리케이션 시작됨!");

    try {
      // Mybatis의 SqlSession 객체 준비
      sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
          "com/share/ftp/conf/mybatis-config.xml")).openSession();

      // SqlSession 객체를 통해 MemberDao 구현체를 자동 생성한다.
      JoinDao joinDao = sqlSession.getMapper(JoinDao.class);
      PersonalDao personalDao = sqlSession.getMapper(PersonalDao.class);
      GroupDao groupDao = sqlSession.getMapper(GroupDao.class);
      OrgDao orgDao = sqlSession.getMapper(OrgDao.class);

      VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);
      GeneralDao generalDao = sqlSession.getMapper(GeneralDao.class);
      VolunteerBoardDao volunteerBoardDao = sqlSession.getMapper(VolunteerBoardDao.class);
      VolunteerBoardCommentDao volunteerBoardCommentDao = sqlSession.getMapper(VolunteerBoardCommentDao.class);
      VolunteerShortReviewDao volunteerShortReviewDao = sqlSession.getMapper(VolunteerShortReviewDao.class);    

      ChallengeDao challengeDao = sqlSession.getMapper(ChallengeDao.class);
      ChallengeReviewDao challengeReviewDao = sqlSession.getMapper(ChallengeReviewDao.class);
      ChallengeQuestionDao challengeQuestionDao = sqlSession.getMapper(ChallengeQuestionDao.class);

      DonationBoardDao donationBoardDao = sqlSession.getMapper(DonationBoardDao.class);
      DonationRegisterDao donationRegisterDao = sqlSession.getMapper(DonationRegisterDao.class);
      NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
      QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);

      // 모든 웹 애플리케이션의 컴포넌트(서블릿, 리스너, 필터)가 공유할 객체를 두는 저장소
      ServletContext 웹애플리케이션공용저장소 = sce.getServletContext();


      // 웹 애플리케이션 공용 저장소에 DAO 객체를 보관한다.
      // => 이 저장소에 보관된 객체는 서블릿에서 사용할 것이다.
      웹애플리케이션공용저장소.setAttribute("volunteerDao", volunteerDao);
      웹애플리케이션공용저장소.setAttribute("generalDao", generalDao);
      웹애플리케이션공용저장소.setAttribute("joinDao", joinDao);
      웹애플리케이션공용저장소.setAttribute("sqlSession", sqlSession);      

      웹애플리케이션공용저장소.setAttribute("joinDao", joinDao);
      웹애플리케이션공용저장소.setAttribute("personalDao", personalDao);
      웹애플리케이션공용저장소.setAttribute("groupDao", groupDao);
      웹애플리케이션공용저장소.setAttribute("orgDao", orgDao);

      웹애플리케이션공용저장소.setAttribute("volunteerDao", volunteerDao);
      웹애플리케이션공용저장소.setAttribute("volunteerBoardDao", volunteerBoardDao);
      웹애플리케이션공용저장소.setAttribute("volunteerBoardCommentDao", volunteerBoardCommentDao);
      웹애플리케이션공용저장소.setAttribute("volunteerShortReviewDao", volunteerShortReviewDao);

      웹애플리케이션공용저장소.setAttribute("challengeDao", challengeDao);
      웹애플리케이션공용저장소.setAttribute("challengeReviewDao", challengeReviewDao);
      웹애플리케이션공용저장소.setAttribute("challengeQuestionDao", challengeQuestionDao);

      웹애플리케이션공용저장소.setAttribute("donationBoardDao", donationBoardDao);
      웹애플리케이션공용저장소.setAttribute("donationRegisterDao", donationRegisterDao);
      웹애플리케이션공용저장소.setAttribute("noticeDao", noticeDao);
      웹애플리케이션공용저장소.setAttribute("questionDao", questionDao);
      웹애플리케이션공용저장소.setAttribute("sqlSession", sqlSession);      

      웹애플리케이션공용저장소.setAttribute("contextPath", 웹애플리케이션공용저장소.getContextPath());

    } catch (Exception e) {

      e.printStackTrace();
      System.out.println("DAO 객체 준비 중 오류 발생!");
    }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("애플리케이션 종료됨!");

    sqlSession.close();
  }
}
