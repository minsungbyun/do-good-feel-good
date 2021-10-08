package com.share.ftp.handler.personal.donation;

import java.sql.Date;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardDetailRegisterAddHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  DonationBoardDao donationBoardDao;
  DonationRegisterDao donationRegisterDao;
  JoinDao joinDao;

  public DonationBoardDetailRegisterAddHandler(
      DonationBoardDao donationBoardDao,
      DonationRegisterDao donationRegisterDao,
      JoinDao joinDao) {
    this.donationBoardDao = donationBoardDao;
    this.donationRegisterDao = donationRegisterDao;
    this.joinDao = joinDao;
  }

  // 모금함 기부하기
  @Override
  public void execute(CommandRequest request) throws Exception {

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");

    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    //    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

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
        //        AuthLoginHandler.getLoginUser().setDonationMoney(myDonationMoney);
        joinDTO.setDonationMoney(myDonationMoney);


        DonationRegisterDTO.totalDonationMoney += donationRegister.getDonationMoney();

        donationRegisterDao.insert(donationRegister);
        joinDao.update(joinDTO);

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




















