package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionListHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 목록 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    if (challengeQuestionDTOList.isEmpty()) {
      System.out.println("문의가 없습니다.");
      return;
    }

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeQuestionDTO.getNo() == challengeNo && !challengeQuestionDTO.getOwner().getId().equals("admin")) {
        System.out.printf("%d, %d, %s, %s, %s\n", 
            challengeQuestionDTO.getNo(),
            challengeQuestionDTO.getQuestionNo(),
            challengeQuestionDTO.getOwner().getId(),
            challengeQuestionDTO.getTitle(),
            challengeQuestionDTO.getRegisteredDate());
      }
    }

    for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeQuestionDTO.getOwner().getId().equals("admin")) {
        System.out.printf("관리자답글 :  %s, %s, %s\n", 
            challengeQuestionDTO.getOwner().getId(),
            challengeQuestionDTO.getContent(),
            challengeQuestionDTO.getRegisteredDate());
      }
    }

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 문의 검색");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeQuestion/search").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}
