package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.util.Prompt;

public class QuestionListHandler {


  static final int MAX_LENGTH = 5;
  MyQuestionListDTO[] myQuestionLists = new MyQuestionListDTO[MAX_LENGTH];
  int size = 0;


  public void addQuestionlist() {

    System.out.println("[게시글 등록하기]");

    MyQuestionListDTO myQuestionList = new MyQuestionListDTO();

    myQuestionList.no = Prompt.inputInt("번호? ");
    myQuestionList.title = Prompt.inputString("제목? ");
    myQuestionList.password = Prompt.inputInt("비밀번호? ");
    myQuestionList.content = Prompt.inputString("내용? ");
    myQuestionList.fileUpload = Prompt.inputString("파일첨부? ");
    myQuestionList.registeredDate = new Date(System.currentTimeMillis());

    this.myQuestionLists[this.size++] = myQuestionList;
  }

  public void questionList() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %s, %d\n", 
          this.myQuestionLists[i].no, 
          this.myQuestionLists[i].title, 
          this.myQuestionLists[i].memberld,
          this.myQuestionLists[i].password,
          this.myQuestionLists[i].content,
          this.myQuestionLists[i].fileUpload,
          this.myQuestionLists[i].registeredDate,
          this.myQuestionLists[i].viewCount);

    }
  }

  public void detailQuestion() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionList = null;

    for (int i = 0; i < this.size; i++) {
      if (this.myQuestionLists[i].no == no) {
        myQuestionList = this.myQuestionLists[i];
        break;
      }
    }

    if (myQuestionList == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", myQuestionList.title);
    System.out.printf("내용: %s\n", myQuestionList.content);
    System.out.printf("작성자: %s\n", myQuestionList.memberld);
    System.out.printf("등록일: %s\n", myQuestionList.registeredDate);
    System.out.printf("조회수: %d\n", ++myQuestionList.viewCount);
  }

  public void updateQuestion() {
    System.out.println("[게시글 수정하기]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionList = null;

    for (int i = 0; i < this.size; i++) {
      if (this.myQuestionLists[i].no == no) {
        myQuestionList = this.myQuestionLists[i];
        break;
      }
    }

    if (myQuestionList == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", myQuestionList.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", myQuestionList.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    myQuestionList.title = title;
    myQuestionList.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void deleteQuestion() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int boardIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.myQuestionLists[i].no == no) {
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
      this.myQuestionLists[i - 1] = this.myQuestionLists[i];
    }
    this.myQuestionLists[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

}








