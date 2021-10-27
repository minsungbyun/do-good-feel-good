package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolQuestionUpdateHandler implements Command {

  VolunteerDao volunteerDao;

  public VolQuestionUpdateHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[ 문의 수정 ]");
    System.out.println();
    int volNo = (int) request.getAttribute("volNo");

    int volQuestionNo = (int) request.getAttribute("volQuestionNo");

    VolunteerQuestionDTO volunteerQuestionDTO = volunteerDao.findByVolQuestionNo(volNo, volQuestionNo);

    if (volunteerQuestionDTO == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if ((volunteerQuestionDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", volunteerQuestionDTO.getContent()));

    while (true) {
      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("문의 수정을 취소하였습니다.");
        return;

      } else if (input.equals("y")) {
        System.out.println();
        volunteerQuestionDTO.setContent(content);
        volunteerDao.updateQuestion(volunteerQuestionDTO);

        System.out.println("문의를 수정하였습니다.");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 
    }
  }
}
