package com.share.ftp.handler.admin;

import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeDeleteHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeDeleteHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 삭제 ]");
    System.out.println();
    int noticeNo = (int) request.getAttribute("noticeNo"); 

    NoticeDTO noticeDTO = noticeDao.findByNoticeNo(noticeNo);


    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시물 삭제를 취소하였습니다.");
      return;

    } 

    noticeDao.delete(noticeNo);

    System.out.println();
    System.out.println("게시글이 삭제되었습니다.");
  }
}


