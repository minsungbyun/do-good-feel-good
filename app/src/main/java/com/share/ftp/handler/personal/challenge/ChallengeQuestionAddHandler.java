package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionAddHandler(List<ChallengeQuestionDTO> ChallengeQuestionDTOList) {
    super(ChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 등록]");

    ChallengeQuestionDTO ChallengeQuestionDTO = new ChallengeQuestionDTO();

    ChallengeQuestionDTO.setNo(Prompt.inputInt("번호: "));
    ChallengeQuestionDTO.setTitle(Prompt.inputString("제목: "));
    ChallengeQuestionDTO.setContent(Prompt.inputString("내용: "));

    ChallengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

    ChallengeQuestionDTOList.add(ChallengeQuestionDTO);

    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
