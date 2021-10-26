package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerListHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolunteerListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사 목록 ]");

    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();

    if (volunteerList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
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

      for (VolunteerAttachedFile file : volunteerRequestDTO.getFileUpload()) {
        System.out.printf("%s\n", file.getFilepath());
      }
    } 

    System.out.println();

    int no = Prompt.inputInt("상세보기 할 봉사 번호를 입력해주세요(이전 0번) ▶ ");
    if (no == 0) {
      return;
    }

    request.setAttribute("no", no); 
    request.getRequestDispatcher("/vol/detail").forward(request);

  }
}
