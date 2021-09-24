package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationRegisterMyListHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<DonationRegisterDTO> donationMyRegisterDTOList;


  public DonationRegisterMyListHandler(List<DonationRegisterDTO> donationRegisterDTOList, List<DonationRegisterDTO> donationMyRegisterDTOList) {
    super(donationRegisterDTOList);
    this.donationMyRegisterDTOList = donationMyRegisterDTOList;
  }


  // 모금함 기부 목록
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[나의 기부 내역]");

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {

      if (AuthLoginHandler.getLoginUser().getName().equals(donationRegisterDTO.getName())) {
        System.out.printf("[기부 분류: %s] [기부 금액: %s원]\n", 
            donationRegisterDTO.getSort(), 
            donationRegisterDTO.getDonationMoney());
      } 
    }

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      if (AuthLoginHandler.getLoginUser().getName().equals(donationRegisterDTO.getName())) {

        System.out.printf("기부 총 금액 : %d\n", DonationRegisterDTO.myTotaldonationMoney);

      } else {
        total = 0;
      }
    }

    if (donationRegisterDTOList == null) {
      return;
    } else {
      System.out.println();
      System.out.printf("나의 기부 총 금액 : %d\n", DonationRegisterDTO.myTotaldonationMoney);
      return;
    }
  }
}















