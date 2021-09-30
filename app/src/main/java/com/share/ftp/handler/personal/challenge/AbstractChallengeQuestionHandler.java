package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeQuestionHandler  implements Command {

  protected List<ChallengeQuestionDTO> challengeQuestionDTOList;
  protected List<ChallengeDTO> challengeDTOList;
  protected List<ChallengeQuestionDTO> challengeReplyList;

  public AbstractChallengeQuestionHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList, List<ChallengeQuestionDTO> challengeReplyList) {
    this.challengeQuestionDTOList = challengeQuestionDTOList;
    this.challengeDTOList = challengeDTOList;
    this.challengeReplyList = challengeReplyList;
  }


  protected ChallengeQuestionDTO findByQuestionNo(int no) {
    for (ChallengeQuestionDTO ChallengeQuestionDTO : challengeQuestionDTOList) {
      if (ChallengeQuestionDTO.getQuestionNo() == no) {
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

  protected ChallengeQuestionDTO findByQuestionNo(int no, ChallengeDTO challengeNo) {
    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeNo.getNo() == challengeQuestionDTO.getNo()) {
        if (challengeQuestionDTO.getQuestionNo() == no) {
          return challengeQuestionDTO;
        }
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

  protected int getNextReplyNum(ChallengeQuestionDTO challengeQuestionDTO) {
    if (challengeReplyList.size() > 0) {
      return challengeQuestionDTO.getReplyCount() + 1;
    } else {
      return 1;
    }
  }

  protected int indexOf(int questionNo) {
    for (int i = 0; i < challengeQuestionDTOList.size(); i++) {
      if (challengeQuestionDTOList.get(i).getQuestionNo() == questionNo) {
        return i;
      }
    }
    return -1;
  }

}
