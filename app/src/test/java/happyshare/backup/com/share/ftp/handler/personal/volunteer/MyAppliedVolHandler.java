package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyAppliedVolHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳


  public MyAppliedVolHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[ 봉사승인 목록 ]");

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    if (generalRequestApplyDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    } 

    for (GeneralRequestDTO generalRequestApplyDTO : generalRequestApplyDTOList) {
      if (generalRequestApplyDTO.getOwner().getName().equals(loginUser.getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            generalRequestApplyDTO.getVolNo(),      
            generalRequestApplyDTO.getMemberType(),      
            generalRequestApplyDTO.getVolTitle(),     
            generalRequestApplyDTO.getOwner().getName(), 
            generalRequestApplyDTO.getVolType(), 
            generalRequestApplyDTO.getVolTel(),
            generalRequestApplyDTO.getVolEmail(),
            generalRequestApplyDTO.getVolStartDate(),
            generalRequestApplyDTO.getVolEndDate(),
            generalRequestApplyDTO.getVolStartTime(),
            generalRequestApplyDTO.getVolEndTime(),
            //            personalRequestApplyDTO.getVolList(),
            generalRequestApplyDTO.getVolLimitNum(),
            generalRequestApplyDTO.getVolContent(),
            generalRequestApplyDTO.getVolFileUpload(),
            generalRequestApplyDTO.getIsSigned()
            );
      } else {
        System.out.println();
        System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
        return;
      }
    }
  }
}
