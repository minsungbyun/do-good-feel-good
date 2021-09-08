package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeJoinDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeJoinHandler implements Command {

  protected List<MyChallengeJoinDTO> myChallengeJoinDTOList;

  public AbstractChallengeJoinHandler(List<MyChallengeJoinDTO> myChallengeJoinDTOList) {
    this.myChallengeJoinDTOList = myChallengeJoinDTOList;
  }
}