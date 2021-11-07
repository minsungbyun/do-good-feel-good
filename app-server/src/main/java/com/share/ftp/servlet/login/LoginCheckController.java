package com.share.ftp.servlet.login;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/login/check")
public class LoginCheckController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  JoinDao joinDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      JoinDTO joinDTO = joinDao.findByIdPassword(id, password);

      if (joinDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다");
      } 

      // happyshare 메인페이지로 이동
      request.getRequestDispatcher("/index.html").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







