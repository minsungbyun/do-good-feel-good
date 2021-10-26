package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.REJECTED;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerRejectHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolunteerRejectHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    int volNo = (int) request.getAttribute("volNo");
    System.out.println();

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolunteerNo(volNo);

    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    volunteerRequestDTO.setStatus(REJECTED);

    volunteerDao.update(volunteerRequestDTO);

    System.out.println("[  ✔️ 해당 봉사신청을 반려하였습니다. ]");
  }
}














