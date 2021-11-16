package com.share.ftp.web.admin.challenge;

import java.util.Collection;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

@Controller
public class AdminChallengeReplyController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ChallengeDao challengeDao;
  @Autowired ChallengeQuestionDao challengeQuestionDao;
  @Autowired ServletContext sc;

  @GetMapping("/admin/challenge/questionList")
  public ModelAndView list(int no) throws Exception {
    ChallengeDTO challengeDTO = challengeDao.findByNo(no);

    Collection<ChallengeQuestionDTO> challengeQuestionList = challengeQuestionDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeDTO", challengeDTO);
    mv.addObject("challengeQuestionList", challengeQuestionList);
    mv.addObject("pageTitle", "Happy share: 챌린지 문의");
    mv.addObject("contentUrl", "admin/challenge/AdminChallengeQuestionList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/challenge/replyUpdate")
  public ModelAndView update(ChallengeQuestionDTO challengeQuestionDTO) throws Exception {

    ChallengeQuestionDTO challengeReply = challengeQuestionDao.findByNo(challengeQuestionDTO.getQuestionNo());

    if (challengeReply == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    } 

    challengeQuestionDao.updateReply(challengeQuestionDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList?no=" + challengeQuestionDTO.getNo());
    return mv;
  }

  @GetMapping("/admin/challenge/replyUpdateDetail")
  public ModelAndView detail(int questionNo) throws Exception {
    ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(questionNo);

    if (challengeQuestionDTO == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeQuestionDTO", challengeQuestionDTO);
    mv.addObject("pageTitle", "답변 등록&변경");
    mv.addObject("contentUrl", "admin/challenge/AdminChallengeReplyUpdateDetail.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/challenge/replyDelete")
  public ModelAndView replyDelete(ChallengeQuestionDTO challengeQuestionDTO) throws Exception {

    ChallengeQuestionDTO challengeReply = challengeQuestionDao.findByNo(challengeQuestionDTO.getQuestionNo());

    if (challengeReply == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    } 

    challengeReply.setReply(null);

    challengeQuestionDao.updateReply(challengeQuestionDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList?no=" + challengeQuestionDTO.getNo());
    return mv;
  }

  //  @GetMapping("/challenge/questionDelete")
  //  public ModelAndView delete(int questionNo) throws Exception {
  //    ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(questionNo);
  //    if (challengeQuestionDTO == null) {
  //      throw new Exception("해당 번호의 챌린지 문의가 없습니다.");
  //    }
  //
  //    challengeQuestionDao.delete(challengeQuestionDTO.getQuestionNo());
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:questionList?no=" + challengeQuestionDTO.getNo());
  //    return mv;
  //  }
}







