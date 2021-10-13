package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardDeleteHandler implements Command {

  CommunityDao communityDao;

  public CommBoardDeleteHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    try {

      System.out.println();
      System.out.println("[  나눔이야기 게시글 삭제  ]");

      int commBoardNo = (int) request.getAttribute("commBoardNo");

      CommBoardDTO commBoardDTO = communityDao.findByCommBoardNo(commBoardNo);


      if (commBoardDTO == null) {
        System.out.println("[ 해당 게시글이 없습니다.  ]");
        return;
      }

      if ((commBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      } else {
        System.out.println("삭제 권한이 없습니다.");
        return;
      }

      String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  게시글 삭제를 취소하였습니다.  ]");
        return;
      } 

      communityDao.delete(commBoardDTO);

      System.out.println();
      System.out.println("[  게시글을 삭제하였습니다. ]");

    } catch (Throwable e) {

    }
  }
}



