package com.share.ftp.servlet.admin.support;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/admin/support/noticeUpdate")
public class AdminNoticeUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  NoticeDao noticeDao;
  //  GeneralDao generalDao;


  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    noticeDao = (NoticeDao) 웹애플리케이션공용저장소.getAttribute("noticeDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

      NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

      if (noticeDTO == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      } 

      noticeDTO.setTitle(request.getParameter("title"));
      noticeDTO.setContent(request.getParameter("content")); 
      //      noticeDTO.setFileUpload((List<NoticeAttachedFile>)request.getAttribute("fileUpload"));
      //      noticeDTO.setFileUpload(request.getParameter("fileUpload")); 

      noticeDao.update(noticeDTO);
      sqlSession.commit();

      response.sendRedirect("noticeList");

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}
