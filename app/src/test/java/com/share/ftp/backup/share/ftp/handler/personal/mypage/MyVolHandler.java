package com.share.ftp.handler.personal.mypage;

import com.share.ftp.handler.personal.volunteer.PersonalVolRequestHandler;

public class MyVolHandler {

  PersonalVolRequestHandler personalVolRequestHandler;
  
  public MyVolHandler(PersonalVolRequestHandler personalVolRequestHandler) {
    this.personalVolRequestHandler = personalVolRequestHandler;
  }


  public void showVolApplyList() {
    //승인 봉사 목록
    personalVolRequestHandler.appliedList();

  }
  public void showApproveList() {
    System.out.println("활동승인내역");
  }
  public void showVolBookmark() {
    System.out.println("찜한봉사");
  }

}
