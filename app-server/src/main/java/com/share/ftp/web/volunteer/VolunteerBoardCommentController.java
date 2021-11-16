package com.share.ftp.web.volunteer;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class VolunteerBoardCommentController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerBoardCommentDao volunteerBoardCommentDao;

  @GetMapping("/volunteer/commentForm")
  public ModelAndView form() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "새 댓글");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/commentAdd")
  public ModelAndView add(VolunteerBoardCommentDTO volunteerBoardCommentDTO, HttpSession session) throws Exception {

    volunteerBoardCommentDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));
    volunteerBoardCommentDTO.setNo((Integer)session.getAttribute("volBoardNo"));   

    volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:commentList?volBoardNo=");
    return mv;
  }

  @GetMapping("/volunteer/commentList")
  public ModelAndView list() throws Exception {
    Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardCommentList", volunteerBoardCommentList);
    mv.addObject("pageTitle", "댓글 목록");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/volunteer/commentUpdateDetail")
  public ModelAndView updateDetail(int commentNo) throws Exception {
    VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByNo(commentNo);

    if (volunteerBoardCommentDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardCommentDTO", volunteerBoardCommentDTO);
    mv.addObject("pageTitle", "댓글 변경");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentUpdateDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/commentUpdate")
  public ModelAndView update(VolunteerBoardCommentDTO volunteerBoardCommentDTO) throws Exception {

    VolunteerBoardCommentDTO oldComment= volunteerBoardCommentDao.findByNo(volunteerBoardCommentDTO.getNo());
    if (oldComment == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    volunteerBoardCommentDao.update(volunteerBoardCommentDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    //  mv.setViewName("redirect:commentList?volBoardNo=" ((Integer)session.getAttribute(volBoardNo)))");
    return mv;
  }

  @GetMapping("/volunteer/commentDelete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByNo(no);
    if (volunteerBoardCommentDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerBoardCommentDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardList");
    return mv;
  }


}
