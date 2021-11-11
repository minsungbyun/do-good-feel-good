package com.share.ftp.servlet.join.org;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;

@WebServlet("/join/org/add")
public class OrgAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  OrgDao orgDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    orgDao = (OrgDao) 웹애플리케이션공용저장소.getAttribute("orgDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    OrgDTO orgDTO = new OrgDTO();

    orgDTO.setId(request.getParameter("id"));
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
    orgDTO.setType(3);
    orgDTO.setStatus(2);

    try {
      orgDao.insert(orgDTO);
      orgDao.insertOrg(orgDTO.getNo(), orgDTO.getCorpNo(), orgDTO.getFax(), orgDTO.getHomepage());
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=../../index.jsp");

      request.getRequestDispatcher("/join/org/OrgUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}







