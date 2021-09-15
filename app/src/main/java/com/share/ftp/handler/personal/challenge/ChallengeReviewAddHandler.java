package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;

import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler extends AbstractChallengeReviewHandler {

  int no; // 번호 자동부여

  public ChallengeReviewAddHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
        List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 등록]");
    System.out.println(" ▶ 참여인증&댓글등록을 원하는 챌린지 번호를 입력해주세요 ");
    System.out.println();
    int challengeNo = Prompt.inputInt("챌린지 번호: ");

    ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


    if (challengeDTO == null) {
      System.out.println("존재하지 않는 챌린지입니다");
    }

    System.out.printf("챌린지 번호: %d\n"
        + "챌린지 제목: %s\n"
//        + "챌린지 시작기간: %s\n"
//        + "챌린지 종료기간: %s\n"
        + "챌린지 내용: %s\n"
        + "첨부파일: %s\n"
        + "등록날짜: %s\n\n",

        challengeDTO.getNo(),      
        challengeDTO.getTitle(),     
        //challengeDTO.getStartDate(),  // 시작날짜
        //challengeDTO.getEndDate(),  // 끝나는 날짜
        challengeDTO.getContent(),
        challengeDTO.getFileUpload(),
        challengeDTO.getRegisteredDate());

    String input = Prompt.inputString("해당 챌린지에 참여인증&댓글등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("해당 챌린지 참여를 취소하였습니다.");
      return;
    }

    ChallengeReviewDTO challengeReviewDTO = new ChallengeReviewDTO();

    challengeReviewDTO.setNo(challengeDTO.getNo());
    challengeReviewDTO.setContent(Prompt.inputString("내용: "));
    challengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    challengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    challengeReviewDTO.setOwner(AuthLoginHandler.getLoginUser());
    challengeReviewDTO.setNo(++no); // 번호 자동부여

    challengeReviewDTOList.add(challengeReviewDTO);

    System.out.println();
    System.out.println("참여인증&댓글이 등록이 완료되었습니다.");
  }

}
