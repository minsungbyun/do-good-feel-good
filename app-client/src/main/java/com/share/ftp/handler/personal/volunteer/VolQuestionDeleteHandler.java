package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolQuestionDeleteHandler implements Command {

  VolunteerDao volunteerDao;

  public VolQuestionDeleteHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[ 문의 삭제 ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApplyVol(volNo); 

    int volQuestionNo = (int) request.getAttribute("volQuestionNo");

    VolunteerQuestionDTO volunteerQuestionDTO = volunteerDao.findByVolQuestionNo(volNo, volQuestionNo);

    if (volunteerQuestionDTO == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    if ((volunteerQuestionDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 삭제를 취소하였습니다.");
      return; 

    } else if (input.equalsIgnoreCase("y")) {
      volunteerRequestDTO.setQuestionCount(volunteerRequestDTO.getQuestionCount() - 1);

      volunteerDao.update(volunteerRequestDTO);
      volunteerDao.deleteQuestion(volunteerQuestionDTO);

      System.out.println("해당 문의사항을 삭제하였습니다.");
    }
  }
}

