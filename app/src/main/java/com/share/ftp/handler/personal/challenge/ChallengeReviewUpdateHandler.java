package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewUpdateHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewUpdateHandler(List<ChallengeReviewDTO> ChallengeReviewDTOList) {
    super(ChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    while (true) {
      System.out.println("[참여인증&댓글 수정]");
      int no = Prompt.inputInt("번호? ");

      ChallengeReviewDTO ChallengeReviewDTO = findByNo(no);

      try {
        if (ChallengeReviewDTO == null) {
          System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
          return;
        }

        if (ChallengeReviewDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("변경 권한이 없습니다.");
          return;
        }

        String content = Prompt.inputString(String.format("내용(%s)? ", ChallengeReviewDTO.getContent()));
        String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", ChallengeReviewDTO.getFileUpload()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("참여인증&댓글 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println("참여인증&댓글을 수정하였습니다.");
          ChallengeReviewDTO.setContent(content);
          ChallengeReviewDTO.setFileUpload(fileUpload);
          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        } 
      } catch (Throwable e) {
      }
    }
  }
}
