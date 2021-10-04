package com.share.ftp.handler.join;

import java.sql.Date;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.menu.Menu;
import com.share.request.RequestAgent;
import com.share.util.General;
import com.share.util.Prompt;

public class JoinAddHandler implements Command {

  JoinDao joinDao;

  public JoinAddHandler(JoinDao joinDao) {
    this.joinDao = joinDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 회원 가입 ]");

    JoinDTO joinDTO = new JoinDTO();
    System.out.println(joinDTO);

    // 아이디 유효성검사
    while (true) {
      System.out.println(joinDTO);

      joinDTO.setId(Prompt.inputString("아이디? "));
      System.out.println("1번");

      JoinDTO user = joinDao.validId(joinDTO);
      System.out.println("아이디 = "+user);
      System.out.println("2번");

      if (user == joinDTO) {
        joinDTO.setId(user.getId());
        System.out.println("해당 아이디는 사용이 가능합니다!");
        break;
      } else {
        System.out.println("이미 존재하는 아이디입니다!");
      }
      System.out.println("3번");
    }

    joinDTO.setPassword(Prompt.inputString("비밀번호? "));

    // 이름 유효성검사
    while (true) {
      joinDTO.setName(Prompt.inputString("이름? "));

      if (!(joinDTO.getName().length() == 0)) {
        break;
      }
      System.out.println("이름을 다시 입력해주세요!");
    }

    joinDTO.setBirthdate(Prompt.inputDate("생년월일? "));
    joinDTO.setTel(Prompt.inputString("전화? "));

    while (true) {
      joinDTO.setEmail(Prompt.inputString("이메일? "));
      if (!(joinDTO.getEmail().contains("@") && 
          joinDTO.getEmail().contains("."))) {
        System.out.println("이메일 양식에 맞추어 작성바랍니다. ex) aaa@test.com");
        System.out.println();
        continue;
      }

      System.out.println();
      System.out.println("[  해당 이메일로 인증번호가 전송되었습니다. ]");
      System.out.println();

      int authNum = Prompt.inputInt("인증번호 입력 > ");

      if (authNum == 1004) {
        System.out.println("[  인증이 정상적으로 완료되었습니다!  ]");
        System.out.println();
        break;
      } else {
        System.out.println("잘못 입력하셨습니다.");
      }
    }

    joinDTO.setAddress(Prompt.inputString("주소? "));
    joinDTO.setRegisterDate(new Date(System.currentTimeMillis()));
    System.out.println();

    while (true) {
      System.out.println("[회원 유형을 선택해주세요]");
      System.out.println();
      System.out.println("1. 개인");
      System.out.println("2. 기관");
      int no = Prompt.inputInt("회원유형 선택 > ");

      if (no == 1) {
        joinDTO.setType(General.member.PERSONAL);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_PERSONAL | Menu.ACCESS_LOGOUT;
        break;

      } else if (no == 2){
        joinDTO.setType(General.member.ORG);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_ORG | Menu.ACCESS_LOGOUT;
        break;

      } else {
        System.out.println("존재하지 않는 유형입니다. 다시입력해주세요");
      }
    }

    // 고유회원번호 부여
    joinDTO.setNo(joinDao.getNextNum());

    joinDao.insert(joinDTO);

    System.out.println();
  }

}
