package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler extends AbstractChallengeReviewHandler {
	
  public ChallengeReviewAddHandler(List<ChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }
  
  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 등록]");

    ChallengeReviewDTO myChallengeReviewDTO = new ChallengeReviewDTO();

    myChallengeReviewDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeReviewDTO.setMemberId(Prompt.inputString("아이디: "));
    myChallengeReviewDTO.setContent(Prompt.inputString("내용: "));
    myChallengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    myChallengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    myChallengeReviewDTOList.add(myChallengeReviewDTO);
  }
  
}
