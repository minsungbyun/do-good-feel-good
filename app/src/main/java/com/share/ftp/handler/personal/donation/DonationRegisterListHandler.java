package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public class DonationRegisterListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationRegisterListHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }


  // 모금함 기부 목록
  @Override
  public void execute() {
    System.out.println("[모금함 기부 목록]");

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      System.out.printf("%d, %d, %s, %s, %s, %s, %s, %s\n", 
          donationRegisterDTO.getSort(), 
          donationRegisterDTO.getNo(), 
          donationRegisterDTO.getDonationMoney(), 
          donationRegisterDTO.getName(), 
          donationRegisterDTO.getRegisterationNumber(),
          donationRegisterDTO.getBirthDate(),
          donationRegisterDTO.getTel(), 
          donationRegisterDTO.getEmail(),
          donationRegisterDTO.getAddress());
    }
  }
}















