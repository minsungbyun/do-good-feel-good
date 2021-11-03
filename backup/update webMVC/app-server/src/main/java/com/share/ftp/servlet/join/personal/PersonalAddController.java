package com.share.ftp.servlet.join.personal;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/join/personal/add")
public class PersonalAddController extends HttpServlet {
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


    PersonalDTO personalDTO = new PersonalDTO();

    personalDTO.setId(request.getParameter("id"));
    personalDTO.setPassword(request.getParameter("password"));
    personalDTO.setName(request.getParameter("name"));
    personalDTO.setTel(request.getParameter("tel"));
    personalDTO.setEmail(request.getParameter("email"));
    personalDTO.setPostNo(Integer.valueOf(request.getParameter("postNo")));
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
      response.setHeader("Refresh", "1;url=list");

      request.getRequestDispatcher("/join/peosonal/PeosonalUserAdd.jsp").forward(request, response);

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







