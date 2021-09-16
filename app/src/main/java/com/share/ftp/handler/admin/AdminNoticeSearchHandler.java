package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class AdminNoticeSearchHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeSearchHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[공지사항 검색]");

    String input = Prompt.inputString("검색어? ");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      if(!noticeDTO.getTitle().contains(input) &&
          !noticeDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%d, %s, %s, %s, %s, %s\n", 
          noticeDTO.getBoardNo(), 
          noticeDTO.getAdmin().getId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }
}
