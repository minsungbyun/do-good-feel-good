package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeJoinHandler implements Command {

  protected List<ChallengeJoinDTO> ChallengeJoinDTOList;

  public AbstractChallengeJoinHandler(List<ChallengeJoinDTO> ChallengeJoinDTOList) {
    this.ChallengeJoinDTOList = ChallengeJoinDTOList;
  }
}