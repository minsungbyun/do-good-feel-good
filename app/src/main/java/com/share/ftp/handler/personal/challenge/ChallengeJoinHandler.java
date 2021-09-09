package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======

import com.share.ftp.domain.join.JoinDTO;
>>>>>>> feccd57486d805acc37694477cd990d177f76356
import com.share.ftp.domain.personal.MyChallengeJoinDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeJoinHandler extends AbstractChallengeJoinHandler {

<<<<<<< HEAD
  //  ChallengeJoinListHandler challengeJoinListHandler;

  public ChallengeJoinHandler(List<MyChallengeJoinDTO> myChallengeJoinDTOList /*ChallengeJoinListHandler challengeJoinListHandler*/) {
    super(myChallengeJoinDTOList);
    //    this.challengeJoinListHandler = challengeJoinListHandler
=======
  List<MyChallengeJoinDTO> myChallengeJoinDTOList;
  List<JoinDTO> members = new ArrayList<>();

  public ChallengeJoinHandler(
      List<MyChallengeJoinDTO> myChallengeJoinDTOList
      ) {

    super(myChallengeJoinDTOList);
    this.myChallengeJoinDTOList = myChallengeJoinDTOList;


>>>>>>> feccd57486d805acc37694477cd990d177f76356
  }

  @Override
  public void execute() {
<<<<<<< HEAD
    while (true) {
      System.out.println("[참여하기]");

      MyChallengeJoinDTO myChallengeJoinDTO = new MyChallengeJoinDTO();

      try {

        String input = Prompt.inputString("정말 참여하시겠습니까?(y/N) ");

        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("챌린지 참여를 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          //        if (myChallengeJoinDTO.getJoiner().getId().equalsIgnoreCase(AuthLoginHandler.getLoginUser().getId())) {
          //      System.out.println("챌린지 참여를 완료하였습니다.");
          myChallengeJoinDTO.setJoiner(AuthLoginHandler.getLoginUser());
          myChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
          myChallengeJoinDTOList.add(myChallengeJoinDTO);
          return;
        } else if (myChallengeJoinDTO.getJoiner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
          System.out.println("이미 참여가 완료되었습니다.");
          return;

        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        }
      } catch (Throwable e) {
      }
    }
  }
}
=======
    System.out.println();
    System.out.println("[참여하기]");

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    MyChallengeJoinDTO myChallengeJoinDTO = new MyChallengeJoinDTO();

    String input = Prompt.inputString("정말 참여하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("챌린지 참여를 취소하였습니다.");
      return;
    }

    // 이미 참여한 적이 있다면 못들어오지ㅠㅠ
    if (members.contains(AuthLoginHandler.getLoginUser())) {
      System.out.println("이미 참여하였습니다!");
      return;
    }

    myChallengeJoinDTO.setUserId(joinDTO.getId()); // 참여 멤버 아이디 추가
    members.add(AuthLoginHandler.getLoginUser());
    myChallengeJoinDTO.setMembers(members); // 참여 멤버 등록

    myChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis())); // 날짜 추가
    myChallengeJoinDTOList.add(myChallengeJoinDTO); 

    System.out.println("챌린지 참여를 완료하였습니다.");
  }
////  ChallengeJoinListHandler challengeJoinListHandler;
//  
//  public ChallengeJoinHandler(List<MyChallengeJoinDTO> myChallengeJoinDTOList /*ChallengeJoinListHandler challengeJoinListHandler*/) {
//    super(myChallengeJoinDTOList);
////    this.challengeJoinListHandler = challengeJoinListHandler
//  }
//
//  @Override
//  public void execute() {
//    while (true) {
//    System.out.println("[참여하기]");
//
//    MyChallengeJoinDTO myChallengeJoinDTO = new MyChallengeJoinDTO();
//
//    try {
//
//    String input = Prompt.inputString("정말 참여하시겠습니까?(y/N) ");
//    if (input.equalsIgnoreCase("n") || input.length() == 0) {
//      System.out.println("챌린지 참여를 취소하였습니다.");
//      return;
//    } else if (input.equals("y")) {
////        if (myChallengeJoinDTO.getJoiner().getId().equalsIgnoreCase(AuthLoginHandler.getLoginUser().getId())) {
////      System.out.println("챌린지 참여를 완료하였습니다.");
//      myChallengeJoinDTO.setJoiner(AuthLoginHandler.getLoginUser());
//      myChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
//      myChallengeJoinDTOList.add(myChallengeJoinDTO);
//      return;
////      } else if (myChallengeJoinDTO.getJoiner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
////        System.out.println("이미 참여가 완료되었습니다.");
////        return;
////      }
//    } else {
//      System.out.println("y 또는 n을 입력하세요.");
//      continue;
//    }
//    } catch (Throwable e) {
//  }
//  }
//  }
}
>>>>>>> feccd57486d805acc37694477cd990d177f76356
