package com.share.ftp.handler.join;

import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinDetailHandler implements Command {

  JoinDao joinDao;

  public JoinDetailHandler(JoinDao joinDao) {
    this.joinDao = joinDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  회원 상세보기  ]");
    String userId = Prompt.inputString("아이디? "); 
    String userPassword = Prompt.inputString("비밀번호? ");

    JoinDTO loginUser = joinDao.selectOneByUser(userId, userPassword);

    if (loginUser == null) {
      System.out.println("해당 아이디와 비밀번호가 일치하지 않습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", loginUser.getName());

    System.out.printf("▶ 아이디: %s\n",   loginUser.getId());
    System.out.printf("▶ 이름: %s\n",     loginUser.getName());
    System.out.printf("▶ 생년월일: %s\n", loginUser.getBirthdate());
    System.out.printf("▶ 전화: %s\n",     loginUser.getTel());
    System.out.printf("▶ 이메일: %s\n",   loginUser.getEmail());
    System.out.printf("▶ 주소: %s\n",     loginUser.getAddress());

    if (loginUser.getType() == 1) {
      System.out.println("▶ 회원유형: 개인");

    } else if (loginUser.getType() == 2) {
      System.out.println("▶ 회원유형: 기관");

    }
    System.out.printf("▶ 등록일: %s\n", loginUser.getRegisterDate());

  }
}



