package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewSearchHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewSearchHandler(List<ChallengeReviewDTO> ChallengeReviewDTOList) {
    super(ChallengeReviewDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (ChallengeReviewDTO ChallengeReviewDTO : ChallengeReviewDTOList) {
      if (!ChallengeReviewDTO.getOwner().getId().contains(input) &&
          !ChallengeReviewDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          ChallengeReviewDTO.getNo(), 
          ChallengeReviewDTO.getOwner().getId(),
          ChallengeReviewDTO.getContent());
    }
  }
}
