package com.share.ftp.handler.personal.donation;

import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationRegisterTotalMoneyHandler implements Command {

  DonationRegisterDao donationRegisterDao;

  public DonationRegisterTotalMoneyHandler(DonationRegisterDao donationRegisterDao) {
    this.donationRegisterDao = donationRegisterDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.printf("[ 기부 총 금액 : %d원 ]\n", DonationRegisterDTO.totalDonationMoney);

  }
}















