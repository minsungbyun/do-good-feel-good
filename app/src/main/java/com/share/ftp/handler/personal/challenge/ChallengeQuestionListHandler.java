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
    
    if (myChallengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }
    
    for (MyChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOList) {
      System.out.printf("%s, %s\n", 
          myChallengeQuestionDTO.getOwner().getId(),
          myChallengeQuestionDTO.getTitle());
    }
  }
}
