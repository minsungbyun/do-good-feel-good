package com.share.ftp.servlet.donation;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;

@WebServlet("/donationBoard/list")
public class DonationBoardListController extends GenericServlet {
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


      Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

      request.setAttribute("donationBoardList", donationBoardList);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/donation/DonationBoardList.jsp");
      요청배달자.forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}


















































