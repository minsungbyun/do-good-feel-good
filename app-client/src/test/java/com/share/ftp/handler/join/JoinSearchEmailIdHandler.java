package com.share.ftp.handler.join;

import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinSearchEmailIdHandler implements Command {

  PersonalDao personalDao;

  public JoinSearchEmailIdHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;
  }

  // 아이디찾기 -> 이메일을 통해 찾는다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[이메일을 입력해주세요.]");
    String userEmail = Prompt.inputString("이메일? ");

    JoinDTO loginUserEmail = personalDao.selectOneByEmail(userEmail);

    if (loginUserEmail  == null) {
      System.out.println("일치하는 이메일이 없습니다.");
      return;

    } else {
      System.out.println();
      System.out.printf("아이디: [ %s ]\n", loginUserEmail.getId());
      return;
    }
  }
}


