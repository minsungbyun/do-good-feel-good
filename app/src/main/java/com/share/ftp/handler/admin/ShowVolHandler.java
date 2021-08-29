package com.share.ftp.handler.admin;

import com.share.ftp.handler.personal.PersonalVolRequestHandler;

public class ShowVolHandler { // 개인, 기관이 신청한 양식 보는 곳

  PersonalVolRequestHandler personalVolRequestHandler;

  public ShowVolHandler(PersonalVolRequestHandler personalVolRequestHandler) {
    this.personalVolRequestHandler = personalVolRequestHandler;
  }



  // 개인, 기관이 양식에 맞추어 봉사신청을 하면 관리자가 승인을 한다.
  public void personalApprove() {

    System.out.println("개인 신청 목록");
    personalVolRequestHandler.applyList();


  }

  public void orgApprove() {

    System.out.println("기관 신청 목록");
    personalVolRequestHandler.applyList();


  }


  public void accept() {
    System.out.println("승인하기");
  }

  public void reject() {
    System.out.println("반려하기");
  }

}
