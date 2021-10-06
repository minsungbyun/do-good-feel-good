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

    if (noticeDTOList.isEmpty()) {
      System.out.println();
      System.out.println("작성된 게시글이 없습니다.");
    }

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %d\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdmin().getId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getRegisteredDate(), 
          noticeDTO.getViewCount());
    }
  }
}
