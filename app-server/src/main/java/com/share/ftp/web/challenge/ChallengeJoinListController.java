package com.share.ftp.web.challenge;
//package com.share.ftp.servlet.challenge;
//
//import com.share.ftp.dao.ChallengeDao;
//import com.share.ftp.domain.admin.ChallengeDTO;
////import com.share.ftp.domain.join.JoinDTO;
//import com.share.ftp.handler.Command;
//import com.share.ftp.handler.CommandRequest;
//
//public class ChallengeJoinListController implements Command {
//
//  ChallengeDao challengeDao;
//
//  public ChallengeJoinListController(ChallengeDao challengeDao) {
//    this.challengeDao = challengeDao;
//  }
//
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println();
//    System.out.println("[ 챌린지 참여자 목록 ]");
//    System.out.println();
//
//    int challengeNo = (int) request.getAttribute("challengeNo");
//    System.out.println();
//
//    ChallengeDTO challengeJoinList = challengeDao.findByNo(challengeNo); 
//
//    if (challengeJoinList == null) {
//      System.out.println("해당 챌린지가 없습니다.");
//      return;
//    }
//
//    System.out.printf("챌린지 제목 ▶ %s\n참가인원 ▶ %s명\n\n           [  챌린지 참여자명  ]\n\n%s\n",
//        challengeJoinList.getTitle(),
//        challengeJoinList.getTotalJoinCount(),
//        challengeJoinList.getMemberNames());
//  }
//}
