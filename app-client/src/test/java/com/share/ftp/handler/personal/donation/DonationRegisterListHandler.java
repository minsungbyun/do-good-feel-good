package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationRegisterListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationRegisterListHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }


  // 모금함 기부 목록
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[모금함 기부 목록]");

    if (donationRegisterDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[ 참여한 모금함 기부내역이 없습니다. ]");
      return;
    }

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      if (donationRegisterDTO.getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %d, %s, %s, %s, %s, %s, %s\n", 
            donationRegisterDTO.getSort(), 
            donationRegisterDTO.getNo(), 
            donationRegisterDTO.getDonationMoney(), 
            donationRegisterDTO.getName(), 
            donationRegisterDTO.getRegisterationNumber(),
            donationRegisterDTO.getBirthDate(),
            donationRegisterDTO.getTel(), 
            donationRegisterDTO.getEmail(),
            donationRegisterDTO.getAddress());
      } else {
        System.out.println();
        System.out.println("[ 참여한 모금함 기부내역이 없습니다. ]");
        return;
      }
    }
  }
}














