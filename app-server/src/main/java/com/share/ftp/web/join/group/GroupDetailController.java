package com.share.ftp.web.join.group;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;

@WebServlet("/join/group/detail")
public class GroupDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  GroupDao groupDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    groupDao = (GroupDao) 웹애플리케이션공용저장소.getAttribute("groupDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {



    try {
      int no = Integer.parseInt(request.getParameter("no"));
      GroupDTO groupDTO = groupDao.findByGroupNo(no);

      if (groupDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다");
      } 

      request.setAttribute("groupDTO", groupDTO);
      request.getRequestDispatcher("/join/group/GroupUserDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







