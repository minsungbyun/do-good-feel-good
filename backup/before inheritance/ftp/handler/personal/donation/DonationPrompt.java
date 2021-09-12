package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationPrompt {

  protected List<DonationBoardDTO> donationBoardDTOList;

  public DonationPrompt(List<DonationBoardDTO> donationBoardDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
  }

  public DonationBoardDTO promptDonation() {
    System.out.println();
    System.out.println("모금함목록:");

    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.isChecked() == true) {
        System.out.println();
        System.out.printf("  [ %d. %s ]\n", donationBoardDTO.getNo(), donationBoardDTO.getTitle());
      }
    }
    while (true) {


      System.out.println();
      int donationBoardNo = Prompt.inputInt("모금함 번호 선택? (취소: 0) ");
      if (donationBoardNo == 0) {
        return null;
      }
      DonationBoardDTO selectedDonation = findByNo(donationBoardNo);
      if (selectedDonation != null) {
        return selectedDonation;
      }
      System.out.println("모금함 번호가 옳지 않습니다.");
    }
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
