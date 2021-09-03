package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {
	
  protected List<MyChallengeReviewDTO> myChallengeReviewDTOList;
	
  public AbstractChallengeReviewHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    this.myChallengeReviewDTOList = myChallengeReviewDTOList;
  }

  protected MyChallengeReviewDTO findByNo(int no) {
      MyChallengeReviewDTO[] arr = myChallengeReviewDTOList.toArray(new MyChallengeReviewDTO[0]);
      for (MyChallengeReviewDTO myChallengeReviewDTO : arr) {
        if (myChallengeReviewDTO.getNo() == no) {
          return myChallengeReviewDTO;
      }
    }
    return null;
  }

}
