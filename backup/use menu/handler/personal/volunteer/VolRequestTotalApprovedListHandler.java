package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;

public class VolRequestTotalApprovedListHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestTotalApprovedListHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<OrgRequestDTO> orgRequestDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(personalRequestDTOList, 
        orgRequestDTOList,
        personalRequestApplyDTOList, 
        personalRequestRejectDTOList,
        orgRequestApplyDTOList,
        orgRequestRejectDTOList);
  }

  // 인증받은 봉사 리스트 세부사항 (개인 기관)   //구현예정
  @Override
  public void execute() {
    System.out.println();

    // 인증받은 봉사 중 1개를 선택해서 세부사항을 본다.
    // 선택 > 참여자현황 / 신청하기 / 세부설명(봉사정보,위치) / 문의사항 

    System.out.println();
    System.out.println("[  전체봉사승인 목록  ]");




    if (personalRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }

    if (personalRequestApplyDTOList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }


    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestApplyDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %b \n", 

          personalRequestApplyDTO.getNo(),      
          personalRequestApplyDTO.getTitle(),     
          personalRequestApplyDTO.getOwner(), 
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
          personalRequestApplyDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }


    System.out.println("-----------------------------------------------------------------------");






    for (OrgRequestDTO orgRequestApplyDTO : orgRequestApplyDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %b \n", 

          orgRequestApplyDTO.getNo(),      
          orgRequestApplyDTO.getTitle(),     
          orgRequestApplyDTO.getOwner(), 
          orgRequestApplyDTO.getSort(), 
          orgRequestApplyDTO.getTel(),
          orgRequestApplyDTO.getEmail(),
          orgRequestApplyDTO.getVolStartDate(),
          orgRequestApplyDTO.getVolEndDate(),
          orgRequestApplyDTO.getVolStartTime(),
          orgRequestApplyDTO.getVolEndTime(),
          orgRequestApplyDTO.getVolList(),
          orgRequestApplyDTO.getJoinNum(),
          orgRequestApplyDTO.getContent(),
          orgRequestApplyDTO.getFileUpload(),
          orgRequestApplyDTO.isChecked()
          //          this.personalRequestRejectDTO[i].getIsSigned()
          );
    }
  }
}
























