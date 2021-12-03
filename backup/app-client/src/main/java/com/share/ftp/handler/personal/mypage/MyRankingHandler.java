package com.share.ftp.handler.personal.mypage;

import java.util.List;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.MemberHelper;

public class MyRankingHandler implements Command {

  PersonalDao personalDao;

  public MyRankingHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    List<PersonalDTO> joinList = personalDao.findAllPersonal();

    PersonalDTO loginUser = (PersonalDTO) AuthLoginHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 랭킹 정보입니다 ]\n", loginUser.getName());
    System.out.println();

    System.out.println("    __  ___         ____              __   _            \r\n"
        + "   /  |/  /_  __   / __ \\____ _____  / /__(_)___  ____ _\r\n"
        + "  / /|_/ / / / /  / /_/ / __ `/ __ \\/ //_/ / __ \\/ __ `/\r\n"
        + " / /  / / /_/ /  / _, _/ /_/ / / / / ,< / / / / / /_/ / \r\n"
        + "/_/  /_/\\__, /  /_/ |_|\\__,_/_/ /_/_/|_/_/_/ /_/\\__, /  \r\n"
        + "       /____/                                  /____/   ");
    System.out.println();

    System.out.printf("▶ 축하합니다! 당신의 랭킹은 %d등입니다.\n ",MemberHelper.printMyRank(joinList)); 
    System.out.println();
    System.out.printf("▶ 당신의 현재 등급은 %s입니다. \n", MemberHelper.getUserLevel(loginUser)); 
    System.out.println();
    System.out.printf("▶ 당신의 현재 포인트는 %d점 입니다. \n", MemberHelper.getUserPoint(loginUser));
    System.out.println();
    System.out.printf("▶ 다음 등급까지 %d point 남았습니다. ", MemberHelper.getUserRemainPoint(loginUser)); 
    System.out.println();

  }

}
