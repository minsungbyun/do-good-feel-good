package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<ChallengeQuestionDTO> challengeQuestionDTOList;

  public AbstractChallengeQuestionHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    this.challengeQuestionDTOList = challengeQuestionDTOList;
  }

  protected ChallengeQuestionDTO findByNo(int no) {
    ChallengeQuestionDTO[] arr = challengeQuestionDTOList.toArray(new ChallengeQuestionDTO[0]);
    for (ChallengeQuestionDTO ChallengeQuestionDTO : arr) {
      if (ChallengeQuestionDTO.getNo() == no) {
        return ChallengeQuestionDTO;
      }
    }
    return null;
  }
}
