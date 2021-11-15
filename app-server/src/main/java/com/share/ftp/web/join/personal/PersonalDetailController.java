package com.share.ftp.web.join.personal;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;

@WebServlet("/join/personal/detail")
public class PersonalDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  PersonalDao personalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    personalDao = (PersonalDao) 웹애플리케이션공용저장소.getAttribute("personalDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {



    try {
      int no = Integer.parseInt(request.getParameter("no"));
      PersonalDTO personalDTO = personalDao.findByPersonalNo(no);

      if (personalDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다");
      } 

      request.setAttribute("personalDTO", personalDTO);
      request.getRequestDispatcher("/join/personal/PersonalUserDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







