package com.share.ftp.handler.admin;

import java.sql.Date;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.util.Prompt;

public class ShowChallengeHandler {

  static final int MAX_LENGTH = 100;

  ChallengeDTO[] challengesDTO = new ChallengeDTO[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[챌린지 등록]");

    ChallengeDTO challengeDTO = new ChallengeDTO();

    challengeDTO.setNo(Prompt.inputInt("번호? ")); 
    challengeDTO.setAdminId(Prompt.inputString("관리자 아이디? "));
    challengeDTO.setTitle(Prompt.inputString("제목? "));
    challengeDTO.setContent(Prompt.inputString("내용? ")); 
    challengeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    challengeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    if (this.size == this.challengesDTO.length) {
      ChallengeDTO[] arr = new ChallengeDTO[this.challengesDTO.length + (this.challengesDTO.length >> 1)];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.challengesDTO[i];
      }
      this.challengesDTO = arr;
    }
    this.challengesDTO[this.size++] = challengeDTO;

    System.out.println("챌린지가 정상적으로 등록되었습니다.");
  }

  public void list() {
    System.out.println("[챌린지 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          this.challengesDTO[i].getNo(), 
          this.challengesDTO[i].getAdminId(), 
          this.challengesDTO[i].getTitle(), 
          this.challengesDTO[i].getContent(), 
          this.challengesDTO[i].getFileUpload(), 
          this.challengesDTO[i].getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[챌린지 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ChallengeDTO challengeDTO = findByNo(no);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", challengeDTO.getNo());
    System.out.printf("관리자 아이디: %s\n", challengeDTO.getAdminId());
    System.out.printf("제목: %s\n", challengeDTO.getTitle());
    System.out.printf("내용: %s\n", challengeDTO.getContent());
    System.out.printf("첨부파일: %s\n", challengeDTO.getFileUpload());
    System.out.printf("등록일: %s\n", challengeDTO.getRegisteredDate());
  }

  public void update() {
    System.out.println("[챌린지 변경]");
    int no = Prompt.inputInt("번호? ");

    ChallengeDTO challengeDTO = findByNo(no);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    String title = Prompt.inputString("제목(" + challengeDTO.getTitle() + ")? ");
    String content = Prompt.inputString("내용(" + challengeDTO.getContent() + ")? ");
    String fileUpload = Prompt.inputString("첨부파일(" + challengeDTO.getFileUpload() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항 변경을 취소하였습니다.");
      return;
    }

    challengeDTO.setTitle(title);
    challengeDTO.setContent(content);
    challengeDTO.setFileUpload(fileUpload);

    System.out.println("챌린지를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[챌린지 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.challengesDTO[i - 1] = this.challengesDTO[i];
    }
    this.challengesDTO[--this.size] = null;

    System.out.println("챌린지를 삭제하였습니다.");
  }



  private ChallengeDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.challengesDTO[i].getNo() == no) {
        return this.challengesDTO[i];
      }
    }
    return null;
  }


  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.challengesDTO[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }


}
