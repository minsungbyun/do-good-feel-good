package com.share.ftp.handler.join;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.menu.Menu;
import com.share.util.Prompt;

public class AuthLoginHandler implements Command {

  List<JoinDTO> joinDTOList;

  public static JoinDTO loginUser;

  static int userAccessLevel = Menu.ACCESS_LOGOUT;

  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public static int getUserAccessLevel() {
    return userAccessLevel;
  }

  public AuthLoginHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[로그인]");

    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");
    System.out.println();

    if (id.equals("admin") && password.equals("111")) {
      JoinDTO admin = new JoinDTO();
      admin.setId("admin");
      admin.setName("관리자");
      admin.setEmail("admin@test.com");
      admin.setPassword("111");
      admin.setTel("010-1111-1111");
      admin.setAddress("no");
      admin.setRegisterDate(new Date(System.currentTimeMillis()));
      admin.setAdmin(true);

      loginUser = admin;
      userAccessLevel = Menu.ACCESS_ADMIN | Menu.ACCESS_MEMBER_ADMIN;
      return;
    } 


    JoinDTO joinDTO = findByMember(id, password);


    if (joinDTO == null) {
      System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
      return;
    } else if (joinDTO.isPersonal() == true) {
      userAccessLevel = Menu.ACCESS_MEMBER | Menu.ACCESS_PERSONAL | Menu.ACCESS_MEMBER_ADMIN;

      System.out.printf("[  %s님 환영합니다!  ]\n", joinDTO.getName());

    } else if (joinDTO.isOrg() == true) {
      userAccessLevel = Menu.ACCESS_MEMBER | Menu.ACCESS_ORG | Menu.ACCESS_MEMBER_ADMIN;

      System.out.printf("[  %s님 환영합니다!  ]\n", joinDTO.getName());
    }

    loginUser = joinDTO;

    //      userAccessLevel = Menu.ACCESS_MEMBER;
  }



  private JoinDTO findByMember(String id, String password) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equals(id) && 
          joinDTO.getPassword().equals(password)) {
        return joinDTO;
      }
    }
    return null;
  }

  public static JoinDTO findByName(String name) {

    if (loginUser.getName().equals(name)) { 
      return loginUser;
    }

    return null;
  }
}

