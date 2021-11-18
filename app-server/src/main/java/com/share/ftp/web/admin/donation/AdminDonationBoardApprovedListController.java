package com.share.ftp.web.admin.donation;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

//@WebServlet("/admin/donation/approvedList")
public class AdminDonationBoardApprovedListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {


      Collection<DonationBoardDTO> approvedDonationList = donationBoardDao.findAllApproved();

      request.setAttribute("approvedDonationList", approvedDonationList);
      request.setAttribute("contentUrl", "/admin/donation/AdminApprovedDonationBoardList.jsp");
      request.getRequestDispatcher("/template2.jsp").forward(request, response);
      //      request.getRequestDispatcher("/admin/donation/AdminApprovedDonationBoardList.jsp").forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}


















































