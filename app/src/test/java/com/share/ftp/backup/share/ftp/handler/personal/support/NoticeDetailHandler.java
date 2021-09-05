package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class NoticeDetailHandler extends AbstractNoticeHandler {

  public NoticeDetailHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[고객센터/공지사항/공지사항 상세]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %s\n", noticeDTO.getNo());
    System.out.printf("제목: %s\n", noticeDTO.getTitle());
    System.out.printf("내용: %s\n", noticeDTO.getContent());
    System.out.printf("작성자: %s\n", noticeDTO.getFileUpload());
    System.out.printf("등록일: %s\n", noticeDTO.getRegisteredDate());

    noticeDTO.setViewCount(noticeDTO.getViewCount() + 1);
    System.out.printf("조회수: %d\n", noticeDTO.getViewCount());
  }
}