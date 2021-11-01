package com.share.ftp.servlet.join.group;

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
import com.share.ftp.domain.join.GroupDTO;

@WebServlet("/join/group/update")
public class GroupUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  GroupDao groupDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    groupDao = (GroupDao) 웹애플리케이션공용저장소.getAttribute("groupDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      GroupDTO groupDTO = groupDao.findByIdPassword(id, password);

      if (groupDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다.<br>");
      } 

      groupDTO.setId(request.getParameter("photo"));
      groupDTO.setPassword(request.getParameter("password"));
      groupDTO.setName(request.getParameter("name"));
      groupDTO.setTel(request.getParameter("tel"));
      groupDTO.setEmail(request.getParameter("email"));
      groupDTO.setPostNo(request.getParameter("postNo"));
      groupDTO.setBasicAddress(request.getParameter("basicAddress"));
      groupDTO.setDetailAddress(request.getParameter("detailAddress"));
      groupDTO.setGroupCount(Integer.valueOf(request.getParameter("groupCount")));

      groupDao.update(groupDTO);
      groupDao.updateGroup(groupDTO);
      sqlSession.commit();


      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







