package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewDeleteHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewDeleteHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[댓글 삭제]");
    int no = Prompt.inputInt("번호? ");

    ChallengeReviewDTO myChallengeReview = findByNo(no);

    if (myChallengeReview == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
      return;
    }

    myChallengeReviewDTOList.remove(myChallengeReview);

    System.out.println("참여인증&댓글을 삭제하였습니다.");
  }
}
