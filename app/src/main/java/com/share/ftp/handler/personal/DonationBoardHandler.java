package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardHandler {


  static final int MAX_LENGTH = 10;
  int size;


  DonationBoardDTO[] donationBoardDTO = new DonationBoardDTO[MAX_LENGTH];
  DonationDetailHandler donationDetailHandler;
  DonationRegisterHandler donationRegisterHandler;

  public DonationBoardHandler(DonationDetailHandler donationDetailHandler, DonationRegisterHandler donationRegisterHandler) {
    this.donationDetailHandler = donationDetailHandler;
    this.donationRegisterHandler = donationRegisterHandler;
  }

  public void list() {
    System.out.println("[모금함 목록]");
  }

  public void detailDonation() {
    while (true) {
      try {
        System.out.println("1. 모금함 정보 상세보기");
        System.out.println("2. 기부하기");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("모금함 상세보기> ");
        switch (menuNo) {
          case 1: donationDetailHandler.detailDonationInfo(); break;
          case 2: donationDetailHandler.joinDonationList(); break;
          case 3: break;
          case 4: break;
          case 5: break;
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

  public void totalDonationDetail() {
    System.out.println("[기부 총 금액]");
  }

  public void applyDonation() {
    System.out.println("[모금함 개설 신청]");

    DonationBoardDTO donationBoard = new DonationBoardDTO();


    donationBoard.setNo(Prompt.inputInt("개설번호: "));
    donationBoard.setTitle(Prompt.inputString("제목: "));
    donationBoard.setLeader(Prompt.inputString("주최자: "));
    donationBoard.setContent(Prompt.inputString("내용: "));
    donationBoard.setFileUpload(Prompt.inputString("첨부파일: "));
    donationBoard.setPassword(Prompt.inputString("비밀번호: "));
    donationBoard.setRegisteredDate(Prompt.inputDate("제안기간(yyyy-mm-dd): "));

    donationBoardDTO[size++] = donationBoard;

    System.out.println("[모금함 개설 신청이 완료되었습니다.]");

  }

  public void applyDonationList() {
    System.out.println("[모금함 개설 신청 목록]");

    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          donationBoardDTO[i].getNo(), 
          donationBoardDTO[i].getTitle(), 
          donationBoardDTO[i].getLeader(),
          donationBoardDTO[i].getContent(),
          donationBoardDTO[i].getFileUpload(), 
          donationBoardDTO[i].getPassword(),
          donationBoardDTO[i].getRegisteredDate());
    }
  }

  public void applyDonationdetail() {
    System.out.println("[모금함 개설 신청내역 상세보기]");
    int no = Prompt.inputInt("번호? ");

    DonationBoardDTO donationBoard = findByNo(no);

    if (donationBoard == null) {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

    System.out.printf("개설번호: %s\n", donationBoard.getNo());
    System.out.printf("제목: %s\n", donationBoard.getTitle());
    System.out.printf("주최자: %s\n", donationBoard.getLeader());
    System.out.printf("내용: %s\n", donationBoard.getContent());
    System.out.printf("첨부파일: %d\n", donationBoard.getFileUpload());
    System.out.printf("제안기간: %d\n", donationBoard.getRegisteredDate());
  }

  private DonationBoardDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (donationBoardDTO[i].getNo() == no) {
        return donationBoardDTO[i];
      }
    }
    return null;
  }
}


















































