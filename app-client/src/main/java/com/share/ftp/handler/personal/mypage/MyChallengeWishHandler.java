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

    Collection<ChallengeDTO> challengeWishList = challengeDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (ChallengeDTO challengeWish : challengeWishList) {
      if (challengeWish.getWish().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
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
