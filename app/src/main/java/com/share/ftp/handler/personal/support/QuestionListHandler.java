package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.MyQuestionListDTO;

public class QuestionListHandler extends AbstractQuestionHandler {

  public QuestionListHandler(List<MyQuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {
    System.out.println();
    System.out.println("[고객센터/문의하기/문의하기 목록]");

    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {

      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
          myQuestionListDTO.getNo(), 
          myQuestionListDTO.getTitle(), 
          myQuestionListDTO.getMemberld(),
          myQuestionListDTO.getContent(),
          myQuestionListDTO.getFileUpload(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount());
    }
  }

}