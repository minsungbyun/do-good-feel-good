package com.share.ftp.handler.join;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinAddHandler implements Command {

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ happy-share 회원 가입 ]");
    System.out.println();

    while (true) {
      System.out.println("1번 ▶ 개인회원");
      System.out.println("2번 ▶ 단체회원");
      System.out.println("3번 ▶ 기관회원");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("회원 유형을 선택해주세요 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/join/personal").forward(request); return;
        case 2: request.getRequestDispatcher("/join/group").forward(request); return;
        case 3: request.getRequestDispatcher("/join/org").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}

