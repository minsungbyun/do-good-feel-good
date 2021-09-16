package com.share.ftp.handler.personal.challenge;

public class ChallengeListHandler {

  //	ChallengeBoardHandler challengeBoardHandler = new ChallengeBoardHandler();

//  public void showList() {
//    System.out.println("관리자가 등록한 챌린지 리스트");
//  }

  public void showDetail() {
    System.out.println();
    System.out.println("챌린지/ 이달의챌린지/ 챌린지 상세정보");

    while (true) {
      System.out.println("[챌린지 상세정보]");
      System.out.println("1. 참여하기");
      System.out.println("2. 참여자 보기");
      System.out.println("3. 참여인증&댓글");
      System.out.println("4. 문의하기");
      System.out.println("0. 이전메뉴");

      //	      int menuNo = Prompt.inputInt("메뉴> ");
      //	      switch (menuNo) {
      //	        case 1: challengeBoardHandler.join(); break;
      //	        case 2: challengeBoardHandler.showMemberList(); break;
      //	        case 3: challengeBoardHandler.showReview(); break;
      //	        case 4: challengeBoardHandler.showQuestionList(); break;
      //	        case 0: return;
      //	        default:
      //	          System.out.println("무효한 메뉴 번호입니다.");
      //	      }
      System.out.println();
    }

  }

}
