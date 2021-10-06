//package com.share.ftp.handler.personal.donation;
//
//import java.util.Collection;
//import com.share.ftp.dao.DonationRegisterDao;
//import com.share.ftp.domain.personal.DonationRegisterDTO;
//import com.share.ftp.handler.Command;
//import com.share.ftp.handler.CommandRequest;
//import com.share.ftp.handler.join.AuthLoginHandler;
//
//public class DonationRegisterListHandler implements Command { // 모금함 기부하기 양식 쓰는곳
//
//  DonationRegisterDao donationRegisterDao;
//
//  public DonationRegisterListHandler(DonationRegisterDao donationRegisterDao) {
//    this.donationRegisterDao = donationRegisterDao;
//  }
//
//
//  // 모금함 기부 목록
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println("[모금함 기부 목록]");
//
//    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAll();
//
//    if (donationRegisterList.isEmpty()) {
//      System.out.println();
//      System.out.println("[ 참여한 모금함 기부내역이 없습니다. ]");
//      return;
//    }
//
//    for (DonationRegisterDTO donationRegisterDTO : donationRegisterList) {
//      if (donationRegisterDTO.getName().equals(AuthLoginHandler.getLoginUser().getName())) {
//        System.out.printf("%d, %d, %s, %s, %s, %s, %s, %s\n", 
//            donationRegisterDTO.getSort(), 
//            donationRegisterDTO.getNo(), 
//            donationRegisterDTO.getDonationMoney(), 
//            donationRegisterDTO.getName(), 
//            donationRegisterDTO.getRegisterationNumber(),
//            donationRegisterDTO.getBirthDate(),
//            donationRegisterDTO.getTel(), 
//            donationRegisterDTO.getEmail(),
//            donationRegisterDTO.getAddress());
//      } else {
//        System.out.println();
//        System.out.println("[ 참여한 모금함 기부내역이 없습니다. ]");
//        return;
//      }
//    }
//  }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
