package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardSearchHandler implements Command {

  CommBoardDao commBoardDao;

  public CommBoardSearchHandler(CommBoardDao commBoardDao) {
    this.commBoardDao =  commBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    String input = Prompt.inputString("[  검색어를 입력하세요!  ");

    Collection<CommBoardDTO> CommBoardDTOList = commBoardDao.findByKeyword(input);

    for(CommBoardDTO commBoardDTO : CommBoardDTOList) {
      if(!commBoardDTO.getTitle().contains(input) &&
          !commBoardDTO.getContent().contains(input)) {
        continue;
      }

      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
    }
  }
}
