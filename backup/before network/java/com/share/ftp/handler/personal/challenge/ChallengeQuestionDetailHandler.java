package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionDetailHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionDetailHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 상세보기 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    int questionNo = Prompt.inputInt("문의 번호를 입력해주세요 ▶ ");

    ChallengeQuestionDTO challengeQuestion = findByQuestionNo(questionNo);

    if (challengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }


    if ((challengeQuestion.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
        if (challengeQuestionDTO.getNo() == challengeNo) {
          System.out.printf("아이디: %s\n", challengeQuestion.getOwner().getId());
          System.out.printf("제목: %s\n", challengeQuestion.getTitle());
          System.out.printf("내용: %s\n", challengeQuestion.getContent());
          System.out.printf("등록날짜: %s\n", challengeQuestion.getRegisteredDate());
        } 
      }
    } else {
      System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
      return;
    }

    System.out.println();

    request.setAttribute("questionNo", questionNo); 


    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 문의 변경");
      System.out.println("2번 ▶ 문의 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeQuestion/update").forward(request); return;
        case 2: request.getRequestDispatcher("/challengeQuestion/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}

