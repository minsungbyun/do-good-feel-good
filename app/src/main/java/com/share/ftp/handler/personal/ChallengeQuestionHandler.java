package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionHandler {
	  static final int MAX_LENGTH = 100;

	  MyChallengeQuestionDTO[] boards = new MyChallengeQuestionDTO[MAX_LENGTH];
	  int size = 0;

	  public void add() {
	    System.out.println("[문의하기 등록]");

	    MyChallengeQuestionDTO board = new MyChallengeQuestionDTO();

	    board.no = Prompt.inputInt("번호: ");
	    board.memberId = Prompt.inputString("아이디: ");
	    board.content = Prompt.inputString("내용: ");

	    this.boards[this.size++] = board;
	  }

	  public void list() {
	    System.out.println("[문의 목록]");
	    for (int i = 0; i < this.size; i++) {
	      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
	          this.boards[i].no, 
	          this.boards[i].memberId, 
	          this.boards[i].content);
	    }
	  }

	  public void detail() {
	    System.out.println("[문의 상세보기]");
	    int no = Prompt.inputInt("번호? ");

	    MyChallengeQuestionDTO board = null;

	    for (int i = 0; i < this.size; i++) {
	      if (this.boards[i].no == no) {
	        board = this.boards[i];
	        break;
	      }
	    }

	    if (board == null) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    System.out.printf("아이디: %s\n", board.memberId);
	    System.out.printf("내용: %s\n", board.content);
	  }

	  public void update() {
	    System.out.println("[문의 변경]");
	    int no = Prompt.inputInt("번호? ");

	    MyChallengeQuestionDTO board = null;

	    for (int i = 0; i < this.size; i++) {
	      if (this.boards[i].no == no) {
	        board = this.boards[i];
	        break;
	      }
	    }

	    if (board == null) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

	    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
	    if (input.equalsIgnoreCase("n") || input.length() == 0) {
	      System.out.println("문의하기 변경을 취소하였습니다.");
	      return;
	    }

	    board.content = content;
	    System.out.println("문의하기를 변경하였습니다.");
	  }

	  public void delete() {
	    System.out.println("[문의 삭제]");
	    int no = Prompt.inputInt("번호? ");

	    int boardIndex = -1;

	    for (int i = 0; i < this.size; i++) {
	      if (this.boards[i].no == no) {
	        boardIndex = i;
	        break;
	      }
	    }

	    if (boardIndex == -1) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
	    if (input.equalsIgnoreCase("n") || input.length() == 0) {
	      System.out.println("문의하기 삭제를 취소하였습니다.");
	      return;
	    }

	    for (int i = boardIndex + 1; i < this.size; i++) {
	      this.boards[i - 1] = this.boards[i];
	    }
	    this.boards[--this.size] = null;

	    System.out.println("문의하기를 삭제하였습니다.");
	  }

}
