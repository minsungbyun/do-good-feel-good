package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.volunteer.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolRequestOrgRejectApplyHandler extends AbstractVolRequestOrgHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestOrgRejectApplyHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);

  }


  // 해당 봉사 신청서를 반려한다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  기관봉사신청서 반려  ]");

    int no = Prompt.inputInt("봉사번호? ");

    OrgRequestDTO orgRequestDTO = findByVol(no);

    if (orgRequestDTO == null) {
      System.out.println("[  해당 번호의 기관봉사신청서가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    orgRequestDTO.setChecked(false);

    // 기존 리스트 복사
    for (OrgRequestDTO orgRejectRequestDTO : orgRequestDTOList) {
      orgRequestRejectDTOList.add(orgRejectRequestDTO);
    }

    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    //    }
    //    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 반려하였습니다.");
  }


}
