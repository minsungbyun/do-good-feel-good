package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {

  int reviewNo; // 번호 자동부여

  public ChallengeQuestionAddHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    super(challengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 등록]");

    ChallengeQuestionDTO challengeQuestionDTO = new ChallengeQuestionDTO();

    challengeQuestionDTO.setTitle(Prompt.inputString("제목: "));
    challengeQuestionDTO.setContent(Prompt.inputString("내용: "));

    challengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());
    challengeQuestionDTO.setNo(++reviewNo); // 번호 자동부여

    challengeQuestionDTOList.add(challengeQuestionDTO);

    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
