package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionUpdateHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeQuestionUpdateHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[ 문의 수정 ]");
      System.out.println();
      int challengeNo = (int) request.getAttribute("challengeNo");

      ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);


      if (challengeDTO == null) {
        System.out.println("존재하지 않는 챌린지입니다");
      }

      int questionNo = (int) request.getAttribute("questionNo");

      ChallengeQuestionDTO challengeQuestion = challengeDao.findByChallengeQuestionNo(challengeNo, questionNo);

      try {
        if (challengeQuestion == null) {
          System.out.println("해당 번호의 문의가 없습니다.");
          return;
        }

        if ((challengeQuestion.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
            AuthLoginHandler.getLoginUser().getId().equals("admin")) {
        } else {
          System.out.println("변경 권한이 없습니다.");
          return;
        }


        ChallengeQuestionDTO updateChallengeQuestion = new ChallengeQuestionDTO();
        updateChallengeQuestion = challengeQuestion;
        updateChallengeQuestion.setContent(Prompt.inputString(String.format("내용(%s)? ", challengeQuestion.getContent())));
        //        String content = Prompt.inputString(String.format("내용(%s)? ", challengeQuestion.getContent()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("문의 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println("문의를 수정하였습니다.");
          challengeDao.updateQuestion(challengeNo, updateChallengeQuestion);
          //          challengeQuestion.setContent(content);
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
