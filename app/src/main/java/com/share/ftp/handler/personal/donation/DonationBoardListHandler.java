package com.share.ftp.handler.personal.donation;

import com.share.ftp.handler.Command;

public class DonationBoardListHandler implements Command {

  DonationBoardAppliedListHandler donationBoardAppliedListHandler;

  public DonationBoardListHandler(DonationBoardAppliedListHandler donationBoardAppliedListHandler) {
    this.donationBoardAppliedListHandler = donationBoardAppliedListHandler;
  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[모금함 승인 목록]");

    donationBoardAppliedListHandler.execute();
    System.out.println("--------------------------------------------------------------");
  }
}


















































