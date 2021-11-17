package com.share.ftp.web.join.group;

import java.io.IOException;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;

//@WebServlet("/join/group/list")
public class GroupListController extends GenericServlet {
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

      List<GroupDTO> groupUserList = groupDao.findAllGroup();
      request.setAttribute("groupUserList", groupUserList);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/join/group/GroupUserList.jsp");
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



