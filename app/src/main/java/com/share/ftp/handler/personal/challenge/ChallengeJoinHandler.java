package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeJoinHandler extends AbstractAdminChallengeHandler {


  public ChallengeJoinHandler(
      List<ChallengeDTO> challengeDTOList) {

    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[챌린지 참여]");
    System.out.println();
    int no = (int) request.getAttribute("no");

    ChallengeDTO challengeDTO = findByNo(no);


    if (challengeDTO == null) {
      System.out.println("존재하지 않는 챌린지입니다");
    }

    System.out.printf("챌린지 번호: %d\n"
        + "챌린지 제목: %s\n"
        //        + "챌린지 시작기간: %s\n"
        //        + "챌린지 종료기간: %s\n"
        + "챌린지 내용: %s\n"
        + "첨부파일: %s\n"
        + "등록날짜: %s\n\n",

        challengeDTO.getNo(),      
        challengeDTO.getTitle(),     
        //challengeDTO.getStartDate(),  // 시작날짜
        //challengeDTO.getEndDate(),  // 끝나는 날짜
        challengeDTO.getContent(),
        challengeDTO.getFileUpload(),
        challengeDTO.getRegisteredDate());

    String input = Prompt.inputString("해당 챌린지에 참가하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("해당 챌린지 참여를 취소하였습니다.");
      return;
    }

    //    // 주최자 유효성검사
    //    if (challengeDTO.getAdmin().getName().
    //        equals(AuthLoginHandler.getLoginUser().getName())) {
    //      System.out.println("관리자는 참여할 수 없습니다!");
    //      return;
    //    }

    //    // 봉사인원 유효성 검사
    //    if (challengeDTO.getTotalJoinCount() == challengeDTO.getVolLimitNum()) {
    //      System.out.println("정원이 초과하였습니다! 다음에 참여해주세요!");
    //      return;
    //    }


    if (challengeDTO.getMembers().contains(AuthLoginHandler.getLoginUser())) {
      System.out.println("이미 챌린지 참여를 하셨습니다!");
      return;
    } 

    // 출력할 멤버 list에 추가시킨다
    challengeDTO.addMembers(AuthLoginHandler.getLoginUser());

    //    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
    //    if (challengeDTO.getMembers().contains(challengeDTO.getOwner())) {
    //      challengeDTO.getMembers().remove(challengeDTO.getOwner());
    //    }

    //    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = challengeDTO.getTotalJoinCount();
    count += 1;
    challengeDTO.setTotalJoinCount(count); 

    System.out.println("챌린지 참여가 완료되었습니다.");
  }
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

//}

