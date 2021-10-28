package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationBoardListHandler implements Command {

  DonationBoardDao donationBoardDao;
  DonationRegisterDao donationRegisterDao;

  public DonationBoardListHandler(DonationBoardDao donationBoardDao, DonationRegisterDao donationRegisterDao) {
    this.donationBoardDao = donationBoardDao;
    this.donationRegisterDao = donationRegisterDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");


    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();


    System.out.println();
    System.out.println("[모금함 승인 목록]");

    if (donationBoardList.isEmpty()) {
      System.out.println("[ 현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      if (donationBoardDTO.getStatus() == APPLIED) {
        System.out.printf("개설번호: %d\n모금함 분류: %s\n주최자: %s\n제목: %s\n내용: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %s원\n",
            donationBoardDTO.getNo(), 
            donationBoardDTO.getCategory().getTitle(), 
            donationBoardDTO.getLeader().getName(),
            donationBoardDTO.getTitle(), 
            donationBoardDTO.getContent(), 
            donationBoardDTO.getStartDate(),
            donationBoardDTO.getEndDate(),
            formatter.format(donationBoardDTO.getMoneyTarget()));
        long remainMoney = donationRegisterDao.findByRemainMoney(donationBoardDTO.getNo());
        System.out.printf("남은금액: %s\n", formatter.format(remainMoney));
        System.out.println("--------------------------------------------------------------");
      } 
    }
    //    else {
    //      System.out.println();
    //      System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
    //      return;
    //    }
  }
}



















































