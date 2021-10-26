package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerShortReviewSearchHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;

  public VolunteerShortReviewSearchHandler(VolunteerShortReviewDao volunteerShortReviewDao) {
    this.volunteerShortReviewDao =  volunteerShortReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 게시글 검색 ]");

    String input = Prompt.inputString("[  검색어를 입력하세요.  ]");

    Collection<VolunteerRequestDTO> volunteerRequestDTOList = volunteerShortReviewDao.findByKeyword(input);

    for(VolunteerRequestDTO volunteerRequestDTO : volunteerRequestDTOList) {
      if(!volunteerRequestDTO.getShortReviewContent().contains(input) &&
          !volunteerRequestDTO.getOwner().getId().contains(input)) {
        continue;
      }

      System.out.println();
      System.out.printf("작성자 ▶ %s\n", volunteerRequestDTO.getOwner().getId());
      System.out.printf("내용 ▶ %s\n", volunteerRequestDTO.getContent());
      System.out.printf("작성일 ▶ %s\n", volunteerRequestDTO.getRegisteredDate());
      System.out.println();
    }
  }
}











