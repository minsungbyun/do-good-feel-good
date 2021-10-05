package com.share.ftp.handler.personal.challenge;

import static com.share.util.General.point.CHALLENGE_REVIEWPOINT;
import java.sql.Date;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler implements Command {

  ChallengeReviewDao challengeReviewDao;
  ChallengeDao challengeDao;

  public ChallengeReviewAddHandler(ChallengeReviewDao challengeReviewDao,
      ChallengeDao challengeDao) {
    this.challengeReviewDao = challengeReviewDao;
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 참여인증&댓글 등록 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);


    if (challengeDTO == null) {
      System.out.println();
      System.out.println("해당 챌린지가 없습니다!");
    }

    //    for (ChallengeReviewDTO challengeReviewDTO : challengeReviewDTOList) {
    //      if (challengeReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
    //        System.out.println("이미 참여하셨습니다.");
    //        return;
    //      } 
    //    }


    //    System.out.printf("챌린지 제목: %s\n"
    //        //        + "챌린지 시작기간: %s\n"
    //        //        + "챌린지 종료기간: %s\n"
    //        + "챌린지 내용: %s\n"
    //        + "첨부파일: %s\n"
    //        + "등록날짜: %s\n\n",
    //
    //        challengeDTO.getTitle(),     
    //        //challengeDTO.getStartDate(),  // 시작날짜
    //        //challengeDTO.getEndDate(),  // 끝나는 날짜
    //        challengeDTO.getContent(),
    //        challengeDTO.getFileUpload(),
    //        challengeDTO.getRegisteredDate());


    if (!challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("챌린지 참여한 회원만 등록이 가능합니다!");
      return;
    }

    // 리뷰어로 참여 한 경우 중복 참여 불가!
    if (challengeDTO.getReviewers().contains(AuthLoginHandler.getLoginUser())) {
      System.out.println("리뷰는 한 번만 작성할 수 있습니다!");
      return;
    }


    ChallengeReviewDTO challengeReviewDTO = new ChallengeReviewDTO();

    challengeReviewDTO.setNo(challengeDTO.getNo());
    challengeReviewDTO.setContent(Prompt.inputString("내용 ▶ "));
    challengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부 ▶ "));
    challengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    challengeReviewDTO.setOwner(AuthLoginHandler.getLoginUser());


    //    System.out.println("챌린지 번호 = " + challengeDTO.getNo());

    if (challengeDTO.getReviewCount() == 0) {
      challengeDTO.setReviewCount(1);
      //      System.out.println("각 챌린지의 첫 댓글입니다");
    } else {
      challengeDTO.setReviewCount(challengeReviewDao.getNextReviewNum(challengeDTO));
      //      challengeReviewDTO.setReviewNo(getNextNum2()); // 해당 챌린지 리뷰의 마지막 번호기억 + 1
      //      System.out.println("현재 댓글의 번호는? (challengeReviewDTO.getReviewNo()) " + challengeReviewDTO.getReviewNo());
      //      System.out.println("현재 댓글의 번호는? (challengeDTO.getReviewCount()) " + challengeDTO.getReviewCount());
    }
    //    challengeDTO.setReviewCount(challengeReviewDTO.getReviewNo());
    challengeReviewDTO.setReviewNo(challengeDTO.getReviewCount()); // 해당 챌린지 리뷰의 마지막 번호기억 + 1
    //    System.out.println("challengeDTO.getReviewCount() = " + challengeDTO.getReviewCount());



    while (true) {
      String input = Prompt.inputString("해당 챌린지에 참여인증&댓글등록을 하시겠습니까? (y/N) ");
      System.out.println();
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("댓글 등록이 취소되었습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {

        // 포인트 적립 (10포인트)
        AuthLoginHandler.getLoginUser().setPoint(AuthLoginHandler.getLoginUser().getPoint() + CHALLENGE_REVIEWPOINT);

        // 리뷰어 등록
        challengeDTO.addReviewer(AuthLoginHandler.getLoginUser());

        challengeReviewDao.insertReview(challengeReviewDTO);
        //    System.out.println("총 댓글 개수 = " + challengeReviewDTOList.size());

        System.out.println();
        System.out.println("참여인증&댓글이 등록이 완료되었습니다.");
        break;

      } else {
        System.out.println("다시입력해주세요");

      }
    }
  }
}
