package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.volunteer.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;

public class VolRequestOrgRejectedListHandler extends AbstractVolRequestOrgHandler { 


  public VolRequestOrgRejectedListHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);
  }



  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  기관봉사반려 목록  ]");

    if (orgRequestRejectDTOList.isEmpty()) {
      System.out.println("현재 반려된 봉사목록이 없습니다.");
      return;
    }

    for (OrgRequestDTO orgRequestDTO : orgRequestRejectDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %b \n", 
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
