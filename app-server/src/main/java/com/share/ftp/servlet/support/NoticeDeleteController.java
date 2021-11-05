package com.share.ftp.servlet.support;

import java.io.IOException;
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

@WebServlet("/support/noticeDelete")
public class NoticeDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  NoticeDao noticeDao;
  //  GeneralDao generalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
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

      noticeDao.delete(noticeDTO);
      sqlSession.commit();

      response.sendRedirect("noticeList");

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

    //    int noticeNo = (int) request.getAttribute("noticeNo"); 
    //
    //    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);
    //
    //    if (noticeDTO == null) {
    //      System.out.println("해당 번호의 게시물이 없습니다.");
    //      return;
    //    }
    //
    //    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    //    System.out.println();
    //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
    //      System.out.println("게시물 삭제를 취소하였습니다.");
    //      return;
    //    }
    //
    //    try {
    //      noticeDao.deleteFile(noticeDTO);
    //      noticeDao.delete(noticeDTO);
    //      sqlSession.commit();
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //      // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
    //      // 그래야 다음 작업에 영향을 끼치지 않는다.
    //      sqlSession.rollback();
    //    }

  }


}
