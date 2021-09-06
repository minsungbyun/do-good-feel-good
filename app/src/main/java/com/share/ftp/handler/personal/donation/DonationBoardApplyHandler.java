package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardApplyHandler extends AbstractDonationBoardHandler {

  List<JoinDTO> joinDTOList;

  public DonationBoardApplyHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<JoinDTO> joinDTOList) {

    super(donationBoardDTOList);
    this.joinDTOList = joinDTOList;
    //    // 기부하기 테스트
    //    DonationBoardDTO donation = new DonationBoardDTO();
    //    donation.setNo(1);
    //    donation.setTitle("코로나극복");
    //    donation.setLeader("한국코로나");
    //    donation.setContent("코로나극복을위하여 도와주세요");
    //    donation.setFileUpload("aaa.jpg");
    //    donation.setPassword("111");
    //    donation.setRegisteredStartDate(new Date(System.currentTimeMillis()));
    //    donation.setRegisteredEndDate(new Date(System.currentTimeMillis()));
    //    donation.setOrg(false);
    //    donation.getIsSigned();
    //
    //    donationBoardDTOList.add(donation);

  }

  // 모금함 개설 신청(기관)
  @Override
  public void execute() {

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    if (joinDTO == null) {
      System.out.println("로그인 후 사용가능합니다.");
      return;
    }

    while (true) {
      try {

        DonationBoardDTO donationBoardDTO = new DonationBoardDTO();

        System.out.println("[모금함 개설 신청]");
        System.out.println("[1.아동] [2.청소년] [3.어르신] [4.장애인] [5.동물] [6.환경] [7.기타] ");

        donationBoardDTO.setNo(Prompt.inputInt("개설번호 ▶"));
        donationBoardDTO.setTitle(Prompt.inputString("제목 ▶"));
        donationBoardDTO.setLeader(AuthLoginHandler.getLoginUser().getName());
        donationBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
        donationBoardDTO.setFileUpload(Prompt.inputString("첨부파일 ▶ "));
        donationBoardDTO.setRegisteredStartDate(Prompt.inputDate("시작일(yyyy-mm-dd) ▶ "));
        donationBoardDTO.setRegisteredEndDate(Prompt.inputDate("종료일(yyyy-mm-dd) ▶ "));
        donationBoardDTO.setOrg(true);
        donationBoardDTO.setChecked(false);
        donationBoardDTO.getIsSigned();


        donationBoardDTOList.add(donationBoardDTO);

      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");
        continue;

      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("다시 입력 바랍니다.");
        System.out.println("--------------------------------------------------------------");
        continue;
      }
      break;
    }

    System.out.println("모금함 개설신청이 완료되었습니다.");

  }
}


















































