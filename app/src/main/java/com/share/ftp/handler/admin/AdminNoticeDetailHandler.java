package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class AdminNoticeDetailHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeDetailHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }



  public void execute() {
    System.out.println("[공지사항 등록]");

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setNo(Prompt.inputInt("번호? ")); 
    noticeDTO.setAdminId(Prompt.inputString("관리자 아이디? "));
    noticeDTO.setTitle(Prompt.inputString("제목? "));
    noticeDTO.setContent(Prompt.inputString("내용? ")); 
    noticeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    noticeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));


    noticeDTOList.add(noticeDTO);

  }

  public void list() {
    System.out.println("[회원 목록]");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdminId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", noticeDTO.getNo());
    System.out.printf("관리자 아이디: %s\n", noticeDTO.getAdminId());
    System.out.printf("제목: %s\n", noticeDTO.getTitle());
    System.out.printf("내용: %s\n", noticeDTO.getContent());
    System.out.printf("첨부파일: %s\n", noticeDTO.getFileUpload());
    System.out.printf("등록일: %s\n", noticeDTO.getRegisteredDate());
  }

  public void update() {
    System.out.println("[공지사항 변경]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

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

  public void delete() {
    System.out.println("[공지사항 삭제]");
    int no = Prompt.inputInt("번호? ");

    NoticeDTO noticeDTO = findByNo(no);

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
