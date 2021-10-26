package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyVolunteerHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public MyVolunteerHandler(VolunteerDao volunteerDao) {

    this.volunteerDao = volunteerDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  나의 봉사 신청서 목록  ]");
    System.out.println();


    List<VolunteerRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequest : list) {
      if (AuthLoginHandler.getLoginUser().getId().equals(volunteerRequest.getOwner().getId())) {

        System.out.printf("번호: %d\n"
            + "봉사제목: %s\n"
            + "주최자: %s\n"
            + "봉사분류: %s\n"
            + "전화번호: %s\n"
            + "이메일: %s\n"
            + "봉사시작기간: %s\n"
            + "봉사종료기간: %s\n"
            + "봉사시작시간: %s\n"
            + "봉사종료시간: %s\n"
            + "봉사인원: %d\n"
            + "봉사내용: %s\n"
            + "승인여부: %d \n\n", 

            volunteerRequest.getNo(), 
            volunteerRequest.getTitle(), 
            volunteerRequest.getOwner().getName(), 
            volunteerRequest.getCategory().getTitle(), 
            volunteerRequest.getTel(),
            volunteerRequest.getEmail(),
            volunteerRequest.getStartDate(),
            volunteerRequest.getEndDate(),
            volunteerRequest.getStartTime(),
            volunteerRequest.getEndTime(),
            volunteerRequest.getLimitNum(),
            volunteerRequest.getContent(),
            volunteerRequest.getStatus()
            );

        for (VolunteerAttachedFile file : volunteerRequest.getFileUpload()) {
          System.out.printf("첨부파일: %s\n", file.getFilepath());
        }
        System.out.println();
      }
    }
  }

}
