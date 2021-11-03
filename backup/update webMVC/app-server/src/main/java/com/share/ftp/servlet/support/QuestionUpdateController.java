package com.share.ftp.servlet.support;

import java.io.IOException;
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
import com.share.ftp.domain.support.QuestionListDTO;

@WebServlet("/support/questionUpdate")
public class QuestionUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  QuestionDao questionDao;
  //  GeneralDao generalDao;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int questionNo = Integer.parseInt(request.getParameter("questionNo"));

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      if (questionListDTO == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      } 

      JoinDTO owner = new JoinDTO();
      owner.setNo(Integer.parseInt(request.getParameter("owner")));

      //    questionListDTO.setQnaType(request.setAttribute(getServletName(), questionListDTO);
      questionListDTO.setTitle(request.getParameter("title")); 
      questionListDTO.setContent(request.getParameter("content"));
      questionListDTO.setQnaPassword(request.getParameter("qnaPassword"));
      //    noticeDTO.setFileUpload(request.getParameter("fileUpload"));

      questionDao.update(questionListDTO);
      sqlSession.commit();

      response.sendRedirect("questionList");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
