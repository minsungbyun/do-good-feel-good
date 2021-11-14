package com.share.ftp.servlet.admin.challenge;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;

@WebServlet("/admin/challenge/list")
public class AdminChallengeListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      Collection<ChallengeDTO> challengeList = challengeDao.findAll();

      request.setAttribute("challengeList", challengeList);
      request.setAttribute("contentUrl", "/admin/challenge/AdminChallengeList.jsp");
      request.getRequestDispatcher("/template2.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
