package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Rejected;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardRejectApplyHandler extends AbstractDonationBoardHandler {

  public DonationBoardRejectApplyHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);

  }
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[모금함 개설신청서 반려]");

    DonationBoardDTO donationBoardAdminDTO = (DonationBoardDTO) request.getAttribute("donationBoardAdminDTO");

    if (donationBoardAdminDTO == null) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설신청서가 없습니다.");
      return;
    }

    System.out.println();
    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 모금함 개설신청 반려를 취소하였습니다.");
      return;
    }

    donationBoardAdminDTO.setIsSigned(Rejected);

    donationBoardRejectDTOList.add(donationBoardAdminDTO);
    System.out.println();
    System.out.println("[ 해당 모금함 개설신청을 반려하였습니다. ]");


  }
}
