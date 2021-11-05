package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;


@WebServlet("/volunteer/commentForm")
public class VolunteerBoardCommentFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int volBoardNo = Integer.parseInt(request.getParameter("volBoardNo"));
      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

      request.setAttribute("volunteerBoardDTO", volunteerBoardDTO);
      // 출력을 담당할 뷰를 호출한다.
      request.getRequestDispatcher("VolunteerBoardCommentForm.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}

