package com.share.ftp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet implements Servlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("안녕!");
    out.println("Hello!");



    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>happyshare</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>sorry</h1>");
    out.println("</body>");
    out.println("</html>");




  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }

}
