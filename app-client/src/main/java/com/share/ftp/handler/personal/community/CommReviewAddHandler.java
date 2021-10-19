package com.share.ftp.handler.personal.community;

import java.sql.Date;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewAddHandler implements Command {

  CommunityDao communityDao;

  public CommReviewAddHandler(CommunityDao communityDao) {
    this.communityDao = communityDao;
  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한줄후기 등록  ]");


    if (!generalRequestDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("봉사 참여한 회원만 등록이 가능합니다!");
      return;

      CommReviewDTO commReviewDTO = new CommReviewDTO();

      commReviewDTO.setNo(communityDao.getNextNumCommReview());
      commReviewDTO.setContent(Prompt.inputString("내용  ▶ "));
      commReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
      commReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

      communityDao.insertReview(commReviewDTO);

      System.out.println();
      System.out.println("[  후기가 등록 되었습니다. ]");
    }
  }

}








