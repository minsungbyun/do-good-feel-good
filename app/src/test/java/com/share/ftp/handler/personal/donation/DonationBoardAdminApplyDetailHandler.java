package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationBoardAdminApplyDetailHandler extends AbstractDonationBoardHandler {


  List<DonationRegisterDTO> donationRegisterDTOList;
  DonationPrompt donationPrompt;

  public DonationBoardAdminApplyDetailHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationRegisterDTO> donationRegisterDTOList,
      DonationPrompt donationPrompt) {
    super(donationBoardDTOList);
    this.donationRegisterDTOList = donationRegisterDTOList;
    this.donationPrompt = donationPrompt;
  }


  // 모금함 개설 신청내역 상세보기 -> 관리자에게 전달
  @Override
  public void execute() {
    System.out.println("[모금함 개설 신청내역 상세보기]");
    int no = Prompt.inputInt("번호? ");

    DonationBoardDTO donationBoardDTO = findByDonationApply(no);

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

    System.out.println();
    System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
    System.out.printf("개설분류: %s\n", donationBoardDTO.getSort());
    System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
    System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
    System.out.printf("내용: %s\n", donationBoardDTO.getContent());
    System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
    System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
    System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
    System.out.printf("승인여부: %s\n", donationBoardDTO.getIsSigned());

  }

}



















































