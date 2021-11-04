package com.share.ftp.servlet.donation;

import static com.share.util.General.check.APPLIED;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@WebServlet("/admin/boardApprove")
public class AdminDonationBoardApproveController extends HttpServlet { // 개인 봉사신청 양식 쓰는 곳

  private static final long serialVersionUID = 1L;

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    donationBoardDao = (DonationBoardDao) 웹애플리케이션공용저장소.getAttribute("donationBoardDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int donationNo = Integer.parseInt(request.getParameter("no"));

      DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(donationNo);

      donationBoardDTO.setStatus(APPLIED);

      donationBoardDao.updateStatus(donationBoardDTO);
      sqlSession.commit();

      response.sendRedirect("adminDonationList");

    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
