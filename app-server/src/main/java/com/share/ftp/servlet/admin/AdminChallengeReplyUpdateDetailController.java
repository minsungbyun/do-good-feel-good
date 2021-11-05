package com.share.ftp.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;


@WebServlet("/admin/challenge/replyUpdateDetail")
public class AdminChallengeReplyUpdateDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeQuestionDao challengeQuestionDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeQuestionDao = (ChallengeQuestionDao) 웹애플리케이션공용저장소.getAttribute("challengeQuestionDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeQuestionNo = Integer.parseInt(request.getParameter("questionNo"));
      ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(challengeQuestionNo);

      if (challengeQuestionDTO == null) {
        throw new Exception("해당 번호의 챌린지가 없습니다.");
      }

      request.setAttribute("challengeQuestionDTO", challengeQuestionDTO);
      // 출력을 담당할 뷰를 호출한다.
      request.getRequestDispatcher("/admin/AdminChallengeReplyUpdateDetail.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







