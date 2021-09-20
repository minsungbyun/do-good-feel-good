package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {

  protected List<ChallengeReviewDTO> challengeReviewDTOList;
  protected List<ChallengeDTO> challengeDTOList;

  public AbstractChallengeReviewHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    this.challengeReviewDTOList = challengeReviewDTOList;
    this.challengeDTOList = challengeDTOList;
  }

  protected ChallengeReviewDTO findByReviewNo(int no) {
    ChallengeReviewDTO[] arr = challengeReviewDTOList.toArray(new ChallengeReviewDTO[0]);
    for (ChallengeReviewDTO challengeReviewDTO : arr) {
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
  protected int getNextNum1(ChallengeDTO challengeDTO) {
    if (challengeReviewDTOList.size() > 0) {
      return challengeDTO.getReviewCount() + 1;
    } else {
      return 1;
    }
  }
  protected int getNextNum2() {
    if (challengeDTOList.size() > 0) {
      return challengeDTOList.get(challengeReviewDTOList.size() - 1).getReviewCount() + 1;
    } else {
      return 1;
    }
  }
  protected int getNextNum(int challengeNo,ChallengeReviewDTO challengeReviewDTO) {
    if (challengeReviewDTOList.isEmpty()) {
      System.out.println("처음");
      return 1;
    }

    if ((challengeReviewDTO.getReviewNo() != 1) && (challengeDTOList.get(challengeNo - 1).getNo() == challengeNo)  /*( challengeDTOList.get(challengeNo - 1).getReviewCount() == 0)*/) {
      challengeDTOList.get(challengeNo - 1).setReviewCount(challengeReviewDTO.getReviewNo());
      return challengeDTOList.get(challengeNo - 1).getReviewCount() + 1;

    } else {
      System.out.println("각 게시판 처음은 1");
      return 1;
    }

    //    if (challengeReviewDTOList.size() > 0) {
    //      return challengeReviewDTOList.get(challengeNo - 1).getReviewNo() + 1;
    //    } else {
    //      return 1;
    //    }
  }

}
