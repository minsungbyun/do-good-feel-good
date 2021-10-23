package com.share.ftp.handler.personal.challenge;

import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class ChallengeDetailHandler implements Command {

  ChallengeDao challengeDao;

  public ChallengeDetailHandler(ChallengeDao challengeDao) {
    this.challengeDao = challengeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 챌린지 상세보기 ]");

    System.out.println();
    int challengeNo = Prompt.inputInt("챌린지 번호를 입력해주세요 ▶ ");

    ChallengeDTO challengeDTO = challengeDao.findByNo(challengeNo);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    request.setAttribute("challengeNo", challengeNo); 

    System.out.println();
    System.out.printf("챌린지 번호 ▶ %d\n",  challengeDTO.getNo());
    System.out.printf("제목 ▶ %s\n", challengeDTO.getTitle());
    System.out.printf("내용 ▶ %s\n", challengeDTO.getContent());
    System.out.printf("댓글수 ▶ %d\n", challengeDTO.getReviewCount());
    System.out.printf("참여자수 ▶ %d\n", challengeDTO.getTotalJoinCount());
    System.out.printf("첨부파일 ▶ %s\n", challengeDTO.getFileUpload());
    System.out.printf("시작일 ▶ %s\n", challengeDTO.getStartDate());
    System.out.printf("종료일 ▶ %s\n", challengeDTO.getEndDate());
    System.out.printf("챌린지기간 ▶ %d일\n",  ((((challengeDTO.getEndDate().getTime() - challengeDTO.getStartDate().getTime()) / 1000)) / (24*60*60)));
    System.out.printf(challengeDao.getRemainTime(challengeDTO.getEndDate().getTime() - System.currentTimeMillis()));
    System.out.printf("등록날짜 ▶ %s\n", challengeDTO.getRegisteredDate());
    System.out.println();

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 참여하기");
      System.out.println("2번 ▶ 참여자 목록");
      System.out.println("3번 ▶ 참여인증&댓글");
      System.out.println("4번 ▶ 문의하기");
      System.out.println("5번 ▶ 찜하기🎈");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/challengeJoin/join").forward(request); break;
        case 2: request.getRequestDispatcher("/challengeJoin/list").forward(request); break;
        case 3: request.getRequestDispatcher("/challengeReview/list").forward(request); break;
        case 4: request.getRequestDispatcher("/challengeQuestion/list").forward(request); break;
        case 5: request.getRequestDispatcher("/challengeDetail/wish").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }





}