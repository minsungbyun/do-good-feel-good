package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolGeneralDoJoinListHandler implements Command {

  VolunteerDao volunteerDao;

  public VolGeneralDoJoinListHandler(VolunteerDao volunteerDao) {
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

    GeneralRequestDTO volJoinList = volunteerDao.findByApplyVol(volNo); 

    if (volJoinList == null) {
      System.out.println("해당 봉사가 없습니다.");
      return;
    }

    // 주최자 이름이 있으면 제거 (따로 명시되게끔 설정함)
    if (volJoinList.getMembers().contains(volJoinList.getOwner())) {
      volJoinList.getMembers().remove(volJoinList.getOwner());
    }

    System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
        volJoinList.getTitle(),
        volJoinList.getTotalJoinCount(),
        volJoinList.getLimitNum(),
        volJoinList.getOwner().getId(), // 주최자 아이디
        volJoinList.getOwner().getName(), // 주최자 이룸
        volJoinList.getMemberNames());


  }
}


