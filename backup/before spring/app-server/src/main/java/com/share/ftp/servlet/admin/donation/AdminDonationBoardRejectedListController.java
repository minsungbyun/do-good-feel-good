package com.share.ftp.servlet.admin.donation;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@WebServlet("/admin/donation/rejectedList")
public class AdminDonationBoardRejectedListController extends HttpServlet {
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


      Collection<DonationBoardDTO> rejectedDonationList = donationBoardDao.findAllRejected();

      request.setAttribute("rejectedDonationList", rejectedDonationList);
      request.setAttribute("contentUrl", "/admin/donation/AdminRejectedDonationBoardList.jsp");
      request.getRequestDispatcher("/template2.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}


















































