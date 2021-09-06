package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;

public class DonationBoardAppliedListHandler extends AbstractDonationBoardHandler {


  public DonationBoardAppliedListHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[모금함 개설 신청서 승인 목록]");

    if (donationBoardApplyDTOList.isEmpty()) {
      System.out.println("현재 승인된 모금함 개설목록이 없습니다.");
      return;
    }

    for (DonationBoardDTO donationBoardApplyDTO : donationBoardApplyDTOList) {
      if (donationBoardApplyDTO.isChecked() == true) {
        System.out.printf("개설번호: %d\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n승인여부: %s\n",
            donationBoardApplyDTO.getNo(), 
            donationBoardApplyDTO.getTitle(), 
            donationBoardApplyDTO.getLeader(),
            donationBoardApplyDTO.getContent(),
            donationBoardApplyDTO.getFileUpload(), 
            donationBoardApplyDTO.getRegisteredStartDate(),
            donationBoardApplyDTO.getRegisteredEndDate(),
            //          donationBoardDTO.isChecked());
            donationBoardApplyDTO.getIsSigned());
      }
    }
  }
}



















































