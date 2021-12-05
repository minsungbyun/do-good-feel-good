package com.share.ftp.servlet.challenge;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;

@WebServlet("/challenge/join")
public class ChallengeJoinController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int challengeNo = Integer.parseInt(request.getParameter("no"));

      int userNo = 1;
      challengeDao.insertUser(challengeNo, userNo);

      sqlSession.commit();
      response.setHeader("Refresh", "1;url=list");
      request.getRequestDispatcher("ChallengeJoin.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      //      sqlSession.rollback();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
