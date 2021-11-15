package com.share.ftp.web.join;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.join.OrgDTO;

@WebServlet("/join/statusUpdate")
public class StatusUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  OrgDao orgDao;
  GroupDao groupDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    orgDao = (OrgDao) 웹애플리케이션공용저장소.getAttribute("orgDao");
    groupDao = (GroupDao) 웹애플리케이션공용저장소.getAttribute("groupDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      OrgDTO orgDTO = orgDao.findByIdPassword(id, password);
      GroupDTO groupDTO = groupDao.findByIdPassword(id, password);

      if (orgDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다.<br>");
      } 

      orgDTO.setStatus(Integer.valueOf(request.getParameter("status")));
      groupDTO.setStatus(Integer.valueOf(request.getParameter("status")));

      orgDao.updateStatus(orgDTO);
      groupDao.updateStatus(groupDTO);
      sqlSession.commit();

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







