package com.share.ftp.servlet.support;

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
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;

@WebServlet("/support/questionAdd")
public class QuestionAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  QuestionDao questionDao;
  //  GeneralDao generalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
    //    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QuestionListDTO questionListDTO = new QuestionListDTO();

    //    questionListDTO.setQnaType(request.setAttribute(getServletName(), questionListDTO);
    questionListDTO.setTitle(request.getParameter("title")); 
    questionListDTO.setContent(request.getParameter("content"));
    //        questionListDTO.getQnaPassword(parseInt(request.getParameter("qnaPassword")));
    //    noticeDTO.setFileUpload(request.getParameter("fileUpload"));
    //    questionListDTO.setStatus(0);

    try {
      questionDao.insert(questionListDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=questionList");
      request.getRequestDispatcher("QuestionAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}