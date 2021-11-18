package com.share.ftp.web.admin.donation;

import static com.share.util.General.check.APPLIED;
import static com.share.util.General.check.REJECTED;
import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@Controller
public class AdminDonationBoardController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired DonationBoardDao donationBoardDao;
  @Autowired DonationRegisterDao donationRegisterDao;
  @Autowired GeneralDao generalDao;

  @GetMapping("/admin/donation/list")
  public ModelAndView list() throws Exception {
    Collection<DonationBoardDTO> adminDonationBoardList = donationBoardDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("adminDonationBoardList", adminDonationBoardList);
    mv.addObject("pageTitle", "HappyShare : 관리자 모금함목록");
    mv.addObject("contentUrl", "admin/donation/AdminDonationBoardList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/donation/rejectedList")
  public ModelAndView rejectedList() throws Exception {
    Collection<DonationBoardDTO> rejectedDonationList = donationBoardDao.findAllRejected();

    ModelAndView mv = new ModelAndView();
    mv.addObject("rejectedDonationList", rejectedDonationList);
    mv.addObject("pageTitle", "HappyShare : 관리자 모금함반려목록");
    mv.addObject("contentUrl", "admin/donation/AdminRejectedDonationBoardList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/donation/waitList")
  public ModelAndView waitList() throws Exception {
    Collection<DonationBoardDTO> waitDonationList = donationBoardDao.findAllWait();

    ModelAndView mv = new ModelAndView();
    mv.addObject("waitDonationList", waitDonationList);
    mv.addObject("pageTitle", "HappyShare : 관리자 모금함대기목록");
    mv.addObject("contentUrl", "admin/donation/AdminWaitDonationBoardList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/donation/approvedList")
  public ModelAndView approvedList() throws Exception {
    Collection<DonationBoardDTO> approvedDonationList = donationBoardDao.findAllApproved();

    ModelAndView mv = new ModelAndView();
    mv.addObject("approvedDonationList", approvedDonationList);
    mv.addObject("pageTitle", "HappyShare : 관리자 모금함승인목록");
    mv.addObject("contentUrl", "admin/donation/AdminApprovedDonationBoardList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @GetMapping("/admin/donation/approve")
  public ModelAndView approve(int no) throws Exception {
    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
    donationBoardDTO.setStatus(APPLIED);
    donationBoardDao.updateStatus(donationBoardDTO);

    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }

  @GetMapping("/admin/donation/reject")
  public ModelAndView reject(int no) throws Exception {
    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
    donationBoardDTO.setStatus(REJECTED);
    donationBoardDao.updateStatus(donationBoardDTO);

    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:list");
    return mv;
  }
  //  @GetMapping("/donation/form")
  //  public ModelAndView form() throws Exception {
  //    List<Category> categorys = generalDao.findAllCategory();
  //    ModelAndView mv = new ModelAndView();
  //
  //    mv.addObject("categorys", categorys);
  //    mv.addObject("pageTitle", "HappyShare : 모금함신청");
  //    mv.addObject("contentUrl", "donation/DonationBoardForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  //
  //  @PostMapping("/donation/add")
  //  public ModelAndView add(
  //      DonationBoardDTO donationBoardDTO,
  //      Category category,
  //      int categoryNo,
  //      HttpSession session) throws Exception {
  //    category.setNo(categoryNo);
  //    donationBoardDTO.setCategory(category);
  //    donationBoardDTO.setLeader((OrgDTO) session.getAttribute("orgLoginUser"));
  //    donationBoardDTO.setOrgNo(donationBoardDTO.getLeader().getOrgNo());
  //
  //    System.out.println(donationBoardDTO.getLeader().getNo());
  //
  //    donationBoardDTO.setStatus(2);
  //
  //    donationBoardDao.insert(donationBoardDTO);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
  //
  //
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







