package com.share.ftp.web.challenge;

import java.util.Collection;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;

@Controller
public class ChallengeController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ChallengeDao challengeDao;
  @Autowired ServletContext sc;

  @GetMapping("/challenge/list")
  public ModelAndView list() throws Exception {

    Collection<ChallengeDTO> challengeList = challengeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeList", challengeList);
    mv.addObject("pageTitle", "Happy share: 챌린지 목록");
    mv.addObject("contentUrl", "challenge/ChallengeList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/challenge/detail")
  public ModelAndView detail(int no) throws Exception {
    ChallengeDTO challengeDTO = challengeDao.findByNo(no);
    if (challengeDTO == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeDTO", challengeDTO);
    mv.addObject("pageTitle", "회원정보");
    mv.addObject("contentUrl", "challenge/ChallengeDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }
}







