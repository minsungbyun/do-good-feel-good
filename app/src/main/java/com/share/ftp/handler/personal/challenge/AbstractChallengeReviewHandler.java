package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {

  protected List<ChallengeReviewDTO> ChallengeReviewDTOList;

  public AbstractChallengeReviewHandler(List<ChallengeReviewDTO> ChallengeReviewDTOList) {
    this.ChallengeReviewDTOList = ChallengeReviewDTOList;
  }

  protected ChallengeReviewDTO findByNo(int no) {
    ChallengeReviewDTO[] arr = ChallengeReviewDTOList.toArray(new ChallengeReviewDTO[0]);
    for (ChallengeReviewDTO ChallengeReviewDTO : arr) {
      if (ChallengeReviewDTO.getNo() == no) {
        return ChallengeReviewDTO;
      }
    }
    return null;
  }

}
