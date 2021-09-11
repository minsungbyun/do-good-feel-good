package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;

public class ChallengeJoinListHandler extends AbstractChallengeJoinHandler {

  ChallengeJoinHandler challengeJoinHandler;
  List<ChallengeJoinDTO> ChallengeJoinDTOList;
  List<JoinDTO> members;

  public ChallengeJoinListHandler(
      List<ChallengeJoinDTO> ChallengeJoinDTOList
      ) {

    super(ChallengeJoinDTOList);
    this.ChallengeJoinDTOList = ChallengeJoinDTOList;
  }

  @Override
  public void execute() {

    System.out.println("[참여자 목록]");

    if (ChallengeJoinDTOList.isEmpty()) {
      System.out.println("참여자가 없습니다.");
      return;
    }
    for (ChallengeJoinDTO ChallengeJoinDTO : ChallengeJoinDTOList) {
      System.out.printf("%s, %s\n", 
          ChallengeJoinDTO.getUserId(),
          ChallengeJoinDTO.getRegisteredDate());
    }
  }

}
