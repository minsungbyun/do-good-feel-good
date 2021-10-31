package com.share.ftp.servlet.donation;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@WebServlet("/donationBoard/detail")
public class DonationBoardDetailController extends GenericServlet {

  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {

      int no = Integer.parseInt(request.getParameter("no"));
      DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
      //      long remainMoney = donationRegisterDao.findByRemainMoney(donationBoardDTO.getNo());

      if (donationBoardDTO == null) {
        throw new Exception("[ 모금함 상세보기를 취소하셨습니다. ]");
      }

      request.setAttribute("donationBoardDTO", donationBoardDTO);
      request.getRequestDispatcher("/donation/DonationBoardDetail.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}




















































