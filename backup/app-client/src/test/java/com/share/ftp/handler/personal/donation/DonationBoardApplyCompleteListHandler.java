package com.share.ftp.handler.personal.donation;

import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardApplyCompleteListHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardApplyCompleteListHandler(DonationBoardDao donationBoardDao) {

    this.donationBoardDao = donationBoardDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    DecimalFormat formatter = new DecimalFormat("###,###,###");

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

    System.out.println();
    System.out.println("[나의 모금함 개설 신청서 목록]");

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 등록된 모금함 개설목록이 없습니다. ]");
      return;
    }

    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      if (donationBoardDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %s\n", 
            donationBoardDTO.getNo(), 
            donationBoardDTO.getSort(), 
            donationBoardDTO.getTitle(), 
            donationBoardDTO.getLeader(),
            donationBoardDTO.getContent(),
            donationBoardDTO.getFileUpload(), 
            donationBoardDTO.getRegisteredStartDate(),
            donationBoardDTO.getRegisteredEndDate(),
            formatter.format(donationBoardDTO.getMoneyTarget()),
            donationBoardDTO.getIsSigned());
        System.out.println("------------------------------------------");
      } 
      //      else if (!donationBoardDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {
      //        System.out.println();
      //        System.out.println("[ 현재 등록된 모금함 개설목록이 없습니다. ]");
      //        return;
      //      } 
    }


    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 모금함 변경, 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/donationBoard/connect").forward(request);return;
        case 0: return;
        default: System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}


















































