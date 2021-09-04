package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;

public class AdminChallengeListHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeListHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  public void execute() {
    System.out.println("[챌린지 목록]");
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          challengeDTO.getNo(), 
          challengeDTO.getAdminId(), 
          challengeDTO.getTitle(), 
          challengeDTO.getContent(), 
          challengeDTO.getFileUpload(), 
          challengeDTO.getRegisteredDate());
    }
  }
}
