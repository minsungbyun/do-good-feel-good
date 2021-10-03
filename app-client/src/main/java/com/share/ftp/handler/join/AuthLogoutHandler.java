package com.share.ftp.handler.join;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.menu.Menu;

public class AuthLogoutHandler implements Command {

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    //    System.out.println("[ 로그아웃 ]");

    AuthLoginHandler.loginUser = null;
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    System.out.println("[  로그아웃 하였습니다! ]");
  }
}

