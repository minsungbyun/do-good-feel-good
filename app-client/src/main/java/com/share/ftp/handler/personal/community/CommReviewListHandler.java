package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewListHandler implements Command {

  CommunityDao communityDao;

  public CommReviewListHandler(CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {


    System.out.println();
    System.out.println("[  한줄후기 목록  ]");
    System.out.println();

    int commBoardNo = (int) request.getAttribute("commBoardNo");
    communityDao.findByCommBoardNo(commBoardNo);

    //
    //    if (commReviewDTOList.isEmpty()) {
    //      System.out.println("[  작성된 후기가 없습니다.  ]");
    //      return;
    //    }

    Collection<CommReviewDTO> commReviewDTOList = communityDao.findAllCommReview();

    for (CommReviewDTO commReviewDTO : commReviewDTOList) {
      System.out.printf("%d, %s, %s, %s\n", 
          commReviewDTO.getCommReviewNo(), 
          commReviewDTO.getOwner().getId(), 
          commReviewDTO.getContent(),
          commReviewDTO.getRegisteredDate());
    }

    System.out.println();

    int commReviewNo = Prompt.inputInt("변경, 삭제하고자 하는 후기 번호를 입력해주세요 (이전: 0) ▶ ");

    if (commReviewNo == 0) {
      return;
    }

    CommReviewDTO commReview = communityDao.findByCommReviewNo(commReviewNo);

    if (commReview == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    //      if (!commReview.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
    //        System.out.println("변경 권한이 없습니다.");
    //        return;  
    //      }

    if (!commReview.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;  
    }

    request.setAttribute("commReviewNo", commReviewNo);

    while (true) {
      String input = Prompt.inputString ("변경(U), 삭제(D), 이전(0) ▶ ");
      switch (input) {
        case "U":
        case "u" :
          request.getRequestDispatcher("/commReview/update").forward(request);
          return;

        case "D":
        case "d":
          request.getRequestDispatcher("/commReview/delete").forward(request);
          return;

        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");

      }
    }
  }
}
