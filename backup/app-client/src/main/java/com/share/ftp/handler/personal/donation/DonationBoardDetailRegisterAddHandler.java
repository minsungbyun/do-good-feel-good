package com.share.ftp.handler.personal.donation;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class DonationBoardDetailRegisterAddHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  DonationRegisterDao donationRegisterDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public DonationBoardDetailRegisterAddHandler(
      DonationRegisterDao donationRegisterDao, 
      GeneralDao generalDao, 
      SqlSession sqlSession) {
    this.donationRegisterDao = donationRegisterDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  // 모금함 기부하기
  @Override
  public void execute(CommandRequest request) throws Exception {

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("donationBoardDTO");


    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();


    //    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

    if (joinDTO == null) {
      System.out.println();
      System.out.println("[ 로그인 후 사용가능합니다. ]");
      return;
    }

    System.out.println();
    DonationRegisterDTO donationRegister = new DonationRegisterDTO();

    donationRegister.setDonator(joinDTO);
    donationRegister.setDonationBoard(donationBoardDTO);
    donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
    donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
    donationRegister.setPayTypeNo(new GeneralHelper(generalDao).promptPayType());
    donationRegister.setPayStatus(1);

    //        int myDonationMoney = AuthLoginHandler.getLoginUser().getDonationMoney();
    //        myDonationMoney += donationRegister.getDonationMoney();
    //        //        AuthLoginHandler.getLoginUser().setDonationMoney(myDonationMoney);
    //        joinDTO.setDonationMoney(myDonationMoney);
    //
    //
    //        DonationRegisterDTO.totalDonationMoney += donationRegister.getDonationMoney();

    donationRegisterDao.insert(donationRegister);
    sqlSession.commit();

    System.out.println();
    System.out.println("[기부가 완료되었습니다.]");
  } 
}




















