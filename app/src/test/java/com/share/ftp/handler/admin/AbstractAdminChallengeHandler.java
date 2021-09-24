package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractAdminChallengeHandler implements Command {

  protected List<ChallengeDTO> challengeDTOList;
  public AbstractAdminChallengeHandler(List<ChallengeDTO> challengeDTOList) {
    this.challengeDTOList = challengeDTOList;
  }

  protected ChallengeDTO findByNo(int no) {
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getNo() == no) {
        return challengeDTO;
      }
    }
    return null;
  }
  protected int getNextNum() {
    if (challengeDTOList.size() > 0) {
      return challengeDTOList.get(challengeDTOList.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }
}
