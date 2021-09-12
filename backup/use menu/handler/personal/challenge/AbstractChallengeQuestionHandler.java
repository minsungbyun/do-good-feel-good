package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<ChallengeQuestionDTO> myChallengeQuestionDTOList;

  public AbstractChallengeQuestionHandler(List<ChallengeQuestionDTO> myChallengeQuestionDTOList) {
    this.myChallengeQuestionDTOList = myChallengeQuestionDTOList;
  }

  protected ChallengeQuestionDTO findByNo(int no) {
    ChallengeQuestionDTO[] arr = myChallengeQuestionDTOList.toArray(new ChallengeQuestionDTO[0]);
    for (ChallengeQuestionDTO myChallengeQuestionDTO : arr) {
      if (myChallengeQuestionDTO.getNo() == no) {
        return myChallengeQuestionDTO;
      }
    }
    return null;
  }
}
