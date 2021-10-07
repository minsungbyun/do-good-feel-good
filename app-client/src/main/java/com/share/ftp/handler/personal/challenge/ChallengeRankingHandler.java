package com.share.ftp.handler.personal.challenge;

import java.util.Collection;
import java.util.List;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.MemberHelper;

public class ChallengeRankingHandler implements Command {

  JoinDao joinDao;

  public ChallengeRankingHandler(JoinDao joinDao) {
    this.joinDao = joinDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println();

    System.out.println("ooooooooo.                         oooo         o8o                         \r\n"
        + "`888   `Y88.                       `888         `\"'                         \r\n"
        + " 888   .d88'  .oooo.   ooo. .oo.    888  oooo  oooo  ooo. .oo.    .oooooooo \r\n"
        + " 888ooo88P'  `P  )88b  `888P\"Y88b   888 .8P'   `888  `888P\"Y88b  888' `88b  \r\n"
        + " 888`88b.     .oP\"888   888   888   888888.     888   888   888  888   888  \r\n"
        + " 888  `88b.  d8(  888   888   888   888 `88b.   888   888   888  `88bod8P'  \r\n"
        + "o888o  o888o `Y888\"\"8o o888o o888o o888o o888o o888o o888o o888o `8oooooo.  \r\n"
        + "                                                                 d\"     YD  \r\n"
        + "                                                                 \"Y88888P'  \r\n"
        + "                                                                            ");

    Collection<JoinDTO> joinList = joinDao.findAll();

    System.out.println("    랭킹  아이디        포인트");
    System.out.println("   ==============================");
    MemberHelper.printUserRank((List<JoinDTO>) joinList);     
  }







}
