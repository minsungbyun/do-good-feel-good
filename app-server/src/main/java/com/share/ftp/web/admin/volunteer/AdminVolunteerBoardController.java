package com.share.ftp.web.admin.volunteer;

import java.util.Collection;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@Controller
public class AdminVolunteerBoardController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerBoardCommentDao volunteerBoardCommentDao;
  @Autowired VolunteerBoardDao volunteerBoardDao;
  @Autowired ServletContext sc;

  @GetMapping("/admin/volunteer/boardList")
  public ModelAndView list() throws Exception {
    Collection<VolunteerBoardDTO> volunteerBoardList = volunteerBoardDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardList", volunteerBoardList);
    mv.addObject("pageTitle", "HappyShare : 관리자 나눔이야기 목록");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerBoardList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/volunteer/boardDetail")
  public ModelAndView detail(int no) throws Exception {
    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardDTO", volunteerBoardDTO);
    mv.addObject("volunteerBoardCommentList", volunteerBoardCommentList);
    mv.addObject("pageTitle", "HappyShare : 관리자 나눔이야기 상세보기");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerBoardDetail.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin//volunteer/boardDelete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    if (volunteerBoardDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerBoardDao.deleteComment(no);
    volunteerBoardDao.deleteFile(volunteerBoardDTO);
    volunteerBoardDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardList");
    return mv;
  }


}