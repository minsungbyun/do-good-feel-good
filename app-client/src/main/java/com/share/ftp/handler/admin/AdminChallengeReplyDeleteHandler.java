package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeReplyDeleteHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  public AdminChallengeReplyDeleteHandler(
      ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의답글 삭제 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    challengeDao.findByNo(challengeNo); 


    int challengQuestionNo = (int) request.getAttribute("challengQuestionNo");

    ChallengeQuestionDTO challengeQuestion = challengeQuestionDao.findByNo(challengeNo, challengQuestionNo);


    while (true) {
      String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("답글 삭제를 취소하였습니다.");
        return; 

        //      } else if (challengeQuestion.getContent().equals("삭제된 댓글입니다")) {
        //        System.out.println("이미 삭제 된 댓글입니다!");
        //        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println("해당 문의답글을 삭제하였습니다.");
        //        challengeList.setQuestionCount(challengeList.getQuestionCount() - 1);
        challengeQuestion.setReply(null);


        //          challengeQuestion.setQuestionNo(challengeQuestion.getQuestionNo() - 1);
        challengeQuestionDao.updateReply(challengeQuestion);
        sqlSession.commit();
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 
    }
  }
}
