package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<ChallengeQuestionDTO> challengeQuestionDTOList;
  protected List<ChallengeDTO> challengeDTOList;

  public AbstractChallengeQuestionHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    this.challengeQuestionDTOList = challengeQuestionDTOList;
    this.challengeDTOList = challengeDTOList;
  }

  protected ChallengeQuestionDTO findByQuestionNo(int no) {
    ChallengeQuestionDTO[] arr = challengeQuestionDTOList.toArray(new ChallengeQuestionDTO[0]);
    for (ChallengeQuestionDTO ChallengeQuestionDTO : arr) {
      if (ChallengeQuestionDTO.getNo() == no) {
        return ChallengeQuestionDTO;
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
    if (challengeQuestionDTOList.size() > 0) {
      return challengeQuestionDTOList.get(challengeQuestionDTOList.size() - 1).getQuestionNo() + 1;
    } else {
      return 1;
    }
  }
  protected int getNextQuestionNum(ChallengeDTO challengeDTO) {
    if (challengeQuestionDTOList.size() > 0) {
      return challengeDTO.getQuestionCount() + 1;
    } else {
      return 1;
    }
  }
  protected int getNextNum2() {
    if (challengeDTOList.size() > 0) {
      return challengeDTOList.get(challengeQuestionDTOList.size() - 1).getQuestionCount() + 1;
    } else {
      return 1;
    }
  }
  protected int getNextNum(int challengeNo,ChallengeQuestionDTO challengeQuestionDTO) {
    if (challengeQuestionDTOList.isEmpty()) {
      System.out.println("처음");
      return 1;
    }

    if ((challengeQuestionDTO.getQuestionNo() != 1) && (challengeDTOList.get(challengeNo - 1).getNo() == challengeNo)  /*( challengeDTOList.get(challengeNo - 1).getReviewCount() == 0)*/) {
      challengeDTOList.get(challengeNo - 1).setQuestionCount(challengeQuestionDTO.getQuestionNo());
      return challengeDTOList.get(challengeNo - 1).getQuestionCount() + 1;

    } else {
      System.out.println("각 게시판 처음은 1");
      return 1;
    }
  }
}
