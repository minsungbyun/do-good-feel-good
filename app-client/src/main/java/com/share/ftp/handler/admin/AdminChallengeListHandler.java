package com.share.ftp.handler.admin;

import java.util.Collection;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class AdminChallengeListHandler implements Command {

  ChallengeDao challengeDao;


  public AdminChallengeListHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 챌린지 목록 ]");

    Collection<ChallengeDTO> challengeList = challengeDao.findAll();

    for (ChallengeDTO challengeDTO : challengeList) {
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
