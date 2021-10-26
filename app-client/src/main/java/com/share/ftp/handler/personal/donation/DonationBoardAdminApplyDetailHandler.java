package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardAdminApplyDetailHandler implements Command {

  DonationBoardDao donationBoardDao;
  DonationAdminPrompt donationAdminPrompt;

  public DonationBoardAdminApplyDetailHandler(
      DonationBoardDao donationBoardDao,
      DonationAdminPrompt donationAdminPrompt) {

    this.donationBoardDao = donationBoardDao;
    this.donationAdminPrompt = donationAdminPrompt;
  }


  // 모금함 개설 신청내역 상세보기 -> 관리자에게 전달
  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

    System.out.println();
    System.out.println("[모금함 개설 신청내역 상세보기]");
    System.out.println();
    if (donationBoardList.isEmpty()) {
      System.out.println("[ 현재 등록된 모금함 개설목록이 없습니다. ]");
      return;
    }

    DonationBoardDTO donationBoardAdminDTO = donationAdminPrompt.promptDonation();

    if (donationBoardAdminDTO == null) {
      System.out.println();
      System.out.println("[ 해당 번호의 모금함 개설 신청내역이 없습니다. ]");
      return;
    }

    System.out.println();
    System.out.printf("개설번호: %s\n", donationBoardAdminDTO.getNo());
    System.out.printf("개설분류: %s\n", donationBoardAdminDTO.getCategory().getTitle());
    System.out.printf("주최자: %s\n", donationBoardAdminDTO.getLeader().getName());
    System.out.printf("제목: %s\n", donationBoardAdminDTO.getTitle());
    System.out.printf("내용: %s\n", donationBoardAdminDTO.getContent());
    System.out.printf("첨부파일: %s\n", donationBoardAdminDTO.getFileNames());
    System.out.printf("시작일: %s\n", donationBoardAdminDTO.getStartDate());
    System.out.printf("종료일: %s\n", donationBoardAdminDTO.getEndDate());
    System.out.printf("목표금액: %s원\n", formatter.format(donationBoardAdminDTO.getMoneyTarget()));
    System.out.printf("승인여부: %d\n", donationBoardAdminDTO.getStatus());

    request.setAttribute("donationBoardAdminDTO", donationBoardAdminDTO); 

    while (true) {
      System.out.println();
      String input = Prompt.inputString("[승인(U), 반려(D), 이전(0)]>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/donationBoard/acceptApply").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/donationBoard/rejectApply").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }

  }

}



















































