package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;

public class VolRequestPersonalApplyListHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestPersonalApplyListHandler(
      List<PersonalRequestDTO> personalRequestDTOList) {

    super(personalRequestDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[개인봉사신청 목록]");

    if (personalRequestDTOList.isEmpty()) {
      System.out.println("현재 등록된 봉사목록이 없습니다.");
      return;
    }


    for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
      System.out.printf("번호: %d\n봉사제목: %s\n전화번호: %s\n이메일: %s\n봉사기간: %s\n봉사시간: %s\n"
          + "봉사목록: %s\n봉사인원: %d\n봉사내용: %s\n첨부파일: %s\n승인여부: %b \n\n", 
          personalRequestDTO.getNo(), 
          personalRequestDTO.getTitle(), 
          personalRequestDTO.getTel(),
          personalRequestDTO.getEmail(),
          personalRequestDTO.getVolunteerPeriod(),
          personalRequestDTO.getVolunteerTime(),
          personalRequestDTO.getVolunteerList(),
          personalRequestDTO.getJoinNum(),
          personalRequestDTO.getContent(),
          personalRequestDTO.getFileUpload(),
          personalRequestDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }



}
