package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.util.Prompt;

public class CommReviewHandler {

  static final int MAX_LENGTH = 5;

  CommReviewDTO[] commReviewDTOs = new CommReviewDTO[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[한줄후기 등록]");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.no = Prompt.inputInt("번호? ");
    commReviewDTO.content = Prompt.inputString("내용? ");
    commReviewDTO.registeredDate = new Date(System.currentTimeMillis());

    this.commReviewDTOs[this.size++] = commReviewDTO;
  }

  public void list() {
    System.out.println("[한줄후기 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s\n", 
          this.commReviewDTOs[i].no, 
          this.commReviewDTOs[i].content,
          this.commReviewDTOs[i].registeredDate); 
    }
  }

  public void update() {
    System.out.println("[한줄후기 변경]");
    int no = Prompt.inputInt("번호? ");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    for (int i = 0; i < this.size; i++) {
      if (this.commReviewDTOs[i].no == no) {
        commReviewDTO = this.commReviewDTOs[i];
        break;
      }
    }

    if (commReviewDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", commReviewDTO.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    commReviewDTO.content = content;

    System.out.println("변경하였습니다.");
  }

  public void delete() {
    System.out.println("[한줄후기 삭제]");
    int no = Prompt.inputInt("번호? ");

    int commBoardIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.commReviewDTOs[i].no == no) {
        commBoardIndex = i;
        break;
      }
    }
    if (commBoardIndex == -1) {
      System.out.println("해당 번호의 리뷰가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    for (int i = commBoardIndex + 1; i < this.size; i++) {
      this.commReviewDTOs[i - 1] = this.commReviewDTOs[i];
    }
    this.commReviewDTOs[--this.size] = null;

    System.out.println("삭제되었습니다.");
    System.out.println();
  }
}











