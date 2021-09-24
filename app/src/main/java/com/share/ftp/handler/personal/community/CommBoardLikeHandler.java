package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardCommentDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardLikeHandler extends AbstractCommBoardHandler {

  public CommBoardLikeHandler(List<CommBoardDTO> commBoardDTOList, List<CommBoardCommentDTO> commBoardCommentDTOList) {
    super(commBoardDTOList, commBoardCommentDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {
      System.out.println("[  ❤ LIKE ❤  ]");
      System.out.println();

      int no = (int) request.getAttribute("no");
      System.out.println();

      CommBoardDTO commBoardDTO = findByNo(no); 



      String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ] ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  ❌ 좋아요 취소❌  ]");
        return;
      } else if (input.equals("y")) {
        System.out.println("[  ❤ LIKE ❤  ]");
        commBoardDTO.setLike(commBoardDTO.getLike() + 1);
        return;
      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

