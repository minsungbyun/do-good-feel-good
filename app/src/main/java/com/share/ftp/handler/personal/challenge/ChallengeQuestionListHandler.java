package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[문의 목록]");
    System.out.println(" ▶ 챌린지 번호를 입력해주세요.");
    System.out.println();

    int challengeNo = Prompt.inputInt("챌린지 번호: ");
    System.out.println();

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    if (challengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeQuestionDTO.getNo() == challengeNo) {
        System.out.printf("%d, %d, %s, %s, %s\n", 
            challengeQuestionDTO.getNo(),
            challengeQuestionDTO.getQuestionNo(),
            challengeQuestionDTO.getOwner().getId(),
            challengeQuestionDTO.getTitle(),
            challengeQuestionDTO.getRegisteredDate());
      }
    }
  }
}
