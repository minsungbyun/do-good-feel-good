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
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/challenge/questionAdd")
public class ChallengeQuestionAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;


  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
    challengeQuestionDao = (ChallengeQuestionDao) 웹애플리케이션공용저장소.getAttribute("challengeQuestionDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      ChallengeQuestionDTO challengeQuestionDTO = new ChallengeQuestionDTO();

      challengeQuestionDTO.setContent(request.getParameter("content"));
      challengeQuestionDTO.setOwner((JoinDTO) request.getSession().getAttribute("loginUser"));
      System.out.println(challengeQuestionDTO.getOwner().getNo());
      challengeQuestionDTO.setNo(Integer.parseInt(request.getParameter("no")));
      challengeQuestionDao.insert(challengeQuestionDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=questionList?no=" + Integer.parseInt(request.getParameter("no")));
      request.getRequestDispatcher("ChallengeQuestionAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
