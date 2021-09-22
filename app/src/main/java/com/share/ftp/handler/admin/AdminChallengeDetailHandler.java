package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeDetailHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeDetailHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[챌린지 상세보기]");

    System.out.println();
    int no = Prompt.inputInt("번호? ");

    ChallengeDTO challengeDTO = findByNo(no);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    request.setAttribute("no", no); 

    //    System.out.printf("번호: %d\n", challengeDTO.getNo());
    // System.out.printf("관리자 아이디: %s\n", challengeDTO.getAdminId());

    //    for (ChallengeDTO challengeDTO : challengeDTOList) {
    System.out.println();
    System.out.printf("제목 ▶ %s\n", challengeDTO.getTitle());
    System.out.printf("내용▶ %s\n", challengeDTO.getContent());
    System.out.printf("첨부파일 ▶ %s\n", challengeDTO.getFileUpload());
    System.out.printf("등록일 ▶ %s\n", challengeDTO.getRegisteredDate());

    while (true) {
      System.out.println();
      String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/adminChallenge/update").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/adminChallenge/delete").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}