package com.share.ftp.web.support;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.support.QuestionCategory;


@WebServlet("/support/questionForm")
public class QuestionFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  GeneralDao generalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      List<QuestionCategory> qnaCategory = generalDao.findAllQnaCategory();

      request.setAttribute("qnaCategory", qnaCategory);
      request.setAttribute("pageTitle", "문의사항 등록");
      request.setAttribute("contentUrl", "/support/QuestionForm.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







