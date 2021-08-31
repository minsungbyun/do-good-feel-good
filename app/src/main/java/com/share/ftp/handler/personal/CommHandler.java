package com.share.ftp.handler.personal;
import com.share.util.Prompt;

public class CommHandler {

  CommBoardHandler commBoardHandler;
  CommBestHandler commBestHandler;
  CommReviewHandler commReviewHandler;

  public CommHandler(CommBoardHandler commBoardHandler, CommBestHandler commBestHandler,
      CommReviewHandler commReviewHandler) {
    this.commBoardHandler = commBoardHandler;
    this.commBestHandler = commBestHandler;
    this.commReviewHandler = commReviewHandler;
  }

  public void commBoard() {

    while (true) {
      System.out.println("[나눔이야기]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("3. 삭제");

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
    System.out.println("베스트후기목록");
  }

  public void commReview() {

    while (true) {
      System.out.println("[한줄후기]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 변경");
      System.out.println("4. 삭제");

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














