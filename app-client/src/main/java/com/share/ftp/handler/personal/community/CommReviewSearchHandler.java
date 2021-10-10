package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommReviewSearchHandler implements Command {

  CommunityDao communityDao;

  public CommReviewSearchHandler(CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    String input = Prompt.inputString("[  검색어를 입력하세요.  ]");

    Collection<CommReviewDTO> commReviewDTOList = communityDao.findByCommReviewKeyword(input);

    for(CommReviewDTO commReviewDTO : commReviewDTOList) {
      if(!commReviewDTO.getContent().contains(input)) {
        continue;
      }

      System.out.println();
      System.out.printf("작성자 ▶ %s\n", commReviewDTO.getOwner().getId());
      System.out.printf("내용 ▶ %s\n", commReviewDTO.getContent());
      System.out.printf("작성일 ▶ %s\n", commReviewDTO.getRegisteredDate());
      System.out.println();
    }
  }
}











