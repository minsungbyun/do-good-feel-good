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

    Collection<VolunteerRequestDTO> volunteerwishList = volunteerDao.findAll();

    System.out.println("[ 나의 찜한목록 ]");
    for (VolunteerRequestDTO volunteerWish : volunteerwishList) {
      if (volunteerWish.getWish().equals(AuthLoginHandler.getLoginUser())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s\\n", 
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
      }
    }
  }
}
