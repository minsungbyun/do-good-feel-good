package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<DonationRegisterDTO> donationRegisterDTOList;
  int total;

  public DonationRegisterHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    this.donationRegisterDTOList = donationRegisterDTOList;
  }

  // 모금함 기부하기
  public void add() {
    System.out.println("[모금함 기부하기]");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    donationRegister.setSort(promptSort());
    donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
    donationRegister.setName(Prompt.inputString("이름: "));
    donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
    donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd): "));
    donationRegister.setTel(Prompt.inputString("연락처: "));
    donationRegister.setEmail(Prompt.inputString("이메일: "));
    donationRegister.setAddress(Prompt.inputString("주소: "));
    donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));

    donationRegisterDTOList.add(donationRegister);

    System.out.println("[기부가 완료되었습니다.]");

  }

  // 모금함 기부 목록
  public void applyDonationList() {
    System.out.println("[모금함 기부 목록]");

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      System.out.printf("%d, %d, %s, %s, %s, %s, %s, %s\n", 
          donationRegisterDTO.getNo(), 
          donationRegisterDTO.getDonationMoney(), 
          donationRegisterDTO.getName(), 
          donationRegisterDTO.getRegisterationNumber(),
          donationRegisterDTO.getBirthDate(),
          donationRegisterDTO.getTel(), 
          donationRegisterDTO.getEmail(),
          donationRegisterDTO.getAddress());
    }
  }

  // 모금함 기부 참여내역
  public void participationDonation() {
    System.out.println("[모금함 기부 참여내역]");

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      System.out.printf("모금함번호: %s\n %s, %s, %s\n", 
          donationRegisterDTO.getSort(), 
          donationRegisterDTO.getName(), 
          donationRegisterDTO.getDonationMoney(), 
          donationRegisterDTO.getRegisteredDate());
    }
  }

  private static String getSortLabel(int sort) {
    //[1.아동] [2.청소년] [3.어르신] [4.장애인] [5.동물] [6.환경] [7.기타]");
    switch (sort) {
      case 1: return "아동";
      case 2: return "청소년";
      case 3: return "어르신";
      case 4: return "장애인";
      case 5: return "동물";
      case 6: return "환경";
      case 7: return "기타";
      default: return null;
    }
  }

  private static int promptSort() {
    return promptSort(-1);
  }

  private static int promptSort(int sort) {
    if (sort == -1) {
      System.out.println("기부목록:");
    } else {
      System.out.printf("상태(%s)?\n", getSortLabel(sort));
    }
    System.out.println("[0: 선택안함]");
    System.out.println("[1: 아동]");
    System.out.println("[2: 청소년]");
    System.out.println("[3: 어르신]");
    System.out.println("[4: 장애인]");
    System.out.println("[5: 동물]");
    System.out.println("[6: 환경]");
    System.out.println("[7: 기타]");
    return Prompt.inputInt("> ");
  }

  //  public void detail() {
  //    System.out.println("[기부내역 상세보기]");
  //    String id = Prompt.inputString("아이디? "); 
  //    String password = Prompt.inputString("비밀번호? ");
  //
  //    JoinDTO joinDTO = findByMember(id, password);
  //
  //    if (joinDTO == null) {
  //      System.out.println("해당 아이디와 비밀번호가 일치하지 않습니다.");
  //      return;
  //    }
  //
  //    System.out.printf("이름: %s\n", joinDTO.getName());
  //    System.out.printf("전화: %s\n", joinDTO.getTel());
  //    System.out.printf("이메일: %s\n", joinDTO.getEmail());
  //    System.out.printf("주소: %s\n", joinDTO.getAdress());
  //    System.out.printf("등록일: %s\n", joinDTO.getRegisterDate());
  //  }

  public void totalDonationMoney() {

    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      total += donationRegisterDTO.getDonationMoney();
    }
    System.out.printf("기부 총 금액 : %d\n", total);
  }
}















