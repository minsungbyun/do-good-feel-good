package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;

public class DonationBoardApplyListHandler extends AbstractDonationBoardHandler {


  public DonationBoardApplyListHandler(List<DonationBoardDTO> donationBoardDTOList) {
    super(donationBoardDTOList);
  }

  // 모금함 개설 신청내역 목록을 -> 관리자에게 전달
  @Override
  public void execute() {

    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      System.out.printf("개설번호: %d\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n개설기간: %s~%s\n승인여부: %b\n", 
          donationBoardDTO.getNo(), 
          donationBoardDTO.getTitle(), 
          donationBoardDTO.getLeader(),
          donationBoardDTO.getContent(),
          donationBoardDTO.getFileUpload(), 
          donationBoardDTO.getPassword(),
          donationBoardDTO.getRegisteredStartDate(),
          donationBoardDTO.getRegisteredEndDate(),
          donationBoardDTO.isChecked());
    }
  }
}


















































