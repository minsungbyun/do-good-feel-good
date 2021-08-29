package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.util.Prompt;

public class SupportHandler {

  public static final int MAX_LENTGH = 100;
  MyQuestionListDTO[] questionListDTO = new MyQuestionListDTO[MAX_LENTGH];
  int size; 

  QuestionListHandler questionListHandler = new QuestionListHandler();

  public void showNoticeList() {
    System.out.println("공지사항 리스트를 보여준다");
  }

  public void showQuestionList() {
    while (true) {
      System.out.println("0. 이전");
      System.out.println("1. 문의하기 목록");
      System.out.println("2. 문의하기 등록");
      System.out.println("3. 문의하기 상세보기");
      System.out.println("4. 문의하기 수정");
      System.out.println("5. 문의하기 삭제");
      System.out.println("6. 확인");

      int input = Prompt.inputInt("번호 > ");
      switch (input) {
        case 0: return;
        case 1: questionListHandler.QuestionList(); break;
        case 2: questionListHandler.addQuestionlist(); break;
        case 3: questionListHandler.detailQuestion(); break;
        case 4: questionListHandler.updateQuestion(); break;
        case 5: questionListHandler.deleteQuestion(); break;
        default : System.out.println("다시 입력해주세요");
      }
      System.out.println();

    }

  }
}








