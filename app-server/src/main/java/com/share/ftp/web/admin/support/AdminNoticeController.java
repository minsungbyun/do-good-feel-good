package com.share.ftp.web.admin.support;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

@Controller
public class AdminNoticeController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired NoticeDao noticeDao;

  @GetMapping("/admin/support/noticeForm")
  public ModelAndView form() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "관리자공지사항새글");
    mv.addObject("contentUrl", "admin/support/AdminNoticeForm.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/support/noticeAdd")
  public ModelAndView add(NoticeDTO noticeDTO, HttpSession session) throws Exception {

    noticeDao.insert(noticeDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:noticeList");
    return mv;
  }

  @GetMapping("/admin/support/noticeList")
  public ModelAndView list() throws Exception {
    Collection<NoticeDTO> noticeList = noticeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("noticeList", noticeList);
    mv.addObject("pageTitle", "관리자공지사항목록");
    mv.addObject("contentUrl", "admin/support/AdminNoticeList.jsp");
    mv.setViewName("template2");
    return mv;
  }


  @GetMapping("/admin/support/noticeDetail")
  public ModelAndView detail(int noticeNo) throws Exception {
    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

    if (noticeDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    noticeDao.updateCount(noticeNo);

    ModelAndView mv = new ModelAndView();
    mv.addObject("noticeDTO", noticeDTO);
    mv.addObject("pageTitle", "관리자공지사항게시글");
    mv.addObject("contentUrl", "admin/support/AdminNoticeDetail.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/support/noticeUpdate")
  public ModelAndView update(NoticeDTO noticeDTO) throws Exception {

    NoticeDTO oldNoticeDTO = noticeDao.findByNo(noticeDTO.getNo());
    if (oldNoticeDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 
    noticeDao.update(noticeDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:noticeList");
    return mv;
  }

  @GetMapping("/admin/support/noticeDelete")
  public ModelAndView delete(int noticeNo) throws Exception {

    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);
    if (noticeDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    noticeDao.delete(noticeDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:noticeList");
    return mv;
  }


}
