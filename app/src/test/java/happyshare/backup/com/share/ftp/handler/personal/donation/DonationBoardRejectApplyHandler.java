package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardRejectApplyHandler extends AbstractDonationBoardHandler {

  public DonationBoardRejectApplyHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);

  }
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[모금함 개설신청서 반려]");

    int no = Prompt.inputInt("개설번호? ");

    DonationBoardDTO donationBoardDTO = findByDonationApply(no);

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함 개설신청서가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 모금함 개설신청 반려를 취소하였습니다.");
      return;
    }

    donationBoardDTO.setChecked(false);
    donationBoardDTO.setIsSigned("반려됨");

    for (DonationBoardDTO donationBoardRejectDTO : donationBoardDTOList) {
      donationBoardRejectDTOList.add(donationBoardRejectDTO);
    }

    System.out.println("해당 모금함 개설신청을 반려하였습니다.");


  }
}
