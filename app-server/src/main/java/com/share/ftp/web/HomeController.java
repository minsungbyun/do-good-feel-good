package com.share.ftp.web;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
public class HomeController {

  @Autowired VolunteerDao volunteerDao;
  @Autowired VolunteerShortReviewDao volunteerShortReviewDao;
  @Autowired DonationBoardDao donationBoardDao;
  @Autowired ChallengeDao challengeDao;


  @RequestMapping("/home")
  public ModelAndView home() throws Exception {

    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();
    Collection<VolunteerShortReviewDTO> volunteerShortReviewList = volunteerShortReviewDao.findAll();
    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAllApply();
    Collection<ChallengeDTO> challengeList = challengeDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("volunteerShortReviewList", volunteerShortReviewList);
    mv.addObject("donationBoardList", donationBoardList);
    mv.addObject("challengeList", challengeList);
    mv.addObject("pageTitle", "HappyShare : 메인화면");
    mv.addObject("contentUrl", "home.jsp");
    mv.setViewName("template1");
    return mv;
  }
}




//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    request.setAttribute("pageTitle", "HappyShare : 메인화면");
//    request.setAttribute("contentUrl", "/index.jsp");
//    request.getRequestDispatcher("/template1.jsp").forward(request, response);
//  }







