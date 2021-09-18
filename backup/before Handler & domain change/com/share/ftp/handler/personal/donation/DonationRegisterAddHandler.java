package com.share.ftp.handler.personal.donation;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationRegisterAddHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<JoinDTO> joinDTOList;
  List<DonationBoardDTO> donationBoardDTOList;

  public DonationRegisterAddHandler(
      List<DonationRegisterDTO> donationRegisterDTOList,
      List<JoinDTO> joinDTOList,
      List<DonationBoardDTO> donationBoardDTOList) {
    super(donationRegisterDTOList);
    this.joinDTOList = joinDTOList;
    this.donationBoardDTOList = donationBoardDTOList;
  }

  // 모금함 기부하기
  @Override
  public void execute() {

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    if (joinDTO == null) {
      System.out.println("로그인 후 사용가능합니다.");
      return;
    }

    try {
      System.out.println();
      System.out.println("[모금함 기부하기]");

      DonationRegisterDTO donationRegister = new DonationRegisterDTO();

      System.out.println("기부목록:");

      System.out.println("[0: 선택안함]");
      System.out.println("[1: 아동]");
      System.out.println("[2: 청소년]");
      System.out.println("[3: 어르신]");
      System.out.println("[4: 장애인]");
      System.out.println("[5: 동물]");
      System.out.println("[6: 환경]");
      System.out.println("[7: 기타]");
      int input = Prompt.inputInt("> ");


      if (input == 0) {
        System.out.println("[ 기부를 취소하셨습니다. ]");
        return;
      } else if (input == 1) {
        System.out.printf("기부목록: %s\n", donationRegister.getChildren());
        donationRegister.setSort(donationRegister.getChildren());
      } else if (input == 2) {
        System.out.printf("기부목록: %s\n", donationRegister.getTeen());
        donationRegister.setSort(donationRegister.getTeen());
      } else if (input == 3) {
        System.out.printf("기부목록: %s\n", donationRegister.getElder());
        donationRegister.setSort(donationRegister.getElder());
      } else if (input == 4) {
        System.out.printf("기부목록: %s\n", donationRegister.getHandicappedPerson());
        donationRegister.setSort(donationRegister.getHandicappedPerson());
      } else if (input == 5) {
        System.out.printf("기부목록: %s\n", donationRegister.getAnimal());
        donationRegister.setSort(donationRegister.getAnimal());
      } else if (input == 6) {
        System.out.printf("기부목록: %s\n", donationRegister.getEnvironmental());
        donationRegister.setSort(donationRegister.getEnvironmental());
      } else if (input == 7) {
        System.out.printf("기부목록: %s\n", donationRegister.getOther());
        donationRegister.setSort(donationRegister.getOther());
      } else {
        System.out.println(" [ 양식에 있는 번호를 입력해주세요. ] ");
        return;
      }

      for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
        if (input == donationBoardDTO.getNo()) {
          donationRegister.setNo(donationBoardDTO.getNo());
        } else {
          donationRegister.setNo(input);
          continue;
        }
      }

      donationRegister.setDonationMoney(Prompt.inputInt("기부 금액 ▶ "));
      donationRegister.setMyTotaldonationMoney(donationRegister.getDonationMoney());
      donationRegister.setName(AuthLoginHandler.getLoginUser().getName());
      donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호 ▶ "));
      donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd) ▶ "));
      donationRegister.setTel(Prompt.inputString("연락처 ▶ "));
      donationRegister.setEmail(Prompt.inputString("이메일 ▶ "));
      donationRegister.setAddress(Prompt.inputString("주소 ▶ "));
      donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));

      donationRegisterDTOList.add(donationRegister);

      System.out.println("[기부가 완료되었습니다.]");

    } catch (NumberFormatException e) {
      System.out.println("--------------------------------------------------------------");
      System.out.println("올바른 숫자를 입력하세요");
      System.out.println("--------------------------------------------------------------");

    } catch (Exception e) {
      System.out.println("--------------------------------------------------------------");
      //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
      System.out.println("다시 입력 바랍니다.");
      System.out.println("--------------------------------------------------------------");
    }
  }

}




















