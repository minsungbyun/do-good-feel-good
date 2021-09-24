package com.share.ftp.handler.personal.donation;

import static com.share.ftp.handler.personal.volunteer.General.check.Applied;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationPrompt {

  protected List<DonationBoardDTO> donationBoardDTOList;
  List<DonationRegisterDTO> donationRegisterDTOList;

  public DonationPrompt(List<DonationBoardDTO> donationBoardDTOList,
      List<DonationRegisterDTO> donationRegisterDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
    this.donationRegisterDTOList = donationRegisterDTOList;
  }

  public DonationBoardDTO promptDonation() {
    System.out.println();
    System.out.println("모금함목록:");

    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getIsSigned().equals(Applied)) {
        System.out.println();
        System.out.printf("  [ %d. %s ]\n", donationBoardDTO.getNo(), donationBoardDTO.getTitle());
      } else {
        System.out.println();
        System.out.println("[ 승인된 모금함이 없습니다. ]");
        break;
      }
    }


    while (true) {



      System.out.println();
      int donationBoardNo = Prompt.inputInt("모금함 번호 선택? (취소: 0) ");
      if (donationBoardNo == 0) {
        return null;
      }

      //      for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      //        if (donationBoardNo == donationBoardDTO.getNo()) {
      //          donationRegisterDTO.setNo(donationBoardDTO.getNo());
      //        } 
      //      }
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
