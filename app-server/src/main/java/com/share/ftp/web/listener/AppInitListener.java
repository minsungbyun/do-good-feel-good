package com.share.ftp.web.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("애플리케이션 시작됨!");

    ServletContext sc = sce.getServletContext();
    sce.getServletContext().setAttribute("contextPath", sc.getContextPath());
  }
}
