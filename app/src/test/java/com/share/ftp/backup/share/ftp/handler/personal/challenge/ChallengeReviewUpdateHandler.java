package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewUpdateHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewUpdateHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }
  
  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 수정]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }
    
//    if (myChallengeReviewDTO.getOwner().getId() != AuthHandler.getLoginUser().getNo()) {
//      System.out.println("변경 권한이 없습니다.");
//      return;
//    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeReviewDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", myChallengeReviewDTO.getFileUpload()));

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 수정을 취소하였습니다.");
      return;
    }
    myChallengeReviewDTO.setContent(content);
    myChallengeReviewDTO.setFileUpload(fileUpload);
    System.out.println("참여인증&댓글을 변경하였습니다.");
  }
}
