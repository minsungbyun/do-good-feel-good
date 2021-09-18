package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    super(challengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 목록]");

    if (challengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      System.out.printf("%s, %s\n", 
          challengeQuestionDTO.getOwner().getId(),
          challengeQuestionDTO.getTitle());
    }
  }
}
