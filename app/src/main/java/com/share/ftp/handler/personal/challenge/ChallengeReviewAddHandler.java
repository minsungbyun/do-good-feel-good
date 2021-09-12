package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler extends AbstractChallengeReviewHandler {

  public ChallengeReviewAddHandler(List<ChallengeReviewDTO> ChallengeReviewDTOList) {
    super(ChallengeReviewDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 등록]");

    ChallengeReviewDTO ChallengeReviewDTO = new ChallengeReviewDTO();

    ChallengeReviewDTO.setNo(Prompt.inputInt("번호: "));
    ChallengeReviewDTO.setContent(Prompt.inputString("내용: "));
    ChallengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    ChallengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    ChallengeReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    ChallengeReviewDTOList.add(ChallengeReviewDTO);

    System.out.println();
    System.out.println("참여인증&댓글이 등록이 완료되었습니다.");
  }

}
