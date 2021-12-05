package com.share.ftp.handler.personal.challenge;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeQuestionUpdateHandler implements Command {

  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  public ChallengeQuestionUpdateHandler(ChallengeQuestionDao challengeQuestionDao, SqlSession sqlSession) {
    this.challengeQuestionDao = challengeQuestionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[ 문의 수정 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    int challengeQuestionNo = (int) request.getAttribute("challengeQuestionNo");

    ChallengeQuestionDTO challengeQuestion = challengeQuestionDao.findByNo(challengeNo, challengeQuestionNo);

    if (challengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    //    if ((challengeQuestion.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
    //        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    //    } else {
    //      System.out.println("변경 권한이 없습니다.");
    //      return;
    //    }

    String content = Prompt.inputString(String.format("내용(%s)? ", challengeQuestion.getContent()));

    while (true) {
      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("문의 수정을 취소하였습니다.");
        return;

      } else if (input.equals("y")) {
        System.out.println();
        challengeQuestion.setContent(content);
        challengeQuestionDao.update(challengeQuestion);
        sqlSession.commit();

        System.out.println("문의를 수정하였습니다.");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 
    }
  }
}
