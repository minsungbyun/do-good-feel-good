package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyVolunteerWishHandler implements Command {

  VolunteerDao volunteerDao;

  public MyVolunteerWishHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    List<VolunteerRequestDTO> volunteerwishList = volunteerDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (VolunteerRequestDTO volunteerWish : volunteerwishList) {
      if (volunteerWish.getWish().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s", 
            volunteerWish.getNo(),      
            volunteerWish.getTitle(),     
            volunteerWish.getOwner().getId(), 
            volunteerWish.getCategory().getTitle(), 
            volunteerWish.getTel(),
            volunteerWish.getEmail(),
            volunteerWish.getStartDate(),
            volunteerWish.getEndDate(),
            volunteerWish.getStartTime(),
            volunteerWish.getEndTime(),
            volunteerWish.getLimitNum(),
            volunteerWish.getContent());

        for (VolunteerAttachedFile file : volunteerWish.getFileUpload()) {
          System.out.printf(", %s", file.getFilepath());
        }
        System.out.println();
      }
    }
  }
}
