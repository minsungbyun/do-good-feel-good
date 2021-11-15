package com.share.ftp.web.auth;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/auth/loginList")
public class AuthLoginListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  JoinDao joinDao;

  @Override
  public void init()  {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      List<JoinDTO> joinUserList = joinDao.findAll();
      request.setAttribute("joinUserList", joinUserList);
      request.setAttribute("contentUrl", "/auth/LoginList.jsp");
      request.getRequestDispatcher("/template2.jsp").forward(request, response);

      //      request.getRequestDispatcher("/auth/LoginList.jsp").forward(request, response);


    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}



