package com.share.ftp.servlet.admin.challenge;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

@WebServlet("/admin/challenge/replyDelete")
public class AdminChallengeReplyDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeQuestionDao = (ChallengeQuestionDao) 웹애플리케이션공용저장소.getAttribute("challengeQuestionDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int challengeQuestionNo = Integer.parseInt(request.getParameter("questionNo")); 
      ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(challengeQuestionNo);

      if (challengeQuestionDTO == null) {
        System.out.println("해당 번호의 문의가 없습니다.");
        return;
      }

      challengeQuestionDTO.setReply(null);

      response.sendRedirect("questionList?no=" + Integer.parseInt(request.getParameter("no")));
      challengeQuestionDao.updateReply(challengeQuestionDTO);
      sqlSession.commit();

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}