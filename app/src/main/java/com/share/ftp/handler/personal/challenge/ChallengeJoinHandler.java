package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;

import com.share.ftp.domain.personal.MyChallengeJoinDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeJoinHandler extends AbstractChallengeJoinHandler {

//  ChallengeJoinListHandler challengeJoinListHandler;
  
  public ChallengeJoinHandler(List<MyChallengeJoinDTO> myChallengeJoinDTOList /*ChallengeJoinListHandler challengeJoinListHandler*/) {
    super(myChallengeJoinDTOList);
//    this.challengeJoinListHandler = challengeJoinListHandler
  }

  @Override
  public void execute() {
    while (true) {
    System.out.println("[참여하기]");

    MyChallengeJoinDTO myChallengeJoinDTO = new MyChallengeJoinDTO();

    try {

    String input = Prompt.inputString("정말 참여하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("챌린지 참여를 취소하였습니다.");
      return;
    } else if (input.equals("y")) {
//        if (myChallengeJoinDTO.getJoiner().getId().equalsIgnoreCase(AuthLoginHandler.getLoginUser().getId())) {
//      System.out.println("챌린지 참여를 완료하였습니다.");
      myChallengeJoinDTO.setJoiner(AuthLoginHandler.getLoginUser());
      myChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
      myChallengeJoinDTOList.add(myChallengeJoinDTO);
      return;
//      } else if (myChallengeJoinDTO.getJoiner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
//        System.out.println("이미 참여가 완료되었습니다.");
//        return;
//      }
    } else {
      System.out.println("y 또는 n을 입력하세요.");
      continue;
    }
    } catch (Throwable e) {
  }
  }
  }
}
