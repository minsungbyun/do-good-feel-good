package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewConnectHandler implements Command {

  ChallengeReviewDao challengeReviewDao;

  public ChallengeReviewConnectHandler(ChallengeReviewDao challengeReviewDao) {
    this.challengeReviewDao = challengeReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 참여인증&댓글 변경, 삭제]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    int challengeReviewNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");

    ChallengeReviewDTO challengeReviewDTO = challengeReviewDao.findByNo(challengeNo, challengeReviewNo);

    if (challengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    if (challengeReviewDTO.getOwner().getNo() == AuthLoginHandler.getLoginUser().getNo() ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("아이디: %s\n", challengeReviewDTO.getOwner().getId());
      System.out.printf("내용: %s\n", challengeReviewDTO.getContent());
      System.out.printf("등록날짜: %s\n", challengeReviewDTO.getRegisteredDate());

    } else {
      System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
      return;
    }

    System.out.println();

    request.setAttribute("challengeReviewNo", challengeReviewNo); 

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