package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;

public class VolRequestOrgApplyCompleteListHandler extends AbstractVolRequestOrgHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestOrgApplyCompleteListHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  기관 봉사 신청서 목록  ]");

    if (orgRequestDTOList.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }


    for (OrgRequestDTO orgRequesDTO : orgRequestDTOList) {
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

          orgRequesDTO.getNo(), 
          orgRequesDTO.getTitle(), 
          orgRequesDTO.getOwner(), 
          orgRequesDTO.getSort(), 
          orgRequesDTO.getTel(),
          orgRequesDTO.getEmail(),
          orgRequesDTO.getVolStartDate(),
          orgRequesDTO.getVolEndDate(),
          orgRequesDTO.getVolStartTime(),
          orgRequesDTO.getVolEndTime(),
          orgRequesDTO.getVolList(),
          orgRequesDTO.getJoinNum(),
          orgRequesDTO.getContent(),
          orgRequesDTO.getFileUpload(),
          orgRequesDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }



}
