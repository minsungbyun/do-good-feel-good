package com.share.ftp.servlet.challenge;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;

@WebServlet("/challenge/detail")
public class ChallengeDetailController extends GenericServlet {
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
      int challengeNo = Integer.parseInt(request.getParameter("no"));
      ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

      if (challengeDTO == null) {
        throw new Exception("해당 번호의 챌린지가 없습니다.");
      }

      request.setAttribute("challengeDTO", challengeDTO);

      request.setAttribute("pageTitle", "챌린지 상세보기");
      request.setAttribute("contentUrl", "/challenge/ChallengeDetail.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}