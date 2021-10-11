package com.share.ftp.handler.admin;

import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class AdminNoticeDetailHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeDetailHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 상세보기 ]");

    int noticeNo = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = noticeDao.findByNoticeNo(noticeNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    System.out.printf("번호: %s\n", noticeDTO.getNo());
    System.out.printf("관리자 아이디: %s\n", noticeDTO.getAdmin().getId());
    System.out.printf("제목: %s\n", noticeDTO.getTitle());
    System.out.printf("내용: %s\n", noticeDTO.getContent());
    System.out.printf("첨부파일: %s\n", noticeDTO.getFileUpload());
    System.out.printf("등록일: %s\n", noticeDTO.getRegisteredDate());
    System.out.println();

    JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 
    if (loginUser == null || (!loginUser.getName().equals("관리자"))) {
      return;
    }

    request.setAttribute("noticeNo", noticeNo);

    while (true) {
      String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/adminNotice/update").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/adminNotice/delete").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }

  }

}
