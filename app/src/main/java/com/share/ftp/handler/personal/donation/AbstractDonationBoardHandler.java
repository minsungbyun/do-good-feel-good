package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractDonationBoardHandler implements Command {

  List<DonationBoardDTO> donationBoardDTOList;

  public AbstractDonationBoardHandler(List<DonationBoardDTO> donationBoardDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
  }

  protected DonationBoardDTO findByNo(int no) {
    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }

}
