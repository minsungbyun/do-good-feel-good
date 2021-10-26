package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.REJECTED;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerRejectHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;
  SqlSession SqlSession;

  public VolunteerRejectHandler(VolunteerDao volunteerDao,SqlSession SqlSession) {
    this.volunteerDao = volunteerDao;
    this.SqlSession = SqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    int no = (int) request.getAttribute("volNo");
    System.out.println();

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolunteerNo(no);

    String input = Prompt.inputString(no +"번 봉사신청서를 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    volunteerRequestDTO.setStatus(REJECTED);

    System.out.println(volunteerRequestDTO.getStatus());

    volunteerDao.updateVolunteer(volunteerRequestDTO.getNo(),volunteerRequestDTO.getStatus());
    SqlSession.commit();


    System.out.println("[  ✔️ 해당 봉사신청을 반려하였습니다. ]");
  }
}














