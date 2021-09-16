package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewUpdateHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewUpdateHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute() {
    while (true) {
      System.out.println("[참여인증&댓글 수정]");
      System.out.println(" ▶ 챌린지 번호를 입력해주세요 ");
      System.out.println();
      int challengeNo = Prompt.inputInt("챌린지 번호: ");

      ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


      if (challengeDTO == null) {
        System.out.println("존재하지 않는 챌린지입니다");
      }

      int updateNo = Prompt.inputInt("번호? ");

      ChallengeReviewDTO challengeReviewDTO = findByReviewNo(updateNo);

      try {
        if (challengeReviewDTO == null) {
          System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
          return;
        }

        if (challengeReviewDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("변경 권한이 없습니다.");
          return;
        }

        String content = Prompt.inputString(String.format("내용(%s)? ", challengeReviewDTO.getContent()));
        String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", challengeReviewDTO.getFileUpload()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("참여인증&댓글 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println("참여인증&댓글을 수정하였습니다.");
          challengeReviewDTO.setContent(content);
          challengeReviewDTO.setFileUpload(fileUpload);
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
