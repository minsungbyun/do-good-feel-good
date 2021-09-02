package com.share.ftp.handler.guest;

import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardHandler {

  static final int MAX_LENGTH = 10;

  DonationBoardDTO[] donationBoardsDTO = new DonationBoardDTO[MAX_LENGTH];
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

    DonationBoardDTO donationBoardDTO = new DonationBoardDTO();


    donationBoardDTO.setNo(Prompt.inputInt("개설번호: "));
    donationBoardDTO.setTitle(Prompt.inputString("제목: "));
    donationBoardDTO.setLeader(Prompt.inputString("주최자: "));
    donationBoardDTO.setContent(Prompt.inputString("내용: "));
    donationBoardDTO.setFileUpload(Prompt.inputString("첨부파일: "));
    donationBoardDTO.setPassword(Prompt.inputString("비밀번호: "));
    donationBoardDTO.setRegisteredStartDate(Prompt.inputDate("시작일: "));
    donationBoardDTO.setRegisteredEndDate(Prompt.inputDate("종료일: "));

    this.donationBoardsDTO[this.size++] = donationBoardDTO;

  }
}
