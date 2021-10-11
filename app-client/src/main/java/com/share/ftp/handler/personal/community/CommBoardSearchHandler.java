package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardSearchHandler implements Command {

  CommunityDao communityDao;

  public CommBoardSearchHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 게시글 검색 ]");

    String input = Prompt.inputString("검색어?  ");

    Collection<CommBoardDTO> commBoardDTOList = communityDao.findByKeyword(input);

    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if(!commBoardDTO.getTitle().contains(input) &&
          !commBoardDTO.getContent().contains(input) &&
          !commBoardDTO.getOwner().getId().contains(input)) {
        continue;
      }

      System.out.printf("작성자 ▶ %s\n", commBoardDTO.getOwner().getId());
      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
      System.out.printf("작성일 ▶ %s\n", commBoardDTO.getRegisteredDate());
      System.out.printf("조회수 ▶ %d\n", commBoardDTO.getViewCount());

      System.out.println();
    }
  }
}
