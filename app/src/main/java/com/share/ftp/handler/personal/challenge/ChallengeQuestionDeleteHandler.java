package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionDeleteHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionDeleteHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    super(myChallengeQuestionDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[문의 삭제]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 삭제를 취소하였습니다.");
      return;
    }

    myChallengeQuestionDTOList.remove(myChallengeQuestion);

    System.out.println("문의를 삭제하였습니다.");
  }
}
