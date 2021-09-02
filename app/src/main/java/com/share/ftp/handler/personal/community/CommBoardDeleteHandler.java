package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.util.Prompt;

public class CommBoardDeleteHandler extends AbstractCommBoardHandler {


  public CommBoardDeleteHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }



  public void execute() {

    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/게시글삭제]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    commBoardDTOList.remove(commBoardDTO);

    System.out.println("게시글을 삭제하였습니다.");
  }



}





