package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;

public class VolRequestOrgAppliedListHandler extends AbstractVolRequestOrgHandler {


  public VolRequestOrgAppliedListHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[기관봉사승인 목록]");


    if (orgRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }


    for (OrgRequestDTO orgRequesApplyDTO : orgRequestApplyDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %b \n", 

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
