package com.share.ftp.handler.personal.donation;

import java.util.Collection;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationBoardRegisterListHandler implements Command  { // 모금함 기부하기 양식 쓰는곳

  DonationRegisterDao donationRegisterDao;

  public DonationBoardRegisterListHandler(DonationRegisterDao donationRegisterDao) {
    this.donationRegisterDao = donationRegisterDao;
  }


  // 모금함 기부 목록
  @Override
  public void execute(CommandRequest request) throws Exception {

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");

    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAll();

    System.out.println();
    System.out.println("[모금함 기부 목록]");
    if (donationRegisterList.isEmpty()) {
      System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
    } else {
      for (DonationRegisterDTO donationRegisterDTO : donationRegisterList) {
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














