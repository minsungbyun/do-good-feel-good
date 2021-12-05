package com.share.ftp.web.admin.support;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionCategory;
import com.share.ftp.domain.support.QuestionListDTO;

@Controller
public class AdminQuestionReplyController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired QuestionDao questionDao;
  @Autowired GeneralDao generalDao;

  @GetMapping("/admin/support/questionList")
  public ModelAndView list() throws Exception {

    Collection<QuestionListDTO> questionList = questionDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionList", questionList);
    mv.addObject("pageTitle", "관리자페이지: 문의사항 목록");
    mv.addObject("contentUrl", "admin/support/AdminQuestionList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/support/replyUpdate")
  public ModelAndView update(QuestionListDTO questionListDTO,
      QuestionCategory qnaType) throws Exception {

    System.out.println(questionListDTO.getNo());

    QuestionListDTO questionReply = questionDao.findByNo(questionListDTO.getNo());

    if (questionReply == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    } 

    questionListDTO.setQnaType(qnaType);
    questionListDTO.setStatus(1);

    questionDao.updateReply(questionListDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList");
    return mv;
  }

  @GetMapping("/admin/support/replyUpdateDetail")
  public ModelAndView detail(int questionNo) throws Exception {
    QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

    if (questionListDTO == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionListDTO", questionListDTO);
    mv.addObject("pageTitle", "답변 등록&변경");
    mv.addObject("contentUrl", "admin/support/AdminQuestionReUpdateDetail.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/support/replyDelete")
  public ModelAndView replyDelete(QuestionListDTO questionListDTO
      ) throws Exception {

    System.out.println(questionListDTO.getNo());
    QuestionListDTO questionReply = questionDao.findByNo(questionListDTO.getNo());

    if (questionReply == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    } 

    questionReply.setReply(null);

    questionDao.updateReply(questionListDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList");
    return mv;
  }

}

//package com.share.ftp.web.admin.support;
//
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.ibatis.session.SqlSession;
//import com.share.ftp.dao.QuestionDao;
//import com.share.ftp.domain.join.JoinDTO;
//import com.share.ftp.domain.support.QuestionListDTO;
//
//@WebServlet("/admin/question/replyAdd")
//public class AdminQuestionReplyController extends HttpServlet {
//  private static final long serialVersionUID = 1L;
//
//  QuestionDao questionDao;
//  SqlSession sqlSession;
//
//  @Override
//  public void init(ServletConfig config) throws ServletException {
//    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
//    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
//    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
//  }
//
//  @Override
//  protected void service(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {

//    int questionNo = (int) request.getAttribute("questionNo");
//    QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

//    QuestionListDTO questionListDTO = new QuestionListDTO();
//
//    JoinDTO owner = new JoinDTO();
//    owner.setNo(Integer.parseInt(request.getParameter("owner")));
//
//    questionListDTO.setOwner(owner);
//    questionListDTO.setTitle(request.getParameter("title"));
//    questionListDTO.setReply(request.getParameter("reply"));
//    questionListDTO.setStatus(1);
//
//    try {
//      questionDao.insert(questionListDTO);
//      sqlSession.commit();
//      response.setHeader("Refresh", "1;url=list");
//      request.getRequestDispatcher("admin/AdminQuestionAdd.jsp").forward(request, response);
//
//    } catch (Exception e) {
//      sqlSession.rollback();
//      e.printStackTrace();
//      request.setAttribute("error", e);

// 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
//      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
//      요청배달자.forward(request, response);
//    }

//  @Override
//  public void execute(CommandRequest request) throws Exception {
//
//    System.out.println();
//    System.out.println("[ 문의사항 - 답글]");
//
//    int questionNo = (int) request.getAttribute("adminNo");
//    QuestionListDTO adminQuestionListDTO = findByNo(questionNo);
//
//    QuestionListDTO questionListDTO = new QuestionListDTO();
//
//    questionListDTO.setTitle(Prompt.inputString("제목? "));
//    questionListDTO.setContent(Prompt.inputString("내용? "));
//    questionListDTO.setQnaType(adminQuestionListDTO.getQnaType());
//    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
//    questionListDTO.setPassword(AuthLoginHandler.getLoginUser().getAdminPassword());
//    questionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
//    questionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
//
//    myQuestionListDTO.setNo(adminQuestionListDTO.getNo());

//  int a = indexOf(adminQuestionListDTO.getNo());
//
//  myQuestionListDTOList.add(a + 1, myQuestionListDTO);
//
//    System.out.println();
//    System.out.println("문의 답글이 등록되었습니다.");
//
//  }


//  }
//}
