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
import static com.share.util.General.status.REJECT;
import static com.share.util.General.status.WAIT;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AuthLoginHandler implements Command {

  PersonalDao personalDao;
  GroupDao groupDao;
  OrgDao orgDao;
  JoinDao joinDao;

  public AuthLoginHandler(
      PersonalDao personalDao,
      GroupDao groupDao,
      OrgDao orgDao,
      JoinDao joinDao) {
    this.personalDao = personalDao;
    this.joinDao = joinDao;
    this.groupDao = groupDao;
    this.orgDao = orgDao;
  }

  public AuthLoginHandler() {
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

    String userId = Prompt.inputString("Id ▶ ");
    String userPassword = Prompt.inputString("Password ▶ ");
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

    JoinDTO loginUser = joinDao.findByType(userId);
    try {
      if (loginUser.getType() == PERSONAL) {
        loginPersonal(userId, userPassword);

      } else if (loginUser.getType() == GROUP) {
        loginGroup(userId, userPassword);

      } else if (loginUser.getType() == ORG) {
        loginOrg(userId, userPassword);

      }

    } catch(Exception e) {
      System.out.println("아이디와 비밀번호가 일치하지 않습니다!");
    }
  } 

  private void loginPersonal(String userId, String userPassword) throws Exception {
    PersonalDTO user = personalDao.findByIdPassword(userId, userPassword);

    if (user == null) {
      System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
      return;
    }
    userAccessLevel = ACCESS_MEMBER | ACCESS_PERSONAL | ACCESS_MEMBER_ADMIN;

    System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());
    loginUser = user;
  }

  private void loginGroup(String userId, String userPassword) throws Exception {
    GroupDTO user = groupDao.findByIdPassword(userId, userPassword);
    if(user.getStatus() == REJECT) {
      System.out.println("사유 ▶ "+user.getNote());
      System.out.println("▶ 재작성을 원할 시 단체양식 수정을 선택해주세요");

      System.out.println();
      System.out.println("관리자의 승인 후 로그인이 가능합니다!");
      return;

    } else if (user.getStatus() == WAIT) {
      System.out.println("관리자의 승인 후 로그인이 가능합니다!");
      return;

    } 

    userAccessLevel = ACCESS_MEMBER | ACCESS_GROUP | ACCESS_MEMBER_ADMIN;

    System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());
    loginUser = user;
  }

  private void loginOrg(String userId, String userPassword) throws Exception {
    OrgDTO user = orgDao.findByIdPassword(userId, userPassword);

    if(user.getStatus() == REJECT) {
      System.out.println("사유 ▶ " +user.getNote());
      System.out.println("▶ 재작성을 원할 시 기관양식 수정을 선택해주세요");
      System.out.println();
      System.out.println("관리자의 승인 후 로그인이 가능합니다!");
      return;

    } else if (user.getStatus() == WAIT) {
      System.out.println("관리자의 승인 후 로그인이 가능합니다!");
      return;

    } 

    userAccessLevel = ACCESS_MEMBER | ACCESS_ORG | ACCESS_MEMBER_ADMIN;

    System.out.printf("[  %s님 환영합니다!  ]\n", user.getName());
    loginUser = user;
  }

}