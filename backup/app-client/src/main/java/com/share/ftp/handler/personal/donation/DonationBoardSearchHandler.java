package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardSearchHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardSearchHandler(DonationBoardDao donationBoardDao) {
    this.donationBoardDao = donationBoardDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    System.out.println();
    System.out.println("[ 모금함 검색 ]");
    System.out.println();

    String input = Prompt.inputString("검색어 ▶  ");

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findByKeyword(input);

    if (donationBoardList.size() == 0) {
      System.out.println();
      System.out.println("[ 입력하신 검색어가 없습니다.]");
      return;
    }

    //    if (donationBoardDTO.getStatus() != APPLIED) {
    //      System.out.println();
    //      System.out.println("[ 입력하신 검색 내용이 없습니다.]");
    //      return;
    //    }

    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n"
          + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %d\n",
          donationBoardDTO.getNo(), 
          donationBoardDTO.getCategory().getTitle(), 
          donationBoardDTO.getTitle(), 
          donationBoardDTO.getLeader().getName(),
          donationBoardDTO.getStartDate(),
          donationBoardDTO.getEndDate(),
          formatter.format(donationBoardDTO.getMoneyTarget()),
          donationBoardDTO.getStatus());
      System.out.println("--------------------------------------------------------------");
    }
  }
}
