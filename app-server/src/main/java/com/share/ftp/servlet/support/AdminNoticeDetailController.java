package com.share.ftp.servlet.support;

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

@WebServlet("/support/noticeDetail")
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
      request.getRequestDispatcher("/support/NoticeDetail.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }


  //    int noticeNo = Prompt.inputInt("번호? ");
  //
  //    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);
  //
  //    if (noticeDTO == null) {
  //      System.out.println("해당 번호의 게시물이 없습니다.");
  //      return;
  //    }
  //
  //    System.out.printf("번호: %s\n", noticeDTO.getNo());
  //    System.out.printf("제목: %s\n", noticeDTO.getTitle());
  //    System.out.printf("내용: %s\n", noticeDTO.getContent());
  //    //    System.out.printf("첨부파일: %s\n", noticeDTO.getFileUpload());
  //    System.out.printf("등록일: %s\n", noticeDTO.getRegisteredDate());
  //
  //    noticeDTO.setViewCount(noticeDTO.getViewCount() + 1);
  //    System.out.printf("조회수: %d\n", noticeDTO.getViewCount());
  //
  //    for (NoticeAttachedFile file : noticeDTO.getFileUpload()) {
  //      System.out.printf("첨부파일: %s\n", file.getFilepath());
  //    }
  //
  //    JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 
  //    if (loginUser == null || (!loginUser.getName().equals("관리자"))) {
  //      return;
  //    }
  //
  //    request.setAttribute("noticeNo", noticeNo);
  //
  //    while (true) {
  //      String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
  //      switch (input) {
  //        case "U":
  //        case "u":
  //          request.getRequestDispatcher("/adminNotice/update").forward(request);
  //          return;
  //        case "D":
  //        case "d":
  //          request.getRequestDispatcher("/adminNotice/delete").forward(request);
  //          return;
  //        case "0":
  //          return;
  //        default:
  //          System.out.println("명령어가 올바르지 않습니다!");
  //      }
  //    }
  //
  //  }

}
