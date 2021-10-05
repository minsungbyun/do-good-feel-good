package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class CommBoardListHandler implements Command {

  CommBoardDao commBoardDao;

  public CommBoardListHandler(CommBoardDao commBoardDao) {
    this.commBoardDao =  commBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/목록  ]");
    System.out.println();


    System.out.println("------------------------------------------------------------------");
    System.out.println("NO    제목 [댓글수]      작성자     작성일  조회 LIKE    첨부");
    System.out.println("------------------------------------------------------------------");

    Collection<CommBoardDTO> CommBoardDTOList = commBoardDao.findAll();

    for(CommBoardDTO commBoardDTO : CommBoardDTOList) {

      System.out.printf("%d, %s[%d], %s, %s, %d, %d, %s\n", 
          // AuthLoginHandler.loginUser.getId(),
          commBoardDTO.getCommNo(), 
          commBoardDTO.getTitle(), 
          commBoardDTO.getReplyCount(),
          commBoardDTO.getOwner().getId(),
          commBoardDTO.getRegisteredDate(), 
          commBoardDTO.getViewCount(),
          commBoardDTO.getLike(),
          commBoardDTO.getFileUpload());
      // commBoardDTO.getContent(),
      //commBoardDTO.getPassword(),
    }
  }
}




