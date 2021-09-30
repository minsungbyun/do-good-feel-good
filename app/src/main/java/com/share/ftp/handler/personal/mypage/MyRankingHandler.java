package com.share.ftp.handler.personal.mypage;

import static com.share.util.Prompt.printMyRank;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class MyRankingHandler implements Command {

  List<JoinDTO> joinDTOList;

  public MyRankingHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println(); 
    System.out.println("나의 랭킹 보기");
    System.out.println(); 

    System.out.println("    __  ___         ____              __   _            \r\n"
        + "   /  |/  /_  __   / __ \\____ _____  / /__(_)___  ____ _\r\n"
        + "  / /|_/ / / / /  / /_/ / __ `/ __ \\/ //_/ / __ \\/ __ `/\r\n"
        + " / /  / / /_/ /  / _, _/ /_/ / / / / ,< / / / / / /_/ / \r\n"
        + "/_/  /_/\\__, /  /_/ |_|\\__,_/_/ /_/_/|_/_/_/ /_/\\__, /  \r\n"
        + "       /____/                                  /____/   ");
    System.out.println();

    System.out.printf("▶ 축하합니다! 당신의 랭킹은 %d등입니다. ",printMyRank(joinDTOList)); 
    System.out.println();

  }

}
