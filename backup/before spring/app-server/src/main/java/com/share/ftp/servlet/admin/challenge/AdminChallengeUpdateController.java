package com.share.ftp.servlet.admin.challenge;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/admin/challenge/update")
public class AdminChallengeUpdateController extends HttpServlet {
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
      int challengeNo = Integer.parseInt(request.getParameter("no"));

      ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

      if (challengeDTO == null) {
        System.out.println("해당 번호의 챌린지가 없습니다.");
        return;
      }
      challengeDTO.setTitle(request.getParameter("title"));
      challengeDTO.setContent(request.getParameter("content"));
      //      challengeDTO.setFileUpload(fileUpload);
      challengeDTO.setStartDate(Date.valueOf(request.getParameter("startDate")));
      challengeDTO.setEndDate(Date.valueOf(request.getParameter("endDate")));

      if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) > 0) {
        throw new Exception("종료일을 지난 시작일은 존재하지 않습니다. 올바른 날짜를 입력해주세요!");
      }

      if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) == 0) {
        throw new Exception("시작일과 종료일은 같을 수 없습니다. 올바른 날짜를 입력해주세요!");
      }

      challengeDao.update(challengeDTO);
      sqlSession.commit();

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}