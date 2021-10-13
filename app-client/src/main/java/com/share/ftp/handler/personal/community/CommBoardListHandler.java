package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class CommBoardListHandler implements Command {

  CommunityDao communityDao;

  public CommBoardListHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/목록  ]");
    System.out.println();

    Collection<CommBoardDTO> commBoardDTOList = communityDao.findAll();

    if (commBoardDTOList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }

    System.out.println("----------------------------------------------");
    System.out.println("NO 제목[댓글]  작성자 작성일 조회 LIKE 첨부");
    System.out.println("----------------------------------------------");


    for(CommBoardDTO commBoardDTO : commBoardDTOList) {

      System.out.printf("%d, %s[%d], %s, %s, %d, %d, %s\n", 
          commBoardDTO.getNo(), 
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




