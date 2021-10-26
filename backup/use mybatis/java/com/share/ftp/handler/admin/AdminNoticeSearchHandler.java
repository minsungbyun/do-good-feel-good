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
    System.out.println("[ 공지사항 - 검색 ] ");

    String input = Prompt.inputString("검색어: ");

    Collection<NoticeDTO> noticeList = noticeDao.findByKeyword(input);

    System.out.println(noticeList);

    for (NoticeDTO noticeDTO : noticeList) {
      System.out.printf("%d, %s, %s, %d\n", 
          noticeDTO.getNo(), 
          //          noticeDTO.getAdmin().getId(), 
          noticeDTO.getTitle(), 
          //          noticeDTO.getContent(), 
          //          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate(),
          noticeDTO.getViewCount());
    }
  }
}
