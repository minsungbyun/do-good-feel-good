package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.util.Prompt;

public class ChallengeDetailHandler extends AbstractAdminChallengeHandler {


  public ChallengeDetailHandler(List<ChallengeDTO> challengeDTOList) {
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
    System.out.printf("제목▶ %s\n", challengeDTO.getTitle());
    System.out.printf("내용▶ %s\n", challengeDTO.getContent());
    System.out.printf("댓글수▶ %d\n", challengeDTO.getReviewCount());
    System.out.printf("참여자수▶ %d\n", challengeDTO.getTotalJoinCount());
    System.out.printf("첨부파일▶ %s\n", challengeDTO.getFileUpload());
    System.out.printf("시작일▶ %s\n", challengeDTO.getStartDate());
    System.out.printf("종료일▶ %s\n", challengeDTO.getEndDate());

    while (true) {
      System.out.println();
      System.out.println("1번: 참여하기");
      System.out.println("2번: 참여자 목록");
      System.out.println("3번: 참여인증&댓글");
      System.out.println("4번: 문의하기");
      System.out.println("0번: 이전");
      int input = Prompt.inputInt("번호 입력 > ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeJoin/join").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeJoin/list").forward(request); break;
        case 3: request.getRequestDispatcher("/challengeReview/connect").forward(request); break;
        case 4: request.getRequestDispatcher("/challengeQuestion/connect").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}