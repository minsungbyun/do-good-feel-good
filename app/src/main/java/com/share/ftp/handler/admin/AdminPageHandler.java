package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.DonationBoardHandler;
import com.share.ftp.handler.personal.PersonalVolRequestHandler;
import com.share.util.Prompt;

public class AdminPageHandler {

  // 봉사활동 관련 Handler
  PersonalVolRequestHandler personalVolRequestHandler;
  //    ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler);

  // 모금활동 관련
  DonationBoardHandler donationBoardHandler;
  ShowDonationHandler showDonationHandler;

  public AdminPageHandler(PersonalVolRequestHandler personalVolRequestHandler, 
      DonationBoardHandler donationBoardHandler,
      ShowDonationHandler showDonationHandler) {
    this.personalVolRequestHandler = personalVolRequestHandler;
    this.donationBoardHandler = donationBoardHandler;
    this.showDonationHandler = showDonationHandler;
  }



  public void showMember() {
    System.out.println("회원정보 조회");
  }

  public void showDonation() {
    while (true) {
      System.out.println("1. 모금활동 관리");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("모금활동관리> ");
      switch (menuNo) {
        case 1: showDonationHandler.list(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void showVolunteer() {
    //
    //    while (true) {
    //      System.out.println("[메인 / 관리자페이지 / 봉사활동관리]");
    //      System.out.println("1. 개인봉사신청내역");
    //      System.out.println("2. 기관봉사신청내역");
    //      System.out.println("3. 승인하기");
    //      System.out.println("4. 반려하기");
    //      System.out.println("0. 이전메뉴");
    //
    //      int menuNo = Prompt.inputInt("봉사활동관리> ");
    //      switch (menuNo) {
    //        case 1: showVolHandler.personalApprove(); break;
    //        case 2: showVolHandler.orgApprove(); break;
    //        case 3: showVolHandler.accept(); break;
    //        case 4: showVolHandler.reject(); break;
    //        case 0: return;
    //        default:
    //          System.out.println("무효한 메뉴 번호입니다.");
    //      }
    //      System.out.println();
    //
    //
    //    }
  }

  public void showNotice() {
    System.out.println("공지사항 관리");

  }

  public void showQuestion() {
    System.out.println("문의사항 관리");

  }

  public void showChallenge() {
    System.out.println("챌리지 관리");

  }

  public void showOrgApprove() {
    System.out.println("기관 승인");

  }
}
