package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.util.Prompt;

public class CommReviewDeleteHandler extends AbstractCommReviewHandler{

  List<CommReviewDTO> commReviewDTOList;

  public CommReviewDeleteHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[소통해요/ 한줄후기/ 삭제]");
    int no = Prompt.inputInt("번호? ");

    CommReviewDTO commReviewDTO = findByNo(no);

    if (commReviewDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    commReviewDTOList.remove(commReviewDTO);

    System.out.println("게시글을 삭제하였습니다.");
  }
}










