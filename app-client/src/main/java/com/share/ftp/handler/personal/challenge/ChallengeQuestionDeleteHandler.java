package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDeleteHandler implements Command {


  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;

  public ChallengeQuestionDeleteHandler(ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[ 문의 삭제 ]");
      System.out.println();

      int challengeNo = (int) request.getAttribute("challengeNo");

      ChallengeDTO challenge = challengeDao.findByChallengeNo(challengeNo); 

      if (challenge == null) {
        System.out.println("해당 챌린지가 없습니다.");
        return;
      }

      int questionNo = (int) request.getAttribute("questionNo");

      ChallengeQuestionDTO deleteChallengeQuestion = challengeQuestionDao.findByChallengeQuestionNo(challengeNo, questionNo);
      try {
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

        } else if (deleteChallengeQuestion.getContent().equals("삭제된 댓글입니다")) {
          System.out.println("이미 삭제 된 댓글입니다!");
          return;

        } else if (input.equals("y")) {
          System.out.println("해당 문의사항을 삭제하였습니다.");
          challenge.setQuestionCount(challenge.getQuestionCount() - 1);
          //          deleteChallengeQuestion.setContent("삭제된 댓글입니다");


          deleteChallengeQuestion.setQuestionNo(deleteChallengeQuestion.getQuestionNo() - 1);
          challengeQuestionDao.deleteQuestion(deleteChallengeQuestion);
          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        } 
      } catch (Exception e) {
        e.printStackTrace();

      }
    }
  }
}
