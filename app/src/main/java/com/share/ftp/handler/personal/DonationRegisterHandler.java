package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  static final int MAX_LENGTH = 10;

  DonationRegisterDTO[] donationRegisters = new DonationRegisterDTO[MAX_LENGTH];

  int size;
  int total;


  // 모금함 기부하기
  public void add() {
    System.out.println("[모금함 기부하기]");
    System.out.println("[1.아동] [2.청소년] [3.어르신] [4.장애인] [5.동물] [6.환경] [7.기타]");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();
    donationRegister.setNo(Prompt.inputInt("기부 번호: "));
    donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
    donationRegister.setName(Prompt.inputString("이름: "));
    donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
    donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd): "));
    donationRegister.setTel(Prompt.inputString("연락처: "));
    donationRegister.setEmail(Prompt.inputString("이메일: "));
    donationRegister.setAddress(Prompt.inputString("주소: "));

    donationRegisters[size++] = donationRegister;

    System.out.println("[기부가 완료되었습니다.]");

  }

  // 모금함 기부 목록
  public void applyDonationList() {
    System.out.println("[모금함 기부 목록]");

    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %d, %s, %s, %s, %s, %s, %s\n", 
          donationRegisters[i].getNo(), 
          donationRegisters[i].getDonationMoney(), 
          donationRegisters[i].getName(), 
          donationRegisters[i].getRegisterationNumber(),
          donationRegisters[i].getBirthDate(),
          donationRegisters[i].getTel(), 
          donationRegisters[i].getEmail(),
          donationRegisters[i].getAddress());
    }
  }

  public void totalDonationMoney() {

    for (int i = 0; i < this.size; i++) {
      total += donationRegisters[i].getDonationMoney();
    }
    System.out.printf("기부 총 금액 : %d\n", total);
  }

}
















