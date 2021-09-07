package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionSearchHandler extends AbstractChallengeQuestionHandler {

  public ChallengeQuestionSearchHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (MyChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOList) {
      if (!myChallengeQuestionDTO.getOwner().getId().contains(input) &&
          !myChallengeQuestionDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          myChallengeQuestionDTO.getNo(), 
          myChallengeQuestionDTO.getOwner().getId(),
          myChallengeQuestionDTO.getContent());
    }
  }
}
