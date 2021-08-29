package com.share.ftp;

import com.share.ftp.handler.personal.ChallengeHandler;
import com.share.ftp.handler.personal.CommHandler;
import com.share.util.Prompt;

public class App {

  static CommHandler commHandler = new CommHandler();
  static ChallengeHandler challengeHandler = new ChallengeHandler();

  public static void main(String[] args) {
    while (true) {
      try {
        int menuNo = doMainMenu();

        if (menuNo == 0) {
          break;
        } else if (menuNo == 1) {
          doVolunteerMenu();
        } else if (menuNo == 2) {
          doCommunityMenu();
        } else if (menuNo == 3) {
          doChallengeMenu();
        } else if (menuNo == 4) {
          doDonationMenu();
        } else if (menuNo == 5) {
          doSupportMenu();
        } else if (menuNo == 6) {
          doMyPageMenu();
        } else if (menuNo == 7) {
          doAdminPageMenu();
        } else {
          System.out.println("메뉴 번호가 유효하지 않습니다.");
        }
        System.out.println();
      } catch (Throwable e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
    Prompt.close();
  }

  static void doVolunteerMenu() {
    while (true) {
      System.out.println("[메인/함께해요]");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. ");
      System.out.println("4. ");
      System.out.println("5. ");
      System.out.println("6. ");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("함께해요> ");
      switch (menuNo) {
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static void doCommunityMenu() {
    while (true) {
      System.out.println("[메인/소통해요]");
      System.out.println("1. 나눔이야기");
      System.out.println("2. 나눔이야기Best");
      System.out.println("3. 한줄후기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("소통해요> ");
      switch (menuNo) {
        case 1: commHandler.commBoard(); break;
        case 2: commHandler.commBest(); break;
        case 3: commHandler.commReview(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    } 
  }

  static void doChallengeMenu() {
    while (true) {
      System.out.println("[메인/챌린지]");
      System.out.println("1. 이달의 챌린지");
      System.out.println("2. 이달의 랭킹");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("챌린지> ");
      switch (menuNo) {
        case 1: challengeHandler.showChallenge(); break;
        case 2: challengeHandler.showRanking(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }

  }

  static void doDonationMenu() {
    while (true) {
      System.out.println("[메인/모금함]");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. ");
      System.out.println("4. ");
      System.out.println("5. ");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("모금함> ");
      switch (menuNo) {
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static void doSupportMenu() {
    while (true) {
      System.out.println("[메인/고객센터]");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. ");
      System.out.println("4. ");
      System.out.println("5. ");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("고객센터> ");
      switch (menuNo) {
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static void doMyPageMenu() {
    while (true) {
      System.out.println("[메인/마이페이지]");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. ");
      System.out.println("4. ");
      System.out.println("5. ");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("마이페이지> ");
      switch (menuNo) {
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static void doAdminPageMenu() {
    while (true) {
      System.out.println("[메인/관리자페이지]");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. ");
      System.out.println("4. ");
      System.out.println("5. ");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("관리자페이지> ");
      switch (menuNo) {
        case 1: break;
        case 2: break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static int doMainMenu() {
    System.out.println("[행복하share에 오신것을 환영합니다.]");
    System.out.println("1. 함께해요");
    System.out.println("2. 소통해요");
    System.out.println("3. 챌린지");
    System.out.println("4. 모금함");
    System.out.println("5. 고객센터");
    System.out.println("6. 마이페이지");
    System.out.println("7. 관리자페이지");
    System.out.println("0. 종료");
    return Prompt.inputInt("메뉴번호> "); 
  }

}