package com.share.ftp.handler.personal.challenge;

import static com.share.util.General.point.CHALLENGE_POINT;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeJoinHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeJoinHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 챌린지 참여 ]");
    System.out.println();
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("존재하지 않는 챌린지입니다");
    }


    System.out.printf("챌린지 번호 ▶ %d\n"
        +"제목[댓글] ▶ %s[%d]\n"
        +"작성자 ▶ %s\n"
        +"참여인원 ▶ %d\n"
        +"참여기간 ▶ %s ~ %s\n"
        +"챌린지기간 ▶ %d일\n"
        + challengeDao.getRemainTime(challengeDTO.getEndDate().getTime() - System.currentTimeMillis())
        +"등록날짜 ▶ %s\n\n",

        challengeDTO.getNo(), 
        //          challengeDTO.getAdminId(), 
        challengeDTO.getTitle(), 
        challengeDTO.getReviewCount(), 
        challengeDTO.getAdmin().getName(),
        challengeDTO.getTotalJoinCount(),
        //          challengeDTO.getFileUpload(), 
        challengeDTO.getStartDate(),
        challengeDTO.getEndDate(),
        ((((challengeDTO.getEndDate().getTime() - challengeDTO.getStartDate().getTime()) / 1000)) / (24*60*60)),
        //        ((((challengeDTO.getEndDate().getTime() - System.currentTimeMillis()) / 1000)) / (24*60*60)),
        //        (challengeDTO.getEndDate().getTime() - challengeDTO.getStartDate().getTime() ),
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

    // 포인트 부여 (참여 100포인트)
    AuthLoginHandler.getLoginUser().setPoint(AuthLoginHandler.getLoginUser().getPoint() + CHALLENGE_POINT);



    //    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = challengeDTO.getTotalJoinCount();
    count += 1;
    challengeDTO.setTotalJoinCount(count); 

    challengeDao.update(challengeDTO);

    System.out.println("[  챌린지 참여가 완료되었습니다. ]");
  }



}




