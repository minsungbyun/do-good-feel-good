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

@WebServlet("/support/noticeUpdate")
public class AdminNoticeUpdateController extends HttpServlet {
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

      noticeDTO.setTitle(request.getParameter("title"));
      noticeDTO.setContent(request.getParameter("content")); 
      //    noticeDTO.setFileUpload(request.getParameter("fileUpload"));

      noticeDao.update(noticeDTO);
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
    //    String title = Prompt.inputString(String.format("제목(%s) ▶ ", noticeDTO.getTitle()));
    //    String content = Prompt.inputString(String.format("내용(%s) ▶ ", noticeDTO.getContent()));
    //    noticeDTO.setFileUpload(GeneralHelper.promptNoticeFileUpload());
    //    //    List<QuestionAttachedFile> filepath = GeneralHelper.promptQnaFileUpload();
    //
    //    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
    //      System.out.println();
    //      System.out.println("게시물 수정을 취소하였습니다.");
    //      return;
    //    }
    //
    //    noticeDTO.setTitle(title);
    //    noticeDTO.setContent(content);
    //
    //    try {
    //      noticeDao.update(noticeDTO);
    //      noticeDao.deleteFile(noticeDTO);
    //      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
    //        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //    } catch (Exception e) {
    //      // 예외검사
    //      e.printStackTrace();
    //      // 예외 발생하면, 발생하기 전 작업이 모두 취소됨
    //      sqlSession.rollback();
    //    }
    //  }
  }
}
