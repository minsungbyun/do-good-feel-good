package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractDonationRegisterHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  List<DonationRegisterDTO> donationRegisterDTOList;

  public AbstractDonationRegisterHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    this.donationRegisterDTOList = donationRegisterDTOList;
  }

  protected DonationRegisterDTO findByNo(int no) {
    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      if (donationRegisterDTO.getNo() == no) {
        return donationRegisterDTO;
      }
    }
    return null;
  }
}



















