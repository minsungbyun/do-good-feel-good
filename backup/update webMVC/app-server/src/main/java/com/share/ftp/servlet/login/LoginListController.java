package com.share.ftp.servlet.login;

import java.io.IOException;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/login/list")
public class LoginListController extends GenericServlet {
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

      List<JoinDTO> joinUserList = joinDao.findAll();
      request.setAttribute("joinUserList", joinUserList);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/login/LoginList.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}



