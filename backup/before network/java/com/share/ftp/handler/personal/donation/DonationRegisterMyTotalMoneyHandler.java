package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;

public class DonationRegisterMyTotalMoneyHandler extends AbstractDonationRegisterHandler {


  public DonationRegisterMyTotalMoneyHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.printf("기부 총 금액 : %d\n", DonationRegisterDTO.myTotaldonationMoney);
  }
}















