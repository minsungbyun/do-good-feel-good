package com.share.ftp.handler.join;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.menu.Menu;
import com.share.util.Prompt;

public class JoinAddHandler extends AbstractJoinHandler {


  public JoinAddHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);



  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[ 회원 가입 ]");

    JoinDTO joinDTO = new JoinDTO();



    // 아이디 유효성검사
    while (true) {

      joinDTO.setId(Prompt.inputString("아이디? "));


      if (validId(joinDTO.getId())) {
        System.out.println("[  이미 존재하는 아이디입니다. ]");
        System.out.println("[  다시 입력해주세요! ]");
      } else {
        break;
      }
    }

    joinDTO.setPassword(Prompt.inputString("비밀번호? "));

    // 이름 유효성검사
    while (true) {

      joinDTO.setName(Prompt.inputString("이름? "));

      if (validName(joinDTO.getName())) {
        System.out.println("[  이미 존재하는 이름입니다. ]");
        System.out.println("[  다시 입력해주세요! ]");
      } else {
        break;
      }
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
        joinDTO.setPersonal(true);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_PERSONAL | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;
        break;

      } else if (no == 2){
        joinDTO.setOrg(true);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_ORG | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;
        break;

      } else {
        System.out.println("존재하지 않는 유형입니다. 다시입력해주세요");
      }
    }

    // 개인 고유번호 부여
    joinDTO.setNo(getNextNum());

    joinDTOList.add(joinDTO);
    System.out.println();
    System.out.println("회원가입이 정상적으로 완료되었습니다.");
  }


  //  private int getNextNum() {
  //    // 마지막 번호를 알아야한다.
  //    int lastNum = 0;
  //    for (int i = 0; i < joinDTOList.size(); i++) {
  //
  //      if (joinDTOList.size() > 0) {
  //        joinDTOList.get(i).setNo(i + 1);
  //        lastNum = i + 2;
  //      } else {
  //        return 1;
  //      }
  //    }
  //    return lastNum;
  //
  //  }

  private int getNextNum() {
    if (joinDTOList.size() > 0) {
      return joinDTOList.get(joinDTOList.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }


  private boolean validId(String id) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().contains(id)) {
        return true;
      }
    }
    return false;
  }

  private boolean validName(String name) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().contains(name)) {
        return true;
      }
    }
    return false;
  }
}



//  public void joinSite() {
//    System.out.println("가입하기");
//  }
//
//  public void idCheck() {
//    System.out.println("ID중복확인");
//  }
//
//  public void telCheck() {
//    System.out.println("휴대전화인증");
//  }
//
//  public void findAddress() {
//    System.out.println("우편번호검색");
//  }




