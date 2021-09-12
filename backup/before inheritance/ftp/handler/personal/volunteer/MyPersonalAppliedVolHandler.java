package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyPersonalAppliedVolHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public MyPersonalAppliedVolHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[ 개인봉사승인 목록 ]");


    if (personalRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }




    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestApplyDTOList) {
      if (personalRequestApplyDTO.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            personalRequestApplyDTO.getNo(),      
            personalRequestApplyDTO.getTitle(),     
            personalRequestApplyDTO.getOwner().getName(), 
            personalRequestApplyDTO.getSort(), 
            personalRequestApplyDTO.getTel(),
            personalRequestApplyDTO.getEmail(),
            personalRequestApplyDTO.getVolStartDate(),
            personalRequestApplyDTO.getVolEndDate(),
            personalRequestApplyDTO.getVolStartTime(),
            personalRequestApplyDTO.getVolEndTime(),
            personalRequestApplyDTO.getVolList(),
            personalRequestApplyDTO.getJoinNum(),
            personalRequestApplyDTO.getContent(),
            personalRequestApplyDTO.getFileUpload(),
            //          personalRequestApplyDTO.isChecked(),
            personalRequestApplyDTO.getIsSigned()
            //          this.personalRequestRejectDTO[i].getIsSigned()
            );

      }
    }
  }



}
