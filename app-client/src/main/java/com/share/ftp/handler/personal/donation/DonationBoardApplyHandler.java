package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Waiting;
import static com.share.util.General.type.ANIMAL;
import static com.share.util.General.type.CHILDREN;
import static com.share.util.General.type.ELDER;
import static com.share.util.General.type.ENVIRONMENT;
import static com.share.util.General.type.HANDICAPPED;
import static com.share.util.General.type.OTHER;
import static com.share.util.General.type.TEEN;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardApplyHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardApplyHandler(DonationBoardDao donationBoardDao) {
    this.donationBoardDao = donationBoardDao;
  }

  // 모금함 개설 신청(기관)
  @Override
  public void execute(CommandRequest request) throws Exception {

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

        System.out.println("[1 ▶ 아동]");
        System.out.println("[2 ▶ 청소년]");
        System.out.println("[3 ▶ 노인]");
        System.out.println("[4 ▶ 장애인]");
        System.out.println("[5 ▶ 동물]");
        System.out.println("[6 ▶ 환경]");
        System.out.println("[7 ▶ 기타]");
        System.out.println("[0 ▶ 선택안함]");
        System.out.println();

        int input = Prompt.inputInt("유형 ▶ ");

        switch (input) {
          case 1: donationBoardDTO.setSort(CHILDREN);        break;
          case 2: donationBoardDTO.setSort(TEEN);            break;
          case 3: donationBoardDTO.setSort(ELDER);           break;
          case 4: donationBoardDTO.setSort(HANDICAPPED);     break;
          case 5: donationBoardDTO.setSort(ANIMAL);          break;
          case 6: donationBoardDTO.setSort(ENVIRONMENT);     break;
          case 7: donationBoardDTO.setSort(OTHER);           break;
          case 0: System.out.println("모금함 개설 신청을 취소하셨습니다.");      return;
          default: System.out.println(" [ 양식에 있는 번호를 입력해주세요. ] "); continue;
        }

        System.out.println();
        donationBoardDTO.setTitle(Prompt.inputString("제목 ▶"));
        donationBoardDTO.setLeader(AuthLoginHandler.getLoginUser().getName());
        donationBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
        donationBoardDTO.setMoneyTarget(Prompt.inputLong("목표금액 ▶ "));
        donationBoardDTO.setFileUpload(Prompt.inputString("첨부파일 ▶ "));

        while (true) {
          donationBoardDTO.setRegisteredStartDate(Prompt.inputDate("시작일(yyyy-mm-dd) ▶ "));
          donationBoardDTO.setRegisteredEndDate(Prompt.inputDate("종료일(yyyy-mm-dd) ▶ "));

          if (donationBoardDTO.getRegisteredStartDate().compareTo(donationBoardDTO.getRegisteredEndDate()) > 0) {
            System.out.println("시작일이 종료일보다 클 수 없습니다 올바른 날짜를 입력해주세요!");
          } else if (donationBoardDTO.getRegisteredStartDate().compareTo(donationBoardDTO.getRegisteredEndDate()) == 0) {
            System.out.println("시작일과 종료일은 같을 수 없습니다.");
          } else {
            break;
          }
        }


        donationBoardDTO.setIsSigned(Waiting);

        donationBoardDTO.setNo(donationBoardDao.getNextNum());
        //        donationBoardDTO.addMembers(AuthLoginHandler.getLoginUser());



        donationBoardDao.insert(donationBoardDTO);

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

    System.out.println();
    System.out.println("[ 모금함 개설신청이 완료되었습니다. ]");

  }
}


















































