package com.share.ftp.handler.personal.mypage;

import java.util.List;
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

    List<ChallengeDTO> challengeList = challengeDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (ChallengeDTO challengeWish : challengeList) {
      if (challengeWish.getMemberNames().contains(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %s[%d], %d, %s ~ %s\n", 
            challengeWish.getNo(),
            //          challengeDTO.getAdminId(), 
            challengeWish.getTitle(), 
            challengeWish.getReviewCount(), 
            //            challengeDTO.getAdmin().getName(),
            challengeWish.getTotalJoinCount(),
            challengeWish.getStartDate(),
            challengeWish.getEndDate());
      }
    }
  }
}
