package com.share.ftp.web.support;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.support.QuestionCategory;
import com.share.ftp.domain.support.QuestionListDTO;

@Controller
public class QuestionController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired QuestionDao questionDao;
  @Autowired GeneralDao generalDao;

  @GetMapping("/support/questionForm")
  public ModelAndView form() throws Exception {

    List<QuestionCategory> questionCategory = generalDao.findAllQnaCategory();

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionCategory", questionCategory);
    mv.addObject("pageTitle", "문의사항 새글");
    mv.addObject("contentUrl", "support/QuestionForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/support/questionAdd")
  public ModelAndView add(QuestionListDTO questionListDTO, QuestionCategory qnaType, HttpSession session) throws Exception {

    questionListDTO.setOwner((JoinDTO)session.getAttribute("loginUser"));
    questionListDTO.setQnaType(qnaType);

    questionDao.insert(questionListDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList");
    return mv;
  }

  @GetMapping("/support/questionList")
  public ModelAndView list() throws Exception {

    Collection<QuestionListDTO> questionList = questionDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionList", questionList);
    mv.addObject("pageTitle", "문의사항게시글목록");
    mv.addObject("contentUrl", "support/QuestionList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/support/questionDetail")
  public ModelAndView detail(int questionNo) throws Exception {
    QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

    if (questionListDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    questionDao.updateCount(questionNo);

    ModelAndView mv = new ModelAndView();
    mv.addObject("questionListDTO", questionListDTO);
    mv.addObject("pageTitle", "문의사항게시글");
    mv.addObject("contentUrl", "support/QuestionDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/support/questionUpdate")
  public ModelAndView update(QuestionListDTO questionListDTO, QuestionCategory qnaType) throws Exception {

    QuestionListDTO qna = questionDao.findByNo(questionListDTO.getNo());

    if (qna == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    questionListDTO.setQnaType(qnaType);

    questionDao.update(questionListDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList");
    return mv;
  }

  @GetMapping("/support/questionDelete")
  public ModelAndView delete(int questionNo) throws Exception {

    QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

    if (questionListDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    questionDao.delete(questionNo);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList");
    return mv;
  }
}







