package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeDeleteHandler implements Command {

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  public AdminChallengeDeleteHandler(ChallengeDao challengeDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 챌린지 삭제 ]");
    int challengeNo = (int) request.getAttribute("challengeNo"); 

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("챌린지 삭제를 취소하였습니다.");
      return; 

    } else if (input.equalsIgnoreCase("y")) {
      challengeDao.delete(challengeNo);
      sqlSession.commit();
      System.out.println();

      System.out.println("[  챌린지를 삭제하였습니다. ]");
    }
  }
}
