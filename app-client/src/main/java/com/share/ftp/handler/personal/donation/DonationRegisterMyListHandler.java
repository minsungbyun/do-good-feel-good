package com.share.ftp.handler.personal.donation;

import java.util.Collection;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationRegisterMyListHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  DonationRegisterDao donationRegisterDao;


  public DonationRegisterMyListHandler(DonationRegisterDao donationRegisterDao) {
    this.donationRegisterDao = donationRegisterDao;
  }


  // 모금함 기부 목록
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[나의 기부 내역]");

    if (AuthLoginHandler.getLoginUser().getDonationMoney() == 0) {
      System.out.println();
      System.out.println("[ 나의 기부 내역이 없습니다. ]");
    }

    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAll();

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterList) {

      if (AuthLoginHandler.getLoginUser().getName().equals(donationRegisterDTO.getName())) {
        System.out.printf("[기부 분류: %s] [기부 금액: %s원]\n", 
            donationRegisterDTO.getSort(), 
            donationRegisterDTO.getDonationMoney());

      } 
    }

    System.out.println();
    System.out.printf("[ 나의 기부 총 금액 %d원 ]", AuthLoginHandler.getLoginUser().getDonationMoney());
    System.out.println();

  }
}















