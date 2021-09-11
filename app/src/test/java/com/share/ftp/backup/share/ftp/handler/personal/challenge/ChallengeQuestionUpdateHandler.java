package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionUpdateHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionUpdateHandler(List<ChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 수정]");
    int no = Prompt.inputInt("번호? ");

    ChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeQuestion.getContent()));

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 수정을 취소하였습니다.");
      return;
    }

    myChallengeQuestion.setContent(content);
    System.out.println("문의를 수정하였습니다.");
  }
}
