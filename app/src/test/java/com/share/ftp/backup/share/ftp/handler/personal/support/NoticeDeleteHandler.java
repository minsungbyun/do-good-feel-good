package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class NoticeDeleteHandler extends AbstractNoticeHandler {

  public NoticeDeleteHandler(List<NoticeDTO> noticeDTOList) {
    super (noticeDTOList);
  }

  public void execute() {
    System.out.println();
    System.out.println("[고객센터/공지사항/공지사항 삭제]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    noticeDTOList.remove(noticeDTO);

    System.out.println("공지사항을 삭제하였습니다.");
  }


}