package com.share.ftp.servlet.support;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;

@WebServlet("/support/questionList")
public class QuestionListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  QuestionDao questionDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      Collection<QuestionListDTO> questionList = questionDao.findAll();


      request.setAttribute("questionList", questionList);

      request.setAttribute("pageTitle", "문의사항 목록");
      request.setAttribute("contentUrl", "/support/QuestionList.jsp");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/template1.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}