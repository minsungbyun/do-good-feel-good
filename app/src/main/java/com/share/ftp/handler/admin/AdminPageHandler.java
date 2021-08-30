package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.DonationBoardHandler;
import com.share.ftp.handler.personal.PersonalVolRequestHandler;
import com.share.util.Prompt;

public class AdminPageHandler {
  // 회원정보 관련 Handler
  ShowMemberHandler showMemberHandler = new ShowMemberHandler();

  // 봉사활동 관련 Handler
  PersonalVolRequestHandler personalVolRequestHandler;

  // 모금활동 관련
  DonationBoardHandler donationBoardHandler;
  ShowDonationHandler showDonationHandler;
  ShowVolHandler showVolHandler;

  // 공지사항 관련
  ShowNoticeHandler showNoticeHandler = new ShowNoticeHandler();
  
  // 문의사항 관련
  ShowQuestionHandler showQuestionHandler = new ShowQuestionHandler();
  
  // 챌린지관리 관련
  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler();
  
  // 기관승인 관련
  ShowOrgApproveHandler showOrgApproveHandler = new ShowOrgApproveHandler();

  public AdminPageHandler(PersonalVolRequestHandler personalVolRequestHandler,ShowVolHandler showVolHandler,
      DonationBoardHandler donationBoardHandler, ShowDonationHandler showDonationHandler) {
    this.personalVolRequestHandler = personalVolRequestHandler;
    this.showVolHandler = showVolHandler;
    this.showDonationHandler = showDonationHandler;
    this.donationBoardHandler = donationBoardHandler;
  }



  public void showMember() {
    System.out.println("회원정보 조회");
    personalVolRequestHandler.applyList();
    
    while (true) {
      System.out.println();
      System.out.println("[메인 / 관리자페이지 / 회원정보 관리]");
      System.out.println("1. 회원목록");
      System.out.println("2. 회원추방");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("회원정보관리> ");
      switch (menuNo) {
        case 1: showMemberHandler.list(); break;
        case 2: showMemberHandler.getOutMember(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();

        }
  }

  // 기관이 모금함 개설 신청한 내역을 받아서 관리자가 관리
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

    while (true) {
      System.out.println("[메인 / 관리자페이지 / 봉사활동관리]");
      System.out.println("1. 개인봉사신청내역");
      System.out.println("2. 기관봉사신청내역");
      System.out.println("3. 승인하기");
      System.out.println("4. 반려하기");
      System.out.println("5. 개인폼(테스트)");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("봉사활동관리> ");
      switch (menuNo) {
        case 1: showVolHandler.personalApprove(); break;
        case 2: showVolHandler.orgApprove(); break;
        case 3: showVolHandler.accept(); break;
        case 4: showVolHandler.reject(); break;
        case 5: personalVolRequestHandler.applyList(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();


    }
  }

  public void showNotice() {

    while (true) {
        System.out.println();
        System.out.println("[메인 / 관리자페이지 / 공지사항 관리]");
        System.out.println("1. 공지사항 등록");
        System.out.println("2. 공지사항 목록");
        System.out.println("3. 공지사항 상세보기");
        System.out.println("4. 공지사항 변경");
        System.out.println("5. 공지사항 삭제");

      int menuNo = Prompt.inputInt("공지사항관리> ");
      switch (menuNo) {
        case 1: showNoticeHandler.add(); break;
        case 2: showNoticeHandler.list(); break;
        case 3: showNoticeHandler.detail(); break;
        case 4: showNoticeHandler.update(); break;
        case 5: showNoticeHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }

  }

  public void showQuestion() {
    System.out.println("문의사항 관리");
    
    while (true) {
        System.out.println();
        System.out.println("[메인 / 관리자페이지 / 문의사항 관리]");
        System.out.println("1. 문의사항 등록");
        System.out.println("2. 문의사항 목록");
        System.out.println("3. 문의사항 상세보기");
        System.out.println("4. 문의사항 변경");
        System.out.println("5. 문의사항 삭제");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("문의사항관리> ");
        switch (menuNo) {
          case 1: showQuestionHandler.addreply(); break;
          case 2: showQuestionHandler.list(); break;
          case 3: showQuestionHandler.detail(); break;
          case 4: showQuestionHandler.update(); break;
          case 5: showQuestionHandler.delete(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();

      }

  }

  public void showChallenge() {
    System.out.println("챌린지 관리");
    
    while (true) {
        System.out.println();
        System.out.println("[메인 / 관리자페이지 / 챌린지 관리]");
        System.out.println("1. 챌린지 등록");
        System.out.println("2. 챌린지 목록");
        System.out.println("3. 챌린지 상세보기");
        System.out.println("4. 챌린지 변경");
        System.out.println("5. 챌린지 삭제");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("챌린지관리> ");
        switch (menuNo) {
          case 1: showChallengeHandler.add(); break;
          case 2: showChallengeHandler.list(); break;
          case 3: showChallengeHandler.detail(); break;
          case 4: showChallengeHandler.update(); break;
          case 5: showChallengeHandler.delete(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();

      }

  }

  public void showOrgApprove() {
    System.out.println("기관 승인");
    

    while (true) {
      System.out.println();
      System.out.println("[메인 / 관리자페이지 / 기관 승인]");
      System.out.println("1. 기관승인신청 목록");
      System.out.println("2. 기관승인신청 내용");
      System.out.println("3. 기관승인신청 변경");
      System.out.println("4. 기관승인신청 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("기관승인관리> ");
      switch (menuNo) {
        case 1: showOrgApproveHandler.list(); break;
        case 2: showOrgApproveHandler.detail(); break;
        case 3: showOrgApproveHandler.update(); break;
        case 4: showOrgApproveHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();

    }

  }
}
