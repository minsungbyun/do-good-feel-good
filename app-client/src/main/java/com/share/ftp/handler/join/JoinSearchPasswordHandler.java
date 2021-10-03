package com.share.ftp.handler.join;

import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinSearchPasswordHandler implements Command {

  JoinDao joinDao;

  public JoinSearchPasswordHandler(JoinDao joinDao) {
    this.joinDao = joinDao;

  }
  // 비밀번호 찾기 (아이디,이메일)
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[아이디를 입력해주세요.]");

    String userId = Prompt.inputString("아이디? ");
    System.out.println();

    System.out.println("[이메일을 입력해주세요.]");

    String userEmail = Prompt.inputString("이메일? ");

    JoinDTO loginUser = joinDao.selectOneByIdEmail(userId, userEmail);

    if (loginUser == null) {
      System.out.println("해당 아이디를 찾을 수 없습니다.");
      return;
    }
    System.out.println();
    System.out.printf("비밀번호: [ %s ]\n", loginUser.getPassword());
  }
}



