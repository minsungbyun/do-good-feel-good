package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeReplyUpdateHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  public AdminChallengeReplyUpdateHandler(
      ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의답글 수정 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    challengeDao.findByNo(challengeNo);

    int challengQuestionNo = (int) request.getAttribute("challengQuestionNo");

    ChallengeQuestionDTO challengeReply = challengeQuestionDao.findByNo(challengeNo, challengQuestionNo);


    String reply = Prompt.inputString(String.format("답글(%s)? ", challengeReply.getReply()));

    while (true) {
      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("답글 수정을 취소하였습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println("문의답글을 수정하였습니다.");
        challengeReply.setReply(reply);
        challengeQuestionDao.updateReply(challengeReply);
        sqlSession.commit();
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 

    }
  }
}
