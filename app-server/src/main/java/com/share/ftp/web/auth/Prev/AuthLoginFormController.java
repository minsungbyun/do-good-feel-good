package com.share.ftp.web.auth.Prev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/auth/loginForm")
public class AuthLoginFormController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setAttribute("pageTitle", "로그인");
    request.setAttribute("contentUrl", "/auth/Login.jsp");
    //    request.getRequestDispatcher("/auth/Login.jsp").forward(request, response);
    request.getRequestDispatcher("/template1.jsp").forward(request, response);

  }
}







