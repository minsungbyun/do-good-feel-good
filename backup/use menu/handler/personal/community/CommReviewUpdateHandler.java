package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.util.Prompt;

public class CommReviewUpdateHandler extends AbstractCommReviewHandler {

  public CommReviewUpdateHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 변경]");
    int no = Prompt.inputInt("번호? ");

    CommReviewDTO commReviewDTO = findByNo(no);

    if (commReviewDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", commReviewDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    commReviewDTO.setContent(content);

    System.out.println("변경하였습니다.");
  }
}










