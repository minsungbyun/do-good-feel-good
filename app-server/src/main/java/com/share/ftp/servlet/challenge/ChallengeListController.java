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
import com.share.ftp.domain.admin.ChallengeDTO;

@WebServlet("/challenge/list")
public class ChallengeListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {
      Collection<ChallengeDTO> challengeList = challengeDao.findAll();
      request.setAttribute("challengeList", challengeList);
      request.setAttribute("pageTitle", "회원목록");
      request.setAttribute("contentUrl", "/challenge/ChallengeList.jsp");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/template1.jsp");
      요청배달자.forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
