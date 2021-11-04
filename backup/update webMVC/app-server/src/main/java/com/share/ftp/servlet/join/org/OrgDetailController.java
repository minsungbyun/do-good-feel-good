package com.share.ftp.servlet.join.org;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;

@WebServlet("/join/org/detail")
public class OrgDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  OrgDao orgDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    orgDao = (OrgDao) 웹애플리케이션공용저장소.getAttribute("orgDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {



    try {
      int no = Integer.parseInt(request.getParameter("no"));
      OrgDTO orgDTO = orgDao.findByOrgNo(no);

      if (orgDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다");
      } 

      request.setAttribute("orgDTO", orgDTO);
      request.getRequestDispatcher("/join/org/OrgUserDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







