package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgAppliedListHandler;

public class VolRequestTotalApprovedListDetailHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolRequestPersonalAppliedListHandler volRequestPersonalAppliedListHandler;
  VolRequestOrgAppliedListHandler volRequestOrgAppliedListHandler;


  public VolRequestTotalApprovedListDetailHandler(
      VolRequestPersonalAppliedListHandler volRequestPersonalAppliedListHandler,
      VolRequestOrgAppliedListHandler volRequestOrgAppliedListHandler) {

    this.volRequestPersonalAppliedListHandler = volRequestPersonalAppliedListHandler;
    this.volRequestOrgAppliedListHandler = volRequestOrgAppliedListHandler;

  }

  // 인증받은 봉사 리스트 세부사항 (개인 기관)   //구현예정
  @Override
  public void execute() {
    System.out.println();

    // 인증받은 봉사 중 1개를 선택해서 세부사항을 본다.
    // 선택 > 참여자현황 / 신청하기 / 세부설명(봉사정보,위치) / 문의사항 


    System.out.println("[  전체봉사승인 목록  ]");
    volRequestPersonalAppliedListHandler.execute();
    volRequestOrgAppliedListHandler.execute();





















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

  }
}
























