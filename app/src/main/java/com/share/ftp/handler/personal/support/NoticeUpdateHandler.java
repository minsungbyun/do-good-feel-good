package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class NoticeUpdateHandler extends AbstractNoticeHandler {

  public NoticeUpdateHandler(List<NoticeDTO> noticeDTOList) {
    super (noticeDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[고객센터/공지사항/공지사항 수정]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", noticeDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", noticeDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    noticeDTO.setTitle(title);
    noticeDTO.setContent(content);
    System.out.println("공지사항을 변경하였습니다.");
  }


}