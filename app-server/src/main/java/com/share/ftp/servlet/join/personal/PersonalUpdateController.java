package com.share.ftp.servlet.join.personal;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;

@WebServlet("/join/personal/update")
public class PersonalUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  PersonalDao personalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    personalDao = (PersonalDao) 웹애플리케이션공용저장소.getAttribute("personalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      PersonalDTO personalDTO = personalDao.findByIdPassword(id, password);

      if (personalDTO == null) {
        throw new Exception("해당 번호의 회원이 없습니다.<br>");
      } 

      personalDTO.setId(request.getParameter("photo"));
      personalDTO.setPassword(request.getParameter("password"));
      personalDTO.setName(request.getParameter("name"));
      personalDTO.setTel(request.getParameter("tel"));
      personalDTO.setEmail(request.getParameter("email"));
      personalDTO.setPostNo(Integer.valueOf(request.getParameter("postNo")));
      personalDTO.setBasicAddress(request.getParameter("basicAddress"));
      personalDTO.setDetailAddress(request.getParameter("detailAddress"));
      personalDTO.setBirthdate(Date.valueOf(request.getParameter("birthdate")));

      personalDao.update(personalDTO);
      personalDao.updatePersonal(personalDTO);
      sqlSession.commit();


      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







