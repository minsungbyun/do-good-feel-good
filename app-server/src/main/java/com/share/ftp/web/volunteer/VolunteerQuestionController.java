package com.share.ftp.web.volunteer;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerQuestionDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
public class VolunteerQuestionController { 

  @Autowired VolunteerQuestionDao volunteerQuestionDao;
  @Autowired GeneralDao generalDao;
  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ServletContext sc;

  @PostMapping("/volunteer/question/add")
  public ModelAndView add(VolunteerQuestionDTO volunteerQuestionDTO, VolunteerRequestDTO volunteerRequestDTO,int no, HttpSession session) throws Exception {

    volunteerQuestionDTO.setJoinUser((JoinDTO) session.getAttribute("loginUser"));
    volunteerRequestDTO.setNo(no);
    volunteerQuestionDTO.setVolunteer(volunteerRequestDTO);



    System.out.println("댓글번호"+volunteerQuestionDTO.getNo());
    System.out.println("봉사번호"+no);
    System.out.println("봉사번호2"+volunteerQuestionDTO.getVolunteer().getNo());
    System.out.println("봉사번호2"+volunteerQuestionDTO.getVolunteer().getTitle());

    System.out.println(volunteerQuestionDTO.getJoinUser().getId());
    System.out.println(volunteerQuestionDTO.getVolunteer().getNo());
    System.out.println(volunteerQuestionDTO.getContent());


    volunteerQuestionDao.insert(volunteerQuestionDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no=" + no);
    mv.setViewName("redirect:list");
    return mv;
  }


  @GetMapping("/volunteer/question/list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerQuestionDTO> volunteerQuestionList = volunteerQuestionDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerQuestionList);
    mv.addObject("pageTitle", "함께해요 : 봉사문의목록");
    mv.addObject("contentUrl", "volunteer/question/VolunteerQuestionList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/question/update")
  public ModelAndView update(VolunteerQuestionDTO volunteerQuestionDTO) throws Exception {

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(volunteerQuestionDTO.getNo());

    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 봉사댓글이 없습니다");
    }

    volunteerQuestionDao.update(volunteerQuestion);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no="+ volunteerQuestion.getNo());
    return mv;
  }

  @GetMapping("/volunteer/question/delete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(no);

    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 봉사댓글이 없습니다");
    }

    volunteerQuestionDao.delete(volunteerQuestion.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no="+ volunteerQuestion.getNo());
    return mv;
  }
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

