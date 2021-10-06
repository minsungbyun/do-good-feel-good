package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Rejected;
import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationBoardRejectedListHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardRejectedListHandler(DonationBoardDao donationBoardDao) {

    this.donationBoardDao = donationBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    DecimalFormat formatter = new DecimalFormat("###,###,###");

    Collection<DonationBoardDTO> donationBoardDTOList = donationBoardDao.findAll();


    System.out.println();
    System.out.println("[모금함 개설 반려 목록]");

    if (donationBoardDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 반려된 모금함 개설목록이 없습니다. ]");
      return;
    } 

    for (DonationBoardDTO donationBoardRejectDTO : donationBoardDTOList) {

      if (donationBoardRejectDTO.getIsSigned().equals(Rejected) && 
          donationBoardRejectDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {

        System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %s\n", 
            donationBoardRejectDTO.getNo(), 
            donationBoardRejectDTO.getSort(), 
            donationBoardRejectDTO.getTitle(), 
            donationBoardRejectDTO.getLeader(),
            donationBoardRejectDTO.getContent(),
            donationBoardRejectDTO.getFileUpload(), 
            donationBoardRejectDTO.getRegisteredStartDate(),
            donationBoardRejectDTO.getRegisteredEndDate(),
            formatter.format(donationBoardRejectDTO.getMoneyTarget()),
            donationBoardRejectDTO.getIsSigned());
        System.out.println("--------------------------------------------------------------");
      } 
      //      else if (!donationBoardRejectDTO.getIsSigned().equals(Rejected) && 
      //          (!donationBoardRejectDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName()))) {
      //        System.out.println();
      //        System.out.println("[  현재 반려된 모금함 개설목록이 없습니다. ]");
      //        return;
      //      } 
    } 
  }
}


















































