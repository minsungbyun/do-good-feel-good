package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.handler.Command;

public class VolGeneralTotalApprovedListHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler;

  public VolGeneralTotalApprovedListHandler(
      VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler) {

    this.volGeneralRequestAppliedListHandler = volGeneralRequestAppliedListHandler;
  }

  @Override
  public void execute() {
    System.out.println();

    System.out.println("▶ 전체봉사승인 목록");

    volGeneralRequestAppliedListHandler.execute();
    //    volRequestOrgAppliedListHandler.execute();

  }
}





















//    if (personalRequestApplyDTOList.isEmpty()) {
//      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
//      return;
//    } else {
//      for (PersonalRequestDTO personalRequestApplyDTO : personalRequestApplyDTOList) {
//        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s\n", 
//
//            personalRequestApplyDTO.getNo(),      
//            personalRequestApplyDTO.getTitle(),     
//            personalRequestApplyDTO.getOwner(), 
//            personalRequestApplyDTO.getSort(), 
//            personalRequestApplyDTO.getTel(),
//            personalRequestApplyDTO.getEmail(),
//            personalRequestApplyDTO.getVolStartDate(),
//            personalRequestApplyDTO.getVolEndDate(),
//            personalRequestApplyDTO.getVolStartTime(),
//            personalRequestApplyDTO.getVolEndTime(),
//            personalRequestApplyDTO.getVolList(),
//            personalRequestApplyDTO.getJoinNum(),
//            personalRequestApplyDTO.getContent(),
//            personalRequestApplyDTO.getFileUpload()
//            //          personalRequestApplyDTO.isChecked()
//            //          this.personalRequestRejectDTO[i].getIsSigned()
//            );
//      }
//    }
//
//
//
//
//    System.out.println("-----------------------------------------------------------------------");
//
//
//
//
//
//    if (orgRequestApplyDTOList.isEmpty()) {
//      System.out.println("[  현재 승인된 기관봉사목록이 없습니다. ]");
//      return;
//    } else {
//      for (OrgRequestDTO orgRequestApplyDTO : orgRequestApplyDTOList) {
//        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s \n", 
//
//            orgRequestApplyDTO.getNo(),      
//            orgRequestApplyDTO.getTitle(),     
//            orgRequestApplyDTO.getOwner(), 
//            orgRequestApplyDTO.getSort(), 
//            orgRequestApplyDTO.getTel(),
//            orgRequestApplyDTO.getEmail(),
//            orgRequestApplyDTO.getVolStartDate(),
//            orgRequestApplyDTO.getVolEndDate(),
//            orgRequestApplyDTO.getVolStartTime(),
//            orgRequestApplyDTO.getVolEndTime(),
//            orgRequestApplyDTO.getVolList(),
//            orgRequestApplyDTO.getJoinNum(),
//            orgRequestApplyDTO.getContent(),
//            orgRequestApplyDTO.getFileUpload()
//            //            orgRequestApplyDTO.isChecked()
//            //          this.personalRequestRejectDTO[i].getIsSigned()
//            );
//      }
//
//    }
























