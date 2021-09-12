package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class VolRequestPersonalDeleteHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳

  List<PersonalRequestDTO> personalSelectedList;
  public VolRequestPersonalDeleteHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList,
      List<PersonalRequestDTO> personalSelectedList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
    this.personalSelectedList = personalSelectedList;
  }


  // 해당 봉사 신청서를 삭제한다.
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사신청서 삭제  ]");

    int no = Prompt.inputInt("봉사번호? ");

    PersonalRequestDTO personalRequestDTO = findByVol(no);

    if (personalRequestDTO == null) {
      System.out.println("[  해당 번호의 개인봉사신청서가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 삭제를 취소하였습니다.  ]");
      return;
    }

    personalRequestDTOList.remove(personalRequestDTO);
    personalRequestApplyDTOList.remove(personalRequestDTO);
    personalRequestRejectDTOList.remove(personalRequestDTO);
    personalSelectedList.remove(personalRequestDTO);




    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    //    }
    //    this.personalRequestsDTO[--this.size] = null;

    System.out.println("[  해당 봉사신청을 삭제하였습니다. ]");
  }


}
