package com.share.ftp.web.volunteer;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerQuestionDao;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;

@Controller
public class VolunteerQuestionController { 

  @Autowired VolunteerQuestionDao volunteerQuestionDao;
  @Autowired GeneralDao generalDao;
  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ServletContext sc;

  //  @PostMapping("/volunteer/question/add")
  //  public ModelAndView add(VolunteerQuestionDTO volunteerQuestionDTO, VolunteerRequestDTO volunteer, HttpSession session) throws Exception {
  //
  //    volunteerRequestDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));
  //    volunteerRequestDTO.setCategory(category);
  //
  //    volunteerQuestionDao.insert(volunteerQuestionDTO);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }


  @GetMapping("/volunteer/question/list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerQuestionDTO> volunteerQuestionList = volunteerQuestionDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerQuestionList);
    mv.addObject("pageTitle", "함께해요 : 봉사문의목록");
    mv.addObject("contentUrl", "volunteer/VolunteerQuestionList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  //  @GetMapping("/volunteer/question/detail")
  //  public ModelAndView detail(int no) throws Exception {
  //
  //    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(no);
  //    String totalDate = volunteerDao.totalDate(no).getTotalDate();
  //    String remainDate = volunteerDao.remainDate(no).getRemainDate();
  //
  //    Map<String,Object> volunteerDate = new HashMap<>();
  //    volunteerDate.put("totalDate", totalDate);
  //    volunteerDate.put("remainDate", remainDate);
  //
  //    if (volunteer == null) {
  //      throw new Exception("해당 번호의 봉사가 없습니다.");
  //    }
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("volunteer", volunteer); 
  //    mv.addObject("volunteerDate", volunteerDate);
  //    mv.addObject("pageTitle", "함께해요 : 봉사내용");
  //    mv.addObject("contentUrl", "volunteer/VolunteerDetail.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }


  //  @PostMapping("/volunteer/question/update")
  //  public ModelAndView update(VolunteerRequestDTO volunteerRequestDTO, Category category) throws Exception {
  //
  //    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());
  //
  //    if (volunteer == null) {
  //      throw new Exception("해당 번호의 봉사가 없습니다");
  //    } 
  //
  //    volunteerRequestDTO.setCategory(category);
  //
  //    volunteerDao.update(volunteer);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //}

  //  @GetMapping("/volunteer/question/delete")
  //  public ModelAndView delete(VolunteerRequestDTO volunteerRequestDTO) throws Exception {
  //
  //    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());
  //
  //    if (volunteer == null) {
  //      throw new Exception("해당 번호의 봉사가 없습니다");
  //    }
  //
  //    volunteerDao.delete(volunteer);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
  //
  //
  //  @GetMapping("/volunteer/question/form")
  //  public ModelAndView form() throws Exception {
  //
  //    List<Category> categorys = generalDao.findAllCategory();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("categorys", categorys);
  //    mv.addObject("pageTitle", "함께해요 : 봉사신청");
  //    mv.addObject("contentUrl", "volunteer/VolunteerForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
}

