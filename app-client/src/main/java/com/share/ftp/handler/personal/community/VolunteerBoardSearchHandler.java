package com.share.ftp.handler.personal.community;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@WebServlet("/volunteer/boardSearch")
public class VolunteerBoardSearchHandler extends GenericServlet {
  private static final long serialVersionUID = 1L;
  SqlSession sqlSession;
  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      int keyword = Integer.parseInt(request.getParameter("keyword"));
      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(keyword);

      if (volunteerBoardDTO == null) {
        throw new Exception("[  해당 게시글이 없습니다.  ]");
      }
      request.setAttribute("volunteerBoardDTO", volunteerBoardDTO);
      request.getRequestDispatcher("VolunteerBoardDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      e.printStackTrace();
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
