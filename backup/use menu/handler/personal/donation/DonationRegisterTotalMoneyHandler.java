package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public class DonationRegisterTotalMoneyHandler extends AbstractDonationRegisterHandler {

  public DonationRegisterTotalMoneyHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }

  @Override
  public void execute() {

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      total += donationRegisterDTO.getDonationMoney();
    }
    System.out.printf("기부 총 금액 : %d\n", total);
  }
}















