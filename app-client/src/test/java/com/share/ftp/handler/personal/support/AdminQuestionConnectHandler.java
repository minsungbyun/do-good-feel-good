package com.share.ftp.handler.personal.support;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminQuestionConnectHandler implements Command {

  public AdminQuestionConnectHandler() {

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();

    int questionNo = (int) request.getAttribute("questionNo");

    request.setAttribute("questionNo", questionNo);

    while (true) {
      System.out.println();
      System.out.println("1: 답글 등록");
      System.out.println("2: 답글 목록");
      System.out.println("3: 답글 상세보기");
      System.out.println("4: 답글 수정");
      System.out.println("5: 답글 삭제");
      System.out.println("6: 답글 검색");
      System.out.println("0: 이전");
      System.out.println();
      int input = Prompt.inputInt("번호 입력 > ");
      switch (input) {
        case 1: request.getRequestDispatcher("/adminQuestion/add").forward(request);
        return;
        case 2: request.getRequestDispatcher("/question/list").forward(request);
        return;
        case 3: request.getRequestDispatcher("/question/detail").forward(request);
        break;
        case 4: request.getRequestDispatcher("/question/update").forward(request);
        break;
        case 5: request.getRequestDispatcher("/question/delete").forward(request);
        break;
        case 6: request.getRequestDispatcher("/question/search").forward(request);
        break;
        case 0:
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}