package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {

  protected List<ChallengeReviewDTO> challengeReviewDTOList;
  protected List<ChallengeDTO> challengeDTOList;

  public AbstractChallengeReviewHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    this.challengeReviewDTOList = challengeReviewDTOList;
    this.challengeDTOList = challengeDTOList;
  }

  protected ChallengeReviewDTO findByReviewNo(int no, ChallengeDTO challengeNo) {
    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewDTOList) {
      if (challengeNo.getNo() == challengeReviewDTO.getNo()) {
        if (challengeReviewDTO.getReviewNo() == no) {
          return challengeReviewDTO;
        }
      }
    }
    return null;
  }

  protected ChallengeReviewDTO findByReviewNo(int no) {
    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewDTOList) {
      if (challengeReviewDTO.getReviewNo() == no) {
        return challengeReviewDTO;
      }
    }
    return null;
  }

  protected ChallengeDTO findByChallengeNo(int no) {
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getNo() == no) {
        return challengeDTO;
      }
    }
    return null;
  }

  protected int getNextNum() {
    if (challengeReviewDTOList.size() > 0) {
      return challengeReviewDTOList.get(challengeReviewDTOList.size() - 1).getReviewNo() + 1;
    } else {
      return 1;
    }
  }

  protected int getNextReviewNum(ChallengeDTO challengeDTO) {
    if (challengeReviewDTOList.size() > 0) {
      return challengeDTO.getReviewCount() + 1;
    } else {
      return 1;
    }
  }
}
