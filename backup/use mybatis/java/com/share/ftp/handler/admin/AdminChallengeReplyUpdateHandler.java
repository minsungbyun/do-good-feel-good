package com.share.ftp.handler.admin;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeReplyUpdateHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;

  public AdminChallengeReplyUpdateHandler(ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의답글 수정 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    int challengQuestionNo = (int) request.getAttribute("challengQuestionNo");

    ChallengeQuestionDTO challengeQuestion = challengeQuestionDao.findByNo(challengeNo, challengQuestionNo);

    if (challengeQuestion.getReply() == null) {
      System.out.println("해당 번호의 답글이 없습니다.");
      return;
    }


    String content = Prompt.inputString(String.format("내용(%s)? ", challengeQuestion.getContent()));

    while (true) {
      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("답글 수정을 취소하였습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println("문의답글을 수정하였습니다.");
        challengeQuestion.setContent(content);
        challengeQuestionDao.update(challengeQuestion);
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 

    }
  }
}
