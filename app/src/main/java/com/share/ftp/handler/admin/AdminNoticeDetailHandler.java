package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeDetailHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeDetailHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[공지사항 상세보기]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", noticeDTO.getNo());
    System.out.printf("관리자 아이디: %s\n", noticeDTO.getAdmin().getId());
    System.out.printf("제목: %s\n", noticeDTO.getTitle());
    System.out.printf("내용: %s\n", noticeDTO.getContent());
    System.out.printf("첨부파일: %s\n", noticeDTO.getFileUpload());
    System.out.printf("등록일: %s\n", noticeDTO.getRegisteredDate());
  }


}
