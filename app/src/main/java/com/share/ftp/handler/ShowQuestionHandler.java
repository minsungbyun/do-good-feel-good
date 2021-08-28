package com.share.ftp.handler;

import com.share.ftp.domain.QuestionDTO;
import com.share.util.Prompt;

public class ShowQuestionHandler {

  static final int MAX_LENGTH = 10;

  QuestionDTO[] questions = new QuestionDTO[MAX_LENGTH];
  int size = 0;

  public void addreply() {
    System.out.println("[문의사항 등록]");

    QuestionDTO question = new QuestionDTO();

    question.setAdminId(Prompt.inputInt("관리자ID: "));
    question.setTitle(Prompt.inputString("제목: "));
    question.setContent(Prompt.inputString("내용: "));

    this.questions[this.size++] = question;
  }

  public void list() {
    System.out.println("[문의사항 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%s, %s, %s\n", 
          this.questions[i].getAdminId(), 
          this.questions[i].getTitle(), 
          this.questions[i].getContent());
    }
  }

  public void detail() {
    System.out.println("[문의사항 상세보기]");
    int no = Prompt.inputInt("관리자ID: ");

    QuestionDTO questionDTO = null;

    for (int i = 0; i < this.size; i++) {
      if (this.questions[i].getAdminId() == no) {
        questionDTO = this.questions[i];
        break;
      }
    }

    if (questionDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", questionDTO.getTitle());
    System.out.printf("내용: %s\n", questionDTO.getContent());
  }

  public void update() {
    System.out.println("[문의사항 변경]");
    int no = Prompt.inputInt("번호? ");

    QuestionDTO questionDTO = null;

    for (int i = 0; i < this.size; i++) {
      if (this.questions[i].getAdminId() == no) {
        questionDTO = this.questions[i];
        break;
      }
    }

    if (questionDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", questionDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", questionDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    questionDTO.setTitle(title);
    questionDTO.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int questionDTOIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.questions[i].getAdminId() == no) {
        questionDTOIndex = i;
        break;
      }
    }

    if (questionDTOIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = questionDTOIndex + 1; i < this.size; i++) {
      this.questions[i - 1] = this.questions[i];
    }
    this.questions[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

}
