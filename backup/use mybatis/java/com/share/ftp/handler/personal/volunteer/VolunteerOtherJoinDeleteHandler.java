package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerOtherJoinDeleteHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolunteerOtherJoinDeleteHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  // 해당 봉사 신청서를 삭제한다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사 참여 취소하기  ]");
    Collection<VolunteerRequestDTO> list = volunteerDao.findAllApply();

    if (list.isEmpty()) {
      System.out.println("봉사 신청서가 없습니다.");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : list) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s \n", 
          volunteerRequestDTO.getNo(),      
          volunteerRequestDTO.getTitle(),     
          volunteerRequestDTO.getOwner().getId(), 
          volunteerRequestDTO.getCategory().getTitle(), 
          volunteerRequestDTO.getTel(),
          volunteerRequestDTO.getEmail(),
          volunteerRequestDTO.getStartDate(),
          volunteerRequestDTO.getEndDate(),
          volunteerRequestDTO.getStartTime(),
          volunteerRequestDTO.getEndTime(),
          volunteerRequestDTO.getLimitNum(),
          volunteerRequestDTO.getContent()
          );
    } 


    int volNo = Prompt.inputInt("참여를 취소할 봉사 번호를 입력해주세요(이전 0번) ▶ ");

    if (volNo == 0) {
      return;
    }

    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo);

    if (volunteer == null) {
      System.out.println("[  해당 번호의 봉사가 없습니다.  ]");
      return;
    }

    String input = Prompt.inputString("정말 취소하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  봉사 취소를 하지 않습니다.  ]");
      return;
    }

    volunteer.removeMembers(AuthLoginHandler.getLoginUser());
    int count = volunteer.getCurrentNum();
    volunteer.setCurrentNum(count -= 1); 
    // volunteerDao.update(rejectVolNo);

    System.out.println("[  ✔️ 해당 봉사신청을 취소하였습니다. ]");
  }
}
