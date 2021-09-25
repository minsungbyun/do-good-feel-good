package com.share.ftp.handler.personal.donation;

import static com.share.util.General.type.ANIMAL;
import static com.share.util.General.type.CHILDREN;
import static com.share.util.General.type.ELDER;
import static com.share.util.General.type.ENVIRONMENT;
import static com.share.util.General.type.HANDICAPPED;
import static com.share.util.General.type.OTHER;
import static com.share.util.General.type.TEEN;
import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationRegisterAddHandler extends AbstractDonationRegisterHandler { // 모금함 기부하기 양식 쓰는곳

  List<JoinDTO> joinDTOList;
  List<DonationBoardDTO> donationBoardDTOList;

  public DonationRegisterAddHandler(
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

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    if (joinDTO == null) {
      System.out.println("로그인 후 사용가능합니다.");
      return;
    }

    while (true) {
      try {
        System.out.println();
        System.out.println("[모금함 기부하기]");

        DonationRegisterDTO donationRegister = new DonationRegisterDTO();

        System.out.println("기부목록:");

        System.out.println("[0: 선택안함]");
        System.out.println("[1: 아동]");
        System.out.println("[2: 청소년]");
        System.out.println("[3: 노인]");
        System.out.println("[4: 장애인]");
        System.out.println("[5: 동물]");
        System.out.println("[6: 환경]");
        System.out.println("[7: 기타]");
        System.out.println();
        int input = Prompt.inputInt("유형 ▶ ");

        switch (input) {
          case 1: donationRegister.setSort(CHILDREN);        break;
          case 2: donationRegister.setSort(TEEN);            break;
          case 3: donationRegister.setSort(ELDER);           break;
          case 4: donationRegister.setSort(HANDICAPPED);     break;
          case 5: donationRegister.setSort(ANIMAL);          break;
          case 6: donationRegister.setSort(ENVIRONMENT);     break;
          case 7: donationRegister.setSort(OTHER);           break;
          case 0: System.out.println("[ 기부를 취소하셨습니다. ]");      return;
          default: System.out.println(" [ 양식에 있는 번호를 입력해주세요. ] "); continue;
        }

        //      if (input == 0) {
        //        System.out.println("[ 기부를 취소하셨습니다. ]");
        //        return;
        //      } else if (input == 1) {
        //        System.out.printf("기부목록: %s\n", CHILDREN);
        //        donationRegister.setSort(CHILDREN);
        //      } else if (input == 2) {
        //        System.out.printf("기부목록: %s\n", TEEN);
        //        donationRegister.setSort(TEEN);
        //      } else if (input == 3) {
        //        System.out.printf("기부목록: %s\n", ELDER);
        //        donationRegister.setSort(ELDER);
        //      } else if (input == 4) {
        //        System.out.printf("기부목록: %s\n", HANDICAPPED);
        //        donationRegister.setSort(HANDICAPPED);
        //      } else if (input == 5) {
        //        System.out.printf("기부목록: %s\n", ANIMAL);
        //        donationRegister.setSort(ANIMAL);
        //      } else if (input == 6) {
        //        System.out.printf("기부목록: %s\n", ENVIRONMENT);
        //        donationRegister.setSort(ENVIRONMENT);
        //      } else if (input == 7) {
        //        System.out.printf("기부목록: %s\n", OTHER);
        //        donationRegister.setSort(OTHER);
        //      } else {
        //        System.out.println(" [ 양식에 있는 번호를 입력해주세요. ] ");
        //        return;
        //      }

        for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
          if (input == donationBoardDTO.getNo()) {
            donationRegister.setNo(donationBoardDTO.getNo());
          } else {
            donationRegister.setNo(input);
            continue;
          }
        }

        System.out.printf("기부목록: %s\n", donationRegister.getSort());
        donationRegister.setDonationMoney(Prompt.inputInt("기부 금액 ▶ "));
        donationRegister.setName(AuthLoginHandler.getLoginUser().getName());
        donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호 ▶ "));
        donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd) ▶ "));
        donationRegister.setTel(Prompt.inputString("연락처 ▶ "));
        donationRegister.setEmail(Prompt.inputString("이메일 ▶ "));
        donationRegister.setAddress(Prompt.inputString("주소 ▶ "));
        donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));

        int myDonationMoney = AuthLoginHandler.getLoginUser().getDonationMoney();
        myDonationMoney += donationRegister.getDonationMoney();
        AuthLoginHandler.getLoginUser().setDonationMoney(myDonationMoney);

        DonationRegisterDTO.totalDonationMoney += donationRegister.getDonationMoney();
        donationRegisterDTOList.add(donationRegister);


      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");

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




















