package com.share.ftp.web.admin.challenge;

import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class AdminChallengeController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ChallengeDao challengeDao;
  @Autowired ServletContext sc;

  @GetMapping("/admin/challenge/form")
  public ModelAndView form() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "새 챌린지");
    mv.addObject("contentUrl", "admin/challenge/AdminChallengeForm.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/challenge/add")
  public ModelAndView add(
      ChallengeDTO challengeDTO, HttpSession session, Part photoFile) throws Exception {

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/challenge") + "/" + filename);
      challengeDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(150, 150)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_150x150";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(200, 200)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_200x200";
        }
      });
    }

    challengeDao.insert(challengeDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("/admin/challenge/list")
  public ModelAndView list() throws Exception {
    Collection<ChallengeDTO> challengeList = challengeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeList", challengeList);
    mv.addObject("pageTitle", "챌린지목록");
    mv.addObject("contentUrl", "admin/challenge/AdminChallengeList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/challenge/detail")
  public ModelAndView detail(int no) throws Exception {
    ChallengeDTO challengeDTO = challengeDao.findByNo(no);

    if (challengeDTO == null) {
      throw new Exception("해당 번호의 챌린지가 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeDTO", challengeDTO);
    mv.addObject("pageTitle", "챌린지상세보기");
    mv.addObject("contentUrl", "admin/challenge/AdminChallengeDetail.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("/admin/challenge/update")
  public ModelAndView update(ChallengeDTO challengeDTO, Part photoFile) throws Exception {

    ChallengeDTO oldChallenge = challengeDao.findByNo(challengeDTO.getNo());
    if (oldChallenge == null) {
      throw new Exception("해당 번호의 챌린지가 없습니다.");
    } 

    challengeDTO.setPhoto(oldChallenge.getPhoto());
    challengeDTO.setRegisteredDate(oldChallenge.getRegisteredDate());

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/challenge") + "/" + filename);
      challengeDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(150, 150)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_150x150";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/challenge") + "/" + filename)
      .size(200, 200)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_200x200";
        }
      });

      challengeDTO.setPhoto(filename);
    }

    challengeDao.update(challengeDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("/admin/challenge/delete")
  public ModelAndView delete(int no) throws Exception {

    ChallengeDTO challengeDTO = challengeDao.findByNo(no);
    if (challengeDTO == null) {
      throw new Exception("해당 번호의 챌린지가 없습니다.");
    }

    challengeDao.deleteReview(no);
    challengeDao.deleteQuestion(no);
    challengeDao.deleteApply(no);
    challengeDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }
}







