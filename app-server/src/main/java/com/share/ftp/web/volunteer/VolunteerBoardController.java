package com.share.ftp.servlet.volunteer;

import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@Controller
public class VolunteerBoardController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerBoardDao volunteerBoardDao;

  @GetMapping("/volunteer/boardList")
  public ModelAndView list() throws Exception {
    Collection<VolunteerBoardDTO> volunteerBoardList = volunteerBoardDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardList", volunteerBoardList);
    mv.addObject("pageTitle", "게시글목록");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardList");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/volunteer/boardDetail")
  public ModelAndView detail(int no) throws Exception {
    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

    if (volunteerBoardDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerBoardDao.updateCount(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("board", board);
    mv.addObject("pageTitle", "게시글 상세보기");
    mv.addObject("contentUrl", "board/BoardDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }

}
