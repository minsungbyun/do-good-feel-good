package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<ChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 목록]");
    ChallengeQuestionDTO[] myChallengeQuestionDTOs = new ChallengeQuestionDTO[myChallengeQuestionDTOList.size()];
    myChallengeQuestionDTOList.toArray(myChallengeQuestionDTOs);
    
    if (myChallengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }
    
    for (ChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOs) {
      System.out.printf("%s, %s\n", 
          myChallengeQuestionDTO.getMemberId(), 
          myChallengeQuestionDTO.getContent());
    }
  }
}
