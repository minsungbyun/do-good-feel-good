package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewUpdateHandler implements Command {

  ChallengeDao challengeDao;
  ChallengeReviewDao challengeReviewDao;

  public ChallengeReviewUpdateHandler(ChallengeDao challengeDao, ChallengeReviewDao challengeReviewDao) {
    this.challengeDao = challengeDao;
    this.challengeReviewDao = challengeReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 참여인증&댓글 수정 ]");

    int challengeNo = (int) request.getAttribute("challengeNo");

    int challengeReviewNo = (int) request.getAttribute("challengeReviewNo");

    ChallengeReviewDTO challengeReviewDTO = challengeReviewDao.findByNo(challengeNo, challengeReviewNo);

    if (challengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    if (!challengeReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", challengeReviewDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", challengeReviewDTO.getFileUpload()));

    while (true) {
      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("참여인증&댓글 수정을 취소하였습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        challengeReviewDTO.setContent(content);
        challengeReviewDTO.setFileUpload(fileUpload);
        challengeReviewDao.update(challengeReviewDTO);

        System.out.println("참여인증&댓글을 수정하였습니다.");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 
    }
  }
}
