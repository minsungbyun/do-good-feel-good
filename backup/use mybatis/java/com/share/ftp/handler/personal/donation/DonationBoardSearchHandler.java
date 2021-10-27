package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import java.text.DecimalFormat;
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

    DonationBoardDTO donationBoardList = donationBoardDao.findByKeyword(input);

    if (donationBoardList == null) {
      System.out.println();
      System.out.println("[ 입력하신 검색 내용이 없습니다.]");
      return;
    }

    if (donationBoardList.getStatus() != APPLIED) {
      System.out.println();
      System.out.println("[ 입력하신 검색 내용이 없습니다.]");
      return;
    }


    System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n"
        + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %d\n",
        donationBoardList.getNo(), 
        donationBoardList.getCategory().getTitle(), 
        donationBoardList.getTitle(), 
        donationBoardList.getLeader().getName(),
        donationBoardList.getStartDate(),
        donationBoardList.getEndDate(),
        formatter.format(donationBoardList.getMoneyTarget()),
        donationBoardList.getStatus());
    System.out.println("--------------------------------------------------------------");

  }
}
