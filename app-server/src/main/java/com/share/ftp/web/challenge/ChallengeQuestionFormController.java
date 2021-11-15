package com.share.ftp.web.challenge;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;


@WebServlet("/challenge/questionForm")
public class ChallengeQuestionFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeNo = Integer.parseInt(request.getParameter("no"));
      ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);
      System.out.println(request.getSession().getAttribute("loginUser"));
      request.setAttribute("challengeDTO", challengeDTO);
      // 출력을 담당할 뷰를 호출한다.
      request.setAttribute("pageTitle", "문의 등록");
      request.setAttribute("contentUrl", "/challenge/ChallengeQuestionForm.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







