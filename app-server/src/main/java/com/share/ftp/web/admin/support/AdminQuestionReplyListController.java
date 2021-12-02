package com.share.ftp.web.admin.support;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;

@Controller
public class AdminQuestionReplyListController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired QuestionDao questionDao;
  @Autowired GeneralDao generalDao;

  //  @GetMapping("/admin/support/questionList")
  public ModelAndView list(int no) throws Exception {
    QuestionListDTO questionListDTO = questionDao.findByNo(no);

    Collection<QuestionListDTO> questionList = questionDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionList", questionList);
    mv.addObject("questionList", questionList);
    mv.addObject("pageTitle", "Happy share: 문의사항 목록");
    mv.addObject("contentUrl", "admin/support/AdminQuestionList.jsp");
    mv.setViewName("template2");
    return mv;
  }

}

//@WebServlet("/admin/support/questionList")
//public class AdminQuestionReplyListController extends GenericServlet {
//  private static final long serialVersionUID = 1L;
//
//  QuestionDao questionDao;

//  @Override
//  public void init(ServletConfig config) throws ServletException {
//    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
//    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
//  }
//
//  @Override
//  public void service(ServletRequest request, ServletResponse response)
//      throws ServletException, IOException {
//
//    try {
//      Collection<QuestionListDTO> questionList = questionDao.findAll();
//
//      request.setAttribute("questionList", questionList);
//
//      // 출력을 담당할 뷰를 호출한다.
//      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/admin/AdminQuestionList.jsp");
//      요청배달자.forward(request, response);
//
//    } catch (Exception e) {
//      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
//      e.printStackTrace();
//      request.setAttribute("error", e);
//
//      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
//      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
//      요청배달자.forward(request, response);
//    }
//



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

//  }
//}