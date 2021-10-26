package com.share.ftp.handler.join;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class AuthDisplayUserHandler implements Command {


  // 마이페이지의 나의정보보기
  @Override
  public void execute(CommandRequest request) throws Exception {

    int userType = AuthLoginHandler.getLoginUser().getType();

    int input = userType;
    switch (input) {
      case 1: request.getRequestDispatcher("/userInfo/personal").forward(request); break;
      case 2: request.getRequestDispatcher("/userInfo/group").forward(request); break;
      case 3: request.getRequestDispatcher("/userInfo/org").forward(request); break;
      case 0: return;
      default:
        System.out.println("명령어가 올바르지 않습니다!");
    }
  }
}

