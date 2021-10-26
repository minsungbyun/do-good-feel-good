package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.APPLIED;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardAttachedFile;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardUpdateHandler implements Command {

  DonationBoardDao donationBoardDao;
  SqlSession sqlSession;

  public DonationBoardUpdateHandler(DonationBoardDao donationBoardDao, SqlSession sqlSession) {
    this.donationBoardDao = donationBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[모금함 변경]");

    DonationBoardDTO donationBoard = (DonationBoardDTO) request.getAttribute("myDonationBoardNo");

    if (donationBoard == null) {
      System.out.println();
      System.out.println("해당 번호의 모금함이 없습니다.");
      return;
    }

    if (donationBoard.getStatus() == APPLIED) {
      System.out.println();
      System.out.println("[ 승인이 완료된 모금함은 변경 할 수 없습니다. ]");
      System.out.println("[ 관리자에게 문의 바랍니다. ]");
      return;
    }

    if (!AuthLoginHandler.getLoginUser().getId().equals(donationBoard.getLeader().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s) ▶ ", donationBoard.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s) ▶ ", donationBoard.getContent()));
    //    String fileUpload = Prompt.inputString(String.format("첨부파일(%s) ▶ ", donationBoard.getFileUpload()));
    donationBoard.setFileUpload(DonationBoardHelper.promptFileUpload());

    while (true) {
      donationBoard.setStartDate(Prompt.inputDate(String.format("시작일(%s) ▶ ", donationBoard.getStartDate())));
      donationBoard.setEndDate(Prompt.inputDate(String.format("종료일(%s) ▶ ", donationBoard.getEndDate())));

      if (donationBoard.getStartDate().compareTo(donationBoard.getEndDate()) > 0) {
        System.out.println("시작일이 종료일보다 클 수 없습니다 올바른 날짜를 입력해주세요!");
      } else if (donationBoard.getStartDate().compareTo(donationBoard.getEndDate()) == 0) {
        System.out.println("시작일과 종료일은 같을 수 없습니다.");
      } else {
        break;
      }
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("모금함 변경을 취소하였습니다.");
      return;
    }


    donationBoard.setTitle(title);
    donationBoard.setContent(content);

    try {
      donationBoardDao.update(donationBoard);
      donationBoardDao.deleteFile(donationBoard);
      for (DonationBoardAttachedFile donationBoardAttachedFile : donationBoard.getFileUpload()) {
        donationBoardDao.insertFile(donationBoard.getNo(), donationBoardAttachedFile.getFilepath());
      }
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
      // 그래야 다음 작업에 영향을 끼치지 않는다.
      sqlSession.rollback();
    }

    System.out.println("[ 모금함을 변경하였습니다. ]");
  }
}







