package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class VolRequestDeleteHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳

  List<PersonalRequestDTO> personalSelectedList;
  public VolRequestDeleteHandler(
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
    System.out.println("[  봉사 참여 취소하기  ]");

    int no = Prompt.inputInt("봉사번호? ");

    PersonalRequestDTO personalRequestDTO = findByApplyVol(no);

    if (personalRequestDTO == null) {
      System.out.println("[  해당 번호의 봉사가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 취소하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  봉사 취소를 하지 않습니다.  ]");
      return;
    }

    personalSelectedList.remove(personalRequestDTO);




    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    //    }
    //    this.personalRequestsDTO[--this.size] = null;

    System.out.println("[  해당 봉사신청을 취소하였습니다. ]");
  }


}
