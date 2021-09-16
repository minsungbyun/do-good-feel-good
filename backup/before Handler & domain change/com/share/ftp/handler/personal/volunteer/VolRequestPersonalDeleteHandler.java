package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalDeleteHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳



  public VolRequestPersonalDeleteHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사신청서 삭제  ]");
    System.out.println();

    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestApplyDTOList) {
      if (personalRequestApplyDTO.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 

            personalRequestApplyDTO.getVolNo(),      
            personalRequestApplyDTO.getVolTitle(),     
            personalRequestApplyDTO.getOwner().getName(), 
            personalRequestApplyDTO.getVolSort(), 
            personalRequestApplyDTO.getVolTel(),
            personalRequestApplyDTO.getVolEmail(),
            personalRequestApplyDTO.getVolStartDate(),
            personalRequestApplyDTO.getVolEndDate(),
            personalRequestApplyDTO.getVolStartTime(),
            personalRequestApplyDTO.getVolEndTime(),
            //            personalRequestApplyDTO.getVolList(),
            personalRequestApplyDTO.getVolLimitNum(),
            personalRequestApplyDTO.getVolContent(),
            personalRequestApplyDTO.getVolFileUpload(),
            personalRequestApplyDTO.getIsSigned()
            );
      } else {
        System.out.println();
        System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
        return;

      }
    }

    int volNo = Prompt.inputInt("삭제 할 봉사번호? ");

    PersonalRequestDTO personalRequestDTO = findByVol(volNo);

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 삭제를 취소하였습니다.  ]");
      return;
    }

    personalRequestDTOList.remove(personalRequestDTO);
    personalRequestApplyDTOList.remove(personalRequestDTO);
    personalRequestRejectDTOList.remove(personalRequestDTO);

    System.out.println("[  해당 봉사신청을 삭제하였습니다. ]");
  }

}
