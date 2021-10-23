package com.share.ftp.handler.personal.challenge;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler implements Command {


  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  public ChallengeQuestionAddHandler(
      ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println();
      System.out.println("해당 챌린지가 없습니다!");
    }

    //    if (!challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
    //      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
    //      return;
    //    }

    ChallengeQuestionDTO challengeQuestionDTO = new ChallengeQuestionDTO();

    challengeQuestionDTO.setNo(challengeDTO.getNo());
    challengeQuestionDTO.setContent(Prompt.inputString("내용: "));

    challengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

    String input = Prompt.inputString("해당 챌린지에 문의등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 챌린지에 문의등록을 취소하였습니다.");
      return;
    }

    //    if (challengeDTO.getQuestionCount() == 0) {
    //      challengeDTO.setQuestionCount(1);
    //      System.out.println("각 챌린지의 첫 문의입니다");
    //      System.out.println(challengeDTO.getQuestionCount());
    //    } else {
    //      challengeDTO.setQuestionCount(challengeDao.getNextQuestionNum(challengeDTO)); 
    //    }
    //
    //    challengeQuestionDTO.setQuestionNo(challengeDTO.getQuestionCount());

    //    challengeDao.update(challengeDTO);
    challengeQuestionDao.insert(challengeQuestionDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
