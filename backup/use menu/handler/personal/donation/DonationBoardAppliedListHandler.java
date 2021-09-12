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
      System.out.println("현재 등록된 모금함 개설목록이 없습니다.");
      return;
    }

    for (DonationBoardDTO donationBoardDTO : donationBoardApplyDTOList) {
      System.out.printf("[%d, %s, %s, %s, %s, %s ~ %s, %b]\n", 
          donationBoardDTO.getNo(), 
          donationBoardDTO.getTitle(), 
          donationBoardDTO.getLeader(),
          donationBoardDTO.getContent(),
          donationBoardDTO.getFileUpload(), 
          donationBoardDTO.getPassword(),
          donationBoardDTO.getRegisteredStartDate(),
          donationBoardDTO.getRegisteredEndDate(),
          donationBoardDTO.isChecked());
    }
  }
}


















































