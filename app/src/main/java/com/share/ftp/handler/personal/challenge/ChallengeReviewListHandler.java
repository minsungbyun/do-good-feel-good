package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeReviewDTO;

public class ChallengeReviewListHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewListHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 목록]");
    
    if (myChallengeReviewDTOList.isEmpty()) {
      System.out.println("참여인증&댓글이 없습니다.");
      return;
    }
    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          myChallengeReviewDTO.getOwner().getId(),
          myChallengeReviewDTO.getContent(),
          myChallengeReviewDTO.getFileUpload(),
          myChallengeReviewDTO.getRegisteredDate());
    }
  }
}
