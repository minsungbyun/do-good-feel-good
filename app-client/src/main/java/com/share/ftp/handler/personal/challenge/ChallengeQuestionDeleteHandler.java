package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDeleteHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeQuestionDeleteHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[ 문의 삭제 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challenge = challengeDao.findByChallengeNo(challengeNo); 

    int challengeQuestionNo = (int) request.getAttribute("challengeQuestionNo");

    ChallengeQuestionDTO deleteChallengeQuestion = challengeDao.findByChallengeQuestionNo(challengeNo, challengeQuestionNo);

    if (deleteChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if ((deleteChallengeQuestion.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 삭제를 취소하였습니다.");
      return; 

    } else if (input.equalsIgnoreCase("y")) {
      challenge.setQuestionCount(challenge.getQuestionCount() - 1);


      challengeDao.update(challenge);
      challengeDao.deleteQuestion(deleteChallengeQuestion);

      System.out.println("해당 문의사항을 삭제하였습니다.");
    }
  }
}

