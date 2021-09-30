package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.personal.challenge.AbstractChallengeQuestionHandler;
import com.share.util.Prompt;

public class AdminChallengeReplyAddHandler extends AbstractChallengeQuestionHandler {

  public AdminChallengeReplyAddHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList, List<ChallengeQuestionDTO> challengeReplyList) {
    super(challengeQuestionDTOList, challengeDTOList, challengeReplyList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 문의답글 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


    int questionNo = (int) request.getAttribute("questionNo");
    ChallengeQuestionDTO challengeQuestion = findByQuestionNo(questionNo);

    //    if (!challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
    //      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
    //      return;
    //    }

    ChallengeQuestionDTO challengeReply = new ChallengeQuestionDTO();

    challengeReply.setNo(challengeDTO.getNo());
    challengeReply.setContent(Prompt.inputString("내용: "));
    challengeReply.setRegisteredDate(new Date(System.currentTimeMillis()));

    challengeReply.setOwner(AuthLoginHandler.getLoginUser());

    //    challengeQuestionDTO.setNo(getNextNum());

    if (challengeQuestion.getReplyCount() == 0) {
      challengeQuestion.setReplyCount(1);
      //      System.out.println("각 챌린지의 첫 문의입니다");
    } else {
      challengeQuestion.setReplyCount(getNextReplyNum(challengeQuestion));
      //      challengeReviewDTO.setReviewNo(getNextNum2()); // 해당 챌린지 문의의 마지막 번호기억 + 1
      //      System.out.println("현재 문의의 번호는? (challengeReviewDTO.getQuestionNo()) " + challengeQuestionDTO.getQuestionNo());
      //      System.out.println("현재 문의의 번호는? (challengeDTO.getQuestionCount()) " + challengeDTO.getQuestionCount());
    }
    //    challengeDTO.setReviewCount(challengeReviewDTO.getReviewNo());
    challengeReply.setQuestionNo(challengeQuestion.getReplyCount()); // 해당 챌린지 문의의 마지막 번호기억 + 1
    //    System.out.println("challengeDTO.getQuestionCount() = " + challengeDTO.getQuestionCount());

    String input = Prompt.inputString("해당 문의에 답글 등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 문의에 답글 등록을 취소하였습니다.");
      return;
    }

    challengeQuestionDTOList.add(challengeQuestion.getQuestionNo(), challengeReply);
    //    challengeQuestionDTOList.add(challengeReply);

    System.out.println();
    System.out.println("문의답글 등록이 완료되었습니다.");
  }
}
