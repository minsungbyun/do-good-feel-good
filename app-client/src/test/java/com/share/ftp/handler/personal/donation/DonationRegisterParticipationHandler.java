package com.share.ftp.handler.personal.donation;

import java.util.Collection;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationRegisterParticipationHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  DonationRegisterDao donationRegisterDao;

  public DonationRegisterParticipationHandler(DonationRegisterDao donationRegisterDao) {
    this.donationRegisterDao = donationRegisterDao;
  }

  // 모금함 기부 참여내역
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[모금함 기부 참여내역]");

    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAll();

    if (donationRegisterList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
      return;
    }

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterList) {
      System.out.printf("[모금함번호: %d, 기부분류: %s, %s님, %s원, 기부날짜: %s]\n", 
          donationRegisterDTO.getNo(), 
          donationRegisterDTO.getSort(), 
          donationRegisterDTO.getName(), 
          donationRegisterDTO.getDonationMoney(), 
          donationRegisterDTO.getRegisteredDate());
      System.out.println();
    }
  }
}















