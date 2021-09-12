package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewSearchHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewSearchHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (ChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOList) {
      if (!myChallengeReviewDTO.getMemberId().contains(input) &&
          !myChallengeReviewDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          myChallengeReviewDTO.getMemberId(), 
          myChallengeReviewDTO.getContent());
    }
  }
}
