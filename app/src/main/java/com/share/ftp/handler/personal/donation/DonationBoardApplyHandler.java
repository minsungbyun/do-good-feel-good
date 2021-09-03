package com.share.ftp.handler.personal.donation;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardApplyHandler extends AbstractDonationBoardHandler {


  public DonationBoardApplyHandler(List<DonationBoardDTO> donationBoardDTOList) {
    super(donationBoardDTOList);
    // 기부하기 테스트
    DonationBoardDTO donation = new DonationBoardDTO();
    donation.setNo(1);
    donation.setTitle("코로나극복");
    donation.setLeader("한국코로나");
    donation.setContent("코로나극복을위하여 도와주세요");
    donation.setFileUpload("aaa.jpg");
    donation.setPassword("111");
    donation.setRegisteredStartDate(new Date(System.currentTimeMillis()));
    donation.setRegisteredEndDate(new Date(System.currentTimeMillis()));
    donation.setOrg(false);

    donationBoardDTOList.add(donation);

  }

  // 모금함 개설 신청(기관)
  @Override
  public void execute() {
    System.out.println("[모금함 개설 신청]");
    System.out.println("[1.아동] [2.청소년] [3.어르신] [4.장애인] [5.동물] [6.환경] [7.기타] ");

    DonationBoardDTO donationBoardDTO = new DonationBoardDTO();

    try {
      donationBoardDTO.setNo(Prompt.inputInt("개설번호: "));
      donationBoardDTO.setTitle(Prompt.inputString("제목: "));
      donationBoardDTO.setLeader(Prompt.inputString("주최자: "));
      donationBoardDTO.setContent(Prompt.inputString("내용: "));
      donationBoardDTO.setFileUpload(Prompt.inputString("첨부파일: "));
      donationBoardDTO.setPassword(Prompt.inputString("비밀번호: "));
      donationBoardDTO.setRegisteredStartDate(Prompt.inputDate("시작일(yyyy-mm-dd): "));
      donationBoardDTO.setRegisteredEndDate(Prompt.inputDate("종료일(yyyy-mm-dd): "));
      donationBoardDTO.setOrg(false);

      donationBoardDTOList.add(donationBoardDTO);

      System.out.println("[모금함 개설 신청이 완료되었습니다.]");

    } catch (Throwable e) {
      System.out.println("--------------------------------------------------------------");
      System.out.printf("오류 발생: %s\n", e.getClass().getName());
      System.out.println("--------------------------------------------------------------");
      System.out.println("제안기간의 양식에 맞춰서 작성 해주세요");
    }
  }
}


















































