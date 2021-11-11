package com.share.ftp.servlet.join.personal;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;

@WebServlet("/join/personal/add")
public class PersonalAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  PersonalDao personalDao;

  @Override
  public void init()  {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    personalDao = (PersonalDao) 웹애플리케이션공용저장소.getAttribute("personalDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PersonalDTO personalDTO = new PersonalDTO();

    personalDTO.setId(request.getParameter("id"));
    personalDTO.setPassword(request.getParameter("password"));
    personalDTO.setName(request.getParameter("name"));
    personalDTO.setTel(request.getParameter("tel"));
    personalDTO.setEmail(request.getParameter("email"));
    personalDTO.setPostNo(request.getParameter("postNo"));
    personalDTO.setBasicAddress(request.getParameter("basicAddress"));
    personalDTO.setDetailAddress(request.getParameter("detailAddress"));

    personalDTO.setBirthdate(Date.valueOf(request.getParameter("birthdate")));
    personalDTO.setType(1);
    personalDTO.setStatus(1);
    personalDTO.setLevel("천콩이");

    try {
      personalDao.insert(personalDTO);
      personalDao.insertPersonal(personalDTO.getNo(), personalDTO.getBirthdate(), personalDTO.getLevel());
      sqlSession.commit();

      response.setHeader("Refresh", "1;url=../../index.jsp");
      request.getRequestDispatcher("/join/personal/PersonalUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}







