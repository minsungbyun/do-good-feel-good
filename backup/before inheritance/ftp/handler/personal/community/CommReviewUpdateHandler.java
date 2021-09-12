package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewUpdateHandler extends AbstractCommReviewHandler {

  public CommReviewUpdateHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }


  @Override
  public void execute() {

    while(true) {

      System.out.println();
      System.out.println("[소통해요/ 한줄후기/ 변경]");
      int no = Prompt.inputInt("번호? ");

      CommReviewDTO commReviewDTO = findByNo(no);

      try {

        if (commReviewDTO == null) {
          System.out.println("해당 번호의 후기가 없습니다.");
          return;
        }

        if (commReviewDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }

        String content = Prompt.inputString(String.format("내용(%s)? ", commReviewDTO.getContent()));

        String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n")) {
          System.out.println("게시글 변경을 취소하였습니다.");
          return;

        } else if(input.equals("y")) {
          System.out.println("게시글을 변경하였습니다.");
          commReviewDTO.setContent(content);
          return;
        }

        else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        }
      } catch (Throwable e) {

      }
    }
  }
}










