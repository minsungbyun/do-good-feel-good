package com.share.ftp.handler.personal.challenge;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewAttachedFile;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeReviewDao challengeReviewDao;
  SqlSession sqlSession;

  public ChallengeReviewAddHandler(
      ChallengeDao challengeDao, ChallengeReviewDao challengeReviewDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.challengeReviewDao = challengeReviewDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 참여인증&댓글 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    if (!challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
      return;
    }

    // 리뷰어로 참여 한 경우 중복 참여 불가!
    if (challengeDTO.getReviewerNames().contains(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("리뷰는 한 번만 작성할 수 있습니다!");
      return;
    }

    ChallengeReviewDTO challengeReviewDTO = new ChallengeReviewDTO();

    challengeReviewDTO.setNo(challengeDTO.getNo());
    challengeReviewDTO.setContent(Prompt.inputString("내용 ▶ "));
    challengeReviewDTO.setFileUpload(GeneralHelper.promptChllengeReviewFileUpload()); 
    //    challengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    challengeReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    //    if (challengeDTO.getReviewCount() == 0) {
    //      challengeDTO.setReviewCount(1);
    //    } else {
    //      challengeDTO.setReviewCount(challengeReviewDao.getNextNum(challengeDTO));
    //    }
    //
    //    challengeReviewDTO.setReviewNo(challengeDTO.getReviewCount()); // 해당 챌린지 리뷰의 마지막 번호기억 + 1

    while (true) {
      String input = Prompt.inputString("해당 챌린지에 참여인증&댓글등록을 하시겠습니까? (y/N) ");
      System.out.println();
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("댓글 등록이 취소되었습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {

        // 포인트 적립 (10포인트)
        //        AuthLoginHandler.getLoginUser().setPoint(AuthLoginHandler.getLoginUser().getPoint() + CHALLENGE_REVIEWPOINT);

        // 리뷰어 등록
        challengeDTO.addReviewer(AuthLoginHandler.getLoginUser());
        System.out.println(challengeDTO.getReviewerNames()); // 리뷰어 등록 테스트

        //        challengeDao.update(challengeDTO);

        try {
          challengeDao.update(challengeDTO);
          challengeReviewDao.insert(challengeReviewDTO);
          System.out.println("insert등록확인");
          for (ChallengeReviewAttachedFile challengeReviewAttachedFile : challengeReviewDTO.getFileUpload()) {
            challengeReviewDao.insertFile(challengeReviewDTO.getNo(), challengeReviewAttachedFile.getFilepath());
            System.out.println("insert파일등록확인");
          }
          sqlSession.commit();
          System.out.println("챌린지리뷰 커밋확인");
        } catch (Exception e) {
          e.printStackTrace();
          sqlSession.rollback();
          System.out.println("챌린지리뷰 롤백확인");
        }

        System.out.println();
        System.out.println("참여인증&댓글이 등록이 완료되었습니다.");
        break;

      } else {
        System.out.println("다시입력해주세요");
      }
    }
  }
}
