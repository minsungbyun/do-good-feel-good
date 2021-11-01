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
import com.share.ftp.dao.VolunteerDao;

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
      VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);
      ChallengeDao challengeDao = sqlSession.getMapper(ChallengeDao.class);
      ChallengeReviewDao challengeReviewDao = sqlSession.getMapper(ChallengeReviewDao.class);
      ChallengeQuestionDao challengeQuestionDao = sqlSession.getMapper(ChallengeQuestionDao.class);

      // 모든 웹 애플리케이션의 컴포넌트(서블릿, 리스너, 필터)가 공유할 객체를 두는 저장소
      ServletContext 웹애플리케이션공용저장소 = sce.getServletContext();

      // 웹 애플리케이션 공용 저장소에 DAO 객체를 보관한다.
      // => 이 저장소에 보관된 객체는 서블릿에서 사용할 것이다.
      웹애플리케이션공용저장소.setAttribute("volunteerDao", volunteerDao);
      웹애플리케이션공용저장소.setAttribute("challengeDao", challengeDao);
      웹애플리케이션공용저장소.setAttribute("challengeReviewDao", challengeReviewDao);
      웹애플리케이션공용저장소.setAttribute("challengeQuestionDao", challengeQuestionDao);

      웹애플리케이션공용저장소.setAttribute("sqlSession", sqlSession);      

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
