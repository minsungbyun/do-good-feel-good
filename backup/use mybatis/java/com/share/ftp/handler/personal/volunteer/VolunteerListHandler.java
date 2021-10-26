package com.share.ftp.handler.personal.volunteer;

import static  com.share.util.General.check.Applied;
import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolunteerListHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolunteerListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사 목록 ]");

    Collection<VolunteerRequestDTO> volunteerList = volunteerDao.findAll();

    if (volunteerList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
      if (volunteerRequestDTO.getStatus() == Applied) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 
            volunteerRequestDTO.getNo(),      
            volunteerRequestDTO.getTitle(),     
            volunteerRequestDTO.getOwner().getName(), 
            volunteerRequestDTO.getCategory(), 
            volunteerRequestDTO.getTel(),
            volunteerRequestDTO.getEmail(),
            volunteerRequestDTO.getStartDate(),
            volunteerRequestDTO.getEndDate(),
            volunteerRequestDTO.getStartTime(),
            volunteerRequestDTO.getEndTime(),
            volunteerRequestDTO.getLimitNum(),
            volunteerRequestDTO.getContent(),
            volunteerRequestDTO.getFileUpload(),
            volunteerRequestDTO.getStatus()
            );
      } 
    }
  }
}
