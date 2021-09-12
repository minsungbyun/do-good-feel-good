package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;

public class QuestionListHandler extends AbstractQuestionHandler {

  public QuestionListHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {
    System.out.println();
    System.out.println("[고객센터/문의하기/문의하기 목록]");

    for (QuestionListDTO myQuestionListDTO : myQuestionListDTOList) {

      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
          myQuestionListDTO.getNo(), 
          myQuestionListDTO.getTitle(), 
          myQuestionListDTO.getContent(),
          myQuestionListDTO.getOwner().getId(),
          myQuestionListDTO.getFileUpload(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount());
    }
  }

}