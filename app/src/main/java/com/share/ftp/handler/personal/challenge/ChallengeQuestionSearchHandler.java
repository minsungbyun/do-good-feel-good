package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionSearchHandler extends AbstractChallengeQuestionHandler {

  public ChallengeQuestionSearchHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    super(challengeQuestionDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (!challengeQuestionDTO.getOwner().getId().contains(input) &&
          !challengeQuestionDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          challengeQuestionDTO.getNo(), 
          challengeQuestionDTO.getOwner().getId(),
          challengeQuestionDTO.getContent());
    }
  }
}
