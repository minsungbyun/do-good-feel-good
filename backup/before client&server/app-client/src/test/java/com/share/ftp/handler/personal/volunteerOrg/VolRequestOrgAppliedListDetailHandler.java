package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;

public class VolRequestOrgAppliedListDetailHandler extends AbstractVolRequestOrgHandler {


  public VolRequestOrgAppliedListDetailHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  기관봉사승인 목록  ]");


    if (orgRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }


    for (OrgRequestDTO orgRequesApplyDTO : orgRequestApplyDTOList) {
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

          orgRequesApplyDTO.getNo(),      
          orgRequesApplyDTO.getTitle(),     
          orgRequesApplyDTO.getOwner(), 
          orgRequesApplyDTO.getSort(), 
          orgRequesApplyDTO.getTel(),
          orgRequesApplyDTO.getEmail(),
          orgRequesApplyDTO.getVolStartDate(),
          orgRequesApplyDTO.getVolEndDate(),
          orgRequesApplyDTO.getVolStartTime(),
          orgRequesApplyDTO.getVolEndTime(),
          orgRequesApplyDTO.getVolList(),
          orgRequesApplyDTO.getJoinNum(),
          orgRequesApplyDTO.getContent(),
          orgRequesApplyDTO.getFileUpload(),
          orgRequesApplyDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }



}
