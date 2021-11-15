package com.share.ftp.web.join.org;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;

@WebServlet("/join/org/update")
public class OrgUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  OrgDao orgDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    orgDao = (OrgDao) 웹애플리케이션공용저장소.getAttribute("orgDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      OrgDTO orgDTO = orgDao.findByIdPassword(id, password);

      if (orgDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다.<br>");
      } 

      orgDTO.setId(request.getParameter("photo"));
      orgDTO.setPassword(request.getParameter("password"));
      orgDTO.setName(request.getParameter("name"));
      orgDTO.setTel(request.getParameter("tel"));
      orgDTO.setEmail(request.getParameter("email"));
      orgDTO.setPostNo(request.getParameter("postNo"));
      orgDTO.setBasicAddress(request.getParameter("basicAddress"));
      orgDTO.setDetailAddress(request.getParameter("detailAddress"));
      orgDTO.setCorpNo(request.getParameter("corpNo"));
      orgDTO.setFax(request.getParameter("fax"));
      orgDTO.setHomepage(request.getParameter("homepage"));

      orgDao.update(orgDTO);
      orgDao.updateOrg(orgDTO);
      sqlSession.commit();


      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







