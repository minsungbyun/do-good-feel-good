package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBestReviewHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;

  public AbstractCommBestReviewHandler(List<CommBoardDTO> commBoardDTOList) {
    this.commBoardDTOList = commBoardDTOList;
  }
}










