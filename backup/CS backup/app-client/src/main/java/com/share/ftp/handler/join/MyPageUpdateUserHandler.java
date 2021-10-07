package com.share.ftp.handler.join;

import java.sql.Date;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class MyPageUpdateUserHandler implements Command {

  JoinDao joinDao;

  public MyPageUpdateUserHandler(JoinDao joinDao) {
    this.joinDao = joinDao;

  }

  // 마이페이지 나의 정보 수정 -> 비밀번호 입력시 변경가능
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[회원 변경]");
    String userPassword = Prompt.inputString("비밀번호? ");

    JoinDTO loginUser = joinDao.selectOneByIdPassword(AuthLoginHandler.getLoginUser().getId(), userPassword);

    if (loginUser == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    Date birthdate = Prompt.inputDate("생년월일(" + loginUser.getBirthdate()  + ")? ");
    String tel = Prompt.inputString("전화(" + loginUser.getTel() + ")? ");
    String email = Prompt.inputString("이메일(" + loginUser.getEmail() + ")? ");
    String adress = Prompt.inputString("주소(" + loginUser.getAddress() + ")? ");
    String passwords = Prompt.inputString("암호? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    loginUser.setBirthdate(birthdate);
    loginUser.setTel(tel);
    loginUser.setEmail(email);
    loginUser.setAddress(adress);
    loginUser.setPassword(passwords);

    System.out.println("회원정보를 변경하였습니다.");
  }
}



