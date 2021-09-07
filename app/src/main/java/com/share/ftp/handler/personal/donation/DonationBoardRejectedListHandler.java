package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;

public class DonationBoardRejectedListHandler extends AbstractDonationBoardHandler {


  public DonationBoardRejectedListHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[모금함 개설 반려 목록]");

    if (donationBoardRejectDTOList.isEmpty()) {
      System.out.println("현재 반려된 모금함 개설목록이 없습니다.");
      return;
    }

    for (DonationBoardDTO donationBoardRejectDTO : donationBoardRejectDTOList) {
      if (donationBoardRejectDTO.isChecked() == false) {
        System.out.printf("개설번호: %d\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n승인여부: %s\n", 
            donationBoardRejectDTO.getNo(), 
            donationBoardRejectDTO.getTitle(), 
            donationBoardRejectDTO.getLeader(),
            donationBoardRejectDTO.getContent(),
            donationBoardRejectDTO.getFileUpload(), 
            donationBoardRejectDTO.getRegisteredStartDate(),
            donationBoardRejectDTO.getRegisteredEndDate(),
            donationBoardRejectDTO.getIsSigned());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }
}


















































