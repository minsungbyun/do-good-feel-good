package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardLikeHandler implements Command {

  CommBoardDao commBoardDao;

  public CommBoardLikeHandler(CommBoardDao commBoardDao) {
    this.commBoardDao =  commBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    while (true) {
      System.out.println("[  ❤ LIKE ❤  ]");
      System.out.println();

      int commNo = (int) request.getAttribute("commNo");
      System.out.println();

      // CommBoardDTO commBoard = findByCommNo(commNo); 

      Collection<CommBoardDTO> CommBoardDTOList = commBoardDao.findAll();


      String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ] ");

      for (CommBoardDTO commBoardDTO : CommBoardDTOList) {
        if (commBoardDTO.getLikeMembers().contains(joinDTO)) {
          System.out.println("좋아요는 1번만 가능합니다."); 
          return;
        }
      }

      //      if (input.equalsIgnoreCase("n") || input.length() == 0) {
      //        System.out.println("[  ❌ 좋아요 취소❌  ]");
      //        return;
      //
      //      } else if (input.equals("y")) {
      //        System.out.println("[  ❤ LIKE 등록 완료 ❤  ]");
      //        commBoardDTO.setLike(commBoardDTO.getLike() + 1);
      //        commBoardDTO.addLikeMember(joinDTO);
      //
      //        commBoardDTO.add(commBoard);
      //
      //        return;
      //      } else {
      //        System.out.println("y 또는 n을 입력하세요.");
      //        continue;
      // } 
    } 
  }
}

