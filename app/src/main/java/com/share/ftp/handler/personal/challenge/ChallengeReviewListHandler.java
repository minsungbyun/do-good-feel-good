package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewListHandler extends AbstractChallengeReviewHandler {



  public ChallengeReviewListHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[참여인증&댓글 목록]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    if (challengeReviewDTOList.isEmpty()) {
      System.out.println("참여인증&댓글이 없습니다.");
      return;
    }
    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewDTOList) {
      if (challengeReviewDTO.getNo() == challengeNo) {
        System.out.printf("%d, %d, %s, %s, %s, %s\n", 
            challengeReviewDTO.getNo(),
            challengeReviewDTO.getReviewNo(),
            challengeReviewDTO.getOwner().getId(),
            challengeReviewDTO.getContent(),
            challengeReviewDTO.getFileUpload(),
            challengeReviewDTO.getRegisteredDate());
      }
    }
    System.out.println();
    System.out.println("변경, 삭제하고자 하는 댓글 번호를 입력해주세요.");
    int reviewNo = Prompt.inputInt("번호? (이전: 0) > ");

    if (reviewNo == 0) {
      return;
    }

    ChallengeReviewDTO challengeReviewDTO = findByReviewNo(reviewNo);

    if (challengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    if (!challengeReviewDTO.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    request.setAttribute("reviewNo", reviewNo); 


    while (true) {
      System.out.println();
      System.out.println("1번: 참여인증&댓글 변경");
      System.out.println("2번: 참여인증&댓글 삭제");
      System.out.println("0번: 이전");
      int input = Prompt.inputInt("번호 입력 > ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeReview/update").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeReview/delete").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}

