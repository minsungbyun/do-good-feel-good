package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralDoJoinDeleteHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳

  public VolGeneralDoJoinDeleteHandler(
      List<GeneralRequestDTO> personalRequestDTOList,
      List<GeneralRequestDTO> personalRequestApplyDTOList,
      List<GeneralRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }


  // 해당 봉사 신청서를 삭제한다.
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여 취소하기  ]");

    int volNo = Prompt.inputInt("봉사번호? ");

    GeneralRequestDTO rejectVolNo = findByApplyVol(volNo);

    if (rejectVolNo == null) {
      System.out.println("[  해당 번호의 봉사가 없습니다.  ]");
      return;
    }

    String input = Prompt.inputString("정말 취소하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  봉사 취소를 하지 않습니다.  ]");
      return;
    }

    rejectVolNo.removeMembers(AuthLoginHandler.getLoginUser());

    int count = rejectVolNo.getTotalJoinCount();
    count -= 1;
    rejectVolNo.setTotalJoinCount(count); 

    System.out.println("[  ✔️ 해당 봉사신청을 취소하였습니다. ]");
  }
}
