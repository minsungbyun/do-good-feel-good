package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewDetailHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewDetailHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  /////////////// 현재 사용안함 ///////////////////
  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ChallengeReviewDTO challengeReviewDTO = findByReviewNo(no);

    if (challengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    System.out.printf("아이디: %s\n", challengeReviewDTO.getOwner().getId());
    System.out.printf("내용: %s\n", challengeReviewDTO.getContent());
    System.out.printf("파일첨부: %s\n", challengeReviewDTO.getFileUpload());
    System.out.printf("등록일: %s\n", challengeReviewDTO.getRegisteredDate());
  }
}
