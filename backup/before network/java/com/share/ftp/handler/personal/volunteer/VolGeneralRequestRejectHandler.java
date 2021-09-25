package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolGeneralRequestRejectHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolGeneralRequestRejectHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사신청서 반려  ]");
    System.out.println();

    int no = Prompt.inputInt("봉사번호 ▶ ");

    GeneralRequestDTO generalRequestDTO = findByVol(no);

    if (generalRequestDTO == null) {
      System.out.println("[  해당 번호의 봉사신청서가 없습니다.  ]");
      return;
    }


    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 반려를 취소하였습니다.  ]");
      return;
    }

    generalRequestDTO.setIsSigned("반려됨");

    generalRequestRejectDTOList.add(generalRequestDTO);

    System.out.println("[  ✔️ 해당 봉사신청을 반려하였습니다. ]");
  }
}
