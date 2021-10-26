package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardDeleteHandler implements Command {

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;

  public DonationBoardDeleteHandler(DonationBoardDao donationBoardDao, SqlSession sqlSession) {
    this.donationBoardDao = donationBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[모금함 삭제]");

    DonationBoardDTO donationBoardDTO = (DonationBoardDTO) request.getAttribute("myDonationBoardNo");

    if (donationBoardDTO == null) {
      System.out.println("해당 번호의 모금함이 없습니다.");
      return;
    }

    if (donationBoardDTO.getStatus() == APPLIED) {
      System.out.println();
      System.out.println("[ 승인이 완료된 모금함은 삭제 할 수 없습니다. ]");
      System.out.println("[ 관리자에게 문의 바랍니다. ]");
      return;
    }


    if (!AuthLoginHandler.getLoginUser().getId().equals(donationBoardDTO.getLeader().getId())) {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("모금함 삭제를 취소하였습니다.");
      return;
    }

    try {
      donationBoardDao.deleteFile(donationBoardDTO);
      donationBoardDao.delete(donationBoardDTO);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    System.out.println("모금함을 삭제하였습니다.");
  }
}







