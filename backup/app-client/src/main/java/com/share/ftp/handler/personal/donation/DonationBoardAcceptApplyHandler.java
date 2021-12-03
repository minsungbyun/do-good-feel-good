package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardAcceptApplyHandler implements Command {

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;

  public DonationBoardAcceptApplyHandler(DonationBoardDao donationBoardDao, SqlSession sqlSession) {
    this.donationBoardDao = donationBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[모금함 개설신청서 승인]");

    //    int donationNo = (int) request.getAttribute("donationBoardAdminDTO");

    DonationBoardDTO donationBoardAdminDTO = (DonationBoardDTO) request.getAttribute("donationBoardAdminDTO");

    //    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(donationNo);


    System.out.println();
    String input = Prompt.inputString(donationBoardAdminDTO.getNo() +"번 모금함 개설신청서를 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println();
      System.out.println("[ 해당 모금함 개설신청 승인을 취소하였습니다. ]");
      return;
    }
    donationBoardAdminDTO.setStatus(APPLIED);

    donationBoardDao.updateStatus(donationBoardAdminDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("[ 해당 모금함 개설신청을 승인하였습니다. ]");


  }
}
