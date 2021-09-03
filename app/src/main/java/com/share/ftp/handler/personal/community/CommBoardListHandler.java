package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;

public class CommBoardListHandler extends AbstractCommBoardHandler {

  public CommBoardListHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/목록]");

    if (commBoardDTOList.isEmpty()) {
<<<<<<< HEAD
      System.out.println("게시글이 없습니다");
      return;
    }


=======
      System.out.println("작성된 게시글이 없습니다.");
      return;
    }

>>>>>>> d51dd8de4b640ebde35d960b4544fe4e8b7c02c7
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {

      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          commBoardDTO.getNo(), 
          commBoardDTO.getTitle(), 
          commBoardDTO.getContent(),
          commBoardDTO.getFileUpload(),
          //commBoardDTO.getPassword(),
          commBoardDTO.getRegisteredDate(), 
          commBoardDTO.getViewCount());
    }
  }
}





