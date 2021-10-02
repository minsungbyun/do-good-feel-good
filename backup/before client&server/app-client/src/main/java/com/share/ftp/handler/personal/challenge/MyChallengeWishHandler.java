package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyChallengeWishHandler extends AbstractAdminChallengeHandler {

  public MyChallengeWishHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 나의 찜한목록 ]");
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getWish() == AuthLoginHandler.getLoginUser()) {
        System.out.printf("%d, %s[%d], %s, %d, %s ~ %s\n", 
            challengeDTO.getNo(), 
            //          challengeDTO.getAdminId(), 
            challengeDTO.getTitle(), 
            challengeDTO.getReviewCount(), 
            challengeDTO.getAdmin().getName(),
            challengeDTO.getTotalJoinCount(),
            //          challengeDTO.getFileUpload(), 
            challengeDTO.getStartDate(),
            challengeDTO.getEndDate());

      }
    }

  }

}
