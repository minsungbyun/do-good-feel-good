package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.member.PERSONAL;
import java.util.List;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;

public class VolPersonalRequestAppliedListHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolPersonalRequestAppliedListHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 개인 봉사승인 목록 ]");


    if (generalRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }


    for (GeneralRequestDTO generalRequestApplyDTO : generalRequestApplyDTOList) {


      if (generalRequestApplyDTO.getMemberType() == PERSONAL) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            generalRequestApplyDTO.getVolNo(),      
            generalRequestApplyDTO.getVolTitle(),     
            generalRequestApplyDTO.getOwner().getName(), 
            generalRequestApplyDTO.getVolType(), 
            generalRequestApplyDTO.getVolTel(),
            generalRequestApplyDTO.getVolEmail(),
            generalRequestApplyDTO.getVolStartDate(),
            generalRequestApplyDTO.getVolEndDate(),
            generalRequestApplyDTO.getVolStartTime(),
            generalRequestApplyDTO.getVolEndTime(),
            //          personalRequestApplyDTO.getVolList(),
            generalRequestApplyDTO.getVolLimitNum(),
            generalRequestApplyDTO.getVolContent(),
            generalRequestApplyDTO.getVolFileUpload(),
            //          personalRequestApplyDTO.isChecked(),
            generalRequestApplyDTO.getIsSigned()
            //          this.personalRequestRejectDTO[i].getIsSigned()
            );
      } else {
        System.out.println("현재 승인된 봉사활동이 없습니다.");
        return;
      } 
    }
  }

}
