package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.Applied;
import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyAppliedVolHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public MyAppliedVolHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사승인 목록 ]");

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    Collection<GeneralRequestDTO> generalRequestDTOList = volunteerDao.findAll();

    if (generalRequestDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    } 

    for (GeneralRequestDTO generalRequestApplyDTO : generalRequestDTOList) {
      if (generalRequestApplyDTO.getStatus().equals(Applied) &&
          generalRequestApplyDTO.getOwner().getName().equals(loginUser.getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            generalRequestApplyDTO.getNo(),      
            generalRequestApplyDTO.getMemberType(),      
            generalRequestApplyDTO.getTitle(),     
            generalRequestApplyDTO.getOwner().getName(), 
            generalRequestApplyDTO.getType(), 
            generalRequestApplyDTO.getTel(),
            generalRequestApplyDTO.getEmail(),
            generalRequestApplyDTO.getStartDate(),
            generalRequestApplyDTO.getEndDate(),
            generalRequestApplyDTO.getStartTime(),
            generalRequestApplyDTO.getEndTime(),
            //            personalRequestApplyDTO.getVolList(),
            generalRequestApplyDTO.getLimitNum(),
            generalRequestApplyDTO.getContent(),
            generalRequestApplyDTO.getFileUpload(),
            generalRequestApplyDTO.getStatus()
            );
      } else {
        System.out.println();
        System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
        return;
      }
    }
  }
}
