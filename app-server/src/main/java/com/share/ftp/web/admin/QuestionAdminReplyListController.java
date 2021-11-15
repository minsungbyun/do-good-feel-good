package com.share.ftp.web.admin;

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

@WebServlet("/admin/question/list")
public class QuestionAdminReplyListController extends GenericServlet {
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

      // 출력을 담당할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/admin/AdminQuestionList.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }




    //    Collection<QuestionListDTO> questionList = questionDao.findAll();
    //
    //    if (questionList.isEmpty()) {
    //      System.out.println("게시글이 없습니다.");
    //      System.out.println();
    //    }
    //
    //
    //    for (QuestionListDTO questionListDTO : questionList) {
    //      System.out.printf("%d, %s, %d,", 
    //          questionListDTO.getNo(),
    //          questionListDTO.getRegisteredDate(),
    //          questionListDTO.getViewCount());
    //      if (questionListDTO.getReply() != null) {
    //        System.out.printf("%s\n", questionListDTO.getReply());
    //      }

  }
}