package com.share.ftp.servlet.register;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationRegisterDTO;

@WebServlet("/register/list")
public class DonationRegisterListController extends HttpServlet { // 모금함 기부하기 양식 쓰는곳
  private static final long serialVersionUID = 1L;
  DonationRegisterDao donationRegisterDao;
  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    donationRegisterDao = (DonationRegisterDao) 웹애플리케이션공용저장소.getAttribute("donationRegisterDao");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      int no = Integer.parseInt(request.getParameter("no"));
      Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAllNo(no);

      request.setAttribute("boardNo", no);
      request.setAttribute("donationRegisterList", donationRegisterList);
      request.setAttribute("contentUrl", "/register/DonationRegisterList.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}














