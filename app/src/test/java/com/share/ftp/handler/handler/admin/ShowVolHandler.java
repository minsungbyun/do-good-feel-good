package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.OrgVolRequestHandler;
import com.share.ftp.handler.personal.PersonalVolRequestHandler;
import com.share.util.Prompt;

public class ShowVolHandler { // 개인, 기관이 신청한 양식 보는 곳

  PersonalVolRequestHandler personalVolRequestHandler;
  OrgVolRequestHandler orgVolRequestHandler;

  public ShowVolHandler(PersonalVolRequestHandler personalVolRequestHandler, OrgVolRequestHandler orgVolRequestHandler) {
    this.personalVolRequestHandler = personalVolRequestHandler;
    this.orgVolRequestHandler = orgVolRequestHandler;
  }



  // 개인, 기관이 양식에 맞추어 봉사신청을 하면 관리자가 승인을 한다.
  public void personalApprove() {
    // 개인 신청 목록
    System.out.println();
    personalVolRequestHandler.applyList();
    System.out.println();
  }

  public void orgApprove() {
    // 기관 신청 목록
    System.out.println();
    orgVolRequestHandler.applyList();
    System.out.println();
  }


  public void accept() {
    // 승인하기
    while (true) {
      System.out.println("[승인유형]");
      System.out.println("1. 개인");
      System.out.println("2. 기관");
      int input = Prompt.inputInt("번호> ");

      if (input == 1) {
        // 개인 봉사 승인
        personalVolRequestHandler.acceptApply();
        break;

      } else if (input == 2) {
        // 기관 봉사 승인
        orgVolRequestHandler.acceptApply();
        break;

      } else {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
        System.out.println();
      }
    }

  }

  public void reject() {
    // 반려하기

    while (true) {
      System.out.println("[반려유형]");
      System.out.println("1. 개인");
      System.out.println("2. 기관");
      int input = Prompt.inputInt("번호> ");

      if (input == 1) {
        // 개인 봉사 반려
        personalVolRequestHandler.rejectApply();
        break;
      } else if (input == 2) {        
        // 기관 봉사 반려
        orgVolRequestHandler.rejectApply();
        break;

      } else {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
        System.out.println();
      }
    }
  }

}
