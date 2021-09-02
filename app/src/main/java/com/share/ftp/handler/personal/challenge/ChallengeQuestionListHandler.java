package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 목록]");
    MyChallengeQuestionDTO[] myChallengeQuestionDTOs = new MyChallengeQuestionDTO[myChallengeQuestionDTOList.size()];
    myChallengeQuestionDTOList.toArray(myChallengeQuestionDTOs);
    for (MyChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOs) {
      System.out.printf("%s, %s\n", 
          myChallengeQuestionDTO.getMemberId(), 
          myChallengeQuestionDTO.getContent());
    }
  }
}
