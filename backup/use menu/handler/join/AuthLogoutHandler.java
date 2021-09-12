package com.share.ftp.handler.join;

import com.share.ftp.handler.Command;

public class AuthLogoutHandler implements Command {

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }
}

