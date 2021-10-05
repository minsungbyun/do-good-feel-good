package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import static com.share.util.General.check.Rejected;
import java.text.DecimalFormat;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractDonationBoardHandler implements Command {

  // 모금함 개설 신청내역 전체 리스트
  protected List<DonationBoardDTO> donationBoardDTOList;

  // 모금함 개설 신청내역 승인 리스트
  protected List<DonationBoardDTO> donationBoardApplyDTOList;

  // 모금함 개설 신청내역 반려 리스트
  protected List<DonationBoardDTO> donationBoardRejectDTOList;

  protected List<DonationRegisterDTO> donationRegisterDTOList;
  protected DonationPrompt donationPrompt;
  protected DonationAdminPrompt donationAdminPrompt;

  // 마이페이지 리스트
  //  protected List<JoinDTO> joinDTOList;

  public AbstractDonationBoardHandler(List<DonationBoardDTO> donationBoardDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
  }

  public AbstractDonationBoardHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      DonationAdminPrompt donationAdminPrompt) {
    this.donationBoardDTOList = donationBoardDTOList;
    this.donationAdminPrompt = donationAdminPrompt;
  }

  public AbstractDonationBoardHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationRegisterDTO> donationRegisterDTOList,
      DonationPrompt donationPrompt) {
    this.donationBoardDTOList = donationBoardDTOList;
    this.donationRegisterDTOList = donationRegisterDTOList;
    this.donationPrompt = donationPrompt;
  }

  public AbstractDonationBoardHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    this(donationBoardDTOList);
    this.donationBoardApplyDTOList = donationBoardApplyDTOList;
    this.donationBoardRejectDTOList = donationBoardRejectDTOList;
  }

  protected static void printDonationBoard(DonationBoardDTO donationBoardDTO) {

    DecimalFormat formatter = new DecimalFormat("###,###,###");


    if (donationBoardDTO.getIsSigned().equals(Rejected)) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    } else if (donationBoardDTO.getIsSigned().equals(Applied)) {
      System.out.println();
      System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
      System.out.printf("개설분류: %s\n", donationBoardDTO.getSort());
      System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
      System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
      System.out.printf("내용: %s\n", donationBoardDTO.getContent());
      System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
      System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
      System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
      System.out.printf("모금함기간 ▶ %d일\n",  ((((donationBoardDTO.getRegisteredEndDate().getTime() - donationBoardDTO.getRegisteredStartDate().getTime()) / 1000)) / (24*60*60)));
      System.out.printf(getRemainTime(donationBoardDTO.getRegisteredEndDate().getTime() - System.currentTimeMillis()));
      System.out.printf("목표금액: %s원\n", formatter.format(donationBoardDTO.getMoneyTarget()));
      System.out.println();

    } else {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }
  }

  protected static String getRemainTime(long millis) {

    long sec = millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = millis / 1000 / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }


  protected DonationBoardDTO findByDonationApply(int no) {
    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }
}
