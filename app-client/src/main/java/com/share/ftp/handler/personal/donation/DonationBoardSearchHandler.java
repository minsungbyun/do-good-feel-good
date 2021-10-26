package com.share.ftp.handler.personal.donation;

import static com.share.ftp.handler.personal.donation.DonationBoardHelper.getRemainTime;
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

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[ 입력하신 검색 내용이 없습니다.]");
      return;
    }

    for (DonationBoardDTO donationBoard : donationBoardList) {
      System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n"
          + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %s\n",
          donationBoard.getNo(), 
          donationBoard.getSort(), 
          donationBoard.getTitle(), 
          donationBoard.getLeader(),
          donationBoard.getRegisteredStartDate(),
          donationBoard.getRegisteredEndDate(),
          formatter.format(donationBoard.getMoneyTarget()),
          donationBoard.getIsSigned());
      System.out.printf("모금함 기부 기간 ▶ %d일\n",  ((((donationBoard.getRegisteredEndDate().getTime() - donationBoard.getRegisteredStartDate().getTime()) / 1000)) / (24*60*60)));
      System.out.printf(getRemainTime(donationBoard.getRegisteredEndDate().getTime() - System.currentTimeMillis()));
      System.out.println("--------------------------------------------------------------");
    }
  }
}
