package com.share.ftp.handler.personal.donation;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationRegisterAddHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳


  public DonationRegisterAddHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    super(donationRegisterDTOList);
  }

  // 모금함 기부하기
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[모금함 기부하기]");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    donationRegister.setSort(promptSort());

    donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
    donationRegister.setName(AuthLoginHandler.getLoginUser().getName());
    donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
    donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd): "));
    donationRegister.setTel(Prompt.inputString("연락처: "));
    donationRegister.setEmail(Prompt.inputString("이메일: "));
    donationRegister.setAddress(Prompt.inputString("주소: "));
    donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));

    donationRegisterDTOList.add(donationRegister);

    System.out.println("[기부가 완료되었습니다.]");

  }
}















