package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;

public class ChallengeReviewListHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewListHandler(List<ChallengeReviewDTO> ChallengeReviewDTOList) {
    super(ChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 목록]");

    if (ChallengeReviewDTOList.isEmpty()) {
      System.out.println("참여인증&댓글이 없습니다.");
      return;
    }
    for (ChallengeReviewDTO ChallengeReviewDTO : ChallengeReviewDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          ChallengeReviewDTO.getNo(), 
          ChallengeReviewDTO.getOwner().getId(),
          ChallengeReviewDTO.getContent(),
          ChallengeReviewDTO.getFileUpload(),
          ChallengeReviewDTO.getRegisteredDate());
    }
  }
}
