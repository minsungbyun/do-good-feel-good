package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import static com.share.util.General.check.REJECTED;
import static com.share.util.General.check.WAITING;
import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardApplyDetailHandler implements Command {

  DonationBoardDao donationBoardDao;
  DonationPrompt donationPrompt;
  DonationRegisterDao donationRegisterDao;

  public DonationBoardApplyDetailHandler(
      DonationBoardDao donationBoardDao,
      DonationPrompt donationPrompt,
      DonationRegisterDao donationRegisterDao) {
    this.donationBoardDao = donationBoardDao;
    this.donationPrompt = donationPrompt;
    this.donationRegisterDao = donationRegisterDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    DonationBoardDTO donationBoardDTO = donationPrompt.promptDonation();

    if (donationBoardDTO == null) {
      System.out.println();
      System.out.println("[ 모금함 상세보기를 취소하셨습니다. ]");
      return;
    }

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    long remainMoney = donationRegisterDao.findByRemainMoney(donationBoardDTO.getNo());


    if (donationBoardDTO.getStatus() == APPLIED) {
      System.out.println();
      System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
      System.out.printf("개설분류: %s\n", donationBoardDTO.getCategory().getTitle());
      System.out.printf("주최자: %s\n", donationBoardDTO.getLeader().getName());
      System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
      System.out.printf("내용: %s\n", donationBoardDTO.getContent());
      System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileNames());
      System.out.printf("시작일: %s\n", donationBoardDTO.getStartDate());
      System.out.printf("종료일: %s\n", donationBoardDTO.getEndDate());
      System.out.printf("목표금액: %s원\n", formatter.format(donationBoardDTO.getMoneyTarget()));
      System.out.printf("남은금액: %s", formatter.format(remainMoney));
      System.out.println();
    } else {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

    if (donationBoardDTO.getStatus() == REJECTED || donationBoardDTO.getStatus() == WAITING) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }


    request.setAttribute("donationBoardDTO", donationBoardDTO);

    while (true) {
      String input = Prompt.inputString("기부하기(U), 모금함 기부자 내역(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/donationBoardDetailRegister/add").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/donationBoardRegister/list").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }
}




















































