package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;
public class ChallengeReviewDeleteHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeReviewDeleteHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println();
      System.out.println("[ 참여인증&댓글 삭제 ]");
      System.out.println();

      int challengeNo = (int) request.getAttribute("challengeNo");
      ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

      int challengeReviewNo = (int) request.getAttribute("challengeReviewNo");
      ChallengeReviewDTO challengeReviewDTO = challengeDao.findByChallengeReviewNo(challengeNo, challengeReviewNo);

      if (challengeReviewDTO == null) {
        System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
        return;
      }

      if ((challengeReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      } else {
        System.out.println("삭제 권한이 없습니다.");
        return;
      }

      while (true) {
        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println();
          System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
          return;

        } else if (input.equalsIgnoreCase("y")) {
          System.out.println();
          challengeDTO.setReviewCount(challengeDTO.getReviewCount() - 1);
          //          AuthLoginHandler.getLoginUser().setPoint(AuthLoginHandler.getLoginUser().getPoint() - CHALLENGE_REVIEWPOINT);
          challengeDTO.removeReviewer(AuthLoginHandler.getLoginUser()); 

          challengeDao.update(challengeDTO);
          challengeDao.deleteReview(challengeReviewDTO);
          System.out.println("참여인증&댓글을 삭제하였습니다.");
          return;

        } else {
          System.out.println("y 또는 n을 입력하세요.");

        }
      }
    }
  }
}
