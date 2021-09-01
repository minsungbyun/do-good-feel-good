package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class AuthHandler {

  List<JoinDTO> joinDTOList;

  static JoinDTO loginUser;
  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public AuthHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

  public void login() {
    System.out.println("[로그인]");

    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else {
      System.out.printf("%s님 환영합니다!\n", joinDTO.getName());
      loginUser = joinDTO;
    }
  }

  public void displayLoginUser() {
    System.out.println("[내정보]");

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("주소: %s\n", loginUser.getAdress());
    System.out.printf("등록일: %s\n", loginUser.getRegisterDate());
  }

  public void logout() {
    System.out.println("[로그아웃]");

    loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }

  private JoinDTO findByMember(String id, String password) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equalsIgnoreCase(id) && 
          joinDTO.getPassword().equalsIgnoreCase(password)) {
        return joinDTO;
      }
    }
    return null;
  }
}

