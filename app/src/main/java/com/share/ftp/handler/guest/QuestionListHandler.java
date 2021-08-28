package com.share.ftp.handler.guest;

import com.share.ftp.domain.personal.myQuestionListDTO;
import com.share.util.Prompt;

public class QuestionListHandler {

  static final int MAX_LENGTH = 5;
  myQuestionListDTO[] boards = new myQuestionListDTO[MAX_LENGTH];
  int size = 0;


  public void addQuestionlist() {

    System.out.println("[게시글 등록하기]");

    myQuestionListDTO board = new myQuestionListDTO();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.password = Prompt.inputInt("비밀번호? ");
    board.content = Prompt.inputString("내용? ");
    board.fileUpload = Prompt.inputString("파일첨부? ");
    board.viewCount = 0;

    this.boards[this.size++] = board;
  }

  public void showQuestionList() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].memberld,
          this.boards[i].content,
          this.boards[i].fileUpload,
          this.boards[i].registeredDate,
          this.boards[i].viewCount);

    }
  }

  public void detailQuestion() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    myQuestionListDTO board = null;

    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.memberld);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void updateQuestion() {
    System.out.println("[게시글 수정하기]");
    int no = Prompt.inputInt("번호? ");

    myQuestionListDTO board = null;

    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void deleteQuestion() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int boardIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        boardIndex = i;
        break;
      }
    }

    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = boardIndex + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

}








