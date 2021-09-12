package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.ChallengeReviewDTO;

public class ChallengeReviewListHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewListHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 목록]");
    ChallengeReviewDTO[] myChallengeReviewDTOs = new ChallengeReviewDTO[myChallengeReviewDTOList.size()];
    myChallengeReviewDTOList.toArray(myChallengeReviewDTOs);
    
    if (myChallengeReviewDTOList.isEmpty()) {
      System.out.println("참여인증&댓글이 없습니다.");
      return;
    }
    for (ChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOs) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          myChallengeReviewDTO.getMemberId(), 
          myChallengeReviewDTO.getContent(),
          myChallengeReviewDTO.getFileUpload(),
          myChallengeReviewDTO.getRegisteredDate());
    }
  }
}
