package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;

public class NoitceListHandler extends AbstractNoticeHandler {

  public NoitceListHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[고객센터/공지사항/공지사항 목록]");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdminId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }

}