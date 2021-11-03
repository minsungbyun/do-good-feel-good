package com.share.ftp.servlet.join.org;

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
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;

@WebServlet("/join/org/add")
public class OrgAddController extends HttpServlet {
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


    OrgDTO orgDTO = new OrgDTO();

    orgDTO.setId(request.getParameter("id"));
    orgDTO.setPassword(request.getParameter("password"));
    orgDTO.setName(request.getParameter("name"));
    orgDTO.setTel(request.getParameter("tel"));
    orgDTO.setEmail(request.getParameter("email"));
    orgDTO.setPostNo(Integer.valueOf(request.getParameter("postNo")));
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
      response.setHeader("Refresh", "1;url=list");

      request.getRequestDispatcher("/join/org/OrgUserAdd.jsp").forward(request, response);

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







