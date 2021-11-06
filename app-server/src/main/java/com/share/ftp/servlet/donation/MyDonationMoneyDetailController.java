package com.share.ftp.servlet.donation;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/donation/myDonationMoney")
public class MyDonationMoneyDetailController extends GenericServlet {

  private static final long serialVersionUID = 1L;

  DonationRegisterDao donationRegisterDao;
  JoinDao joinDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    donationRegisterDao = (DonationRegisterDao) 웹애플리케이션공용저장소.getAttribute("donationRegisterDao");
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {

      int no = Integer.parseInt(request.getParameter("no"));
      JoinDTO joinDTO = joinDao.findByNo(no);

      joinDTO.setDonationMoney((int) donationRegisterDao.findByMyDonationMoney(no));


      request.setAttribute("joinDTO", joinDTO);
      request.getRequestDispatcher("/donation/MyDonationMoneyDetail.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}




















































