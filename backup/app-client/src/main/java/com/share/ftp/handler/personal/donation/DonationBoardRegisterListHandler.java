package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.donation.DonationRegisterDTO;
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
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");

    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAll();

    System.out.println();
    System.out.printf("[ %d번 모금함 기부 목록]\n", donationBoardDTO.getNo());
    if (donationRegisterList.isEmpty()) {
      System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
    } else {
      for (DonationRegisterDTO donationRegisterDTO : donationRegisterList) {
        if (donationRegisterDTO.getDonationBoard().getNo() == donationBoardDTO.getNo()) {
          System.out.printf("[ %s님, %s원, %s ]\n", 
              donationRegisterDTO.getDonator().getId(), 
              formatter.format(donationRegisterDTO.getDonationMoney()), 
              donationRegisterDTO.getRegisteredDate());
        } 
      } 
    }
  }
}














