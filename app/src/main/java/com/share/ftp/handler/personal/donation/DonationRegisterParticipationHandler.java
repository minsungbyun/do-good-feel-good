package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public class DonationRegisterParticipationHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationRegisterParticipationHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
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
      System.out.println();
      System.out.printf("모금함번호: %s\n %s님, %s, %s\n", 
          donationRegisterDTO.getSort(), 
          donationRegisterDTO.getName(), 
          donationRegisterDTO.getDonationMoney(), 
          donationRegisterDTO.getRegisteredDate());
      System.out.println();
    }
  }
}















