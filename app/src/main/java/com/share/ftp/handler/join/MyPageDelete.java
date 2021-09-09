package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.menu.Menu;
import com.share.util.Prompt;

public class MyPageDelete extends AbstractJoinHandler {


  public MyPageDelete(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  회원 탈퇴  ]");
    System.out.println();

    if (AuthLoginHandler.getLoginUser() == null) {
      System.out.println("로그인 후 이용가능합니다.");
    }

    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByIdPassword(id, password);

    if (joinDTO == null) {
      System.out.println("해당 회원은 존재하지 않습니다.");
      return;
    }


    String input = Prompt.inputString("정말 탈퇴 하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }


    AuthLoginHandler.loginUser = null; // 로그인 끊는다.
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    joinDTOList.remove(joinDTO); // 회원 제거한다.

    System.out.println("");
    System.out.println("[  그동안 행복하share를 이용해주셔서 감사했습니다.  ]");

    return;
  }

  //  private JoinDTO findByPassword(int password) {
  //    for (JoinDTO joinDTO : joinDTOList) {
  //      if (joinDTO.getPassword() == password) {
  //        return joinDTO;
  //      }
  //    }
  //    return null;
  //  }
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




