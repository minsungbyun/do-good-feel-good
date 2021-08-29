package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  static final int MAX_LENGTH = 10;

  DonationRegisterDTO[] donationRegisters = new DonationRegisterDTO[MAX_LENGTH];
  int size;

  // 모금함 기부하기
  public void add() {
    System.out.println("[모금함 기부하기]");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    donationRegister.setNo(Prompt.inputInt("기부 번호: "));
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
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          donationRegisters[i].getNo(), 
          donationRegisters[i].getName(), 
          donationRegisters[i].getRegisterationNumber(),
          donationRegisters[i].getBirthDate(),
          donationRegisters[i].getTel(), 
          donationRegisters[i].getEmail(),
          donationRegisters[i].getAddress());
    }
  }

}
