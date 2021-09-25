package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeQuestionAddHandler extends AbstractChallengeQuestionHandler {


  public ChallengeQuestionAddHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeQuestionDTOList, challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("no");

    ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


    if (challengeDTO == null) {
      System.out.println();
      System.out.println("해당 챌린지가 없습니다!");
    }

    //    System.out.printf("챌린지 번호: %d\n"
    //        + "챌린지 제목: %s\n"
    //        //        + "챌린지 시작기간: %s\n"
    //        //        + "챌린지 종료기간: %s\n"
    //        + "챌린지 내용: %s\n"
    //        + "첨부파일: %s\n"
    //        + "등록날짜: %s\n\n",
    //
    //        challengeDTO.getNo(),      
    //        challengeDTO.getTitle(),     
    //        //challengeDTO.getStartDate(),  // 시작날짜
    //        //challengeDTO.getEndDate(),  // 끝나는 날짜
    //        challengeDTO.getContent(),
    //        challengeDTO.getFileUpload(),
    //        challengeDTO.getRegisteredDate());

    String input = Prompt.inputString("해당 챌린지에 문의등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 챌린지에 문의등록을 취소하였습니다.");
      return;
    }


    if (!challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
      return;
    }

    ChallengeQuestionDTO challengeQuestionDTO = new ChallengeQuestionDTO();

    challengeQuestionDTO.setNo(challengeDTO.getNo());
    challengeQuestionDTO.setTitle(Prompt.inputString("제목: "));
    challengeQuestionDTO.setContent(Prompt.inputString("내용: "));
    challengeQuestionDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    challengeQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

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
