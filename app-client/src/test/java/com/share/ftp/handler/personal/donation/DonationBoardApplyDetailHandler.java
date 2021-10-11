package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardApplyDetailHandler extends AbstractDonationBoardHandler {

  public DonationBoardApplyDetailHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationRegisterDTO> donationRegisterDTOList,
      DonationPrompt donationPrompt) {
    super(donationBoardDTOList, donationRegisterDTOList, donationPrompt);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    if (donationBoardDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    DonationBoardDTO donationBoardDTO = donationPrompt.promptDonation();

    if (donationBoardDTO == null) {
      System.out.println();
      System.out.println("[ 모금함 상세보기를 취소하셨습니다. ]");
      return;
    }

    printDonationBoard(donationBoardDTO);


    request.setAttribute("donationBoardDTO", donationBoardDTO);

    while (true) {
      String input = Prompt.inputString("기부하기(U), 모금함 기부자 내역(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/donationBoardDetailRegister/add").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/donationBoardRegister/list").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}




















































