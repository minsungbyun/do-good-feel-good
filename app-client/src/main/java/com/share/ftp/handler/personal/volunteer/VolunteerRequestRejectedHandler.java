package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.REJECTED;
import java.util.List;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolunteerRequestRejectedHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolunteerRequestRejectedHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사반려 목록  ]");

    List<VolunteerRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : list) {
      if (volunteerRequestDTO.getStatus() == REJECTED) {

        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s \n", 
            volunteerRequestDTO.getNo(),      
            volunteerRequestDTO.getTitle(),     
            volunteerRequestDTO.getOwner().getName(), 
            volunteerRequestDTO.getCategory().getTitle(), 
            volunteerRequestDTO.getTel(),
            volunteerRequestDTO.getEmail(),
            volunteerRequestDTO.getStartDate(),
            volunteerRequestDTO.getEndDate(),
            volunteerRequestDTO.getStartTime(),
            volunteerRequestDTO.getEndTime(),
            volunteerRequestDTO.getLimitNum(),
            volunteerRequestDTO.getContent(),
            volunteerRequestDTO.getStatus()
            );

        for (VolunteerAttachedFile file : volunteerRequestDTO.getFileUpload()) {
          System.out.printf("%s\n", file.getFilepath());
        }
      }
    }
  }
}
