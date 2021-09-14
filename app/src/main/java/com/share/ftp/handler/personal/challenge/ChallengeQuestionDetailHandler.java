package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDetailHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionDetailHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    super(challengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ChallengeQuestionDTO challengeQuestion = findByNo(no);

    if (challengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if (challengeQuestion.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      System.out.println("읽을 권한이 없습니다.");
      return;
    }
    
    System.out.printf("아이디: %s\n", challengeQuestion.getOwner().getId());
    System.out.printf("제목: %s\n", challengeQuestion.getTitle());
    System.out.printf("내용: %s\n", challengeQuestion.getContent());
  }
}
