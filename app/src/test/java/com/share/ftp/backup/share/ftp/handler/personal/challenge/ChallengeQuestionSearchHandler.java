package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionSearchHandler extends AbstractChallengeQuestionHandler {

  public ChallengeQuestionSearchHandler(List<ChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (ChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOList) {
      if (!myChallengeQuestionDTO.getMemberId().contains(input) &&
          !myChallengeQuestionDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          myChallengeQuestionDTO.getNo(), 
          myChallengeQuestionDTO.getMemberId(), 
          myChallengeQuestionDTO.getContent());
    }
  }
}
