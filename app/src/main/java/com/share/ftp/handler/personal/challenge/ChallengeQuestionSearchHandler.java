package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionSearchHandler extends AbstractChallengeQuestionHandler {

  public ChallengeQuestionSearchHandler(List<ChallengeQuestionDTO> ChallengeQuestionDTOList) {
    super(ChallengeQuestionDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (ChallengeQuestionDTO ChallengeQuestionDTO : ChallengeQuestionDTOList) {
      if (!ChallengeQuestionDTO.getOwner().getId().contains(input) &&
          !ChallengeQuestionDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          ChallengeQuestionDTO.getNo(), 
          ChallengeQuestionDTO.getOwner().getId(),
          ChallengeQuestionDTO.getContent());
    }
  }
}
