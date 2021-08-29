package com.share.ftp.handler.personal;

import com.share.util.Prompt;

public class ChallengeBoardHandler {
  public void join() {
    System.out.println("참여하기");
  }

  public void showMemberList() {
    System.out.println("참여자 정보");
  }

  public void showReview() {
    System.out.println("참여인증&댓글");
    while (true) {
      System.out.println("0. 이전메뉴");
      System.out.println("1. 개인봉사등록");
      System.out.println("2. 기관봉사등록");

      int input = Prompt.inputInt("번호 > ");
      switch (input) {
        case 1: 
        case 2: personalVolRequestHandler.apply(); break;
        case 3: orgVolRequestHandler.apply(); break;
        default : System.out.println("다시 입력해주세요");
      }
      System.out.println();

    }

  }
}

public void showQuestionList() {
  System.out.println("문의하기");
}

}







