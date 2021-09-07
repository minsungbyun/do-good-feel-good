package com.share.ftp.handler.join;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.menu.Menu;
import com.share.util.Prompt;

public class JoinAddHandler extends AbstractJoinHandler {


  public JoinAddHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

    // 로그인 테스드를 위한 데이터

    // 관리자


    //    // 개인회원
    //    JoinDTO testUser = new JoinDTO();
    //    testUser.setId("aaa");
    //    testUser.setName("행복이");
    //    testUser.setEmail("aaa@test.com");
    //    testUser.setPassword("111");
    //    testUser.setTel("010-2222-2222");
    //    testUser.setAddress("no");
    //    testUser.setRegisterDate(new Date(System.currentTimeMillis()));
    //    testUser.setPersonal(true);
    //
    //    joinDTOList.add(testUser);
    //
    //    // 기관회원
    //    testUser = new JoinDTO();
    //    testUser.setId("bbb");
    //    testUser.setName("test2");
    //    testUser.setEmail("bbb");
    //    testUser.setPassword("111");
    //    testUser.setTel("010-3333-3333");
    //    testUser.setAddress("no");
    //    testUser.setRegisterDate(new Date(System.currentTimeMillis()));
    //    testUser.setOrg(true);
    //    //    AuthLoginHandler.loginUser = testUser;
    //    AuthLoginHandler.userAccessLevel = Menu.ACCESS_ORG | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;
    //
    //    joinDTOList.add(testUser);
    //
    //    testUser = new JoinDTO();
    //    testUser.setId("object");
    //    testUser.setName("자바최고조상");
    //    testUser.setEmail("object@java.com");
    //    testUser.setPassword("111");
    //    testUser.setTel("010-4444-4444");
    //    testUser.setAddress("모두의집");
    //    testUser.setRegisterDate(new Date(System.currentTimeMillis()));
    //    testUser.setPersonal(true);
    //    //    AuthLoginHandler.loginUser = testUser;
    //    AuthLoginHandler.userAccessLevel = Menu.ACCESS_PERSONAL | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;

    //    joinDTOList.add(testUser);

  }


  // 회원 가입하기
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[회원 가입]");

    JoinDTO joinDTO = new JoinDTO();

    // 아이디 유효성검사
    while (true) {

      joinDTO.setId(Prompt.inputString("아이디? "));

      Boolean vaildId = validId(joinDTO.getId());
      if (vaildId == true) {
        System.out.println("[  이미 존재하는 아이디입니다. ]");
        System.out.println("[  다시 입력해주세요! ]");
      } else {
        break;
      }
    }



    joinDTO.setPassword(Prompt.inputString("비밀번호? "));
    joinDTO.setName(Prompt.inputString("이름? "));
    joinDTO.setTel(Prompt.inputString("전화? "));
    joinDTO.setEmail(Prompt.inputString("이메일? "));
    joinDTO.setAddress(Prompt.inputString("주소? "));
    joinDTO.setRegisterDate(new Date(System.currentTimeMillis()));
    System.out.println();

    while (true) {
      System.out.println("[회원 유형을 선택해주세요]");
      System.out.println();
      System.out.println("1. 개인");
      System.out.println("2. 기관");
      int no = Prompt.inputInt("번호> ");

      if (no == 1) {
        joinDTO.setPersonal(true);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_PERSONAL | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;
        break;

      } else if (no == 2){
        joinDTO.setOrg(true);
        AuthLoginHandler.userAccessLevel = Menu.ACCESS_ORG | Menu.ACCESS_LOGOUT | Menu.ACCESS_MEMBER_ADMIN;
        break;

      } else {
        System.out.println("잘못된 유형입니다. 다시입력해주세요");
        continue;
      }
    }

    joinDTOList.add(joinDTO);

    System.out.println("회원가입이 정상적으로 완료되었습니다.");
  }



  private boolean validId(String id) {

    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().contains(id)) {

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




