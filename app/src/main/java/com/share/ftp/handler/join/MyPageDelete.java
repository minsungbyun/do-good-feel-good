package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class MyPageDelete extends AbstractJoinHandler{

  public MyPageDelete(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[회원 탈퇴]");
    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 탈퇴 하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }

    joinDTO = null;
    //    joinDTOList.remove(joinDTO);

    System.out.println("회원을 탈퇴하였습니다.");
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




