package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBoardHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;

  public AbstractCommBoardHandler(List<CommBoardDTO> commBoardDTOList) {
    this.commBoardDTOList = commBoardDTOList;
  }



  protected CommBoardDTO findByNo(int no) {
    CommBoardDTO[] arr = commBoardDTOList.toArray(new CommBoardDTO[0]);
    for(CommBoardDTO commBoardDTO : arr) {
      if (commBoardDTO.getNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }

  //  public CommBoardDTO[] chooseBoard() {
  //
  //    // 조회수 높은 상위 3개 담을 배열
  //    CommBoardDTO[] top3 = new CommBoardDTO[3];
  //
  //    CommBoardDTO max = commBoardsDTO[0];
  //
  //    for (int i = 0; i < this.size; i++) {
  //      if (max.getViewCount() < commBoardsDTO[i].getViewCount()) {
  //        max = commBoardsDTO[i];
  //        top3[0] = max;
  //      }
  //    }
  //    return top3;
  //
  //  }

}





