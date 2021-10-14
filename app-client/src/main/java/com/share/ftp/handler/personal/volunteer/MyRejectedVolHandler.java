package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.Rejected;
import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyRejectedVolHandler implements Command { 

  VolunteerDao volunteerDao;

  public MyRejectedVolHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사반려 목록  ]");


    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    Collection<GeneralRequestDTO> generalRequestDTOList = volunteerDao.findAll();

    if (generalRequestDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      return;
    }



    for (GeneralRequestDTO generalRequestRejectDTO : generalRequestDTOList) {
      if (generalRequestRejectDTO.getStatus().equals(Rejected) &&
          generalRequestRejectDTO.getOwner().getName().equals(loginUser.getName())) {
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
            //            personalRequestRejectDTO.getVolList(),
            generalRequestRejectDTO.getLimitNum(),
            generalRequestRejectDTO.getContent(),
            generalRequestRejectDTO.getFileUpload(),
            generalRequestRejectDTO.getStatus()
            );
      } 
      //      else {
      //        System.out.println();
      //        System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      //        return;
      //      }
    }
  }
}
