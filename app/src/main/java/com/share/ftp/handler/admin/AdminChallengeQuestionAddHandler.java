package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.AdminChallengeQuestionDTO;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.personal.challenge.AbstractChallengeQuestionHandler;
import com.share.util.Prompt;

public class AdminChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {

  public AdminChallengeQuestionAddHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의답글 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


    //    if (challengeDTO == null) {
    //      System.out.println();
    //      System.out.println("해당 챌린지가 없습니다!");
    //    }


    int challengeQuestionNo = (int) request.getAttribute("no");

    ChallengeQuestionDTO challengeQuestionDTO = findByQuestionNo(challengeQuestionNo);

    String input = Prompt.inputString("해당 문의에 답글등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 챌린지에 문의등록을 취소하였습니다.");
      return;
    }


    AdminChallengeQuestionDTO adminChallengeQuestionDTO = new AdminChallengeQuestionDTO();

    adminChallengeQuestionDTO.setNo(challengeDTO.getNo());
    adminChallengeQuestionDTO.setNo(challengeQuestionNo);
    adminChallengeQuestionDTO.setTitle(Prompt.inputString("제목: "));
    adminChallengeQuestionDTO.setContent(Prompt.inputString("내용: "));
    adminChallengeQuestionDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    adminChallengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

    //    challengeQuestionDTO.setNo(getNextNum());

    if (challengeDTO.getQuestionCount() == 0) {
      challengeDTO.setQuestionCount(1);
      //      System.out.println("각 챌린지의 첫 문의입니다");
    } else {
      challengeDTO.setQuestionCount(getNextQuestionNum(challengeDTO));
      //      challengeReviewDTO.setReviewNo(getNextNum2()); // 해당 챌린지 문의의 마지막 번호기억 + 1
      //      System.out.println("현재 문의의 번호는? (challengeReviewDTO.getQuestionNo()) " + challengeQuestionDTO.getQuestionNo());
      //      System.out.println("현재 문의의 번호는? (challengeDTO.getQuestionCount()) " + challengeDTO.getQuestionCount());
    }
    //    challengeDTO.setReviewCount(challengeReviewDTO.getReviewNo());
    challengeQuestionDTO.setQuestionNo(challengeDTO.getQuestionCount()); // 해당 챌린지 문의의 마지막 번호기억 + 1
    //    System.out.println("challengeDTO.getQuestionCount() = " + challengeDTO.getQuestionCount());

    challengeQuestionDTOList.add(challengeQuestionDTO);

    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
