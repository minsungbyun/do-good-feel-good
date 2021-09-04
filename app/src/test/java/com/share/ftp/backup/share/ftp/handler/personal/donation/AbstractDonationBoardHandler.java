package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractDonationBoardHandler implements Command {

  // 모금함 개설 신청내역 전체 리스트
  protected List<DonationBoardDTO> donationBoardDTOList;

  // 모금함 개설 신청내역 승인 리스트
  protected List<DonationBoardDTO> donationBoardApplyDTOList;

  // 모금함 개설 신청내역 반려 리스트
  protected List<DonationBoardDTO> donationBoardRejectDTOList;

  public AbstractDonationBoardHandler(List<DonationBoardDTO> donationBoardDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
  }

  public AbstractDonationBoardHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    this(donationBoardDTOList);
    this.donationBoardApplyDTOList = donationBoardApplyDTOList;
    this.donationBoardRejectDTOList = donationBoardRejectDTOList;
  }

  protected DonationBoardDTO findByDonationApply(int no) {
    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }

}
