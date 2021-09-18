package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.util.Prompt;

public class AdminChallengeDetailHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeDetailHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[챌린지 상세보기]");

    int no = Prompt.inputInt("번호? ");

    ChallengeDTO challengeDTO = findByNo(no);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    //    System.out.printf("번호: %d\n", challengeDTO.getNo());
    // System.out.printf("관리자 아이디: %s\n", challengeDTO.getAdminId());

//    for (ChallengeDTO challengeDTO : challengeDTOList) {

    System.out.printf("제목 ▶ %s\n", challengeDTO.getTitle());
    System.out.printf("내용▶ %s\n", challengeDTO.getContent());
    System.out.printf("첨부파일 ▶ %s\n", challengeDTO.getFileUpload());
    System.out.printf("등록일 ▶ %s\n", challengeDTO.getRegisteredDate());
  }
}