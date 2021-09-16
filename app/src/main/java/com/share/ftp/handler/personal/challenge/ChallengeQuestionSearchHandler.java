package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionSearchHandler extends AbstractChallengeQuestionHandler {

  public ChallengeQuestionSearchHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 검색]");
    System.out.println(" ▶ 챌린지 번호를 입력해주세요.");
    System.out.println();

    int challengeNo = Prompt.inputInt("챌린지 번호: ");
    System.out.println();

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    String input = Prompt.inputString("검색어? ");

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (!challengeQuestionDTO.getOwner().getId().contains(input) &&
          !challengeQuestionDTO.getContent().contains(input)) {
        continue;
      }
      System.out.printf("%s, %s, %s\n", 
          challengeQuestionDTO.getNo(), 
          challengeQuestionDTO.getOwner().getId(),
          challengeQuestionDTO.getContent());
    }
  }
}
