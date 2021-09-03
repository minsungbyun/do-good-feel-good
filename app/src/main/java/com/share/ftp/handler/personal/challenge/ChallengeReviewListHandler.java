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
    MyChallengeReviewDTO[] myChallengeReviewDTOs = new MyChallengeReviewDTO[myChallengeReviewDTOList.size()];
    myChallengeReviewDTOList.toArray(myChallengeReviewDTOs);
    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOs) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          myChallengeReviewDTO.getMemberId(), 
          myChallengeReviewDTO.getContent(),
          myChallengeReviewDTO.getFileUpload(),
          myChallengeReviewDTO.getRegisteredDate());
    }
  }
}
