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
    System.out.println("[  개인봉사신청 목록  ]");

    if (personalRequestDTOList.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }


    for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
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
          + "봉사목록: %s\n"
          + "봉사인원: %d\n"
          + "봉사내용: %s\n"
          + "첨부파일: %s\n"
          //          + "승인여부: %b \n"
          + "승인여부: %s \n\n", 

          personalRequestDTO.getNo(), 
          personalRequestDTO.getTitle(), 
          personalRequestDTO.getOwner().getName(), 
          //          personalRequestDTO.getName(), 
          personalRequestDTO.getSort(), 
          personalRequestDTO.getTel(),
          personalRequestDTO.getEmail(),
          personalRequestDTO.getVolStartDate(),
          personalRequestDTO.getVolEndDate(),
          personalRequestDTO.getVolStartTime(),
          personalRequestDTO.getVolEndTime(),
          personalRequestDTO.getVolList(),
          personalRequestDTO.getJoinNum(),
          personalRequestDTO.getContent(),
          personalRequestDTO.getFileUpload(),
          //          personalRequestDTO.isChecked(),
          personalRequestDTO.getIsSigned()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }



}
