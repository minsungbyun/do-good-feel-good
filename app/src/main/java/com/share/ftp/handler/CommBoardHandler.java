package com.share.ftp.handler;

import java.sql.Date;
import com.share.ftp.domain.CommBoardDTO;
import com.share.util.Prompt;

public class CommBoardHandler {

  static final int MAX_LENGTH = 5;

  CommBoardDTO[] commBoardDTOs = new CommBoardDTO[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[나눔이야기 등록]");

    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.no = Prompt.inputInt("번호? ");
    commBoardDTO.title = Prompt.inputString("제목? ");
    commBoardDTO.content = Prompt.inputString("내용? ");
    commBoardDTO.fileUpload = Prompt.inputString("첨부파일? ");
    commBoardDTO.password = Prompt.inputString("비밀번호? ");
    commBoardDTO.registeredDate = new Date(System.currentTimeMillis());

    this.commBoardDTOs[this.size++] = commBoardDTO;
  }

  public void list() {
    System.out.println("[나눔이야기 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
          this.commBoardDTOs[i].no, 
          this.commBoardDTOs[i].title, 
          this.commBoardDTOs[i].content,
          this.commBoardDTOs[i].fileUpload,
          this.commBoardDTOs[i].password,
          this.commBoardDTOs[i].registeredDate, 
          this.commBoardDTOs[i].viewCount);
    }
  }

  public void detail() {
    System.out.println("[상세보기]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = null;

    for (int i = 0; i < this.size; i++) {
      if (this.commBoardDTOs[i].no == no) {
        commBoardDTO = this.commBoardDTOs[i];
        break;
      }
    }

    if (commBoardDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %s\n", commBoardDTO.no);
    System.out.printf("제목: %s\n", commBoardDTO.title);
    System.out.printf("내용: %s\n", commBoardDTO.content);
    System.out.printf("작성자: %s\n", commBoardDTO.fileUpload);
    System.out.printf("작성자: %s\n", commBoardDTO.password);
    System.out.printf("등록일: %s\n", commBoardDTO.registeredDate);
    System.out.printf("조회수: %d\n", ++commBoardDTO.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = null;

    for (int i = 0; i < this.size; i++) {
      if (this.commBoardDTOs[i].no == no) {
        commBoardDTO = this.commBoardDTOs[i];
        break;
      }
    }

    if (commBoardDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", commBoardDTO.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", commBoardDTO.content));
    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", commBoardDTO.fileUpload));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    commBoardDTO.title = title;
    commBoardDTO.content = content;
    commBoardDTO.fileUpload = fileUpload;

    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int commBoardIndex = -1;

    // Board 인스턴스가 들어 있는 배열을 뒤져서
    // 게시글 번호와 일치하는 Board 인스턴스를 찾는다. 
    for (int i = 0; i < this.size; i++) {
      if (this.commBoardDTOs[i].no == no) {
        commBoardIndex = i;
        break;
      }
    }

    if (commBoardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    for (int i = commBoardIndex + 1; i < this.size; i++) {
      this.commBoardDTOs[i - 1] = this.commBoardDTOs[i];
    }
    this.commBoardDTOs[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

}







