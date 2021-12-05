package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;

public class DonationBoardRegisterListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationBoardRegisterListHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }


  // 모금함 기부 목록
  @Override
  public void execute(CommandRequest request) throws Exception {

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");

    System.out.println();
    System.out.println("[모금함 기부 목록]");
    if (donationRegisterDTOList.isEmpty()) {
      System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
    } else {
      for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
        if (donationRegisterDTO.getNo() == donationBoardDTO.getNo()) {
          System.out.printf("[ %s님, %d원, %s ]\n", 
              donationRegisterDTO.getName(), 
              donationRegisterDTO.getDonationMoney(), 
              donationRegisterDTO.getRegisteredDate());
        } 
      } 
    }
  }
}














