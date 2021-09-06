package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;

public class CommReviewListHandler extends AbstractCommReviewHandler {

  public CommReviewListHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[소통해요 게시글]");
    //    CommReviewDTO[] commReviewsDTO = new CommReviewDTO [commReviewDTOList.size()];
    //    commReviewDTOList.toArray(commReviewsDTO);
    //    for (CommReviewDTO commReviewDTO : commReviewsDTO) {
    if (commReviewDTOList.isEmpty()) {
      System.out.println("게시글이 없습니다");
      return;
    }

    System.out.println("[소통해요/한줄후기/목록]");

    if (commReviewDTOList.isEmpty()) {
      System.out.println("작성된 게시글이 없습니다.");
      return;
    }
    //    CommReviewDTO[] commReviewsDTO = new CommReviewDTO [commReviewDTOList.size()];
    //    commReviewDTOList.toArray(commReviewsDTO);
    //    for (CommReviewDTO commReviewDTO : commReviewsDTO) {

    for (CommReviewDTO commReviewDTO : commReviewDTOList) {
      System.out.printf("%s, %d, %s, %s\n", 
          AuthLoginHandler.loginUser.getId(),
          commReviewDTO.getNo(), 
          commReviewDTO.getContent(),
          commReviewDTO.getRegisteredDate());

    }
  }
}









