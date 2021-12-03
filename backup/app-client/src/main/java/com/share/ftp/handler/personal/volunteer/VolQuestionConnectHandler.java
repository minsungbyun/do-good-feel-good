package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolQuestionConnectHandler implements Command {

  VolunteerDao volunteerDao;

  public VolQuestionConnectHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 변경, 삭제 ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    int volQuestionNo = Prompt.inputInt("문의 번호를 입력해주세요 ▶ ");

    VolunteerQuestionDTO volunteerQuestionDTO = volunteerDao.findByVolQuestionNo(volNo, volQuestionNo);

    if (volunteerQuestionDTO == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if ((volunteerQuestionDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("아이디: %s\n", volunteerQuestionDTO.getOwner().getId());
      System.out.printf("내용: %s\n", volunteerQuestionDTO.getContent());
      System.out.printf("등록날짜: %s\n", volunteerQuestionDTO.getRegisteredDate());

    } else {
      System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
      return;
    }

    System.out.println();

    request.setAttribute("volQuestionNo", volQuestionNo); 

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 문의 변경");
      System.out.println("2번 ▶ 문의 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/volQuestion/update").forward(request); return;
        case 2: request.getRequestDispatcher("/volQuestion/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}