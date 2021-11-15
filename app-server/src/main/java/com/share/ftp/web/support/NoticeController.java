package com.share.ftp.web.support;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

@Controller
public class NoticeController {

  @Autowired NoticeDao noticeDao;

  @GetMapping("/support/noticeList")
  public ModelAndView list() throws Exception {
    Collection<NoticeDTO> noticeList = noticeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("noticeList", noticeList);
    mv.addObject("pageTitle", "공지사항목록");
    mv.addObject("contentUrl", "support/NoticeList.jsp");
    mv.setViewName("template1");
    return mv;
  }


  @GetMapping("/support/noticeDetail")
  public ModelAndView detail(int noticeNo) throws Exception {
    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

    if (noticeDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    noticeDao.updateCount(noticeNo);

    ModelAndView mv = new ModelAndView();
    mv.addObject("noticeDTO", noticeDTO);
    mv.addObject("pageTitle", "공지사항게시글");
    mv.addObject("contentUrl", "support/NoticeDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }


}
