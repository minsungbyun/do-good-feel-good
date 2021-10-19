package com.share.ftp.handler.join;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_GROUP;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import static com.share.util.General.member.GROUP;
import static com.share.util.General.member.ORG;
import static com.share.util.General.member.PERSONAL;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AuthLoginHandler implements Command {

  JoinDao joinDao;

  public AuthLoginHandler(JoinDao joinDao) {
    this.joinDao = joinDao;
  }

  public static JoinDTO loginUser;

  public static int userAccessLevel = ACCESS_LOGOUT;

  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public static int getUserAccessLevel() {
    return userAccessLevel;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ Happy-Share Login Page]");

    String userId = Prompt.inputString("Id : ");
    String userPassword = Prompt.inputString("Password : ");
    System.out.println();

    if (userId.equals("admin") && userPassword.equals("111")) {
      OrgDTO admin = new OrgDTO();
      admin.setId("admin");
      admin.setName("관리자");
      admin.setEmail("admin@test.com");
      admin.setPassword("111");
      admin.setTel("010-1111-1111");

      loginUser = admin;
      userAccessLevel = ACCESS_ADMIN | ACCESS_MEMBER_ADMIN;
      return;
    } 

    JoinDTO user = joinDao.selectOneByIdPassword(userId, userPassword);

    if (user == null) {
      System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
      return;

    } else if (user.getType() == PERSONAL) {
      userAccessLevel = ACCESS_MEMBER | ACCESS_PERSONAL | ACCESS_MEMBER_ADMIN;

      System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());

    } else if (user.getType() == ORG) {
      userAccessLevel = ACCESS_MEMBER | ACCESS_ORG | ACCESS_MEMBER_ADMIN;

      System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());

    } else if (user.getType() == GROUP) {
      userAccessLevel = ACCESS_MEMBER | ACCESS_GROUP | ACCESS_MEMBER_ADMIN;

      System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());
    } 

    loginUser = user;
  } 
}

