package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerShortReviewListHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;

  public VolunteerShortReviewListHandler(VolunteerShortReviewDao volunteerShortReviewDao) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한줄후기 목록  ]");
    System.out.println();

    Collection<VolunteerShortReviewDTO> volunteerShortReviewDTOList = volunteerShortReviewDao.findAll();

    for (VolunteerShortReviewDTO volunteerShortReviewDTO : volunteerShortReviewDTOList) {
      System.out.printf("%d, %s, %s, %s\n", 
          volunteerShortReviewDTO.getNo(), 
          volunteerShortReviewDTO.getOwner().getId(), 
          volunteerShortReviewDTO.getContent(),
          volunteerShortReviewDTO.getRegisteredDate());
    }

    System.out.println();

    int no = Prompt.inputInt("변경, 삭제하고자 하는 후기 번호를 입력해주세요 (이전: 0) ▶ ");

    if (no == 0) {
      return;
    }

    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(no);

    if (volunteerShortReviewDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    //      if (!volunteerShortReviewDTO.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
    //        System.out.println("변경 권한이 없습니다.");
    //        return;  
    //      }

    if (!volunteerShortReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;  
    }

    request.setAttribute("no", no);

    while (true) {
      String input = Prompt.inputString ("변경(U), 삭제(D), 이전(0) ▶ ");
      switch (input) {
        case "U":
        case "u" :
          request.getRequestDispatcher("/volunteerShortReview/update").forward(request);
          return;

        case "D":
        case "d":
          request.getRequestDispatcher("/volunteerShortReview/delete").forward(request);
          return;

        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");

      }
    }
  }
}

