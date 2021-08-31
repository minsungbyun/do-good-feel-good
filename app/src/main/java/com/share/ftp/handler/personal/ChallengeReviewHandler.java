package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewHandler {
  static final int MAX_LENGTH = 100;

  MyChallengeReviewDTO[] myChallengeReviews = new MyChallengeReviewDTO[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[참여인증&댓글 등록]");

    MyChallengeReviewDTO myChallengeReview = new MyChallengeReviewDTO();

    myChallengeReview.setNo(Prompt.inputInt("번호: "));
    myChallengeReview.setMemberId(Prompt.inputString("아이디: "));
    myChallengeReview.setContent(Prompt.inputString("내용: "));
    myChallengeReview.setFileUpload(Prompt.inputString("파일첨부: "));
    myChallengeReview.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.myChallengeReviews[this.size++] = myChallengeReview;
  }

  public void list() {
    System.out.println("[참여인증&댓글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s", 
          this.myChallengeReviews[i].getNo(), 
          this.myChallengeReviews[i].getMemberId(), 
          this.myChallengeReviews[i].getContent(),
          this.myChallengeReviews[i].getFileUpload(),
          this.myChallengeReviews[i].getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[참여인증&댓글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReview = findByNo(no);

    if (myChallengeReview == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    System.out.printf("아이디: %s\n", myChallengeReview.getMemberId());
    System.out.printf("내용: %s\n", myChallengeReview.getContent());
    System.out.printf("파일첨부: %s\n", myChallengeReview.getFileUpload());
    System.out.printf("등록일: %s\n", myChallengeReview.getRegisteredDate());
  }

  public void update() {
    System.out.println("[참여인증&댓글 변경]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReview = findByNo(no);

    if (myChallengeReview == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeReview.getContent()));
    String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", myChallengeReview.getFileUpload()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 변경을 취소하였습니다.");
      return;
    }

    myChallengeReview.setContent(content);
    myChallengeReview.setFileUpload(fileUpload);
    System.out.println("참여인증&댓글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[댓글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.myChallengeReviews[i - 1] = this.myChallengeReviews[i];
    }
    this.myChallengeReviews[--this.size] = null;

    System.out.println("참여인증&댓글을 삭제하였습니다.");
  }


  private MyChallengeReviewDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myChallengeReviews[i].getNo() == no) {
        return this.myChallengeReviews[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.myChallengeReviews[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
