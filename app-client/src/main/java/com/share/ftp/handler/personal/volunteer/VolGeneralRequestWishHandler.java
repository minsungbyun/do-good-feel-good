package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralRequestWishHandler implements Command {

  VolunteerDao volunteerDao;

  public VolGeneralRequestWishHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  🎈 WISH 🎈  ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    GeneralRequestDTO GeneralRequestDTO = volunteerDao.findByApplyVol(volNo); 

    while (true) {
      String input = Prompt.inputString("[  🎈 관심 봉사로 추가하시겠습니까?(y/N) 🎈 ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  ❌ WISH 취소 ❌  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        GeneralRequestDTO.setWish(AuthLoginHandler.getLoginUser());
        volunteerDao.update(GeneralRequestDTO);
        System.out.println("[  🎈 관심 봉사로 등록되었습니다. 🎈  ]");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

