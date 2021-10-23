package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralRequestDeleteHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralRequestDeleteHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사신청서 삭제  ]");
    System.out.println();

    Collection<VolunteerRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("봉사 신청서가 없습니다.");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : list) {
      if (volunteerRequestDTO.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.println("봉사신청서가 없습니다.");
        return;
      }
    }

    //    for (int i = 0; i < generalRequestDTOList.size(); i++) {
    //
    //      if (!generalRequestDTOList.get(i).getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
    //        System.out.println("봉사신청서가 없습니다.");
    //        return;
    //      }
    //    }

    int volNo = Prompt.inputInt("삭제 할 봉사번호? ");
    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolNo(volNo);

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 삭제를 취소하였습니다.  ]");
      return;
    }
    volunteerDao.delete(volunteerRequestDTO);

    //    list.remove(generalRequestDTO);
    //    if (generalRequestDTO.getStatus().equals("승인됨")) {
    //      generalRequestApplyDTOList.remove(generalRequestDTO);
    //      
    //    } else if (generalRequestDTO.getIsSigned().equals("반려됨")) {
    //      
    //      generalRequestRejectDTOList.remove(generalRequestDTO);
    //    }

    System.out.println("[  해당 봉사신청을 삭제하였습니다. ]");
  } 


}



