package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardUpdateHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardUpdateHandler(DonationBoardDao donationBoardDao) {
    this.donationBoardDao = donationBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[모금함 변경]");
    int donationNo = (int) request.getAttribute("myDonationBoardNo");

    DonationBoardDTO donationBoard = donationBoardDao.findByNo(donationNo);

    if (donationBoard == null) {
      System.out.println();
      System.out.println("해당 번호의 모금함이 없습니다.");
      return;
    }

    if (donationBoard.getIsSigned().equals(Applied)) {
      System.out.println();
      System.out.println("[ 승인이 완료된 모금함은 변경 할 수 없습니다. ]");
      System.out.println("[ 관리자에게 문의 바랍니다. ]");
      return;
    }

    if (!donationBoard.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s) ▶ ", donationBoard.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s) ▶ ", donationBoard.getContent()));
    String fileUpload = Prompt.inputString(String.format("첨부파일(%s) ▶ ", donationBoard.getFileUpload()));

    while (true) {
      donationBoard.setRegisteredStartDate(Prompt.inputDate(String.format("시작일(%s) ▶ ", donationBoard.getRegisteredStartDate())));
      donationBoard.setRegisteredEndDate(Prompt.inputDate(String.format("종료일(%s) ▶ ", donationBoard.getRegisteredEndDate())));

      if (donationBoard.getRegisteredStartDate().compareTo(donationBoard.getRegisteredEndDate()) > 0) {
        System.out.println("시작일이 종료일보다 클 수 없습니다 올바른 날짜를 입력해주세요!");
      } else if (donationBoard.getRegisteredStartDate().compareTo(donationBoard.getRegisteredEndDate()) == 0) {
        System.out.println("시작일과 종료일은 같을 수 없습니다.");
      } else {
        break;
      }
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("모금함 변경을 취소하였습니다.");
      return;
    }


    donationBoard.setTitle(title);
    donationBoard.setContent(content);
    donationBoard.setFileUpload(fileUpload);
    donationBoardDao.update(donationBoard);

    System.out.println("[ 모금함을 변경하였습니다. ]");
  }
}







