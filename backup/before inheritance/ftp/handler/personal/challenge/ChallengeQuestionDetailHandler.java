package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDetailHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionDetailHandler(List<ChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if (myChallengeQuestion.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      System.out.println("읽을 권한이 없습니다.");
      return;
    }
    
    System.out.printf("아이디: %s\n", myChallengeQuestion.getOwner().getId());
    System.out.printf("제목: %s\n", myChallengeQuestion.getTitle());
    System.out.printf("내용: %s\n", myChallengeQuestion.getContent());
  }
}
