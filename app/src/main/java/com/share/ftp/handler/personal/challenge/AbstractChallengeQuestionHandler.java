package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<MyChallengeQuestionDTO> myChallengeQuestionDTOList;

  public AbstractChallengeQuestionHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    this.myChallengeQuestionDTOList = myChallengeQuestionDTOList;
  }

  protected MyChallengeQuestionDTO findByNo(int no) {
    MyChallengeQuestionDTO[] arr = myChallengeQuestionDTOList.toArray(new MyChallengeQuestionDTO[0]);
    for (MyChallengeQuestionDTO myChallengeQuestionDTO : arr) {
      if (myChallengeQuestionDTO.getNo() == no) {
        return myChallengeQuestionDTO;
      }
    }
    return null;
  }
}
