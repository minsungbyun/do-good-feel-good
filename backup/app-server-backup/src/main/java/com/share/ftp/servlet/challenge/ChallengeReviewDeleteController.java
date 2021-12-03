package com.share.ftp.servlet.challenge;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

@WebServlet("/challenge/reviewDelete")
public class ChallengeReviewDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeReviewDao challengeReviewDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeReviewDao = (ChallengeReviewDao) 웹애플리케이션공용저장소.getAttribute("challengeReviewDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int challengeReviewNo = Integer.parseInt(request.getParameter("reviewNo")); 
      ChallengeReviewDTO challengeReviewDTO = challengeReviewDao.findByNo(challengeReviewNo);
      if (challengeReviewDTO == null) {
        throw new Exception("해당 번호의 문의가 없습니다.");
      }

      //      challengeDao.deleteFile(challengeNo);
      challengeReviewDao.delete(challengeReviewDTO.getReviewNo());
      sqlSession.commit();

      response.sendRedirect("reviewList?no=" + Integer.parseInt(request.getParameter("no")));

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}

