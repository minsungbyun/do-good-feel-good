package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;

public class AdminChallengeListHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeListHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[챌린지 목록]");
    for (ChallengeDTO challengeDTO : challengeDTOList) {
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
