package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralRequestDeleteHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳



  public VolGeneralRequestDeleteHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사신청서 삭제  ]");
    System.out.println();

    if (generalRequestDTOList.isEmpty()) {
      System.out.println("봉사 신청서가 없습니다.");
      return;
    }

    for (int i = 0; i < generalRequestDTOList.size(); i++) {

      if (!generalRequestDTOList.get(i).getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.println("봉사신청서가 없습니다.");
        return;
      }
    }

    int volNo = Prompt.inputInt("삭제 할 봉사번호? ");
    GeneralRequestDTO generalRequestDTO = findByVol(volNo);

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 삭제를 취소하였습니다.  ]");
      return;
    }

    generalRequestDTOList.remove(generalRequestDTO);

    if (generalRequestDTO.getIsSigned().equals("승인됨")) {
      generalRequestApplyDTOList.remove(generalRequestDTO);
    } else if (generalRequestDTO.getIsSigned().equals("반려됨")) {
      generalRequestRejectDTOList.remove(generalRequestDTO);
    }

    System.out.println("[  해당 봉사신청을 삭제하였습니다. ]");
  } 


}



