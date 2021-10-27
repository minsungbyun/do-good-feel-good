package com.share.ftp.handler.admin;

import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeUpdateHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeUpdateHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 수정 ]");

    int noticeNo = (int) request.getAttribute("noticeNo");

    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    String title = Prompt.inputString("제목(" + noticeDTO.getTitle() + ")? ");
    String content = Prompt.inputString("내용(" + noticeDTO.getContent() + ")? ");
    //    String fileUpload = Prompt.inputString("첨부파일(" + noticeDTO.getFileUpload() + ")? ");

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("게시물 수정을 취소하였습니다.");
      return;
    } else if (input.equals("y")) {
      noticeDTO.setTitle(title);
      noticeDTO.setContent(content);
      //      noticeDTO.setFileUpload(fileUpload);

      noticeDao.update(noticeDTO);

      System.out.println();
      System.out.println("게시물을 수정하였습니다.");
      return;
    }
  }
}
