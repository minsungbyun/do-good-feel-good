package com.share.ftp.web;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.domain.donation.DonationRegisterPayType;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class DonationRegisterController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired DonationBoardDao donationBoardDao;
  @Autowired DonationRegisterDao donationRegisterDao;

  //  @GetMapping("/board/form")
  //  public ModelAndView form() {
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("pageTitle", "새 글");
  //    mv.addObject("contentUrl", "board/BoardForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  @PostMapping("/register/add")
  public ModelAndView add(
      DonationBoardDTO donationBoard,
      DonationRegisterDTO donationRegisterDTO,
      DonationRegisterPayType payTypeNo,
      HttpSession session) throws Exception {

    donationRegisterDTO.setPayTypeNo(payTypeNo);
    donationRegisterDTO.setDonationBoard(donationBoard);
    donationRegisterDTO.setDonator((JoinDTO) session.getAttribute("loginUser"));

    donationRegisterDao.insert(donationRegisterDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect: ../donation/list");
    return mv;
  }

  @GetMapping("/register/list")
  public ModelAndView list(int no) throws Exception {
    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("donationRegisterList", donationRegisterList);
    mv.addObject("pageTitle", "HappyShare : 기부자목록");
    mv.addObject("contentUrl", "register/DonationRegisterList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  //  @GetMapping("/donation/detail")
  //  public ModelAndView detail(int no) throws Exception {
  //    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
  //    long remainMoney = donationRegisterDao.findByRemainMoney(no);
  //    if (donationBoardDTO == null) {
  //      throw new Exception("해당 번호의 모금함이 없습니다.");
  //    }
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("donationBoardDTO", donationBoardDTO);
  //    mv.addObject("remainMoney", remainMoney);
  //    mv.addObject("pageTitle", "HappyShare : 모금함 상세");
  //    mv.addObject("contentUrl", "donation/DonationBoardDetail.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  //  @PostMapping("/board/update")
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
  //  @GetMapping("/board/delete")
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







