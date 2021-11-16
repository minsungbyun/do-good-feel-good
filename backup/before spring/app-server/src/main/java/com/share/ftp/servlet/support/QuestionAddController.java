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
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.support.QuestionCategory;
import com.share.ftp.domain.support.QuestionListDTO;

@WebServlet("/support/questionAdd")
public class QuestionAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  QuestionDao questionDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QuestionListDTO questionListDTO = new QuestionListDTO();

    QuestionCategory questionCategory = new QuestionCategory();
    questionCategory.setNo(Integer.parseInt(request.getParameter("qnaType")));

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    questionListDTO.setOwner(owner);
    questionListDTO.setQnaType(questionCategory);
    questionListDTO.setTitle(request.getParameter("title")); 
    questionListDTO.setContent(request.getParameter("content"));
    questionListDTO.setQnaPassword(request.getParameter("qnaPassword"));
    //    noticeDTO.setFileUpload(request.getParameter("fileUpload"));
    questionListDTO.setStatus(0);

    try {
      questionDao.insert(questionListDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=questionList");
      request.getRequestDispatcher("support/QuestionAdd.jsp").forward(request, response);

    } catch (Exception e) {
      sqlSession.rollback();
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}