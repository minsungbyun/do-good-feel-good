package com.share.ftp.handler.admin;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeUpdateHandler implements Command {

  ChallengeDao challengeDao;

  public AdminChallengeUpdateHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 챌린지 변경 ]");
    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeDTO = challengeDao.findByChallengeNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    ChallengeDTO updateChallenge = new ChallengeDTO();
    updateChallenge.setTitle(Prompt.inputString("제목(" + challengeDTO.getTitle() + ")? "));
    updateChallenge.setContent(Prompt.inputString("내용(" + challengeDTO.getContent() + ")? "));
    updateChallenge.setFileUpload(Prompt.inputString("첨부파일(" + challengeDTO.getFileUpload() + ")? "));
    updateChallenge.setStartDate(Prompt.inputDate("시작일(" + challengeDTO.getStartDate() + ")? "));
    updateChallenge.setEndDate(Prompt.inputDate("종료일(" + challengeDTO.getEndDate() + ")? "));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항 변경을 취소하였습니다.");
      return;
    }

    challengeDao.update(updateChallenge);

    System.out.println();
    System.out.println("[  챌린지를 변경하였습니다. ]");
  }
}
