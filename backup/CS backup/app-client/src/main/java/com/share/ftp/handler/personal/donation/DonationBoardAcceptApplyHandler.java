package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardAcceptApplyHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardAcceptApplyHandler(DonationBoardDao donationBoardDao) {

    this.donationBoardDao = donationBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[모금함 개설신청서 승인]");

    DonationBoardDTO donationBoardAdminDTO = (DonationBoardDTO) request.getAttribute("donationBoardAdminDTO");

    if (donationBoardAdminDTO == null) {
      System.out.println();
      System.out.println("[ 해당 번호의 모금함 개설신청서가 없습니다. ]");
      return;
    }

    System.out.println();
    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("[ 해당 모금함 개설신청 승인을 취소하였습니다. ]");
      return;
    }

    donationBoardAdminDTO.setIsSigned(Applied);

    donationBoardDao.update(donationBoardAdminDTO);

    System.out.println();
    System.out.println("[ 해당 모금함 개설신청을 승인하였습니다. ]");


  }
}
