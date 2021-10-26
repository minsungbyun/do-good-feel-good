package com.share.ftp.handler.join;

import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.menu.Menu;
import com.share.util.Prompt;

public class OrgUserDeleteHandler implements Command {

  OrgDao orgDao;

  public OrgUserDeleteHandler(OrgDao orgDao) {
    this.orgDao = orgDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  회원 탈퇴  ]");
    System.out.println();

    if (AuthLoginHandler.getLoginUser() == null) {
      System.out.println("로그인 후 이용가능합니다.");
    }

    String userId = Prompt.inputString("아이디? ");
    String userPassword = Prompt.inputString("비밀번호? ");

    OrgDTO loginUser = orgDao.findByIdPassword(userId, userPassword);

    if (loginUser == null) {
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

    loginUser.setId("탈퇴회원");
    loginUser.setPassword("1004");
    loginUser.setName("탈퇴회원");
    loginUser.setTel("비공개");
    loginUser.setEmail("비공개");
    loginUser.setPostNo(-1);
    loginUser.setBasicAddress("비공개");
    loginUser.setDetailAddress("비공개");
    loginUser.setStatus(0);
    loginUser.setType(0);

    loginUser.setCorpNo("비공개");
    loginUser.setFax("비공개");
    loginUser.setHomepage("비공개");

    orgDao.delete(loginUser);
    //    orgDao.deleteOrg(loginUser);

    System.out.println("");
    System.out.println("[  그동안 행복하share를 이용해주셔서 감사했습니다.  ]");

    return; 
  }
}
