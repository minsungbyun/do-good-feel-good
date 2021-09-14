package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionUpdateHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionUpdateHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList) {
    super(challengeQuestionDTOList);
  }

  @Override
  public void execute() {
    while (true) {
      System.out.println("[문의 수정]");
      int no = Prompt.inputInt("번호? ");

      ChallengeQuestionDTO challengeQuestion = findByNo(no);

      try {
        if (challengeQuestion == null) {
          System.out.println("해당 번호의 문의가 없습니다.");
          return;
        }

        if (challengeQuestion.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("변경 권한이 없습니다.");
          return;
        }

        String content = Prompt.inputString(String.format("내용(%s)? ", challengeQuestion.getContent()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("문의 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println("문의를 수정하였습니다.");
          challengeQuestion.setContent(content);
          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        } 
      } catch (Throwable e) {
      }
    }
  }
}
