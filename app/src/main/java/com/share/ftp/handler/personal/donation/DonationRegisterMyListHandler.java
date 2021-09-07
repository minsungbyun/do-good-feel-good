package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public class DonationRegisterMyListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationRegisterMyListHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }


  // 모금함 기부 목록
  @Override
  public void execute() {
    System.out.println("[나의 기부 내역]");

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      System.out.printf("[기부 분류: %d] [기부 금액: %s원]\n", 
          donationRegisterDTO.getSort(), 
          donationRegisterDTO.getDonationMoney());
      continue;
    }

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      total += donationRegisterDTO.getDonationMoney();
    }
    System.out.println();
    System.out.printf("나의 기부 총 금액 : %d\n", total);
    return;
  }
}















