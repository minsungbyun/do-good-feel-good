package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.General;

public class VolGeneralAppliedListHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralAppliedListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사승인 목록 ]");


    //    if (generalRequestApplyDTOList.isEmpty()) {
    //      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
    //      return;
    //    }

    Collection<VolunteerRequestDTO> list = volunteerDao.findAll();

    for (VolunteerRequestDTO generalRequestApplyDTO : list) {
      if (generalRequestApplyDTO.getStatus().equals(General.check.Applied)) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            generalRequestApplyDTO.getNo(),      
            generalRequestApplyDTO.getTitle(),     
            generalRequestApplyDTO.getOwner().getName(), 
            generalRequestApplyDTO.getType(), 
            generalRequestApplyDTO.getTel(),
            generalRequestApplyDTO.getEmail(),
            generalRequestApplyDTO.getStartDate(),
            generalRequestApplyDTO.getEndDate(),
            generalRequestApplyDTO.getStartTime(),
            generalRequestApplyDTO.getEndTime(),
            //          personalRequestApplyDTO.getVolList(),
            generalRequestApplyDTO.getLimitNum(),
            generalRequestApplyDTO.getContent(),
            generalRequestApplyDTO.getFileUpload(),
            //          personalRequestApplyDTO.isChecked(),
            generalRequestApplyDTO.getStatus()
            //          this.personalRequestRejectDTO[i].getIsSigned()
            );
      } 
      //      else {
      //        System.out.println("현재 등록된 봉사활동이 없습니다.");
      //        return;
      //      } 


    }
  }
}
