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
  private int getNextNum() {
    if (challengeQuestionDTOList.size() > 0) {
      return challengeQuestionDTOList.get(challengeQuestionDTOList.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }
}
