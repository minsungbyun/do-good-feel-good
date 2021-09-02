package com.share.ftp.handler.personal.support;

import com.share.util.Prompt;

public class SupportHandler {

  QuestionListHandler questionListHandler;
  NoticeListHandler noticeListHandler;

  public SupportHandler(QuestionListHandler questionListHandler, NoticeListHandler noticeListHandler) {
    this.questionListHandler = questionListHandler;
    this.noticeListHandler = noticeListHandler;
  }

  public void showNoticeList() {
    while (true) {
      System.out.println();
      System.out.println("[/ 고객센터/공지사항]");
      System.out.println("1. 공지사항 목록");
      System.out.println("2. 공지사항 상세보기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("메뉴> ");
      switch (menuNo) {
        case 1:noticeListHandler.noticeList(); break;
        case 2:noticeListHandler.noticeDetail(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  public void showQuestionList() {
    while (true) {
      System.out.println();
      System.out.println("[/ 고객센터/문의하기]");
      System.out.println("1. 문의하기 목록");
      System.out.println("2. 문의하기 등록");
      System.out.println("3. 문의하기 상세보기");
      System.out.println("4. 문의하기 수정");
      System.out.println("5. 문의하기 삭제");
      System.out.println("6. 확인");
      System.out.println("0. 이전메뉴");

      int input = Prompt.inputInt("번호 > ");
      switch (input) {
        case 1: questionListHandler.questionList(); break;
        case 2: questionListHandler.addQuestionlist(); break;
        case 3: questionListHandler.detailQuestion(); break;
        case 4: questionListHandler.updateQuestion(); break;
        case 5: questionListHandler.deleteQuestion(); break;
        case 0: return;
        default : System.out.println("다시 입력해주세요");
      }
      System.out.println();

    }

  }
}








