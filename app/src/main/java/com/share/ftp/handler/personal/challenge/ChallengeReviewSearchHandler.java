package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewSearchHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewSearchHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {

    String input = Prompt.inputString("검색어? ");

    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOList) {
      if (!AuthLoginHandler.loginUser.getId().contains(input) &&
          !myChallengeReviewDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          AuthLoginHandler.loginUser.getId(), 
          myChallengeReviewDTO.getContent());
    }
  }
}
