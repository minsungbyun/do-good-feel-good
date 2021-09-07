package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeJoinDTO;

public class ChallengeJoinListHandler extends AbstractChallengeJoinHandler {

  public ChallengeJoinListHandler(List<MyChallengeJoinDTO> myChallengeJoinDTOList) {
    super(myChallengeJoinDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여자 목록]");
    
    if (myChallengeJoinDTOList.isEmpty()) {
      System.out.println("참여자가 없습니다.");
      return;
    }
    for (MyChallengeJoinDTO myChallengeJoinDTO : myChallengeJoinDTOList) {
      System.out.printf("%s, %s\n", 
          myChallengeJoinDTO.getJoiner().getId(),
          myChallengeJoinDTO.getRegisteredDate());
    }
  }

}
