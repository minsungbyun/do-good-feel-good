package com.share.ftp.web.volunteer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
public class VolunteerController { 

  @Autowired VolunteerDao volunteerDao;
  @Autowired GeneralDao generalDao;
  @Autowired SqlSessionFactory sqlSessionFactory;

  @PostMapping("/volunteer/add")
  public ModelAndView add(VolunteerRequestDTO volunteerRequestDTO, Category category, HttpSession session) throws Exception {

    volunteerRequestDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));
    volunteerRequestDTO.setCategory(category);

    volunteerDao.insert(volunteerRequestDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }


  @GetMapping("/volunteer/list")
  public ModelAndView list() throws Exception {

    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();

    int remainNum = 0;
    for (VolunteerRequestDTO volunteer : volunteerList) {
      remainNum = (volunteer.getLimitNum() - volunteer.getCurrentNum());
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("remainNum", remainNum);
    mv.addObject("pageTitle", "함께해요 : 봉사목록");
    mv.addObject("contentUrl", "volunteer/VolunteerList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/volunteer/detail")
  public ModelAndView detail(int no) throws Exception {

    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(no);
    String totalDate = volunteerDao.totalDate(no).getTotalDate();
    String remainDate = volunteerDao.remainDate(no).getRemainDate();

    Map<String,Object> volunteerDate = new HashMap<>();
    volunteerDate.put("totalDate", totalDate);
    volunteerDate.put("remainDate", remainDate);

    if (volunteer == null) {
      throw new Exception("해당 번호의 봉사가 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteer", volunteer); 
    mv.addObject("volunteerDate", volunteerDate);
    mv.addObject("pageTitle", "함께해요 : 봉사내용");
    mv.addObject("contentUrl", "volunteer/VolunteerDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }


  @PostMapping("/volunteer/update")
  public ModelAndView update(VolunteerRequestDTO volunteerRequestDTO, Category category) throws Exception {

    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());

    if (volunteer == null) {
      throw new Exception("해당 번호의 봉사가 없습니다");
    } 

    volunteerRequestDTO.setCategory(category);
    // 파일 추가 해야 함

    volunteerDao.update(volunteer);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("/volunteer/delete")
  public ModelAndView delete(VolunteerRequestDTO volunteerRequestDTO) throws Exception {

    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());

    if (volunteer == null) {
      throw new Exception("해당 번호의 봉사가 없습니다");
    }

    volunteerDao.delete(volunteer);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }


  @GetMapping("/volunteer/form")
  public ModelAndView form() throws Exception {

    List<Category> categorys = generalDao.findAllCategory();

    ModelAndView mv = new ModelAndView();
    mv.addObject("categorys", categorys);
    mv.addObject("pageTitle", "함께해요 : 봉사신청");
    mv.addObject("contentUrl", "volunteer/VolunteerForm.jsp");
    mv.setViewName("template1");
    return mv;
  }
}

