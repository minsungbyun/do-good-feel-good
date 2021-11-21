package com.share.ftp.web.join;

import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class OrgController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired OrgDao orgDao;
  @Autowired ServletContext sc;

  @GetMapping("/join/org/form")
  public ModelAndView form() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "HappyShare : 기관회원가입");
    mv.addObject("contentUrl", "join/org/OrgUserForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/join/org/add")
  public ModelAndView add(OrgDTO orgDTO, Part photoFile) throws Exception {
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      System.out.println(filename);
      photoFile.write(sc.getRealPath("/upload/user") + "/" + filename);
      orgDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/user") + "/" + filename)
      .size(20, 20)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_20x20";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/user") + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });
    }

    orgDTO.setType(3);
    orgDTO.setStatus(2);

    orgDao.insert(orgDTO);
    orgDao.insertOrg(orgDTO.getNo(), orgDTO.getCorpNo(), orgDTO.getFax(), orgDTO.getHomepage());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("refresh", "2;url=../../../app/home");
    mv.addObject("pageTitle", "HappyShare : 기관회원등록");
    mv.addObject("contentUrl", "join/org/OrgUserAdd.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/join/org/checkId")
  @ResponseBody
  public String checkId(String id) throws Exception {
    OrgDTO orgDTO = orgDao.validId(id);
    if (orgDTO == null) {
      return "false";
    } else {
      return "true";
    }
  }

  //  @GetMapping("/member/list")
  //  public ModelAndView list() throws Exception {
  //
  //    Collection<Member> memberList = memberDao.findAll();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("memberList", memberList);
  //    mv.addObject("pageTitle", "회원목록");
  //    mv.addObject("contentUrl", "member/MemberList.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  //  @GetMapping("/member/detail")
  //  public ModelAndView detail(int no) throws Exception {
  //    Member member = memberDao.findByNo(no);
  //    if (member == null) {
  //      throw new Exception("해당 번호의 회원이 없습니다.");
  //    }
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("member", member);
  //    mv.addObject("pageTitle", "회원정보");
  //    mv.addObject("contentUrl", "member/MemberDetail.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
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







