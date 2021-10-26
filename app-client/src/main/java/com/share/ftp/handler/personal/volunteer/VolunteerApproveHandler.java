package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.APPLIED;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerApproveHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;
  SqlSession SqlSession;

  public VolunteerApproveHandler(VolunteerDao volunteerDao,SqlSession SqlSession) {
    this.volunteerDao = volunteerDao;
    this.SqlSession = SqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  봉사신청서 승인  ]");
    System.out.println();

    int no = (int) request.getAttribute("volNo");
    System.out.println();

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolunteerNo(no);

    String input = Prompt.inputString(no +"번 봉사신청서를 승인하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 승인을 취소하였습니다. ]");
      return;
    }

    volunteerRequestDTO.setStatus(APPLIED);
    volunteerRequestDTO.addMembers(volunteerRequestDTO.getOwner());



    volunteerDao.updateVolunteer(volunteerRequestDTO);
    //    volunteerDao.updateVolunteer(volunteerRequestDTO.getNo(),volunteerRequestDTO.getStatus());
    SqlSession.commit();

    System.out.println("[  ✔️ 해당 봉사신청을 승인하였습니다. ]");
  } 
}
