package com.share.ftp.handler.personal;

import com.share.util.Prompt;

public class VolListHandler {

  // 봉사등록
  PersonalVolRequestHandler personalVolReqestHandler;
  public VolListHandler(PersonalVolRequestHandler personalVolReqestHandler) {
    this.personalVolReqestHandler = personalVolReqestHandler;
  }

  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();

  // 봉사리스트
  VolApprovedHandler volApprovedHandler = new VolApprovedHandler();

  // 봉사참여
  VolJoinHandler volJoinHandler = new VolJoinHandler();   

  public void volAuthForm() {

    System.out.println("[메인/함께해요/봉사신청]");
    System.out.println("1. 개인봉사신청");
    System.out.println("2. 기관봉사신청");
    System.out.println("3. 개인봉사내역보기(테스트)");
    System.out.println("0. 이전메뉴");

    int input = Prompt.inputInt("봉사신청> ");
    System.out.println();

    switch (input) {
      case 1: personalVolReqestHandler.apply(); break;
      case 2: orgVolRequestHandler.apply(); break;
      case 3: personalVolReqestHandler.applyList(); break;
      case 0: return;
      default: System.out.println("다시 입력해주세요");
    }
    System.out.println();

  }

  public void volApprovedList() {

    System.out.println("[메인/함께해요/봉사목록]");
    System.out.println("1. 봉사목록 보기");
    System.out.println("2. 봉사세부사항 보기");
    System.out.println("3. 관리자test");
    System.out.println("0. 이전메뉴");

    int input = Prompt.inputInt("봉사목록> ");

    switch (input) {
      case 1: volApprovedHandler.approvedList(); break;
      case 2: volApprovedHandler.approvedDetail(); break;
      case 0: return;
      default: System.out.println("다시 입력해주세요");
    }
    System.out.println();
  }

  public void volJoin() {

    System.out.println("[메인/함께해요/봉사참여]");
    System.out.println("1. 봉사참여");
    System.out.println("2. 봉사참여내역");
    System.out.println("3. 봉사참여자목록");
    System.out.println("0. 이전메뉴");

    int input = Prompt.inputInt("봉사참여> ");

    switch (input) {
      case 1: volJoinHandler.join(); break;
      case 2: volJoinHandler.joinList(); break;
      case 3: volJoinHandler.joinMemberList(); break;
      case 0: return;
      default: System.out.println("다시 입력해주세요");
    }
    System.out.println();
  }
}

