package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewListHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewListHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
        List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 목록]");
    System.out.println(" ▶ 참여인증&댓글 목록을 확인하고 싶은 챌린지 번호를 입력해주세요.");
    System.out.println();

    int challengeNo = Prompt.inputInt("챌린지 번호: ");
    System.out.println();

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
      System.out.printf("%d, %s, %s, %s, %s\n", 
          challengeReviewDTO.getNo(), 
          challengeReviewDTO.getOwner().getId(),
          challengeReviewDTO.getContent(),
          challengeReviewDTO.getFileUpload(),
          challengeReviewDTO.getRegisteredDate());
    }
    }
  }
  }

