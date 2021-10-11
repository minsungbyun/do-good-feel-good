package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeReviewSearchHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewSearchHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 참여인증&댓글 검색 ]");
    System.out.println();

    int challengeNo = Prompt.inputInt("챌린지 번호를 입력해주세요 ▶ ");
    System.out.println();

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    String input = Prompt.inputString("검색어를 입력해주세요 ▶ ");

    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewDTOList) {
      if (!challengeReviewDTO.getOwner().getId().contains(input) &&
          !challengeReviewDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          challengeReviewDTO.getNo(), 
          challengeReviewDTO.getOwner().getId(),
          challengeReviewDTO.getContent());
    }
  }
}
