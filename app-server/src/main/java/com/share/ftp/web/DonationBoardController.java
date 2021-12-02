package com.share.ftp.web;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.join.OrgDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/donation")
public class DonationBoardController {

  private static final Logger logger = LogManager.getLogger(DonationBoardController.class);

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired DonationBoardDao donationBoardDao;
  @Autowired DonationRegisterDao donationRegisterDao;
  @Autowired GeneralDao generalDao;
  @Autowired ServletContext sc;

  @GetMapping("form")
  public ModelAndView form() throws Exception {
    List<Category> categorys = generalDao.findAllCategory();
    ModelAndView mv = new ModelAndView();

    mv.addObject("categorys", categorys);
    mv.addObject("pageTitle", "HappyShare : 모금함신청");
    mv.addObject("contentUrl", "donation/DonationBoardForm.jsp");
    mv.setViewName("template1");
    return mv;
  }


  @PostMapping("add")
  public ModelAndView add(
      DonationBoardDTO donationBoardDTO,
      Category category,
      int categoryNo,
      HttpSession session,
      Part photoFile) throws Exception {


    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/donation") + "/" + filename);
      donationBoardDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/donation") + "/" + filename)
      .size(500, 500)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_500x500";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/donation") + "/" + filename)
      .size(550, 550)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_550x550";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/donation") + "/" + filename)
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
    category.setNo(categoryNo);
    donationBoardDTO.setCategory(category);
    donationBoardDTO.setLeader((OrgDTO) session.getAttribute("orgLoginUser"));
    donationBoardDTO.setOrgNo(donationBoardDTO.getLeader().getOrgNo());

    donationBoardDTO.setStatus(2);

    donationBoardDao.insert(donationBoardDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("list")
  public ModelAndView list() throws Exception {
    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAllApply();

    ModelAndView mv = new ModelAndView();
    mv.addObject("donationBoardList", donationBoardList);
    mv.addObject("pageTitle", "HappyShare : 모금함 목록");
    mv.addObject("contentUrl", "donation/DonationBoardList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail(int no) throws Exception {
    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
    long remainMoney = donationRegisterDao.findByRemainMoney(no);
    long money = donationRegisterDao.findByRegisterMoney(no);
    if (donationBoardDTO == null) {
      throw new Exception("해당 번호의 모금함이 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("donationBoardDTO", donationBoardDTO);
    mv.addObject("remainMoney", remainMoney);
    mv.addObject("money", money);
    mv.addObject("pageTitle", "HappyShare : 모금함 상세");
    mv.addObject("contentUrl", "donation/DonationBoardDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }
  //
  //  @PostMapping("update")
  //  public ModelAndView update(Board board) throws Exception {
  //
  //    Board oldBoard = boardDao.findByNo(board.getNo());
  //    if (oldBoard == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다.");
  //    } 
  //
  //    boardDao.update(board);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
  //
  //  @GetMapping("delete")
  //  public ModelAndView delete(int no) throws Exception {
  //
  //    Board board = boardDao.findByNo(no);
  //    if (board == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다.");
  //    }
  //
  //    boardDao.delete(no);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
}







