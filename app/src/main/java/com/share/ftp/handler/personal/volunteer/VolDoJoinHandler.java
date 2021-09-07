package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public class VolDoJoinHandler implements Command {

  List<PersonalRequestDTO> personalSelectedList;
  VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler;
  PersonalRequestDTO personalRequestDTO;
  public VolDoJoinHandler(
      List<PersonalRequestDTO> personalSelectedList,
      VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler,
      PersonalRequestDTO personalRequestDTO
      ) {
    this.personalSelectedList = personalSelectedList;
    this.volRequestPersonalAppliedListDetailHandler = volRequestPersonalAppliedListDetailHandler;
    this.personalRequestDTO = personalRequestDTO;

  }

  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");

    int no = Prompt.inputInt("번호? ");

    PersonalRequestDTO personalRequestSelectedDTO = findBySelectedVol(no);

    System.out.printf("봉사제목: %s\n총봉사인원: %d\n현재봉사인원 :%d\n봉사자명: %s\n",
        personalRequestSelectedDTO.getTitle(),
        personalRequestSelectedDTO.getJoinNum(),
        totalJoinCount(),
        personalRequestSelectedDTO.getMemberNames());




  }



  private PersonalRequestDTO findBySelectedVol(int no) {
    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
      if (personalRequestSelectedDTO.getNo() == no) {
        return personalRequestSelectedDTO;
      }
    }
    return null;
  }

  private int totalJoinCount() {
    int sum = 0;
    for (PersonalRequestDTO personalRequestApplyDTO : personalSelectedList) {
      sum = personalRequestApplyDTO.getJoinCount();
    }
    return sum;
  }



}
