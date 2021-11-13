package com.share.ftp.servlet.donation;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@WebServlet("/admin/donationList")
public class AdminDonationBoardListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      Collection<DonationBoardDTO> adminDonationBoardList = donationBoardDao.findAll();

      request.setAttribute("adminDonationBoardList", adminDonationBoardList);
      request.setAttribute("contentUrl", "/donation/AdminDonationBoardList.jsp");
      request.getRequestDispatcher("/template2.jsp").forward(request, response);
      //      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/donation/AdminDonationBoardList.jsp");
      //      요청배달자.forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}


















































