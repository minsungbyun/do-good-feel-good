package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeBoardHandler {
  static final int MAX_LENGTH = 10;
  int size;

  MyChallengeReviewDTO myChallengeReview = new MyChallengeReviewDTO();

  ChallengeReviewHandler challengeReviewHandler = new ChallengeReviewHandler();
  AbstractChallengeQuestionHandler challengeQuestionHandler = new AbstractChallengeQuestionHandler();

  public void join() {
    System.out.println();
    System.out.println("챌린지/ 이달의 챌린지/ 챌린지 상세정보 / 참여하기");
    System.out.println("참여가 완료되었습니다.");
  }

  public void showMemberList() {
    System.out.println();
    System.out.println("챌린지/ 이달의 챌린지/ 챌린지 상세정보 / 참여자 정보");
    System.out.println("참여자 목록");
  }

  public void showReview() {
    System.out.println();
    System.out.println("챌린지/ 이달의 챌린지/ 챌린지 상세정보 / 참여인증&댓글");

    while (true) {
      System.out.println("[참여인증&댓글]");
      System.out.println("1. 댓글 등록");
      System.out.println("2. 댓글 목록");
      System.out.println("3. 댓글 상세보기");
      System.out.println("4. 댓글 수정");
      System.out.println("5. 댓글 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: challengeReviewHandler.add(); break;
        case 2: challengeReviewHandler.list(); break;
        case 3: challengeReviewHandler.detail(); break;
        case 4: challengeReviewHandler.update(); break;
        case 5: challengeReviewHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void showQuestionList() {
    System.out.println();
    System.out.println("챌린지/ 이달의 챌린지/ 챌린지 상세정보 / 문의하기");

    while (true) {
      System.out.println("문의하기");
      System.out.println("1. 문의 등록");
      System.out.println("2. 문의 목록");
      System.out.println("3. 문의 상세보기");
      System.out.println("4. 문의 수정");
      System.out.println("5. 문의 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: challengeQuestionHandler.add(); break;
        case 2: challengeQuestionHandler.list(); break;
        case 3: challengeQuestionHandler.detail(); break;
        case 4: challengeQuestionHandler.update(); break;
        case 5: challengeQuestionHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }
}

