package com.share.ftp.handler.personal.mypage;

import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyPointListHandler implements Command {

  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 포인트 정보입니다 ]\n", loginUser.getName());

    System.out.println("                               _       _   \r\n"
        + " _ __ ___  _   _   _ __   ___ (_)_ __ | |_ \r\n"
        + "| '_ ` _ \\| | | | | '_ \\ / _ \\| | '_ \\| __|\r\n"
        + "| | | | | | |_| | | |_) | (_) | | | | | |_ \r\n"
        + "|_| |_| |_|\\__, | | .__/ \\___/|_|_| |_|\\__|\r\n"
        + "           |___/  |_|                     ");

    System.out.println();
    System.out.printf("[  당신의 현재 포인트는 %d점 입니다. ]\n", loginUser.getPoint());
    System.out.println( "[  축하합니다! 당신의 랭킹은 1등입니다. ]"); // 구현예정
    System.out.println( "[  다음 등급까지 1000point 남았습니다. ]"); // 구현예정
  }
}







