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
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/challenge/reviewAdd")
public class ChallengeReviewAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;


  ChallengeDao challengeDao;
  ChallengeReviewDao challengeReviewDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
    challengeReviewDao = (ChallengeReviewDao) 웹애플리케이션공용저장소.getAttribute("challengeReviewDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ChallengeReviewDTO challengeReviewDTO = new ChallengeReviewDTO();

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    challengeReviewDTO.setContent(request.getParameter("content"));
    challengeReviewDTO.setOwner(owner);

    try {
      challengeReviewDTO.setNo(Integer.parseInt(request.getParameter("no")));
      challengeReviewDao.insert(challengeReviewDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=reviewList?no=" + Integer.parseInt(request.getParameter("no")));
      request.getRequestDispatcher("ChallengeReviewAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
