package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardDeleteHandler implements Command {

  CommunityDao commBoardDao;

  public CommBoardDeleteHandler(CommunityDao commBoardDao) {
    this.commBoardDao =  commBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[  메인/소통해요/나눔이야기/게시글삭제  ]");
      int commNo = (int) request.getAttribute("commNo");

      CommBoardDTO commBoardDTO = commBoardDao.findByCommNo(commNo);

      try {

        if (commBoardDTO == null) {
          System.out.println("[ 해당 번호의 게시글이 없습니다.  ]");
          return;
        }

        //        if (commBoardDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId() /*|| commBoardDTO.getOwner().getId() != "admin"*/ )   {
        //          System.out.println("[  삭제 권한이 없습니다.  ]");
        //          return;
        //        }

        String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
        if (input.equalsIgnoreCase("n") /*|| input.length() == 0 */) {
          System.out.println("[  게시글 삭제를 취소하였습니다.  ]");
          return;

        } else if(input.equals("y")) {
          System.out.println("[  ✔️ 게시글을 삭제하였습니다.  ]");
          commBoardDao.delete(commNo);
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



