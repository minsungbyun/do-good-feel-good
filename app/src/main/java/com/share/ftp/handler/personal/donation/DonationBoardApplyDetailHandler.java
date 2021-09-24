package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import static com.share.util.General.check.Rejected;
import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class DonationBoardApplyDetailHandler extends AbstractDonationBoardHandler {


  List<DonationRegisterDTO> donationRegisterDTOList;
  DonationPrompt donationPrompt;
  //  DonationRegisterParticipationListHandler donationRegisterParticipationListHandler;

  public DonationBoardApplyDetailHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationRegisterDTO> donationRegisterDTOList,
      DonationPrompt donationPrompt) {
    super(donationBoardDTOList);
    this.donationRegisterDTOList = donationRegisterDTOList;
    this.donationPrompt = donationPrompt;

  }


  // 모금함 개설 신청내역 상세보기 -> 관리자에게 전달
  @Override
  public void execute(CommandRequest request) throws Exception {
    //    System.out.println("[모금함 개설 신청내역 상세보기]");
    //    int no = Prompt.inputInt("번호? ");

    DonationBoardDTO donationBoardDTO = donationPrompt.promptDonation();

    if (donationBoardDTO == null) {
      System.out.println("모금함 상세보기를 취소하셨습니다.");
      return;
    }

    if (donationBoardDTO.getIsSigned().equals(Rejected)) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    } else if (donationBoardDTO.getIsSigned().equals(Applied)) {
      System.out.println();
      System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
      System.out.printf("개설분류: %s\n", donationBoardDTO.getSort());
      System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
      System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
      System.out.printf("내용: %s\n", donationBoardDTO.getContent());
      System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
      System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
      System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
      System.out.println();
      System.out.println("모금함 기부 참여자: ");


      if (donationRegisterDTOList.isEmpty()) {
        System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
      } else {
        for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
          if (donationRegisterDTO.getNo() == donationBoardDTO.getNo()) {
            System.out.printf("[ %s님, %d원, %s ]\n", 
                donationRegisterDTO.getName(), 
                donationRegisterDTO.getDonationMoney(), 
                donationRegisterDTO.getRegisteredDate());
          } 
        } 
      }

      //      if (donationRegisterDTOList.size() > 0 && ) {
      //        
      //          System.out.println("[  현재 참여된 기부 내역이 없습니다. ]");
      //        
      //      }



      //      donationRegisterParticipationListHandler.execute();


      System.out.println();
      String input = Prompt.inputString("해당 모금함에 기부하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[ 해당 모금함 기부를 취소하였습니다. ]");
        return;
      } else if (input.equalsIgnoreCase("y")) {

        DonationRegisterDTO donationRegister = new DonationRegisterDTO();

        System.out.println();

        donationRegister.setNo(donationBoardDTO.getNo());
        donationRegister.setSort(donationBoardDTO.getSort());
        donationRegister.setDonationMoney(Prompt.inputInt("기부 금액: "));
        donationRegister.setMyTotaldonationMoney(donationRegister.getDonationMoney());
        donationRegister.setName(AuthLoginHandler.getLoginUser().getName());
        donationRegister.setRegisterationNumber(Prompt.inputString("주민등록번호: "));
        donationRegister.setBirthDate(Prompt.inputDate("생년월일(yyyy-mm-dd): "));
        donationRegister.setTel(Prompt.inputString("연락처: "));
        donationRegister.setEmail(Prompt.inputString("이메일: "));
        donationRegister.setAddress(Prompt.inputString("주소: "));
        donationRegister.setRegisteredDate(new Date(System.currentTimeMillis()));
        donationRegister.addMembers(AuthLoginHandler.getLoginUser());


        donationRegisterDTOList.add(donationRegister);

        System.out.println();
        System.out.println("[기부가 완료되었습니다.]");
      } else {
        System.out.println("다시 입력해주세요.");
        return;
      }
    }
  }
}


















































