package com.share.ftp.servlet.admin.support;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

@WebServlet("/admin/support/noticeDetail")
public class AdminNoticeDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  NoticeDao noticeDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    noticeDao = (NoticeDao) 웹애플리케이션공용저장소.getAttribute("noticeDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
      NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

      if (noticeDTO == null) {
        throw new Exception("해당 번호의 게시물이 없습니다.");
      }

      request.setAttribute("noticeDTO", noticeDTO);
      request.getRequestDispatcher("/admin/support/AdminNoticeDetail.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }


}
