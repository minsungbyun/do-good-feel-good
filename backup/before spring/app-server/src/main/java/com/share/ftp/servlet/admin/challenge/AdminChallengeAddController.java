package com.share.ftp.servlet.admin.challenge;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/admin/challenge/add")
public class AdminChallengeAddController extends HttpServlet {
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

    ChallengeDTO challengeDTO = new ChallengeDTO();

    challengeDTO.setTitle(request.getParameter("title"));
    challengeDTO.setContent(request.getParameter("content")); 
    //    challengeDTO.setFileUpload(request.promptChllengeFileUpload()); 


    challengeDTO.setStartDate(Date.valueOf(request.getParameter("startDate")));
    challengeDTO.setEndDate(Date.valueOf(request.getParameter("endDate")));


    try {
      if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) > 0) {
        throw new Exception("종료일을 지난 시작일은 존재하지 않습니다. 올바른 날짜를 입력해주세요!");
      }

      if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) == 0) {
        throw new Exception("시작일과 종료일은 같을 수 없습니다. 올바른 날짜를 입력해주세요!");
      }
      challengeDao.insert(challengeDTO);
      //        for (ChallengeAttachedFile challengeAttachedFile : challengeDTO.getFileUpload()) {
      //          challengeDao.insertFile(challengeDTO.getNo(), challengeAttachedFile.getFilepath());
      //        }
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=list");
      request.getRequestDispatcher("AdminChallengeAdd.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      //      sqlSession.rollback();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}

