package com.share.ftp.handler.admin;

import java.util.Collection;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class AdminNoticeListHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeListHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 목록 ]");

    Collection<NoticeDTO> noticeList = noticeDao.findAll();

    if (noticeList.isEmpty()) {
      System.out.println();
      System.out.println("작성된 게시글이 없습니다.");
    }

    for (NoticeDTO noticeDTO : noticeList) {
      System.out.printf("%d, %s, %s, %d\n", 
          noticeDTO.getNo(), 
          noticeDTO.getTitle(), 
          noticeDTO.getRegisteredDate(), 
          noticeDTO.getViewCount());

      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
        System.out.printf("첨부파일: %s\n", noticeAttachedFile.getFilepath());
      }
    }
  }
}
