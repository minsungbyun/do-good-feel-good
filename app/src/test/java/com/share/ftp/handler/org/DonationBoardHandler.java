package com.share.ftp.handler.org;

import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardHandler {

  static final int MAX_LENGTH = 10;


  DonationBoardDTO[] donationBoards = new DonationBoardDTO[MAX_LENGTH];
  DonationRegisterHandler donationRegisterHandler;
  int size;

  public DonationBoardHandler(DonationRegisterHandler donationRegisterHandler) {
    this.donationRegisterHandler = donationRegisterHandler;
  }

  public void list() {
    System.out.println("모금함 목록");
  }

  public void detailDonation() {
    System.out.println("모금함 상세보기");
  }

  public void totalDonationDetail() {
    while (true) {
      try {
        System.out.println("[기부 총 금액]");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("신청내역 상세보기> ");
        switch (menuNo) {
          case 1: 
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();
      } catch (Throwable e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }

  public void applyDonation() {
    System.out.println("모금함 개설 신청");

    DonationBoardDTO donationBoard = new DonationBoardDTO();


    donationBoard.setNo(Prompt.inputInt("개설번호: "));
    donationBoard.setTitle(Prompt.inputString("제목: "));
    donationBoard.setLeader(Prompt.inputString("주최자: "));
    donationBoard.setContent(Prompt.inputString("내용: "));
    donationBoard.setFileUpload(Prompt.inputString("첨부파일: "));
    donationBoard.setPassword(Prompt.inputString("비밀번호: "));
    // donationBoard.setRegisteredDate(Prompt.inputDate("제안기간: "));

    this.donationBoards[this.size++] = donationBoard;

  }
}
