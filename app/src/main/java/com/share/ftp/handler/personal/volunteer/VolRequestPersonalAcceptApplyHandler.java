package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class VolRequestPersonalAcceptApplyHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestPersonalAcceptApplyHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }


  @Override
  public void execute() {
    //해당 봉사 신청서를 승인한다.   

    System.out.println();
    System.out.println("[개인봉사신청서 승인]");
    int no = Prompt.inputInt("번호? ");

    //    int personalRequestIndex = indexOf(no);


    //    PersonalRequestDTO personalRequestApplyDTO = null;
    PersonalRequestDTO personalRequestDTO = findByVol(no);

    //    PersonalRequestApplyDTO personalRequestApplyDTO = (PersonalRequestApplyDTO)personalRequestDTO;
    //
    ////    PersonalRequestApplyDTO personalRequestApplyDTO : personalRequestApplyDTOList
    //    
    //    personalRequestApplyDTOList.add(personalRequestDTO);
    //    
    //    
    //    for (PersonalRequestDTO personalRequestDTO : personalRpersonalRequestApplyDTOListequestDTOList) {
    //      if (personalRequestDTO.getNo() == no) {
    //
    //
    //        personalRequestDTO = personalRequestsDTO[i];
    //        personalRequestIndex = i;
    //        break;
    //      }
    //    }

    //
    //    if (personalRequestIndex == -1) {
    //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
    //      return;
    //    }

    if (personalRequestDTO == null) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
      return;
    }




    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
      return;
    }

    personalRequestDTO.setChecked(true);
    //    personalRequestDTO.setIsSigned("승인됨");

    //    List<Integer> first = new ArrayList<>(); first.add(0); first.add(1); first.add(2);
    //
    //    
    //    List<Integer> second = new ArrayList<>();
    //    for (Integer i : first) { 
    //      second.add(i);
    //      } 
    // second.addAll(first); first.add(3); System.out.println(second.toString()); }

    //    List<PersonalRequestDTO> personalRequestApplyDTOList = new ArrayList<>();

    // 기존 리스트 복사
    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestDTOList) {
      personalRequestApplyDTOList.add(personalRequestApplyDTO);
    }




    //    personalRequestApplyDTO[applySize++] = personalRequestDTO;

    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    //    }
    //    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 승인하였습니다.");

  }

}
