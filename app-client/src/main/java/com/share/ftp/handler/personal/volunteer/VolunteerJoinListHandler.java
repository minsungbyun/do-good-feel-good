package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolunteerJoinListHandler implements Command {

  VolunteerDao volunteerDao;

  public VolunteerJoinListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");
    System.out.println();
    System.out.println(" ▶ 참여인원을 확인하고 싶은 봉사번호를 입력해주세요.");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");
    System.out.println();

    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo); 

    if (volunteer == null) {
      System.out.println("해당 봉사가 없습니다.");
      return;
    }


    System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
        volunteer.getTitle(),
        volunteer.getCurrentNum(),
        volunteer.getLimitNum(),
        volunteer.getOwner().getId(), // 주최자 아이디
        volunteer.getOwner().getName(), // 주최자 이룸
        volunteer.getMemberNames());


  }
}


