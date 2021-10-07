package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewConnectHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeReviewConnectHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 참여인증&댓글 변경, 삭제]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

    int reviewNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");

    //    if (reviewNo == 0) {
    //      return;
    //    }

    ChallengeReviewDTO challengeReviewDTO = challengeDao.findByChallengeReviewNo(challengeNo, reviewNo);

    if (challengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }


    //    if (challengeReviewDTO.getContent().equals("삭제된 댓글입니다")) {
    //      System.out.println();
    //      System.out.println("이미 삭제 된 댓글입니다!");
    //      return;
    //
    //    }

    if (!challengeReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    request.setAttribute("reviewNo", reviewNo); 


    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 참여인증&댓글 변경");
      System.out.println("2번 ▶ 참여인증&댓글 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeReview/update").forward(request); return;
        case 2: request.getRequestDispatcher("/challengeReview/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}