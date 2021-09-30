package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.personal.challenge.AbstractChallengeQuestionHandler;
import com.share.util.Prompt;

public class AdminChallengeQuestionListHandler extends AbstractChallengeQuestionHandler {
  public AdminChallengeQuestionListHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList, List<ChallengeQuestionDTO> challengeReplyList) {
    super(challengeQuestionDTOList, challengeDTOList, challengeReplyList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {

      int challengeNo = (int) request.getAttribute("challengeNo");

      ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);

      //      int questionNo = (int) request.getAttribute("questionNo");
      //      ChallengeQuestionDTO detailNo = findByQuestionNo();

      System.out.println();
      System.out.printf("[ %d번 챌린지 문의 목록 ]", challengeNo);
      System.out.println();



      if (challengeQuestionDTOList.isEmpty()) {
        System.out.println("문의가 없습니다.");
        return;
      }

      //      if (detailNo == null) {
      //        System.out.println("문의가 없습니다.");
      //        return;
      //      }

      for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
        if (challengeQuestionDTO.getNo() == challengeNo) {
          System.out.printf("%d, %d, %s, %s, %s\n", 
              challengeQuestionDTO.getNo(),
              challengeQuestionDTO.getQuestionNo(),
              challengeQuestionDTO.getOwner().getId(),
              challengeQuestionDTO.getContent(),
              challengeQuestionDTO.getRegisteredDate());
        } 
      }

      //      for (ChallengeQuestionDTO challengeReply : challengeReplyList) {
      //        if (challengeReply.getOwner().getId().equals("admin")) {
      //          System.out.printf("%d, %d, %s, %s, %s\n", 
      //              challengeReply.getNo(),
      //              challengeReply.getQuestionNo(),
      //              challengeReply.getOwner().getName(),
      //              challengeReply.getContent(),
      //              challengeReply.getRegisteredDate());
      //        }
      //      }

      System.out.println();
      System.out.println("1번 ▶ 답글 등록, 변경, 삭제");
      //      System.out.println("2번 ▶ 문의 변경, 삭제");
      System.out.println("2번 ▶ 문의 검색");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/adminChallenge/replyConnect").forward(request); break;
        //        case 2: request.getRequestDispatcher("/challengeQuestion/connect").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeQuestion/search").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}
