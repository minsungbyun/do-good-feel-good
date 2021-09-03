package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;

public class VolRequestTotalApprovedListHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestTotalApprovedListHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }

  // 인증받은 봉사 리스트 세부사항 (개인 기관)   //구현예정
  @Override
  public void execute() {
    System.out.println();

    // 인증받은 봉사 중 1개를 선택해서 세부사항을 본다.
    // 선택 > 참여자현황 / 신청하기 / 세부설명(봉사정보,위치) / 문의사항 

    System.out.println("[전체봉사승인 목록]");
    //    for (int i = 0; i < this.applySize; i++) {
    //      System.out.printf("봉사명 : %d\n 봉사제목 : %s\n %s, %s, %s, %s, %s, %s, %s, %s\n", 
    //          this.personalRequestApplyDTO[i].getNo(), 
    //          this.personalRequestApplyDTO[i].getTitle(), 
    //          this.personalRequestApplyDTO[i].getTel(),
    //          this.personalRequestApplyDTO[i].getEmail(),
    //          this.personalRequestApplyDTO[i].getVolunteerPeriod(),
    //          this.personalRequestApplyDTO[i].getVolunteerTime(),
    //          this.personalRequestApplyDTO[i].getVolunteerList(),
    //          this.personalRequestApplyDTO[i].getContent(),
    //          this.personalRequestApplyDTO[i].getFileUpload(),
    //          //          this.personalRequestApplyDTO[i].isChecked()
    //          this.personalRequestRejectDTO[i].getIsSigned()
    //
    //          );
    //    }



  }




}
