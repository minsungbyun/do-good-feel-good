package com.share.ftp.servlet.donation;

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

@WebServlet("/donation/list")
public class DonationBoardListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;
  //  DonationRegisterDao donationRegisterDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
    //    donationRegisterDao = (DonationRegisterDao) 웹애플리케이션공용저장소.getAttribute("donationRegisterDao");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAllApply();

      request.setAttribute("donationBoardList", donationBoardList);
      request.setAttribute("contentUrl", "/donation/DonationBoardList.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}


















































