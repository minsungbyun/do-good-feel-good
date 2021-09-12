package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionHandler {
	  static final int MAX_LENGTH = 100;

	  ChallengeQuestionDTO[] myChallengeQuestions = new ChallengeQuestionDTO[MAX_LENGTH];
	  int size = 0;

	  public void add() {
	    System.out.println("[문의하기 등록]");

	    ChallengeQuestionDTO myChallengeQuestion = new ChallengeQuestionDTO();

	    myChallengeQuestion.setNo(Prompt.inputInt("번호: "));
	    myChallengeQuestion.setMemberId(Prompt.inputString("아이디: "));
	    myChallengeQuestion.setContent(Prompt.inputString("내용: "));

	    myChallengeQuestions[size++] = myChallengeQuestion;
	  }

	  public void list() {
	    System.out.println("[문의 목록]");
	    for (int i = 0; i < this.size; i++) {
	      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
	          myChallengeQuestions[i].getMemberId(), 
	          myChallengeQuestions[i].getContent());
	    }
	  }

	  public void detail() {
	    System.out.println("[문의 상세보기]");
	    int no = Prompt.inputInt("번호? ");

	    ChallengeQuestionDTO myChallengeQuestion = findByNo(no);

	    if (myChallengeQuestion == null) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    System.out.printf("아이디: %s\n", myChallengeQuestion.getMemberId());
	    System.out.printf("내용: %s\n", myChallengeQuestion.getContent());
	  }

	  public void update() {
	    System.out.println("[문의 변경]");
	    int no = Prompt.inputInt("번호? ");

	    ChallengeQuestionDTO myChallengeQuestion = findByNo(no);

	    if (myChallengeQuestion == null) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    String content = Prompt.inputString(String.format("내용: " + myChallengeQuestion.getContent()));

	    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
	    if (input.equalsIgnoreCase("n") || input.length() == 0) {
	      System.out.println("문의하기 변경을 취소하였습니다.");
	      return;
	    }

	    myChallengeQuestion.setContent(content);
	    System.out.println("문의하기를 변경하였습니다.");
	  }

	  public void delete() {
	    System.out.println("[문의 삭제]");
	    int no = Prompt.inputInt("번호? ");

	    int index = indexOf(no);

	    if (index == -1) {
	      System.out.println("해당 번호의 문의가 없습니다.");
	      return;
	    }

	    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
	    if (input.equalsIgnoreCase("n") || input.length() == 0) {
	      System.out.println("문의하기 삭제를 취소하였습니다.");
	      return;
	    }

	    for (int i = index + 1; i < this.size; i++) {
	      this.myChallengeQuestions[i - 1] = this.myChallengeQuestions[i];
	    }
	    this.myChallengeQuestions[--this.size] = null;

	    System.out.println("문의하기를 삭제하였습니다.");
	  }

  private ChallengeQuestionDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myChallengeQuestions[i].getNo() == no) {
        return this.myChallengeQuestions[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myChallengeQuestions[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
