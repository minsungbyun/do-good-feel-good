package com.share.ftp.handler.personal;

import com.share.util.Prompt;

public class MyPageHandler {

  MyVolHandler myVolHandler;

  public MyPageHandler(MyVolHandler myVolHandler) {
    this.myVolHandler = myVolHandler;
  }

  MyBoardListHandler myBoardListHandler = new MyBoardListHandler();
  MyPointHandler myPointHandler = new MyPointHandler();
  MyDonationHandler myDonationHandler = new MyDonationHandler();
  ApproveOrgHandler approveOrgHandler = new ApproveOrgHandler();
  WithdrawMemberHandler withdrawMemberHandler = new WithdrawMemberHandler();

  public void myProfile() {

    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 회원정보수정]");
      System.out.println("1. 회원정보 수정");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1:myProfileHandler.updateMyProfile(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }


  public void myVolunteer() {
    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 나의봉사]");
      System.out.println("1. 신청내역");
      System.out.println("2. 활동승인");
      System.out.println("3. 찜한봉사");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1:myVolHandler.showVolApplyList(); break;
        case 2:myVolHandler.showApproveList(); break;
        case 3:myVolHandler.showVolBookmark(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void myBoardList() {
    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 나의작성글]");
      System.out.println("1. 함께해요");
      System.out.println("2. 나눔이야기");
      System.out.println("3. 문의내역");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1:myBoardListHandler.showVolBoardList(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void myPoint() {
    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 나의포인트]");
      System.out.println("1. 나의포인트확인");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: myPointHandler.showMyPointList(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }


  public void myDonation() {
    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 나의모금함]");
      System.out.println("1. 나의기부내역");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: myDonationHandler.showMyTotalDonation(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void approveOrganization() {
    while (true) {
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 기관승인신청]");
      System.out.println("1. 기관인증신청");
      System.out.println("1. 기관인증신청내역");
      System.out.println("1. 기관인증신청상세보기");
      System.out.println("1. 기관인증신청내역 변경");
      System.out.println("1. 기관인증신청내역 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: approveOrgHandler.add(); break;
        case 2: approveOrgHandler.list(); break;
        case 3: approveOrgHandler.detail(); break;
        case 4: approveOrgHandler.update(); break;
        case 5: approveOrgHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void withdrawMember() {
    while (true) {
      System.out.println();
      System.out.println();
      System.out.println("[메인/ 마이페이지 / 회원탈퇴]");
      System.out.println("1. 탈퇴하기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1: withdrawMemberHandler.withdraw(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }

  }

}
