package com.share.ftp.handler.admin;

import java.util.Collection;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeSearchHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeSearchHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 검색] ");

    String input = Prompt.inputString("검색어: ");

    Collection<NoticeDTO> noticeList = noticeDao.findByKeyword(input);

    for (NoticeDTO noticeDTO : noticeList) {
      if(!noticeDTO.getTitle().contains(input) &&
          !noticeDTO.getContent().contains(input) &&
          !noticeDTO.getAdmin().getId().contains(input)) {
        continue;
      }
      System.out.printf("%d, %s, %s, %s, %s, %s\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdmin().getId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }
}
