package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.WAITING;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.donation.DonationBoardAttachedFile;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class DonationBoardApplyHandler implements Command {

  DonationBoardDao donationBoardDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public DonationBoardApplyHandler(DonationBoardDao donationBoardDao, GeneralDao generalDao,
      SqlSession sqlSession) {
    this.donationBoardDao = donationBoardDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  // 모금함 개설 신청(기관)
  @Override
  public void execute(CommandRequest request) throws Exception {

    OrgDTO orgDTO = (OrgDTO) AuthLoginHandler.getLoginUser();


    if (orgDTO.getType() != 3) {
      System.out.println("기관 회원만 개설 신청 가능합니다!");
      return;
    }


    while (true) {
      try {

        DonationBoardDTO donationBoardDTO = new DonationBoardDTO();

        System.out.println();
        donationBoardDTO.setOrgNo(orgDTO.getOrgNo());
        donationBoardDTO.setCategory(new GeneralHelper(generalDao).promptCategory());
        donationBoardDTO.setLeader(orgDTO);
        donationBoardDTO.setTitle(Prompt.inputString("제목 ▶"));
        donationBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
        donationBoardDTO.setTel(Prompt.inputString("전화번호 ▶ "));
        donationBoardDTO.setEmail(Prompt.inputString("이메일 ▶ "));
        donationBoardDTO.setMoneyTarget(Prompt.inputLong("목표금액 ▶ "));
        donationBoardDTO.setStartDate(Prompt.inputDate("시작일(yyyy-mm-dd) ▶ "));
        donationBoardDTO.setEndDate(Prompt.inputDate("종료일(yyyy-mm-dd) ▶ "));
        donationBoardDTO.setFileUpload(DonationBoardHelper.promptFileUpload());
        donationBoardDTO.setStatus(WAITING);

        try {
          donationBoardDao.insert(donationBoardDTO);
          for (DonationBoardAttachedFile donationBoardAttachedFile : donationBoardDTO.getFileUpload()) {
            donationBoardDao.insertFile(donationBoardDTO.getNo(), donationBoardAttachedFile.getFilepath());
          }
          sqlSession.commit();

        } catch (Exception e) {
          e.printStackTrace();
          sqlSession.rollback();
        }

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
    System.out.println("[ 모금함 개설신청이 완료되었습니다. ]");

  }
}


















































