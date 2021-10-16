package com.share.ftp.handler.personal.mypage;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyVolWishHandler implements Command {

  VolunteerDao volunteerDao;

  public MyVolWishHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<GeneralRequestDTO> generalRequestList = volunteerDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (GeneralRequestDTO generalRequestDTO : generalRequestList) {
      if (generalRequestDTO.getWish().equals(AuthLoginHandler.getLoginUser())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \\n", 
            generalRequestDTO.getNo(),      
            generalRequestDTO.getTitle(),     
            generalRequestDTO.getOwner().getName(), 
            generalRequestDTO.getType(), 
            generalRequestDTO.getTel(),
            generalRequestDTO.getEmail(),
            generalRequestDTO.getStartDate(),
            generalRequestDTO.getEndDate(),
            generalRequestDTO.getStartTime(),
            generalRequestDTO.getEndTime(),
            generalRequestDTO.getLimitNum(),
            generalRequestDTO.getContent(),
            generalRequestDTO.getFileUpload(),
            generalRequestDTO.getStatus());
      }
    }
  }
}
