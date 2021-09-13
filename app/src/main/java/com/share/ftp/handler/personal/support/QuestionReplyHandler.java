package com.share.ftp.handler.personal.support;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionReplyHandler extends AbstractQuestionHandler {

  int boardNo;

  public QuestionReplyHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[고객센터/문의하기/문의하기 답글]");


    QuestionListDTO myQuestionListDTO = new QuestionListDTO();

    myQuestionListDTO.setTitle(Prompt.inputString("제목? "));
    myQuestionListDTO.setContent(Prompt.inputString("내용? "));
    myQuestionListDTO.setOwner(AuthLoginHandler.getLoginUser());
    myQuestionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
    myQuestionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    myQuestionListDTO.setBoardNo(++boardNo);

    myQuestionListDTOList.add(myQuestionListDTO);
  }

}