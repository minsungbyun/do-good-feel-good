package com.share.ftp.handler.personal.mypage;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
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

    Collection<VolunteerRequestDTO> generalRequestList = volunteerDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (VolunteerRequestDTO volunteerRequestDTO : generalRequestList) {
      if (volunteerRequestDTO.getWish().equals(AuthLoginHandler.getLoginUser())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \\n", 
            volunteerRequestDTO.getNo(),      
            volunteerRequestDTO.getTitle(),     
            volunteerRequestDTO.getOwner().getName(), 
            volunteerRequestDTO.getType(), 
            volunteerRequestDTO.getTel(),
            volunteerRequestDTO.getEmail(),
            volunteerRequestDTO.getStartDate(),
            volunteerRequestDTO.getEndDate(),
            volunteerRequestDTO.getStartTime(),
            volunteerRequestDTO.getEndTime(),
            volunteerRequestDTO.getLimitNum(),
            volunteerRequestDTO.getContent(),
            volunteerRequestDTO.getFileUpload(),
            volunteerRequestDTO.getStatus());
      }
    }
  }
}
