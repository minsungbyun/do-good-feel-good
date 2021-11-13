package com.share.ftp.servlet.join;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/userType")
public class JoinUserTypeController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setAttribute("contentUrl", "/join/JoinUserType.jsp");
    request.getRequestDispatcher("/template1.jsp").forward(request, response);
    //    request.getRequestDispatcher("/join/JoinUserType.jsp").forward(request, response);
  }
}







