package com.share.ftp.handler.join;

import static com.share.ftp.handler.join.AuthLoginHandler.userAccessLevel;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import static com.share.util.General.member.ORG;
import static com.share.util.General.member.PERSONAL;
import java.sql.Date;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinAddHandler implements Command {

  JoinDao joinDao;

  public JoinAddHandler(JoinDao joinDao) {
    this.joinDao = joinDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ happy-share 회원 가입 ]");
    System.out.println();

    JoinDTO joinUser = new JoinDTO();

    //    아이디 유효성검사
    while (true) {

      joinUser.setId(Prompt.inputString("ID ▶ "));

      JoinDTO userId = joinDao.validId(joinUser);

      if (userId != null) {
        System.out.println("사용가능한 아이디입니다.");
        break;
      }

      System.out.println("해당 아이디는 중복되는 아이디입니다.");
    }

    joinUser.setPassword(Prompt.inputString("Password ▶ "));

    while (true) {
      joinUser.setName(Prompt.inputString("Name ▶ "));

      if (!(joinUser.getName().length() == 0)) {
        break;
      }
      System.out.println("이름을 다시 입력해주세요!");
    }

    joinUser.setBirthdate(Prompt.inputDate("Birthdate ▶ "));
    joinUser.setTel(Prompt.inputString("Tel ▶ "));

    while (true) {
      joinUser.setEmail(Prompt.inputString("Email ▶ "));
      if (!(joinUser.getEmail().contains("@") && 
          joinUser.getEmail().contains("."))) {
        System.out.println("이메일 양식에 맞추어 작성바랍니다. ex) aaa@test.com");
        System.out.println();
        continue;
      }

      System.out.println();
      System.out.println("[  해당 이메일로 인증번호가 전송되었습니다. ]");
      System.out.println();

      int authNum = Prompt.inputInt("인증번호 입력 ▶ ");

      if (authNum == 1004) {
        System.out.println("[  인증이 정상적으로 완료되었습니다!  ]");
        System.out.println();
        break;
      } else {
        System.out.println("잘못 입력하셨습니다.");
      }
    }

    joinUser.setAddress(Prompt.inputString("Address ▶ "));
    joinUser.setRegisterDate(new Date(System.currentTimeMillis()));
    System.out.println();

    while (true) {
      System.out.println("[회원 유형을 선택해주세요]");
      System.out.println();
      System.out.println("1번 ▶ Personal");
      System.out.println("2번 ▶ Organization");
      int userType = Prompt.inputInt("회원유형 선택 ▶ ");

      if (userType == 1) {
        joinUser.setType(PERSONAL);
        userAccessLevel = ACCESS_PERSONAL | ACCESS_LOGOUT;
        break;

      } else if (userType == 2){
        joinUser.setType(ORG);
        userAccessLevel = ACCESS_ORG | ACCESS_LOGOUT;
        break;

      } else {
        System.out.println("존재하지 않는 유형입니다. 다시입력해주세요");
      }
    }

    // 고유회원번호 부여
    joinUser.setNo(joinDao.getNextNum());

    joinDao.insert(joinUser);

    System.out.println();
  }

}
