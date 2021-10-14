package com.share.ftp.handler.personal.volunteer;

import java.sql.Date;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.domain.volunteer.VolQuestionDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolQuestionAddHandler implements Command {

  VolunteerDao volunteerDao;

  public VolQuestionAddHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 문의 등록 ]");
    System.out.println();
    int volNo = (int) request.getAttribute("volNo");

    GeneralRequestDTO generalRequestDTO = volunteerDao.findByApplyVol(volNo);

    if (!generalRequestDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("봉사 참여한 회원만 등록이 가능합니다!");
      return;
    }

    VolQuestionDTO volQuestionDTO = new VolQuestionDTO();

    volQuestionDTO.setNo(generalRequestDTO.getNo());
    volQuestionDTO.setContent(Prompt.inputString("내용: "));
    volQuestionDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    volQuestionDTO.setOwner(AuthLoginHandler.getLoginUser());

    String input = Prompt.inputString("해당 봉사에 문의등록을 하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("해당 봉사에 문의등록을 취소하였습니다.");
      return;
    }

    if (generalRequestDTO.getQuestionCount() == 0) {
      generalRequestDTO.setQuestionCount(1);
      System.out.println("각 봉사의 첫 문의입니다");
      System.out.println(generalRequestDTO.getQuestionCount());
    } else {
      generalRequestDTO.setQuestionCount(volunteerDao.getNextQuestionNum(generalRequestDTO)); 
    }

    volQuestionDTO.setQuestionNo(generalRequestDTO.getQuestionCount());

    volunteerDao.update(generalRequestDTO);
    volunteerDao.insertQuestion(volQuestionDTO);

    System.out.println();
    System.out.println("문의 등록이 완료되었습니다.");
  }
}
