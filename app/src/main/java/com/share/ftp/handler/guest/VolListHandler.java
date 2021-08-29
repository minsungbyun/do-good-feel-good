package com.share.ftp.handler.guest;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.personal.OrgVolRequestHandler;
import com.share.ftp.handler.personal.PersonalVolRequestHandler;
import com.share.util.Prompt;

public class VolListHandler {

  public static final int MAX_LENTGH = 100;
  VolListDTO[] volListsDTO = new VolListDTO[MAX_LENTGH];
  int size;    

  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler();
  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler();

  public void approveList() {
    System.out.println("관리자의 승인을 받은 리스트를 보여준다.");


  }

  public void detail() {
    System.out.println("관리자의 승인을 받은 리스트 중 세부사항을 보여준다.");


  }

  public void join() {

    while (true) {
      System.out.println("0. 이전메뉴");
      System.out.println("1. 개인봉사등록");
      System.out.println("2. 기관봉사등록");

      int input = Prompt.inputInt("번호 > ");
      switch (input) {
        case 0: 
        case 1: personalVolRequestHandler.apply(); break;
        case 2: orgVolRequestHandler.apply(); break;
        default : System.out.println("다시 입력해주세요");
      }
      System.out.println();

    }

  }

}
