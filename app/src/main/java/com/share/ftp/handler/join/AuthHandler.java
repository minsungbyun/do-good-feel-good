package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class AuthHandler {

  List<JoinDTO> joinDTOList;

  public static JoinDTO loginUser;
  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public AuthHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

<<<<<<< HEAD
=======
  public void login() {
    System.out.println();
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

  public void logout() {
    System.out.println();
    System.out.println("[로그아웃]");

    loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }

>>>>>>> 0c52c57f94bd015022730358b2a6c00fe52e1da8
  // 마이페이지의 나의정보보기
  public void displayUserInfo() {

    JoinDTO loginUser = AuthHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", loginUser.getName());

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("주소: %s\n", loginUser.getAdress());
    System.out.printf("등록일: %s\n", loginUser.getRegisterDate());
  }

  // 마이페이지의 나의정보수정
  public void changeUserInfo() {
    System.out.println();
    System.out.println("[회원 변경]");

    JoinDTO loginUser = AuthHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + loginUser.getName()  + ")? ");
    String tel = Prompt.inputString("전화(" + loginUser.getTel() + ")? ");
    String email = Prompt.inputString("이메일(" + loginUser.getEmail() + ")? ");
    String adress = Prompt.inputString("주소(" + loginUser.getAdress() + ")? ");
    String passwords = Prompt.inputString("암호? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    loginUser.setName(name);
    loginUser.setTel(tel);
    loginUser.setEmail(email);
    loginUser.setAdress(adress);
    loginUser.setPassword(passwords);

    System.out.println("회원정보가 수정되었습니다.");
  }

}

