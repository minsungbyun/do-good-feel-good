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
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

@WebServlet("/challenge/questionList")
public class ChallengeQuestionListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  //  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    //    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
    challengeQuestionDao = (ChallengeQuestionDao) 웹애플리케이션공용저장소.getAttribute("challengeQuestionDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {
      int challengeNo = Integer.parseInt(request.getParameter("no"));
      Collection<ChallengeQuestionDTO> challengeQuestionList = challengeQuestionDao.findAllNo(challengeNo);
      request.setAttribute("challengeQuestionList", challengeQuestionList);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/challenge/ChallengeQuestionList.jsp");
      요청배달자.forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
