package com.share.ftp.handler.personal;

import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationBoardHandler {

  List<DonationBoardDTO> donationBoardDTOList;


  public DonationBoardHandler(List<DonationBoardDTO> donationBoardDTOList) {
    this.donationBoardDTOList = donationBoardDTOList;
  }

  // 모금함 목록
  public void list() {
    System.out.println("[모금함 목록]");
  }

  //  // 모금함 상세보기
  //  public void detailDonation() {
  //
  //
  //
  //    System.out.println("1. 모금함 상세보기");
  //    System.out.println("2. 기부하기");
  //    System.out.println("0. 이전메뉴");
  //    //    case 1: donationDetailHandler.detailDonationInfo(); break;
  //    //    case 2: donationDetailHandler.joinDonationList(); break;
  //
  //  }

  // 기부 총 금액
  //  public void totalDonationDetail() {
  //    System.out.println("[기부 총 금액]");
  //    donationRegisterHandler.totalDonationMoney();
  //  }

  // 모금함 개설 신청(기관)
  public void applyDonation() {
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

  // 모금함 개설 신청내역 목록을 -> 관리자에게 전달
  public void applyDonationList() {

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

  // 모금함 개설 신청내역 상세보기 -> 관리자에게 전달
  public void applyDonationdetail() {
    System.out.println("[모금함 개설 신청내역 상세보기]");
    int no = Prompt.inputInt("번호? ");

    DonationBoardDTO donationBoardDTO = findByNo(no);

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

    System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
    System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
    System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
    System.out.printf("내용: %s\n", donationBoardDTO.getContent());
    System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
    System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
    System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
  }

  private DonationBoardDTO findByNo(int no) {
    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }

  //해당 모금함 개설 신청을 승인한다.   
  //    public void acceptApply() {
  //  
  //  
  //      System.out.println("[모금함 개설신청서 승인]");
  //      int no = Prompt.inputInt("번호? ");
  //  
  //      int applyDonationIndex = indexOf(no);
  //  
  //      DonationBoardDTO donationBoardDTO = findByVol(no);
  //  
  //      for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
  //        if (this.personalRequestsDTO[i].getNo() == no) {
  //          personalRequestDTO = personalRequestsDTO[i];
  //          personalRequestIndex = i;
  //          break;
  //        }
  //      }
  //
  //
  //    if (applyDonationIndex == -1) {
  //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //    }
  //
  //    if (applyDonationIndex == null) {
  //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //    }
  //
  //
  //
  //
  //    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
  //      return;
  //    }
  //
  //    donationBoardDTO.setChecked(true);
  //    personalRequestApplyDTO[applySize++] = personalRequestDTO;
  //
  //    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
  //    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
  //    //    }
  //    //    this.personalRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사신청을 승인하였습니다.");
  //
  //  }
  //
  //
  //
  //  // 해당 봉사 신청서를 반려한다.
  //  public void rejectApply() {
  //    System.out.println();
  //    System.out.println("[개인봉사신청서 반려]");
  //
  //    int no = Prompt.inputInt("봉사번호? ");
  //
  //    int applyDonationIndex = indexOf(no);
  //    DonationBoardDTO donationBoardDTO = findByVol(no);
  //
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.personalRequestsDTO[i].getNo() == no) {
  //        personalRequestDTO = personalRequestsDTO[i];
  //        personalRequestIndex = i;
  //        break;
  //      }
  //    }
  //
  //    if (personalRequestIndex == -1) {
  //      System.out.println("개인봉사신청서를 찾을 수 없습니다.");
  //      return;
  //    }
  //
  //    if (personalRequestDTO == null) {
  //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //    }
  //
  //
  //    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      return;
  //    }
  //
  //    personalRequestDTO.setChecked(false);
  //    personalRequestApplyDTO[applySize++] = personalRequestDTO;
  //
  //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
  //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
  //    }
  //    this.personalRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사신청을 반려하였습니다.");
  //  }
  //  
  //  private int indexOf(int no) {
  //    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
  //      if (this.personalRequestsDTO[i].getNo() == no) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
  //
  //  public String getReturnMessage() {
  //    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
  //      if (this.personalRequestsDTO[i] == null) {
  //        return ""; 
  //      }
  //    }
  //    return null;
  //  }
  //
  //    private DonationBoardDTO findByVol(int no) {
  //      for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
  //        if (donationBoardDTO.getNo() == no) {
  //          return donationBoardDTO.getNo();
  //        }
  //      }
  //      return null;
  //  
  //    }
}


















































