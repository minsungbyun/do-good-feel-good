package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.donation.DonationBoardHandler;
import com.share.util.Prompt;

public class ShowDonationHandler { // 기관이 모금함 개설 신청한 양식 보는곳
  DonationBoardHandler donationBoardHandler;

  public ShowDonationHandler (DonationBoardHandler donationBoardHandler) {
    this.donationBoardHandler = donationBoardHandler;
  }

  // 모금함 개설 신청내역 목록
  public void list() {
    while (true) {
      try {
        System.out.println("1. 모금함 개설 신청내역 목록");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("신청내역 목록> ");
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

  // 모금함 개설 신청내역 상세보기
  public void detail() {
    while (true) {
      try {
        System.out.println("1. 모금함 개설 신청내역 상세보기");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("신청내역 상세보기> ");
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

  // 모금함 개설 신청내역 승인하기
  public void accept() {
    System.out.println("승인하기");
  }

  // 모금함 개설 신청내역 반려하기
  public void reject() {
    System.out.println("반려하기");
  }

}