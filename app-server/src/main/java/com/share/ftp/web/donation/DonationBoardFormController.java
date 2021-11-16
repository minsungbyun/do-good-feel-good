package com.share.ftp.web.donation;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.Category;


@WebServlet("/donation/boardForm")
public class DonationBoardFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  GeneralDao generalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      //      List<JoinDTO> user = joinDao.findAll();
      List<Category> categorys = generalDao.findAllCategory();

      // 출력을 담당할 뷰를 호출한다.
      request.setAttribute("categorys", categorys);
      request.getRequestDispatcher("/donation/DonationBoardForm.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







