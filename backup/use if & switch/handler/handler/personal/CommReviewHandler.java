package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.util.Prompt;

public class CommReviewHandler {

  static final int MAX_LENGTH = 5;

  CommReviewDTO[] commReviewsDTO = new CommReviewDTO[MAX_LENGTH];
  int size;

  public void add() {

    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 등록]");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.setNo(Prompt.inputInt("번호? "));
    commReviewDTO.setContent(Prompt.inputString("내용? "));
    commReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.commReviewsDTO[this.size++] = commReviewDTO;
  }

  public void list() {
    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s\n", 
          this.commReviewsDTO[i].getNo(), 
          this.commReviewsDTO[i].getContent(),
          this.commReviewsDTO[i].getRegisteredDate()); 
    }
  }

  public void update() {
    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 변경]");
    int no = Prompt.inputInt("번호? ");

    CommReviewDTO commReviewDTO = findByNo(no);

    if (commReviewDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", commReviewDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    commReviewDTO.setContent(content);

    System.out.println("변경하였습니다.");
  }

  public void delete() {
    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.commReviewsDTO[i - 1] = this.commReviewsDTO[i];
    }
    this.commReviewsDTO[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private CommReviewDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if(this.commReviewsDTO[i].getNo() == no) {
        return this.commReviewsDTO[i];
      }
    }
    return null;
  }
  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.commReviewsDTO[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}











