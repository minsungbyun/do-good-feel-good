package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolRequestOrgAcceptApplyHandler extends AbstractVolRequestOrgHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestOrgAcceptApplyHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    super(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    //해당 봉사 신청서를 승인한다.   

    System.out.println();
    System.out.println("[  기관봉사신청서 승인  ]");
    int no = Prompt.inputInt("번호? ");

    OrgRequestDTO orgRequestDTO = findByVol(no);

    if (orgRequestDTO == null) {
      System.out.println("해당 번호의 기관봉사신청서가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
      return;
    }

    orgRequestDTO.setChecked(true);
    orgRequestDTO.setIsSigned("승인됨");
    //    personalRequestDTO.setIsSigned("승인됨");


    // 기존 리스트 복사

    orgRequestApplyDTOList.add(orgRequestDTO);


    System.out.println("해당 봉사신청을 승인하였습니다.");

  }
}
