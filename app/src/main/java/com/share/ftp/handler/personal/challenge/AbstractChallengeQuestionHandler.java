package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<ChallengeQuestionDTO> ChallengeQuestionDTOList;

  public AbstractChallengeQuestionHandler(List<ChallengeQuestionDTO> ChallengeQuestionDTOList) {
    this.ChallengeQuestionDTOList = ChallengeQuestionDTOList;
  }

  protected ChallengeQuestionDTO findByNo(int no) {
    ChallengeQuestionDTO[] arr = ChallengeQuestionDTOList.toArray(new ChallengeQuestionDTO[0]);
    for (ChallengeQuestionDTO ChallengeQuestionDTO : arr) {
      if (ChallengeQuestionDTO.getNo() == no) {
        return ChallengeQuestionDTO;
      }
    }
    return null;
  }
}
