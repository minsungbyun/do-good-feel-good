package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.DonationBoardHandler;
import com.share.util.Prompt;

public class ShowDonationHandler {
  DonationBoardHandler donationBoardHandler;

  public ShowDonationHandler (DonationBoardHandler donationBoardHandler) {
    this.donationBoardHandler = donationBoardHandler;
  }

  public void list() {
    while (true) {
      try {
        System.out.println("1. 기부 목록");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("기부 목록> ");
        switch (menuNo) {
          case 1: donationBoardHandler.applyDonationList(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();
      } catch (Throwable e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }
  public void detail() {
    while (true) {
      try {
        System.out.println("1. 기부 상세보기");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("기부 목록> ");
        switch (menuNo) {
          case 1: donationBoardHandler.applyDonationdetail(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();
      } catch (Throwable e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }
}