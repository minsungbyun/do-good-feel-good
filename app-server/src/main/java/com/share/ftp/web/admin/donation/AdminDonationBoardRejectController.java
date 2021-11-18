package com.share.ftp.web.admin.donation;

import static com.share.util.General.check.REJECTED;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

//@WebServlet("/admin/donation/reject")
public class AdminDonationBoardRejectController extends HttpServlet { // 개인 봉사신청 양식 쓰는 곳

  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;


  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int donationNo = Integer.parseInt(request.getParameter("no"));

      DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(donationNo);

      donationBoardDTO.setStatus(REJECTED);

      donationBoardDao.updateStatus(donationBoardDTO);
      sqlSession.commit();

      response.sendRedirect("list");

    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
