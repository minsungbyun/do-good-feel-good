package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {

  public CommBoardDetailHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[소통해요/ 나눔이야기Best/ 상세보기]");
    System.out.println();

  }
}





