package com.share.ftp.handler.personal.donation;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardDetailRegisterAddHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<JoinDTO> joinDTOList;
  List<DonationBoardDTO> donationBoardDTOList;

  public DonationBoardDetailRegisterAddHandler(
      List<DonationRegisterDTO> donationRegisterDTOList,
      List<JoinDTO> joinDTOList,
      List<DonationBoardDTO> donationBoardDTOList) {
    super(donationRegisterDTOList);
    this.joinDTOList = joinDTOList;
    this.donationBoardDTOList = donationBoardDTOList;
  }

  // 모금함 기부하기
  @Override
  public void execute(CommandRequest request) throws Exception {

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    if (joinDTO == null) {
      System.out.println();
      System.out.println("[ 로그인 후 사용가능합니다. ]");
      return;
    }

    while (true) {
      try {
        System.out.println();

        donationRegister.setNo(donationBoardDTO.getNo());
        donationRegister.setSort(donationBoardDTO.getSort());
        donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
        donationRegister.setName(AuthLoginHandler.getLoginUser().getName());
        donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
        donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd): "));
        donationRegister.setTel(Prompt.inputString("연락처: "));
        donationRegister.setEmail(Prompt.inputString("이메일: "));
        donationRegister.setAddress(Prompt.inputString("주소: "));
        donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));
        donationRegister.addMembers(AuthLoginHandler.getLoginUser());

        int myDonationMoney = AuthLoginHandler.getLoginUser().getDonationMoney();
        myDonationMoney += donationRegister.getDonationMoney();
        AuthLoginHandler.getLoginUser().setDonationMoney(myDonationMoney);


        DonationRegisterDTO.totalDonationMoney += donationRegister.getDonationMoney();
        donationRegisterDTOList.add(donationRegister);

      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");
        continue; // 나중에 설정할거

      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("다시 입력 바랍니다.");
        System.out.println("--------------------------------------------------------------");
        continue;
      }
      break;
    }
    System.out.println();
    System.out.println("[기부가 완료되었습니다.]");
  } 
}




















