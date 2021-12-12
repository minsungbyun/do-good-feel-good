package com.share.ftp.web.volunteer;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerJoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerJoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
@RequestMapping("/volunteer/join")
//@SessionAttributes("loginUser")
public class VolunteerJoinController { 

  private static final Logger logger = LogManager.getLogger(VolunteerJoinController.class);

  @Autowired VolunteerJoinDao volunteerJoinDao;
  @Autowired VolunteerDao VolunteerDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @GetMapping("form")
  public ModelAndView form(int no) throws Exception {

    VolunteerRequestDTO volunteer = VolunteerDao.findByVolunteerNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "함께해요 : 봉사참여");
    mv.addObject("volunteer", volunteer);
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoinForm.jsp");
    mv.setViewName("template1");
    logger.info("봉사 참여자 목록 실행 중");
    return mv;
  }

  @PostMapping(value="add", produces="text/html;charset=UTF-8")
  public ModelAndView add(
      VolunteerRequestDTO volunteerRequestDTO,
      VolunteerJoinDTO volunteerJoinDTO, 
      @SessionAttribute("loginUser") JoinDTO loginUser
      //@ModelAttribute("loginUser") JoinDTO loginUser
      //HttpSession session
      ) throws Exception {

    ModelAndView mv = new ModelAndView();

    // JoinDTO loginUser = (JoinDTO) session.getAttribute("loginUser");
    if (loginUser == null) {
      mv.addObject("error","로그인이 필요합니다!");
      mv.setViewName("Error");
      logger.info("로그인이 필요합니다!");
    }

    logger.info("로그확인용 전(봉사) ==> "+volunteerRequestDTO);
    logger.info("로그확인용 전(참여) ==> "+volunteerJoinDTO);
    logger.info("로그확인용 전(로그인유저) ==> "+loginUser);
    logger.info("로그확인용 전(번호) ==> "+ volunteerRequestDTO.getNo());
    volunteerJoinDTO.setVolunteer(volunteerRequestDTO);
    volunteerJoinDTO.setJoinUser(loginUser);
    logger.info("로그확인용 후(봉사) ==> "+volunteerRequestDTO);
    logger.info("로그확인용 후(참여) ==> "+volunteerJoinDTO);
    logger.info("로그확인용 후(로그인유저) ==> "+loginUser);
    logger.info("로그확인용 후(번호) ==> "+ volunteerRequestDTO.getNo());

    volunteerJoinDao.insert(volunteerJoinDTO);
    sqlSessionFactory.openSession().commit();
    logger.info(volunteerRequestDTO.getNo() +" 번 봉사 참여가 완료되었습니다.");

    mv.setViewName("redirect:../detail?no=" + volunteerRequestDTO.getNo());
    return mv;
  }

  @GetMapping("list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerJoinDTO> volunteerList = volunteerJoinDao.findAll(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("pageTitle", "함께해요 : 봉사참여자목록");
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoinMember.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail(int no) throws Exception {

    List<VolunteerJoinDTO> volunteerList = volunteerJoinDao.findAll(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("pageTitle", "함께해요 : 봉사참여");
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoin1.jsp");
    mv.setViewName("template1");
    logger.info(no +"번 봉사 참여");
    return mv;
  }

  @GetMapping("checkJoin")
  @ResponseBody
  public String checkJoin(int no, String id) throws Exception {
    VolunteerJoinDTO volunteerJoinDTO = volunteerJoinDao.checkJoin(no, id);
    if (volunteerJoinDTO == null) {
      return "false";
    } else {
      return "true";
    }
  }
}