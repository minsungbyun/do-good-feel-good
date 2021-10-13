package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolGeneralRequestApplyCompleteHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralRequestApplyCompleteHandler(VolunteerDao volunteerDao) {

    this.volunteerDao = volunteerDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  나의 봉사 신청서 목록  ]");
    System.out.println();

    Collection<GeneralRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }

    for (GeneralRequestDTO generalRequestDTO : list) {
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
          //          + "봉사목록: %s\n"
          + "봉사인원: %d\n"
          + "봉사내용: %s\n"
          + "첨부파일: %s\n"
          + "승인여부: %s \n\n", 

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
          //          personalRequestDTO.getVolList(),
          generalRequestDTO.getLimitNum(),
          generalRequestDTO.getContent(),
          generalRequestDTO.getFileUpload(),
          //          personalRequestDTO.isChecked(),
          generalRequestDTO.getStatus()
          );
    }
  }

}
