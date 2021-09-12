package com.share.ftp.handler.personal.challenge;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeJoinHandler extends AbstractChallengeJoinHandler {

  List<ChallengeJoinDTO> ChallengeJoinDTOList;
  List<JoinDTO> members = new ArrayList<>();

  public ChallengeJoinHandler(
      List<ChallengeJoinDTO> ChallengeJoinDTOList
      ) {

    super(ChallengeJoinDTOList);
    this.ChallengeJoinDTOList = ChallengeJoinDTOList;

  }

  @Override
  public void execute() {

    System.out.println();
    System.out.println("[참여하기]");

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    ChallengeJoinDTO ChallengeJoinDTO = new ChallengeJoinDTO();

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

    ChallengeJoinDTO.setUserId(joinDTO.getId()); // 참여 멤버 아이디 추가
    members.add(AuthLoginHandler.getLoginUser());
    ChallengeJoinDTO.setMembers(members); // 참여 멤버 등록

    ChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis())); // 날짜 추가
    ChallengeJoinDTOList.add(ChallengeJoinDTO); 

    System.out.println("챌린지 참여를 완료하였습니다.");
  }
  ////  ChallengeJoinListHandler challengeJoinListHandler;
  //  
  //  public ChallengeJoinHandler(List<ChallengeJoinDTO> ChallengeJoinDTOList /*ChallengeJoinListHandler challengeJoinListHandler*/) {
  //    super(ChallengeJoinDTOList);
  ////    this.challengeJoinListHandler = challengeJoinListHandler
  //  }
  //
  //  @Override
  //  public void execute() {
  //    while (true) {
  //    System.out.println("[참여하기]");
  //
  //    ChallengeJoinDTO ChallengeJoinDTO = new ChallengeJoinDTO();
  //
  //    try {
  //
  //    String input = Prompt.inputString("정말 참여하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("챌린지 참여를 취소하였습니다.");
  //      return;
  //    } else if (input.equals("y")) {
  ////        if (ChallengeJoinDTO.getJoiner().getId().equalsIgnoreCase(AuthLoginHandler.getLoginUser().getId())) {
  ////      System.out.println("챌린지 참여를 완료하였습니다.");
  //      ChallengeJoinDTO.setJoiner(AuthLoginHandler.getLoginUser());
  //      ChallengeJoinDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
  //      ChallengeJoinDTOList.add(ChallengeJoinDTO);
  //      return;
  ////      } else if (ChallengeJoinDTO.getJoiner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
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

