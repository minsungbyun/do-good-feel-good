package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;

public class AdminNoticeListHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeListHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }



  public void execute() {
    System.out.println("[공지사항 목록]");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s\n", 
          noticeDTO.getNo(), 
<<<<<<< HEAD
          noticeDTO.getAdmin().getId(), 
=======
          noticeDTO.getAdmin().getId(),
>>>>>>> feccd57486d805acc37694477cd990d177f76356
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }



}
