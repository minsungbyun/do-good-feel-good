package com.share.ftp.handler.personal.donation;

import com.share.ftp.handler.Command;

public class DonationBoardListHandler implements Command {


  DonationBoardAppliedListHandler donationBoardAppliedListHandler;

  public DonationBoardListHandler(DonationBoardAppliedListHandler donationBoardAppliedListHandler) {
    this.donationBoardAppliedListHandler = donationBoardAppliedListHandler;
  }

  @Override
  public void execute() {
    donationBoardAppliedListHandler.execute();
  }
}


















































