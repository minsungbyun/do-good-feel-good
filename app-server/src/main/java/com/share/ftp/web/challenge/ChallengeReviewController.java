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
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class ChallengeReviewController {

  @Autowired SqlSessionFactory sqlSessionFactory;
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

    challengeReviewDTO.setNo(no);
    challengeReviewDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));

    challengeReviewDao.insert(challengeReviewDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("refresh", "2;url=list");
    mv.addObject("pageTitle", "Happy share: 참여댓글등록");
    mv.addObject("contentUrl", "challenge/ChallengeReviewAdd.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/challenge/reviewList")
  public ModelAndView list(int no) throws Exception {

    Collection<ChallengeReviewDTO> challengeReviewList = challengeReviewDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("challengeReviewList", challengeReviewList);
    mv.addObject("pageTitle", "회원목록");
    mv.addObject("contentUrl", "challenge/ChallengeReviewList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  //  @PostMapping("/member/update")
  //  public ModelAndView update(Member member, Part photoFile) throws Exception {
  //
  //    Member oldMember = memberDao.findByNo(member.getNo());
  //    if (oldMember == null) {
  //      throw new Exception("해당 번호의 회원이 없습니다.");
  //    } 
  //
  //    member.setPhoto(oldMember.getPhoto());
  //    member.setRegisteredDate(oldMember.getRegisteredDate());
  //
  //    if (photoFile.getSize() > 0) {
  //      String filename = UUID.randomUUID().toString();
  //      photoFile.write(sc.getRealPath("/upload/member") + "/" + filename);
  //      member.setPhoto(filename);
  //
  //      Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
  //      .size(20, 20)
  //      .outputFormat("jpg")
  //      .crop(Positions.CENTER)
  //      .toFiles(new Rename() {
  //        @Override
  //        public String apply(String name, ThumbnailParameter param) {
  //          return name + "_20x20";
  //        }
  //      });
  //
  //      Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
  //      .size(100, 100)
  //      .outputFormat("jpg")
  //      .crop(Positions.CENTER)
  //      .toFiles(new Rename() {
  //        @Override
  //        public String apply(String name, ThumbnailParameter param) {
  //          return name + "_100x100";
  //        }
  //      });
  //
  //      member.setPhoto(filename);
  //    }
  //
  //    memberDao.update(member);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
  //
  //  @GetMapping("/member/delete")
  //  public ModelAndView delete(int no) throws Exception {
  //    Member member = memberDao.findByNo(no);
  //    if (member == null) {
  //      throw new Exception("해당 번호의 회원이 없습니다.");
  //    }
  //
  //    memberDao.delete(no);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
}







