package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralDoJoinDeleteHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralDoJoinDeleteHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  // 해당 봉사 신청서를 삭제한다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사 참여 취소하기  ]");

    Collection<GeneralRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("봉사 신청서가 없습니다.");
      return;
    }

    //    for (int i = 0; i < list.size(); i++) {
    //
    //      if (!list.get(i).getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
    //        System.out.println("봉사신청서가 없습니다.");
    //        return;
    //      }
    //    }


    int volNo = Prompt.inputInt("봉사번호? ");

    GeneralRequestDTO rejectVolNo = volunteerDao.findByApplyVol(volNo);

    if (rejectVolNo == null) {
      System.out.println("[  해당 번호의 봉사가 없습니다.  ]");
      return;
    }

    String input = Prompt.inputString("정말 취소하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  봉사 취소를 하지 않습니다.  ]");
      return;
    }

    rejectVolNo.removeMembers(AuthLoginHandler.getLoginUser());

    int count = rejectVolNo.getTotalJoinCount();
    count -= 1;
    rejectVolNo.setTotalJoinCount(count); 
    volunteerDao.update(rejectVolNo);

    System.out.println("[  ✔️ 해당 봉사신청을 취소하였습니다. ]");
  }
}
