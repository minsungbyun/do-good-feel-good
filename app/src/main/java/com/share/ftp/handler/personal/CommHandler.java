package com.share.ftp.handler.personal;

import com.share.util.Prompt;

public class CommHandler {

  CommBoardHandler commBoardHandler = new CommBoardHandler();
  CommBestHandler commBestHandler = new CommBestHandler();
  CommReviewHandler commReviewHandler = new CommReviewHandler();

  public void commBoard() {

    while (true) {
      System.out.println("[소통해요/ 나눔이야기]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: commBoardHandler.add(); break;
        case 2: commBoardHandler.list(); break;
        case 3: commBoardHandler.detail(); break;
        case 4: commBoardHandler.update(); break;
        case 5: commBoardHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void commBest() {
    while (true) {
      System.out.println("소통해요/ 나눔이야기 Best");
      System.out.println("1. 목록");
      System.out.println("2. 상세보기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: commBestHandler.showList(); break;
        case 2: commBestHandler.showDetail(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void commReview() {

    while (true) {
      System.out.println("소통해요/ 한줄후기");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 변경");
      System.out.println("4. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: commReviewHandler.add(); break;
        case 2: commReviewHandler.list(); break;
        case 3: commReviewHandler.update(); break;
        case 4: commReviewHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }
}














