package com.share.ftp.handler.personal.challenge;

import java.util.Collection;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeReviewListHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeReviewListHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 참여인증&댓글 목록 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");
    challengeDao.findByChallengeNo(challengeNo);

    //    if (challengeReviewDao.isEmpty()) {
    //      System.out.println("참여인증&댓글이 없습니다.");
    //    }

    Collection<ChallengeReviewDTO> challengeReviewList = challengeDao.findAllReview();

    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewList) {
      if (challengeReviewDTO.getNo() == challengeNo) {
        System.out.printf("%d, %d, %s, %s, %s, %s\n", 
            challengeReviewDTO.getNo(),
            challengeReviewDTO.getReviewNo(),
            challengeReviewDTO.getOwner().getId(),
            challengeReviewDTO.getContent(),
            challengeReviewDTO.getFileUpload(),
            challengeReviewDTO.getRegisteredDate());
      } 
      //      else {
      //        System.out.println("참여인증&댓글이 없습니다.");
      //        return;
      //      }
    }

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 참여인증&댓글 등록");
      System.out.println("2번 ▶ 참여인증&댓글 변경, 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeReview/add").forward(request); return;
        case 2: request.getRequestDispatcher("/challengeReview/connect").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}

