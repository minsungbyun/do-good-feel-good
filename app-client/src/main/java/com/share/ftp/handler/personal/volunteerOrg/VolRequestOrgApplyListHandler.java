package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.volunteer.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;

public class VolRequestOrgApplyListHandler extends AbstractVolRequestOrgHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestOrgApplyListHandler(
      List<OrgRequestDTO> orgRequestDTOList) {

    super(orgRequestDTOList);

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  기관봉사신청 목록  ]");

    if (orgRequestDTOList.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }


    for ( OrgRequestDTO orgRequestDTO : orgRequestDTOList) {
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
          + "승인여부: %b \n\n", 

          orgRequestDTO.getNo(), 
          orgRequestDTO.getTitle(), 
          orgRequestDTO.getOwner(), 
          orgRequestDTO.getSort(), 
          orgRequestDTO.getTel(),
          orgRequestDTO.getEmail(),
          orgRequestDTO.getVolStartDate(),
          orgRequestDTO.getVolEndDate(),
          orgRequestDTO.getVolStartTime(),
          orgRequestDTO.getVolEndTime(),
          orgRequestDTO.getVolList(),
          orgRequestDTO.getJoinNum(),
          orgRequestDTO.getContent(),
          orgRequestDTO.getFileUpload(),
          orgRequestDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }



}
