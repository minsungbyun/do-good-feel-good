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

        System.out.println();
        System.out.println("[모금함 개설 신청]");

        System.out.println();
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
          System.out.println("모금함 개설 신청을 취소하셨습니다.");
          return;
        } else if (input == 1) {
          donationBoardDTO.setSort(donationBoardDTO.getChildren());
        } else if (input == 2) {
          donationBoardDTO.setSort(donationBoardDTO.getChildren());
        } else if (input == 3) {
          donationBoardDTO.setSort(donationBoardDTO.getElder());
        } else if (input == 4) {
          donationBoardDTO.setSort(donationBoardDTO.getHandicappedPerson());
        } else if (input == 5) {
          donationBoardDTO.setSort(donationBoardDTO.getAnimal());
        } else if (input == 6) {
          donationBoardDTO.setSort(donationBoardDTO.getEnvironmental());
        } else if (input == 7) {
          donationBoardDTO.setSort(donationBoardDTO.getOther());
        } else {
          System.out.println(" [ 양식에 있는 번호를 입력해주세요. ] ");
          return;
        }

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


















































