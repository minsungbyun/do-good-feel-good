package com.share.ftp.handler.personal;

import com.share.util.Prompt;


public class ChallengeHandler {

  ChallengeListHandler challengeListHandler = new ChallengeListHandler();
  RankingHandler rankingHandler = new RankingHandler();

  public void showChallenge() {
    System.out.println("[이달의 챌린지]");

    while (true) {
      System.out.println("챌린지/ 이달의챌린지");
      System.out.println("1. 목록");
      System.out.println("2. 상세보기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: challengeListHandler.showList(); break;
        case 2: challengeListHandler.showDetail(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }

  }

  public void showRanking() {
    System.out.println("[이달의 랭킹]");

    while (true) {
      System.out.println("챌린지/ 이달의랭킹");
      System.out.println("1. 전체랭킹");
      System.out.println("2. 나의랭킹");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: rankingHandler.showTotalRanking(); break;
        case 2: rankingHandler.showMyRanking(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }


  }

<<<<<<< HEAD
}
=======
}
>>>>>>> 4c06da1b6cae24ab53d89fe0f3c64ab5fdcd8bc4
