package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import java.util.List;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class DonationBoardApplyListHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardApplyListHandler(DonationBoardDao donationBoardDao) {

    this.donationBoardDao = donationBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    DecimalFormat formatter = new DecimalFormat("###,###,###");

    List<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();


    System.out.println();
    System.out.println("[모금함 개설 신청서 목록]");

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 등록된 모금함 개설목록이 없습니다. ]");
      return;
    }

    System.out.println();
    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      System.out.printf("개설번호: %d\n모금함 분류: %s\n주최자: %s\n제목: %s\n내용: %s\n첨부파일: %s\n"
          + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %d\n", 
          donationBoardDTO.getNo(), 
          donationBoardDTO.getCategory().getTitle(), 
          donationBoardDTO.getLeader().getId(),
          donationBoardDTO.getTitle(), 
          donationBoardDTO.getContent(), 
          donationBoardDTO.getFileNames(), 
          donationBoardDTO.getStartDate(),
          donationBoardDTO.getEndDate(),
          formatter.format(donationBoardDTO.getMoneyTarget()),
          donationBoardDTO.getStatus());
      System.out.println("--------------------------------------------------------------");
    }
  }
}


















































