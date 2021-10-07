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
    System.out.println("[공지사항 - 변경]");
    System.out.println();

    int noticeNo = (int) request.getAttribute("noticeNo");

    NoticeDTO noticeDTO = noticeDao.findByNoticeNo(noticeNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    NoticeDTO updateNotice = new NoticeDTO();

    updateNotice.setTitle(Prompt.inputString("제목(" + noticeDTO.getTitle() + ")? "));
    updateNotice.setContent(Prompt.inputString("내용(" + noticeDTO.getContent() + ")? "));
    updateNotice.setFileUpload(Prompt.inputString("첨부파일(" + noticeDTO.getFileUpload() + ")? "));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시물 변경을 취소하였습니다.");
      return;
    }

    noticeDao.update(updateNotice);
    System.out.println();

    System.out.println("게시물을 변경하였습니다.");
  }



}
