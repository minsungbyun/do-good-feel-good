package com.share.ftp.handler.personal.challenge;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class ChallengeQuestionConnectHandler implements Command {


  public ChallengeQuestionConnectHandler() {
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();



    //    while (true) {
    //      System.out.println();
    //      System.out.println("1번 ▶ 문의 등록");
    //      System.out.println("2번 ▶ 문의 목록");
    //      System.out.println("3번 ▶ 문의 상세보기");
    //      System.out.println("0번 ▶ 이전");
    //      int input = Prompt.inputInt("번호 입력 ▶ ");
    //      switch (input) {
    //        case 1: request.getRequestDispatcher("/challengeQuestion/add").forward(request); break;
    //        case 2: request.getRequestDispatcher("/challengeQuestion/list").forward(request); break;
    //        case 3: request.getRequestDispatcher("/challengeQuestion/detail").forward(request); break;
    //        case 0: return;
    //        default:
    //          System.out.println("명령어가 올바르지 않습니다!");
    //      }
    //    }
  }
}