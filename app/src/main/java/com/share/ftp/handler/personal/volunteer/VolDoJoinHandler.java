package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class VolDoJoinHandler extends AbstractVolRequestPersonalHandler {

  List<PersonalRequestDTO> personalSelectedList;
  public VolDoJoinHandler(
      List<PersonalRequestDTO> personalSelectedList,
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {
    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
    this.personalSelectedList = personalSelectedList;

  }

  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");

    int no = Prompt.inputInt("번호? ");

    PersonalRequestDTO personalRequestSelectedDTO = findBySelectedVol(no);

    System.out.printf("봉사제목: %s\n총봉사인원: %d\n현재봉사인원 :%d\n봉사자명: %s\n",
        personalRequestSelectedDTO.getTitle(),
        personalRequestSelectedDTO.getJoinNum(),
        personalRequestSelectedDTO.getJoinCount(),
        personalRequestSelectedDTO.getMemberNames());




  }

  protected PersonalRequestDTO findBySelectedVol(int no) {
    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
      if (personalRequestSelectedDTO.getNo() == no) {
        return personalRequestSelectedDTO;
      }
    }
    return null;
  }

}
