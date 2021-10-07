package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewDeleteHandler implements Command {

  CommunityDao communityDao;

  public CommReviewDeleteHandler(CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {

      System.out.println();
      System.out.println("[  한 줄 후기 삭제  ]");
      int commReviewNo = Prompt.inputInt("[  번호?  ]");

      CommReviewDTO commReview = communityDao.findByCommReviewNo(commReviewNo);

      try {

        if (commReview == null) {
          System.out.println("[  해당 번호의 게시글이 없습니다.  ]");
          return;
        }

        if (commReview.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("[  삭제 권한이 없습니다.  ]");
          return;
        }

        String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
        if (input.equalsIgnoreCase("n")) {
          System.out.println("[  게시글 삭제를 취소하였습니다.  ]");
          return;

        } else if(input.equals("y")) {
          System.out.println("[  ✔️ 게시글이 삭제 되었습니다. ]");
          communityDao.deleteCommeReview(commReviewNo);
          return;
        }

        else  {
          System.out.println("[  y 또는 n을 입력하세요.  ]");
          continue;  
        } 


      } catch (Throwable e) {

      }
    }
  }
}














