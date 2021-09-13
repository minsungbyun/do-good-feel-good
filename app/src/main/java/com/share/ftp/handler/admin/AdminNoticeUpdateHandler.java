package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class AdminNoticeUpdateHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeUpdateHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }


  public void execute() {
    System.out.println("[공지사항 변경]");
    int boardNo = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(boardNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 공지사항이 없습니다.");
      return;
    }

    String title = Prompt.inputString("제목(" + noticeDTO.getTitle() + ")? ");
    String content = Prompt.inputString("내용(" + noticeDTO.getContent() + ")? ");
    String fileUpload = Prompt.inputString("첨부파일(" + noticeDTO.getFileUpload() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항 변경을 취소하였습니다.");
      return;
    }

    noticeDTO.setTitle(title);
    noticeDTO.setContent(content);
    noticeDTO.setFileUpload(fileUpload);

    System.out.println("공지사항을 변경하였습니다.");
  }



}
