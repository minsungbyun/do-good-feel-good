package com.share.ftp.web.challenge;

import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class ChallengeQuestionController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ChallengeDao challengeDao;
  @Autowired ChallengeQuestionDao challengeQuestionDao;
  @Autowired ServletContext sc;

  @PostMapping("/challenge/questionAdd")
  public ModelAndView add(
      ChallengeQuestionDTO challengeQuestionDTO, HttpSession session, int no) throws Exception {

    challengeQuestionDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));

    challengeQuestionDao.insert(challengeQuestionDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList?no=" + no);
    return mv;
  }

  @GetMapping("/challenge/questionList")
  public ModelAndView list(int no) throws Exception {
    ChallengeDTO challengeDTO = challengeDao.findByNo(no);

    Collection<ChallengeQuestionDTO> challengeQuestionList = challengeQuestionDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeDTO", challengeDTO);
    mv.addObject("challengeQuestionList", challengeQuestionList);
    mv.addObject("pageTitle", "Happy share: 챌린지 문의");
    mv.addObject("contentUrl", "challenge/ChallengeQuestionList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/challenge/questionUpdate")
  public ModelAndView update(ChallengeQuestionDTO challengeQuestionDTO) throws Exception {

    ChallengeQuestionDTO oldChallengeQuestion = challengeQuestionDao.findByNo(challengeQuestionDTO.getQuestionNo());

    if (oldChallengeQuestion == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    } 

    challengeQuestionDao.update(challengeQuestionDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList?no=" + challengeQuestionDTO.getNo());
    return mv;
  }

  @GetMapping("/challenge/questionDelete")
  public ModelAndView delete(int questionNo) throws Exception {
    ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(questionNo);
    if (challengeQuestionDTO == null) {
      throw new Exception("해당 번호의 챌린지 문의가 없습니다.");
    }

    challengeQuestionDao.delete(challengeQuestionDTO.getQuestionNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:questionList?no=" + challengeQuestionDTO.getNo());
    return mv;
  }
}







