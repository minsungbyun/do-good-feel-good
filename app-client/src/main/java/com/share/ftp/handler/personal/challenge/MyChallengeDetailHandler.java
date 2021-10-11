package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class MyChallengeDetailHandler implements Command {

  ChallengeDao challengeDao;

  public MyChallengeDetailHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[ 나의 챌린지 상세보기 ]");
    System.out.println();
    int challengeNo = Prompt.inputInt("챌린지 번호를 입력해주세요 ▶ ");

    ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    System.out.println();
    System.out.printf("챌린지 번호 ▶ %d\n "
        + "제목[댓글] ▶ %s[%d]\n "
        + "작성자 ▶ %s\n "
        + "참여인원 ▶ %d\n "
        + "참여기간 ▶ %s ~ %s\n", 
        challengeDTO.getNo(), 
        //          challengeDTO.getAdminId(), 
        challengeDTO.getTitle(), 
        challengeDTO.getReviewCount(), 
        challengeDTO.getAdmin().getName(),
        challengeDTO.getTotalJoinCount(),
        //          challengeDTO.getFileUpload(), 
        challengeDTO.getStartDate(),
        challengeDTO.getEndDate());
  }
}
