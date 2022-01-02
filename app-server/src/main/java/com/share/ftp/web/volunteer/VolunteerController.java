package com.share.ftp.web.volunteer;

import static com.share.util.General.member.PERSONAL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerJoinDao;
import com.share.ftp.dao.VolunteerQuestionDao;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerJoinDTO;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/volunteer")
@SessionAttributes("loginUser")
public class VolunteerController { 

  private static final Logger logger = LogManager.getLogger(VolunteerController.class);

  @Autowired VolunteerDao volunteerDao;
  @Autowired VolunteerJoinDao volunteerJoinDao;
  @Autowired VolunteerQuestionDao volunteeQuestionDao;
  @Autowired VolunteerShortReviewDao volunteerShortReviewDao;
  @Autowired GeneralDao generalDao;
  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ServletContext sc;
  //@Autowired VolunteerService volunteerService;

  @PostMapping("add")
  public ModelAndView add(
      VolunteerRequestDTO volunteerRequestDTO, 
      Category category, 
      @ModelAttribute("loginUser") JoinDTO loginUser,
      int categoryNo,
      Part photoFile) throws Exception {

    ModelAndView mv = new ModelAndView();

    if (loginUser.getType() == PERSONAL) {
      logger.info("개인회원으로는 봉사 신청이 불가능합니다");
      mv.addObject("pageTitle", "함께해요 : 오류페이지");
      mv.addObject("error","개인회원으로는 봉사 신청이 불가능합니다");
      mv.addObject("contentUrl", "Error.jsp");
      mv.setViewName("template1");
      return mv;
    }


    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/volunteer") + "/" + filename);
      volunteerRequestDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(500, 500)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_500x500";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(550, 550)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_550x550";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(600, 600)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_600x600";
        }
      });
    }


    volunteerRequestDTO.setOwner(loginUser);
    category.setNo(categoryNo);
    volunteerRequestDTO.setCategory(category);
    logger.info("봉사정보 ==> "+ volunteerRequestDTO);

    //volunteerService.add(volunteerRequestDTO);
    volunteerDao.insert(volunteerRequestDTO);
    sqlSessionFactory.openSession().commit();
    logger.info("봉사신청을 완료하였습니다!");


    mv.setViewName("redirect:list");
    return mv;
  }


  @GetMapping("list")
  public ModelAndView list() throws Exception {

    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();
    //    int remainNum = 0;
    //    for (VolunteerRequestDTO volunteer : volunteerList) {
    //      int joinCount = volunteerJoinDao.findByJoinUser(volunteer.getNo());
    //      volunteerList.get(volunteer.getNo() - 1).setJoinCount(joinCount);
    //    }
    ModelAndView mv = new ModelAndView();

    if (volunteerList == null) {
      logger.info("봉사목록 없음....");
    }

    mv.addObject("volunteerList", volunteerList);
    //    mv.addObject("remainNum", remainNum);
    mv.addObject("pageTitle", "함께해요 : 봉사목록");
    mv.addObject("info","봉사목록 없음");
    mv.addObject("contentUrl", "volunteer/VolunteerList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail(int no) throws Exception {
    int joinCount = volunteerJoinDao.findByJoinUser(no);
    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(no);
    List<VolunteerJoinDTO> volunteerList = volunteerJoinDao.findAll(no);
    List<VolunteerJoinDTO> joinMember = volunteerJoinDao.findByJoinMember(no);
    List<VolunteerQuestionDTO> volunteerQuestion = volunteeQuestionDao.findAllNo(no);
    Collection<VolunteerShortReviewDTO> volunteerShortReviewList = volunteerShortReviewDao.findAll();

    for (VolunteerQuestionDTO volunteerQuestionDTO : volunteerQuestion) {
      System.out.println(volunteerQuestionDTO.getVolunteer().getNo());
      System.out.println(volunteerQuestionDTO.getJoinUser().getId());
      System.out.println(volunteerQuestionDTO.getNo());
    }
    String totalDate = volunteerDao.totalDate(no).getTotalDate();
    String remainDate = volunteerDao.remainDate(no).getRemainDate();

    Map<String,Object> volunteerDate = new HashMap<>();
    volunteerDate.put("totalDate", totalDate);
    volunteerDate.put("remainDate", remainDate);

    if (volunteer == null) {
      logger.info(no+"번 봉사는 없습니다...");
    }
    logger.info(no+"번 봉사 세부사항 보는 중...");

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteer", volunteer); 
    mv.addObject("joinCount", joinCount); 
    mv.addObject("volunteerDate", volunteerDate);
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("joinMember", joinMember);
    mv.addObject("volunteerShortReviewList", volunteerShortReviewList);
    mv.addObject("volunteerQuestion", volunteerQuestion);
    mv.addObject("pageTitle", "함께해요 : 봉사내용");
    mv.addObject("contentUrl", "volunteer/VolunteerDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }


  @PostMapping("update")
  public ModelAndView update(VolunteerRequestDTO volunteerRequestDTO, Category category) throws Exception {

    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());

    if (volunteer == null) {
      logger.info(volunteerRequestDTO.getNo()+"번 봉사는 없습니다.");
    } 

    volunteerRequestDTO.setCategory(category);

    volunteerDao.update(volunteer);
    sqlSessionFactory.openSession().commit();
    logger.info(volunteerRequestDTO.getNo()+"번 봉사 수정 완료");

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("delete")
  public ModelAndView delete(VolunteerRequestDTO volunteerRequestDTO) throws Exception {

    VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volunteerRequestDTO.getNo());

    if (volunteer == null) {
      logger.info(volunteerRequestDTO.getNo()+"번 봉사는 없습니다.");
    }

    volunteerDao.delete(volunteer);
    sqlSessionFactory.openSession().commit();
    logger.info(volunteerRequestDTO.getNo()+"번 봉사 삭제 완료");

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }


  @GetMapping("form")
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

