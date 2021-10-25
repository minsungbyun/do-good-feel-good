package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class CommBoardListHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;

  public CommBoardListHandler(VolunteerBoardDao volunteerBoardDao) {
    this.volunteerBoardDao =  volunteerBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/목록  ]");
    System.out.println();

    Collection<CommBoardDTO> commBoardDTOList = volunteerBoardDao.findAll();

    if (commBoardDTOList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }

    System.out.println("----------------------------------------------");
    System.out.println("NO 제목[댓글]  작성자 작성일 조회 LIKE 첨부");
    System.out.println("----------------------------------------------");


    for(CommBoardDTO commBoardDTO : commBoardDTOList) {

      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          commBoardDTO.getNo(), 
          commBoardDTO.getOwner().getId(),
          commBoardDTO.getTitle(), 
          commBoardDTO.getRegisteredDate(), 
          commBoardDTO.getFileUpload(),
          commBoardDTO.getViewCount());
      //          commBoardDTO.getLike(),
    }
  }
}




