package com.share.ftp.servlet.challenge;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

@WebServlet("/challengeReview/list")
public class ChallengeReviewListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;
  ChallengeReviewDao challengeReviewDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
    challengeReviewDao = (ChallengeReviewDao) 웹애플리케이션공용저장소.getAttribute("challengeReviewDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeNo = (int) request.getAttribute("challengeNo");
      challengeDao.findByNo(challengeNo);
      Collection<ChallengeReviewDTO> challengeReviewList = challengeReviewDao.findAll();
      request.setAttribute("challengeReviewList", challengeReviewList);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/challenge/ChallengeReviewList.jsp");
      요청배달자.forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}

