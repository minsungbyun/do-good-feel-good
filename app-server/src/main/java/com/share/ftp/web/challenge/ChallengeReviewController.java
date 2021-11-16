package com.share.ftp.web.challenge;

import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class ChallengeReviewController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ChallengeDao challengeDao;
  @Autowired ChallengeReviewDao challengeReviewDao;
  @Autowired ServletContext sc;

  //  @GetMapping("/member/form")
  //  public ModelAndView form() {
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("pageTitle", "새회원");
  //    mv.addObject("contentUrl", "member/MemberForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  @PostMapping("/challenge/reviewAdd")
  public ModelAndView add(
      ChallengeReviewDTO challengeReviewDTO, HttpSession session, int no) throws Exception {
    //      if (photoFile.getSize() > 0) {
    //        String filename = UUID.randomUUID().toString();
    //        photoFile.write(sc.getRealPath("/upload/member") + "/" + filename);
    //        member.setPhoto(filename);
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(20, 20)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_20x20";
    //          }
    //        });
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(100, 100)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_100x100";
    //          }
    //        });
    //      }

    challengeReviewDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));

    challengeReviewDao.insert(challengeReviewDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList?no=" + no);
    return mv;
  }

  @GetMapping("/challenge/reviewList")
  public ModelAndView list(int no) throws Exception {
    ChallengeDTO challengeDTO = challengeDao.findByNo(no);

    Collection<ChallengeReviewDTO> challengeReviewList = challengeReviewDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeDTO", challengeDTO);
    mv.addObject("challengeReviewList", challengeReviewList);
    mv.addObject("pageTitle", "Happy share: 참여인증&댓글");
    mv.addObject("contentUrl", "challenge/ChallengeReviewList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/challenge/reviewUpdate")
  public ModelAndView update(ChallengeReviewDTO challengeReviewDTO) throws Exception {

    ChallengeReviewDTO oldChallengeReview = challengeReviewDao.findByNo(challengeReviewDTO.getReviewNo());

    if (oldChallengeReview == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    } 

    //      member.setPhoto(oldMember.getPhoto());
    //      member.setRegisteredDate(oldMember.getRegisteredDate());
    //  
    //      if (photoFile.getSize() > 0) {
    //        String filename = UUID.randomUUID().toString();
    //        photoFile.write(sc.getRealPath("/upload/member") + "/" + filename);
    //        member.setPhoto(filename);
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(20, 20)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_20x20";
    //          }
    //        });
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(100, 100)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_100x100";
    //          }
    //        });
    //  
    //        member.setPhoto(filename);
    //      }

    challengeReviewDao.update(challengeReviewDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList?no=" + challengeReviewDTO.getNo());
    return mv;
  }

  @GetMapping("/challenge/reviewDelete")
  public ModelAndView delete(int reviewNo) throws Exception {
    ChallengeReviewDTO challengeReviewDTO = challengeReviewDao.findByNo(reviewNo);
    if (challengeReviewDTO == null) {
      throw new Exception("해당 번호의 참여댓글이 없습니다.");
    }

    challengeReviewDao.delete(challengeReviewDTO.getReviewNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList?no=" + challengeReviewDTO.getNo());
    return mv;
  }
}







