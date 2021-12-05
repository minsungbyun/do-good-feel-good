package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolQuestionListHandler implements Command {

  VolunteerDao volunteerDao;

  public VolQuestionListHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      int volNo = (int) request.getAttribute("volNo");

      VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApplyVol(volNo);

      System.out.println();
      System.out.printf("[ %d번 봉사 문의 목록 ]\n", volNo);
      System.out.println();

      System.out.printf("봉사 번호 ▶ %d\n"
          + "제목 ▶ %s\n"
          + "작성자 ▶ %s\n"
          + "참여인원 ▶ %d\n"
          + "참여기간 ▶ %s ~ %s\n", 
          volunteerRequestDTO.getNo(), 
          volunteerRequestDTO.getTitle(), 
          volunteerRequestDTO.getOwner().getName(),
          volunteerRequestDTO.getTotalJoinCount(),
          volunteerRequestDTO.getStartDate(),
          volunteerRequestDTO.getEndDate());

      System.out.println();
      System.out.println("---------------------------------------------------------");
      System.out.println();
      System.out.printf("[ 댓글 %d개 ]\n", volunteerRequestDTO.getQuestionCount());


      if (volunteerRequestDTO.getQuestionCount() == 0 /*|| challengeQuestionDTOList.isEmpty()*/) {
        System.out.println("문의댓글이 없습니다!");
        System.out.println();
      }

      Collection<VolunteerQuestionDTO> list = volunteerDao.findAllQuestion();
      for (VolunteerQuestionDTO volunteerQuestionDTO : list) {
        if (volunteerQuestionDTO.getNo() == volNo) {
          System.out.printf("%d, %d, %s, %s, %s\n", 
              volunteerQuestionDTO.getNo(), // 테스트 끝나고 지움
              volunteerQuestionDTO.getQuestionNo(),
              volunteerQuestionDTO.getOwner().getId(),
              volunteerQuestionDTO.getContent(),
              volunteerQuestionDTO.getRegisteredDate());
        }
      }
      System.out.println();
      System.out.println("1번 ▶ 문의 등록");
      System.out.println("2번 ▶ 문의 변경, 삭제");
      //      System.out.println("3번 ▶ 문의 검색"); // 보류
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      System.out.println();
      switch (input) {
        case 1: request.getRequestDispatcher("/volQuestion/add").forward(request); break;
        case 2: request.getRequestDispatcher("/volQuestion/connect").forward(request); break;
        //        case 3: request.getRequestDispatcher("/challengeQuestion/search").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}
