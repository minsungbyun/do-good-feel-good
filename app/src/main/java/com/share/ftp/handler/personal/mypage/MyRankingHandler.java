package com.share.ftp.handler.personal.mypage;

import static com.share.util.Prompt.getUserLevel;
import static com.share.util.Prompt.getUserPoint;
import static com.share.util.Prompt.getUserRemainPoint;
import static com.share.util.Prompt.printMyRank;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyRankingHandler implements Command {

  List<JoinDTO> joinDTOList;

  public MyRankingHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

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

    System.out.printf("▶ 축하합니다! 당신의 랭킹은 %d등입니다.\n ",printMyRank(joinDTOList)); 
    System.out.println();
    System.out.printf("▶ 당신의 현재 등급은 %s입니다. \n", getUserLevel(loginUser)); 
    System.out.println();
    System.out.printf("▶ 당신의 현재 포인트는 %d점 입니다. \n", getUserPoint(loginUser));
    System.out.println();
    System.out.printf("▶ 다음 등급까지 %d point 남았습니다. ", getUserRemainPoint(loginUser)); 
    System.out.println();

  }

}
