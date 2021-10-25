package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeReplyAddHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeQuestionDao challengeQuestionDao;
  SqlSession sqlSession;

  public AdminChallengeReplyAddHandler(
      ChallengeDao challengeDao, ChallengeQuestionDao challengeQuestionDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.challengeQuestionDao = challengeQuestionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 문의답글 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    int challengeQuestionNo = Prompt.inputInt("문의 번호를 입력해주세요 ▶ ");

    ChallengeQuestionDTO challengeReply = challengeQuestionDao.findByNo(challengeNo, challengeQuestionNo);
    //    request.setAttribute("challengeQuestionNo", challengeQuestionNo); 

    //    ChallengeQuestionDTO challengeQuestionDTO = new ChallengeQuestionDTO();

    //    challengeQuestionDTO.setNo(challengeDTO.getNo());
    //    challengeQuestionDTO.setContent(Prompt.inputString("내용: "));
    //    challengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());
    String reply = Prompt.inputString(String.format("답글? ", challengeReply.getReply()));

    String input = Prompt.inputString("해당 문의에 답글 등록을 하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 문의에 답글 등록을 취소하였습니다.");
      return;

    } else if (input.equalsIgnoreCase("y")) {
      challengeReply.setReply(reply);
      //      challengeDTO.setQuestionCount(challengeQuestionDao.getNextNum(challengeDTO));
      //      challengeQuestionDTO.setQuestionNo(challengeDTO.getQuestionCount()); // 해당 챌린지 문의의 마지막 번호기억 + 1

      //      int index = challengeDao.questionIndexOf(challengeNo, challengeQuestionNo);

      //      challengeQuestionDao.insertReply(challengeQuestionNo, challengeQuestionDTO);
      challengeQuestionDao.updateReply(challengeReply);
      sqlSession.commit();

      //      Collection<ChallengeQuestionDTO> challengeQuestionSort = challengeQuestionDao.findAll();
      //
      //      for (ChallengeQuestionDTO a : challengeQuestionSort) {
      //        System.out.printf("%d, %d, %s, %s, %s\n", 
      //            a.getNo(), // 테스트 끝나고 지움
      //            a.getQuestionNo(),
      //            a.getOwner().getId(),
      //            a.getContent(),
      //            a.getRegisteredDate());
      //      }
      //
      //      challengeQuestionDao.sortChallengeQuestion(challengeQuestionDTO);

      System.out.println();
      System.out.println("문의답글 등록이 완료되었습니다.");
    }
  }



}
