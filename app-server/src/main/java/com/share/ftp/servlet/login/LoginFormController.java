package com.share.ftp.servlet.login;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/login/form")
public class LoginFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {


    request.getRequestDispatcher("/login/Login.jsp").forward(request, response);

  }
}







