package com.share.ftp.handler.admin;

import java.sql.Date;
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

    String title = Prompt.inputString(String.format("제목(%s)? ", challengeDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", challengeDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", challengeDTO.getFileUpload()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", challengeDTO.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", challengeDTO.getEndDate()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("챌린지 변경을 취소하였습니다.");
      return;
    }
    challengeDTO.setTitle(title);
    challengeDTO.setContent(content);
    challengeDTO.setFileUpload(fileUpload);
    challengeDTO.setStartDate(startDate);
    challengeDTO.setEndDate(endDate);

    challengeDao.update(challengeDTO);
    System.out.println();

    System.out.println("[  챌린지를 변경하였습니다. ]");
  }
}
