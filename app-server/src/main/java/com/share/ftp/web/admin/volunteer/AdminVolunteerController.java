package com.share.ftp.web.admin.volunteer;

import static com.share.util.General.check.APPLIED;
import static com.share.util.General.check.REJECTED;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
@RequestMapping("/admin/volunteer")
@SessionAttributes({"loginUser","admin"})
public class AdminVolunteerController {

  private static final Logger logger = LogManager.getLogger(AdminVolunteerController.class);

  @Autowired SqlSessionFactory sqlSessionFactroy;
  @Autowired ServletContext sc;
  @Autowired VolunteerDao volunteerDao;

  @GetMapping("list")
  public ModelAndView list() throws Exception {

    List<VolunteerRequestDTO> adminVolunteerList = volunteerDao.findAll();
    logger.info(adminVolunteerList +" 관리자 봉사리스트");

    ModelAndView mv = new ModelAndView();
    mv.addObject("adminVolunteerList", adminVolunteerList);
    mv.addObject("pageTitle", "HappyShare : 관리자 봉사목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerList.jsp");
    mv.setViewName("template2");
    logger.info("관리자 봉사 전체 목록 실행 중");
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("update")
  public ModelAndView update() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("delete")
  public ModelAndView delete() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("search")
  public ModelAndView search(String keyword) throws Exception {

    List<VolunteerRequestDTO> keywords = volunteerDao.findByKeyword(keyword);
    logger.info(keywords +" 관리자 봉사리스트");

    ModelAndView mv = new ModelAndView();
    mv.addObject("keywords", keywords);
    mv.addObject("pageTitle", "HappyShare : 관리자 봉사목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerSearchList.jsp");
    mv.setViewName("template2");
    logger.info("관리자 봉사목록 실행 중(키워드 검색 후)");
    return mv;
  }

  @GetMapping("doApprove")
  public ModelAndView doApprove(int no) throws Exception {

    VolunteerRequestDTO doVolunteerApprove = volunteerDao.findByVolunteerNo(no);
    logger.info(no+ "번의 관리자 봉사정보"+ doVolunteerApprove);

    doVolunteerApprove.setStatus(APPLIED);

    volunteerDao.updateVolunteer(doVolunteerApprove);
    sqlSessionFactroy.openSession().commit();
    logger.info(no+ "번 봉사 승인완료");

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;

  }

  @GetMapping("approve")
  public ModelAndView approve() throws Exception {

    List<VolunteerRequestDTO> adminVolunteerApprovedList = volunteerDao.findAllApproved();
    logger.info(adminVolunteerApprovedList +" 관리자 봉사리스트");

    ModelAndView mv = new ModelAndView();
    mv.addObject("adminVolunteerApprovedList", adminVolunteerApprovedList);
    mv.addObject("pageTitle", "HappyShare : 관리자 봉사목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerApprovedList.jsp");
    mv.setViewName("template2");
    logger.info("관리자 봉사 승인 목록 실행 중");
    return mv;

  }

  @GetMapping("doReject")
  public ModelAndView doReject(int no) throws Exception {

    VolunteerRequestDTO doVolunteerReject = volunteerDao.findByVolunteerNo(no);
    logger.info(no+ "번의 관리자 봉사정보"+ doVolunteerReject);

    doVolunteerReject.setStatus(REJECTED);

    volunteerDao.updateVolunteer(doVolunteerReject);
    sqlSessionFactroy.openSession().commit();
    logger.info(no+ "번 봉사 반려완료");

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;

  }

  @GetMapping("reject")
  public ModelAndView reject() throws Exception {

    List<VolunteerRequestDTO> adminVolunteerRejectedList = volunteerDao.findAllRejected();
    logger.info(adminVolunteerRejectedList +" 관리자 봉사리스트");

    ModelAndView mv = new ModelAndView();
    mv.addObject("adminVolunteerRejectedList", adminVolunteerRejectedList);
    mv.addObject("pageTitle", "HappyShare : 관리자 봉사목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerRejectedList.jsp");
    mv.setViewName("template2");
    logger.info("관리자 봉사 반려 목록 실행 중");
    return mv;

  }

  @GetMapping("wait")
  public ModelAndView waitList() throws Exception {

    List<VolunteerRequestDTO> adminVolunteerWaitList = volunteerDao.findAllWait();
    logger.info(adminVolunteerWaitList +" 관리자 봉사리스트");

    ModelAndView mv = new ModelAndView();
    mv.addObject("adminVolunteerList", adminVolunteerWaitList);
    mv.addObject("pageTitle", "HappyShare : 관리자 봉사목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerWaitList.jsp");
    mv.setViewName("template2");
    logger.info("관리자 봉사 대기 목록 실행 중");
    return mv;

  }
}
