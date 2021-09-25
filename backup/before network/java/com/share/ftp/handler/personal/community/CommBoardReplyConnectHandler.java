package com.share.ftp.handler.personal.community;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardReplyConnectHandler implements Command {


  public CommBoardReplyConnectHandler() {
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();



    while (true) {
      System.out.println();
      System.out.println("1. 댓글 등록");
      System.out.println("2. 댓글 목록");
      System.out.println("0번: 이전");
      int input = Prompt.inputInt("번호 입력 > ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeReview/add").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeReview/list").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}