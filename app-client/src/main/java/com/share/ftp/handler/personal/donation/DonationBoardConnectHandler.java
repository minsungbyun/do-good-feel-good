package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardConnectHandler implements Command {

  DonationBoardDao donationBoardDao;


  public DonationBoardConnectHandler(DonationBoardDao donationBoardDao) {
    this.donationBoardDao = donationBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    System.out.println("[ 모금함 변경 or 삭제 ]");
    System.out.println();


    int donationBoardNo = Prompt.inputInt("모금함 번호를 입력해주세요 ▶ ");

    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(donationBoardNo);

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함이 없습니다.");
      return;
    }

    System.out.println();
    System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
    System.out.printf("개설분류: %s\n", donationBoardDTO.getCategory().getTitle());
    System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
    System.out.printf("주최자: %s\n", donationBoardDTO.getLeader().getName());
    System.out.printf("내용: %s\n", donationBoardDTO.getContent());
    System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileNames());
    System.out.printf("시작일: %s\n", donationBoardDTO.getStartDate());
    System.out.printf("종료일: %s\n", donationBoardDTO.getEndDate());
    System.out.printf("목표금액: %s원\n", formatter.format(donationBoardDTO.getMoneyTarget()));
    System.out.printf("승인여부: %d\n", donationBoardDTO.getStatus());


    request.setAttribute("myDonationBoardNo", donationBoardDTO); 


    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 모금함 변경");
      System.out.println("2번 ▶ 모금함 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/donationBoard/update").forward(request); return;
        case 2: request.getRequestDispatcher("/donationBoard/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}