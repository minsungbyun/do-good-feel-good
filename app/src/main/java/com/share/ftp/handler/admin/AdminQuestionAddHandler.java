package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminQuestionAddHandler extends AbstractAdminQuestionHandler {

  public AdminQuestionAddHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super(myQuestionListDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 문의사항 답글 ]");

    QuestionListDTO myQuestionListDTO = new QuestionListDTO();

    myQuestionListDTO.setTitle(Prompt.inputString("제목? "));
    myQuestionListDTO.setContent(Prompt.inputString("내용: "));
    myQuestionListDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    myQuestionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    myQuestionListDTO.setNo(getNextNum());

  }



}
