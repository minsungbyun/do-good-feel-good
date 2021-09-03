package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewAddHandler extends AbstractChallengeReviewHandler {
	
  public ChallengeReviewAddHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    super(myChallengeReviewDTOList);
  }
  
  @Override
  public void execute() {
    System.out.println("[참여인증&댓글 등록]");

    MyChallengeReviewDTO myChallengeReviewDTO = new MyChallengeReviewDTO();

    myChallengeReviewDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeReviewDTO.setMemberId(Prompt.inputString("아이디: "));
    myChallengeReviewDTO.setContent(Prompt.inputString("내용: "));
    myChallengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    myChallengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    myChallengeReviewDTOList.add(myChallengeReviewDTO);
  }
  
}
