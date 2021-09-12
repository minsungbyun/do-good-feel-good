package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public class DonationRegisterParticipationListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<DonationBoardDTO> donationBoardDTOList;

  public DonationRegisterParticipationListHandler(List<DonationRegisterDTO> donationRegisterDTOList,
      List<DonationBoardDTO> donationBoardDTOList) {
    super(donationRegisterDTOList);
    this.donationBoardDTOList = donationBoardDTOList;
  }

  // 모금함 기부 참여내역
  @Override
  public void execute() {
    System.out.println("[모금함 기부 참여내역]");

    if (donationRegisterDTOList.isEmpty()) {
      System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
      return;
    }


    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      for (DonationBoardDTO a : donationBoardDTOList) {
        System.out.println();
        if (donationRegisterDTO.getNo() == a.getNo()) {
          System.out.printf("모금함번호: %d  분류: %s\n %s님, %s, %s\n", 
              donationRegisterDTO.getNo(), 
              donationRegisterDTO.getSort(), 
              donationRegisterDTO.getName(), 
              donationRegisterDTO.getDonationMoney(), 
              donationRegisterDTO.getRegisteredDate());
          System.out.println();
        }
      }
    }
  }
}















