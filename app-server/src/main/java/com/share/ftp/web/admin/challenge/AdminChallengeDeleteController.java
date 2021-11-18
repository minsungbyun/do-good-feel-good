package com.share.ftp.web.admin.challenge;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;

@WebServlet("/admin/challenge/delete")
public class AdminChallengeDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    challengeDao = (ChallengeDao) 웹애플리케이션공용저장소.getAttribute("challengeDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int challengeNo = Integer.parseInt(request.getParameter("no")); durtlsjanwhfflrnajs
      ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);
      if (challengeDTO == null) {
        throw new Exception("해당 번호의 챌린지가 없습니다.");
      }

      //      challengeDao.deleteFile(challengeNo);
      challengeDao.delete(challengeNo);
      sqlSession.commit();

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}