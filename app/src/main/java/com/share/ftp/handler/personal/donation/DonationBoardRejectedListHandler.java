package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Rejected;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationBoardRejectedListHandler extends AbstractDonationBoardHandler {


  public DonationBoardRejectedListHandler(
      List<DonationBoardDTO> donationBoardDTOList,
      List<DonationBoardDTO> donationBoardApplyDTOList,
      List<DonationBoardDTO> donationBoardRejectDTOList) {

    super(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[모금함 개설 반려 목록]");

    if (donationBoardRejectDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 반려된 모금함 개설목록이 없습니다. ]");
      return;
    } 

    for (DonationBoardDTO donationBoardRejectDTO : donationBoardRejectDTOList) {

      if (donationBoardRejectDTO.getIsSigned().equals(Rejected)) {
        if (donationBoardRejectDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {

          System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
              + "개설기간: %s ~ %s\n승인여부: %s\n", 
              donationBoardRejectDTO.getNo(), 
              donationBoardRejectDTO.getSort(), 
              donationBoardRejectDTO.getTitle(), 
              donationBoardRejectDTO.getLeader(),
              donationBoardRejectDTO.getContent(),
              donationBoardRejectDTO.getFileUpload(), 
              donationBoardRejectDTO.getRegisteredStartDate(),
              donationBoardRejectDTO.getRegisteredEndDate(),
              donationBoardRejectDTO.getIsSigned());
          System.out.println("--------------------------------------------------------------");
        } else {
          System.out.println();
          System.out.println("[  현재 반려된 모금함 개설목록이 없습니다. ]");
          return;
        } 
      } else {
        System.out.println();
        System.out.println("[  현재 반려된 모금함 개설목록이 없습니다. ]");
        return;
      }
    }
  }
}


















































