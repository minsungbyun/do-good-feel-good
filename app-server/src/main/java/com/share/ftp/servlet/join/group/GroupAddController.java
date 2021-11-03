package com.share.ftp.servlet.join.group;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/join/group/add")
public class GroupAddController extends HttpServlet {
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


    GroupDTO groupDTO = new GroupDTO();

    groupDTO.setId(request.getParameter("id"));
    groupDTO.setPassword(request.getParameter("password"));
    groupDTO.setName(request.getParameter("name"));
    groupDTO.setTel(request.getParameter("tel"));
    groupDTO.setEmail(request.getParameter("email"));
    groupDTO.setPostNo(request.getParameter("postNo"));
    groupDTO.setBasicAddress(request.getParameter("basicAddress"));
    groupDTO.setDetailAddress(request.getParameter("detailAddress"));
    groupDTO.setType(2);
    groupDTO.setStatus(2);

    groupDTO.setGroupCount(Integer.valueOf(request.getParameter("groupCount")));

    try {
      groupDao.insert(groupDTO);
      groupDao.insertGroup(groupDTO.getNo(), groupDTO.getGroupCount());
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=list");

      request.getRequestDispatcher("/join/group/GroupUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);
      e.printStackTrace();

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}







