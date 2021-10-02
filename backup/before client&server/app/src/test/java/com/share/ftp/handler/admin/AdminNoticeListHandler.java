package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.CommandRequest;

public class AdminNoticeListHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeListHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }



  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[공지사항 목록]");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdmin().getId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getRegisteredDate(), 
          noticeDTO.getViewCount());
    }
  }
}
