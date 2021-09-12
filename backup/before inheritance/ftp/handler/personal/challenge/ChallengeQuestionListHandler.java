package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<ChallengeQuestionDTO> ChallengeQuestionDTOList) {
    super(ChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 목록]");

    if (ChallengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }

    for (ChallengeQuestionDTO ChallengeQuestionDTO : ChallengeQuestionDTOList) {
      System.out.printf("%s, %s\n", 
          ChallengeQuestionDTO.getOwner().getId(),
          ChallengeQuestionDTO.getTitle());
    }
  }
}
