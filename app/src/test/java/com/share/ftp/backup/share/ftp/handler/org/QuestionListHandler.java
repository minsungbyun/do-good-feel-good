package com.share.ftp.handler.org;

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

    myQuestionList.setNo(Prompt.inputInt("번호? "));
    myQuestionList.setTitle(Prompt.inputString("제목? "));
    myQuestionList.setPassword(Prompt.inputInt("비밀번호? "));
    myQuestionList.setContent(Prompt.inputString("내용? "));
    myQuestionList.setFileUpload(Prompt.inputString("파일첨부? "));
    myQuestionList.setRegisteredDate(new Date(System.currentTimeMillis()));

    myQuestionLists[size++] = myQuestionList;
  }

  public void showQuestionList() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.myQuestionLists[i].getNo(), 
          this.myQuestionLists[i].getTitle(), 
          this.myQuestionLists[i].getMemberld(),
          this.myQuestionLists[i].getContent(),
          this.myQuestionLists[i].getFileUpload(),
          this.myQuestionLists[i].getRegisteredDate(),
          this.myQuestionLists[i].getViewCount());

    }
  }

  public void detailQuestion() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionList = findByNo(no);

    if (myQuestionList == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", myQuestionList.getTitle());
    System.out.printf("내용: %s\n", myQuestionList.getContent());
    System.out.printf("작성자: %s\n", myQuestionList.getMemberld());
    System.out.printf("등록일: %s\n", myQuestionList.getRegisteredDate());

    myQuestionList.setViewCount(myQuestionList.getViewCount() + 1);
    System.out.printf("조회수: %d\n", myQuestionList.getViewCount());
  }

  public void updateQuestion() {
    System.out.println("[게시글 수정하기]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionList = findByNo(no);

    if (myQuestionList == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", myQuestionList.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", myQuestionList.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    myQuestionList.setTitle(title);
    myQuestionList.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }

  public void deleteQuestion() {
    System.out.println("[게시글 삭제]");
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
      this.myQuestionLists[i - 1] = this.myQuestionLists[i];
    }
    this.myQuestionLists[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private MyQuestionListDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myQuestionLists[i].getNo() == no) {
        return this.myQuestionLists[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myQuestionLists[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}








