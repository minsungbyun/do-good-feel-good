package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerApproveListHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolunteerApproveListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사 목록 ]");



    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllWait();

    if (volunteerList.isEmpty()) {
      System.out.println("[  현재 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s \n", 
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
          volunteerRequestDTO.getContent()
          );
    } 

    int volNo = Prompt.inputInt("상태 변경할 봉사 번호를 입력해주세요 ▶ ");

    request.setAttribute("volNo", volNo); 

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 승인하기");
      System.out.println("2번 ▶ 반려하기");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/vol/approve").forward(request); break;
        case 2: request.getRequestDispatcher("/vol/reject").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}
