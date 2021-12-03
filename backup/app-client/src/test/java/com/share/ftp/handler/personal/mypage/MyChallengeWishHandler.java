package com.share.ftp.handler.personal.mypage;

import java.util.Collection;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyChallengeWishHandler implements Command {

  ChallengeDao challengeDao;

  public MyChallengeWishHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<ChallengeDTO> challengeList = challengeDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (ChallengeDTO challengeDTO : challengeList) {
      if (challengeDTO.getWish().equals(AuthLoginHandler.getLoginUser())) {
        System.out.printf("%d, %s[%d], %s, %d, %s ~ %s\n", 
            challengeDTO.getNo(),
            //          challengeDTO.getAdminId(), 
            challengeDTO.getTitle(), 
            challengeDTO.getReviewCount(), 
            challengeDTO.getAdmin().getName(),
            challengeDTO.getTotalJoinCount(),
            challengeDTO.getStartDate(),
            challengeDTO.getEndDate());
      }
    }
  }
}
