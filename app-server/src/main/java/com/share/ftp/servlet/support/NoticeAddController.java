package com.share.ftp.servlet.support;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

@WebServlet("/support/noticeAdd")
public class NoticeAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  NoticeDao noticeDao;
  //  GeneralDao generalDao;


  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    noticeDao = (NoticeDao) 웹애플리케이션공용저장소.getAttribute("noticeDao");
    //    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setTitle(request.getParameter("title"));
    noticeDTO.setContent(request.getParameter("content")); 
    //    noticeDTO.setFileUpload((List<NoticeAttachedFile>)request.getAttribute("fileUpload"));
    //    noticeDTO.setFileUpload((List<NoticeAttachedFile>)request.getAttribute("fileUpload"));

    try {
      noticeDao.insert(noticeDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=noticeList");
      request.getRequestDispatcher("/support/NoticeAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }

    //    try {
    //      noticeDao.insert(noticeDTO);
    //      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
    //        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //
    //    } catch (Exception e) {
    //      e.printStackTrace(); 
    //      sqlSession.rollback();
    //    }


  }
}
