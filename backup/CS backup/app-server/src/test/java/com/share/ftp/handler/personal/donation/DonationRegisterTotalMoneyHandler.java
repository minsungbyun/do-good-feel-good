package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;

public class DonationRegisterTotalMoneyHandler extends AbstractDonationRegisterHandler {

  public DonationRegisterTotalMoneyHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.printf("[ 기부 총 금액 : %d원 ]\n", DonationRegisterDTO.totalDonationMoney);

  }
}















