package com.share.ftp.handler.org;

import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.util.Prompt;

public class DonationRegisterHandler {

  static final int MAX_LENGTH = 10;

  DonationRegisterDTO[] donationRegisters = new DonationRegisterDTO[MAX_LENGTH];
  int size;

  public void add() {
    System.out.println("모금함 기부하기");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    donationRegister.setNo(Prompt.inputInt("기부 번호: "));
    donationRegister.setName(Prompt.inputString("이름: "));
    donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
    donationRegister.setBirthDate(Prompt.inputDate("생년월일: "));
    donationRegister.setTel(Prompt.inputString("연락처: "));
    donationRegister.setEmail(Prompt.inputString("이메일: "));
    donationRegister.setAddress(Prompt.inputString("주소: "));

    this.donationRegisters[this.size++] = donationRegister;

  }
}
