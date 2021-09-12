package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {
	
  protected List<ChallengeReviewDTO> myChallengeReviewDTOList;
	
  public AbstractChallengeReviewHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    this.myChallengeReviewDTOList = myChallengeReviewDTOList;
  }

  protected ChallengeReviewDTO findByNo(int no) {
      ChallengeReviewDTO[] arr = myChallengeReviewDTOList.toArray(new ChallengeReviewDTO[0]);
      for (ChallengeReviewDTO myChallengeReviewDTO : arr) {
        if (myChallengeReviewDTO.getNo() == no) {
          return myChallengeReviewDTO;
      }
    }
    return null;
  }

}
