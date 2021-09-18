package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler extends AbstractChallengeReviewHandler {


  public ChallengeReviewAddHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
      List<ChallengeDTO> challengeDTOList) {
    super(challengeReviewDTOList, challengeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 등록]");
    System.out.println(" ▶ 챌린지 번호를 입력해주세요 ");
    System.out.println();
    int challengeNo = Prompt.inputInt("챌린지 번호: ");

    ChallengeDTO challengeDTO = findByChallengeNo(challengeNo);


    if (challengeDTO == null) {
      System.out.println();
      System.out.println("해당 챌린지가 없습니다!");
    }

    System.out.printf("챌린지 제목: %s\n"
        //        + "챌린지 시작기간: %s\n"
        //        + "챌린지 종료기간: %s\n"
        + "챌린지 내용: %s\n"
        + "첨부파일: %s\n"
        + "등록날짜: %s\n\n",

        challengeDTO.getTitle(),     
        //challengeDTO.getStartDate(),  // 시작날짜
        //challengeDTO.getEndDate(),  // 끝나는 날짜
        challengeDTO.getContent(),
        challengeDTO.getFileUpload(),
        challengeDTO.getRegisteredDate());

    String input = Prompt.inputString("해당 챌린지에 참여인증&댓글등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 챌린지 참여를 취소하였습니다.");
      return;
    }

    //    if (challengeDTO.getMemberNames() != AuthLoginHandler.getLoginUser().getName()) {
    //      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
    //      return;
    //    }

    ChallengeReviewDTO challengeReviewDTO = new ChallengeReviewDTO();

    challengeReviewDTO.setNo(challengeDTO.getNo());
    challengeReviewDTO.setContent(Prompt.inputString("내용: "));
    challengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    challengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    challengeReviewDTO.setOwner(AuthLoginHandler.getLoginUser());



    //    int count = challengeReviewDTOList.get(challengeReviewDTO.getNo() - 1).getReviewNo();

    // 각 챌린지에서 댓글이 비었을 때 초기값 1설정 이후에는 1씩 증가

    //    if (challengeReviewDTOList.isEmpty()) {
    //
    //    }

    //    if (challengeDTO.getNo() == challengeReviewDTO.getNo()) {
    //      challengeReviewDTO.setReviewNo(1);
    //      System.out.println("초기화");
    //    } else {
    //      challengeReviewDTO.setReviewNo(getNextNum());
    //    }

    System.out.println("챌린지 번호 = " + challengeDTO.getNo());

    if (challengeDTO.getReviewCount() == 0) {
      challengeReviewDTO.setReviewNo(1);
      System.out.println("각 챌린지의 첫 댓글입니다");
    } else {
      challengeReviewDTO.setReviewNo(getNextNum());
    }
    challengeDTO.setReviewCount(challengeReviewDTO.getReviewNo());
    System.out.println("challengeDTO.getReviewCount() = " + challengeDTO.getReviewCount());


    //    challengeReviewDTO.setReviewNo(getNextNum());

    //      challengeReviewDTO.setReviewNo(1);
    //    challengeReviewDTO.setReviewNo(getNextNum(challengeDTO.getNo(),challengeReviewDTO));
    //    System.out.println("challengeReviewDTO.getNo() = " + challengeReviewDTO.getNo());
    //    System.out.println("challengeReviewDTO.getReviewNo() = " + challengeReviewDTO.getReviewNo());

    challengeReviewDTOList.add(challengeReviewDTO);
    System.out.println("총 댓글 개수 = " + challengeReviewDTOList.size());

    System.out.println();
    System.out.println("참여인증&댓글이 등록이 완료되었습니다.");
  }



}
