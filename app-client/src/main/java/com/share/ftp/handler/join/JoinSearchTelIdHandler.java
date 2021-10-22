package com.share.ftp.handler.join;

import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinSearchTelIdHandler implements Command {

  PersonalDao personalDao;

  public JoinSearchTelIdHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;
  }

  // 아이디찾기 -> 휴대폰 번호를 통해 찾는다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();

    System.out.println("[휴대폰 번호를 입력해주세요.]");
    String userTel = Prompt.inputString("휴대폰 번호? ");

    JoinDTO loginUserTel = personalDao.selectOneByTel(userTel);

    if (loginUserTel == null) {
      System.out.println("일치하는 휴대폰 번호가 없습니다.");
      return;
    }  else {
      System.out.println();
      System.out.printf("아이디: [ %s ]\n", loginUserTel.getId());
      return;
    }
  }
}


