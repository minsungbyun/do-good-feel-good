package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationRegisterTotalMoneyHandler implements Command {

  DonationRegisterDao donationRegisterDao;

  public DonationRegisterTotalMoneyHandler(DonationRegisterDao donationRegisterDao) {
    this.donationRegisterDao = donationRegisterDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    long totalDonationMoney = donationRegisterDao.findAllDonationMoney();

    if (totalDonationMoney == 0) {
      System.out.println();
      System.out.println("[ 기부금액이 없습니다. ]");
      return;
    }

    System.out.println();
    System.out.printf("[ 기부 총 금액 : %s원 ]\n", formatter.format(totalDonationMoney));

  }
}















