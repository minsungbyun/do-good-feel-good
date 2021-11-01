package com.share.ftp.servlet.vol;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@WebServlet("/vol/boarddetail")
public class VolunteerBoardDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      int volBoardNo = Integer.parseInt(request.getParameter("no"));
      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

      if (volunteerBoardDTO == null) {
        throw new Exception("[  해당 게시글이 없습니다.  ]");
      }

      request.setAttribute("volunteerBoardDTO", volunteerBoardDTO);
      request.getRequestDispatcher("/vol/VolunteerBoardDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      e.printStackTrace();
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
