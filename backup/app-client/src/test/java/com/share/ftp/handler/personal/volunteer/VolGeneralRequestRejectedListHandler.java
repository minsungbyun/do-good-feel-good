package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolGeneralRequestRejectedListHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolGeneralRequestRejectedListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사반려 목록  ]");

    Collection<VolunteerRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO generalRequestRejectDTO : list) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 
          generalRequestRejectDTO.getNo(),      
          generalRequestRejectDTO.getMemberType(),      
          generalRequestRejectDTO.getTitle(),     
          generalRequestRejectDTO.getOwner().getName(), 
          generalRequestRejectDTO.getType(), 
          generalRequestRejectDTO.getTel(),
          generalRequestRejectDTO.getEmail(),
          generalRequestRejectDTO.getStartDate(),
          generalRequestRejectDTO.getEndDate(),
          generalRequestRejectDTO.getStartTime(),
          generalRequestRejectDTO.getEndTime(),
          //          personalRequestRejectDTO.getVolList(),
          generalRequestRejectDTO.getLimitNum(),
          generalRequestRejectDTO.getContent(),
          generalRequestRejectDTO.getFileUpload(),
          generalRequestRejectDTO.getStatus()
          );
    }
  }
}
