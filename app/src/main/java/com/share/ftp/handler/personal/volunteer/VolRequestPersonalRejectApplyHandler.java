package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class VolRequestPersonalRejectApplyHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestPersonalRejectApplyHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);

  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사신청서 반려  ]");
    System.out.println();

    int no = Prompt.inputInt("봉사번호? ");

    PersonalRequestDTO personalRequestDTO = findByVol(no);

    if (personalRequestDTO == null) {
      System.out.println("[  해당 번호의 개인봉사신청서가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    //    personalRequestDTO.setChecked(false);
    personalRequestDTO.setIsSigned("반려됨");

    personalRequestRejectDTOList.add(personalRequestDTO);

    System.out.println("[  ✔️ 해당 봉사신청을 반려하였습니다. ]");
  }
}
