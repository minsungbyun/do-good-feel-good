package com.share.ftp.handler.guest;

import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardHandler {

  static final int MAX_LENGTH = 10;

  DonationBoardDTO[] donationBoards = new DonationBoardDTO[MAX_LENGTH];
  int size;

  public void list() {
    System.out.println("모금함 목록");
  }

  public void detailDonation() {
    System.out.println("모금함 상세보기");
  }

  public void totalDonationDetail() {
    System.out.println("기부 총 금액");
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
