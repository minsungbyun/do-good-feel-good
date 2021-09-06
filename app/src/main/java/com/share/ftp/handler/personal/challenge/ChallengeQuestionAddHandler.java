package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionAddHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 등록]");

    MyChallengeQuestionDTO myChallengeQuestionDTO = new MyChallengeQuestionDTO();

    myChallengeQuestionDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeQuestionDTO.setTitle(Prompt.inputString("제목: "));
    myChallengeQuestionDTO.setContent(Prompt.inputString("내용: "));
    
    myChallengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

    myChallengeQuestionDTOList.add(myChallengeQuestionDTO);
    
    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
