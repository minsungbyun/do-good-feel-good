package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.Rejected;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolGeneralRequestRejectHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralRequestRejectHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사신청서 반려  ]");
    System.out.println();

    int no = Prompt.inputInt("봉사번호 ▶ ");

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolNo(no);

    if (volunteerRequestDTO == null) {
      System.out.println("[  해당 번호의 봉사신청서가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    volunteerRequestDTO.setStatus(Rejected);

    volunteerDao.update(volunteerRequestDTO);

    System.out.println("[  ✔️ 해당 봉사신청을 반려하였습니다. ]");
  }
}














