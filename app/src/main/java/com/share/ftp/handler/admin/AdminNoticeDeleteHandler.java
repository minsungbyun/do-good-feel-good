package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class AdminNoticeDeleteHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeDeleteHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  public void execute() {
    System.out.println("[공지사항 삭제]");
    int boardNo = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(boardNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항삭제를 취소하였습니다.");
      return;
    }

    noticeDTOList.remove(noticeDTO);

    System.out.println("공지사항을 삭제하였습니다.");
  }


}
