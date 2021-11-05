package com.share.ftp.servlet.challenge;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;


@WebServlet("/challenge/reviewUpdateDetail")
public class ChallengeReviewUpdateDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeReviewDao challengeReviewDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeReviewDao = (ChallengeReviewDao) 웹애플리케이션공용저장소.getAttribute("challengeReviewDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeReviewNo = Integer.parseInt(request.getParameter("reviewNo"));
      ChallengeReviewDTO challengeReviewDTO = challengeReviewDao.findByNo(challengeReviewNo);

      if (challengeReviewDTO == null) {
        throw new Exception("해당 번호의 챌린지가 없습니다.");
      }

      request.setAttribute("challengeReviewDTO", challengeReviewDTO);
      // 출력을 담당할 뷰를 호출한다.
      request.getRequestDispatcher("/challenge/ChallengeReviewUpdateDetail.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







