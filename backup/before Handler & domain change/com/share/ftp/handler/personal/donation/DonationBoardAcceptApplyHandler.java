package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardAcceptApplyHandler extends AbstractDonationBoardHandler {

  public DonationBoardAcceptApplyHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[모금함 개설신청서 승인]");

    int no = Prompt.inputInt("개설번호? ");

    DonationBoardDTO donationBoardDTO = findByDonationApply(no);

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함 개설신청서가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 모금함 개설신청 승인을 취소하였습니다.");
      return;
    }

    donationBoardDTO.setChecked(true);
    donationBoardDTO.setIsSigned("승인됨");

    for (DonationBoardDTO donationBoardApplyDTO : donationBoardDTOList) {
      donationBoardApplyDTOList.add(donationBoardApplyDTO);
    }

    System.out.println("해당 모금함 개설신청을 승인하였습니다.");


  }
}
