package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationBoardAppliedListHandler extends AbstractDonationBoardHandler {


  public DonationBoardAppliedListHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[모금함 개설 승인 목록]");

    if (donationBoardApplyDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    for (DonationBoardDTO donationBoardApplyDTO : donationBoardApplyDTOList) {
      if (donationBoardApplyDTO.getIsSigned().equals(Applied) && 
          donationBoardApplyDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {

        System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %d원\n승인여부: %s\n",
            donationBoardApplyDTO.getNo(), 
            donationBoardApplyDTO.getSort(), 
            donationBoardApplyDTO.getTitle(), 
            donationBoardApplyDTO.getLeader(),
            donationBoardApplyDTO.getContent(),
            donationBoardApplyDTO.getFileUpload(), 
            donationBoardApplyDTO.getRegisteredStartDate(),
            donationBoardApplyDTO.getRegisteredEndDate(),
            donationBoardApplyDTO.getMoneyTarget(),
            //          donationBoardDTO.isChecked());
            donationBoardApplyDTO.getIsSigned());
        System.out.println("--------------------------------------------------------------");

      } else {
        System.out.println();
        System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
        return;
      }
    } 
  }
}



















































