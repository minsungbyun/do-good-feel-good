package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeJoinHandler implements Command {

  protected List<ChallengeJoinDTO> challengeJoinDTOList;

  public AbstractChallengeJoinHandler(List<ChallengeJoinDTO> challengeJoinDTOList) {
    this.challengeJoinDTOList = challengeJoinDTOList;
  }
}