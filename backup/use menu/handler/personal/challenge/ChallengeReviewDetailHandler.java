package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewDetailHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewDetailHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    System.out.printf("아이디: %s\n", myChallengeReviewDTO.getMemberId());
    System.out.printf("내용: %s\n", myChallengeReviewDTO.getContent());
    System.out.printf("파일첨부: %s\n", myChallengeReviewDTO.getFileUpload());
    System.out.printf("등록일: %s\n", myChallengeReviewDTO.getRegisteredDate());
  }
}
